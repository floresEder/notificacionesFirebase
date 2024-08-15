package com.oscar.notificaciones

import android.app.NotificationManager
import androidx.core.app.NotificationCompat
import com.oscar.notificaciones.data.Notification
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import kotlinx.coroutines.launch
import com.oscar.notificaciones.data.NotificationDao
import com.oscar.notificaciones.data.NotificationDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MessagingService : FirebaseMessagingService() {

    private lateinit var notificationDao: NotificationDao

    override fun onCreate() {
        super.onCreate()

        val database = NotificationDatabase.getDatabase(applicationContext)
        notificationDao = database.notificationsDao()
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        val notification = Notification(
            title = message.notification?.title,
            description = message.notification?.body,
            dateAdded = System.currentTimeMillis()
        )

        CoroutineScope(Dispatchers.IO).launch{ notificationDao.upsertNote(notification) }

        showNotification(message)
    }

    private fun showNotification(message: RemoteMessage) {
        val notificationManager = getSystemService(NotificationManager::class.java)
        val notification = NotificationCompat.Builder(this, NotificationApp.NOTIFICATION_CHANNEL_ID)
            .setContentTitle(message.notification?.title)
            .setContentText(message.notification?.body)
            .setSmallIcon(R.drawable.notification)
            .setAutoCancel(true)
            .build()
        notificationManager.notify(1, notification)
    }


}