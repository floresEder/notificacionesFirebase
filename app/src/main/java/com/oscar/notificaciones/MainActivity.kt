package com.oscar.notificaciones

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Looper
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Update
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.oscar.notificaciones.data.NotificationDatabase
import com.oscar.notificaciones.presentation.NotificationState
import com.oscar.notificaciones.presentation.NotificationEvent
import com.oscar.notificaciones.presentation.NotesViewModel
import com.ahmedapps.roomdatabase.ui.theme.RoomDatabaseTheme
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.maps.model.LatLng

class MainActivity : ComponentActivity() {


    // permissions
    private var permissions = arrayOf(
        android.Manifest.permission.ACCESS_COARSE_LOCATION,
        android.Manifest.permission.ACCESS_FINE_LOCATION,
        android.Manifest.permission.POST_NOTIFICATIONS
    )

    // gps
    private lateinit var  fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback
    private var locationRequired: Boolean = false

    override fun onResume() {
        super.onResume()
        if(locationRequired) {
            starLocationUpdates()
        }
    }

   @SuppressLint("MissingPermission")
    private fun starLocationUpdates() {
        locationCallback?.let {
            val locationRequest = LocationRequest.Builder(
                Priority.PRIORITY_HIGH_ACCURACY, 100
            )
                .setWaitForAccurateLocation(false)
                .setMinUpdateIntervalMillis(3000)
                .setMaxUpdateDelayMillis(100)
                .build()

            fusedLocationClient?.requestLocationUpdates(
                locationRequest,
                it,
                Looper.getMainLooper()
            )
        }
    }

    override fun onPause() {
        super.onPause()
        locationCallback?.let {
            fusedLocationClient?.removeLocationUpdates(it)
        }
    }

    // get the db
    private val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            NotificationDatabase::class.java,
            "notifications.db"
        ).build()
    }




    // viewModel
    private val viewModel by viewModels<NotesViewModel> (
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun<T: ViewModel> create(modelClass: Class<T>): T {
                    return NotesViewModel(database.notificationsDao()) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Gps
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        setContent {
            var currentLocation by remember {
                mutableStateOf(LatLng(0.toDouble(),0.toDouble()))
            }

            locationCallback = object :LocationCallback() {
                override fun onLocationResult(p0: LocationResult) {
                    super.onLocationResult(p0)
                    for(location in p0.locations) {
                        currentLocation = LatLng(location.latitude, location.longitude)
                    }
                }
            }

            BuildUi(currentLocation)


        }
    }


    @Composable
    private fun BuildUi(currentLocation: LatLng) {

        RoomDatabaseTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                val state by viewModel.state.collectAsState()


                ShowNotifications(state = state,
                    onEvent = viewModel::onEvent,
                    this@MainActivity,
                    currentLocation = currentLocation)
            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ShowNotifications(
        state: NotificationState,
        onEvent: (NotificationEvent) -> Unit,
        context: Context,
        currentLocation: LatLng
    ) {

        val launcherMultiplePermissions = rememberLauncherForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
                permissionsMaps ->
            val areGranted = permissionsMaps.values.reduce{acc, next -> acc && next}
            if(areGranted) {
                locationRequired = true
                starLocationUpdates()
                Toast.makeText(context, "Permissions granted", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(context, "Permissions denied", Toast.LENGTH_LONG).show()
            }
        }

        Scaffold(
            topBar = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        modifier = Modifier.weight(1f),
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )

                    IconButton(onClick = { onEvent(NotificationEvent.SortNotification) }) {
                        Icon(
                            imageVector = Icons.Rounded.Update,
                            contentDescription = "Sort Notes",
                            modifier = Modifier.size(35.dp),
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            }

            ) { paddingValues ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(modifier = Modifier.fillMaxSize()
                    .padding(16.dp)){

                    Button(onClick = {
                        Toast.makeText(context, "Obteniendo coordenadas", Toast.LENGTH_LONG).show()

                        if(permissions.all {
                                ContextCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
                            })
                        {
                            starLocationUpdates()
                        }
                        else{
                            launcherMultiplePermissions.launch(permissions)
                        }
                    }) {

                        Text(text = "Obtener las coordenadas geográficas")
                    }
                    Text(modifier = Modifier.fillMaxSize()
                        .padding(paddingValues),
                        text = "Coordenadas geográficas: ${currentLocation.latitude} / ${currentLocation.longitude}")
                }
            }

            Text(modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 180.dp, horizontal = 15.dp),
                text = "Mis notificaciones se muestran abajo una vez recibidas",
                fontWeight = FontWeight.Bold)


            //Lazy Column is like a modern RecyclerView
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 200.dp, horizontal = 10.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                // inside de LazyColumn we put the items
                items(state.notifications.size) { index ->
                    NotificationItem(
                        // parameters of the NoteItem
                        state = state,
                        index = index,
                        onEvent = onEvent
                    )
                }
            }
        }
    }

    @Composable
    fun NotificationItem(
        state: NotificationState,
        index: Int,
        onEvent: (NotificationEvent) -> Unit
    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(12.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = state.notifications[index].title ?: "Untitled",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = state.notifications[index].description ?: "Untitled",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }

            IconButton(
                onClick = {
                    onEvent(NotificationEvent.DeleteNotification(state.notifications[index]))
                }
            ) {

                Icon(
                    imageVector = Icons.Rounded.Delete,
                    contentDescription = "Delete Note",
                    modifier = Modifier.size(35.dp),
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }




}

