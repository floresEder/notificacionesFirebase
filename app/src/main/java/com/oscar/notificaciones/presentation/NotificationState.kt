package com.oscar.notificaciones.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.oscar.notificaciones.data.Notification

data class NotificationState(

    // Initialization of the Note State
    val notifications: List<Notification> = emptyList(),

    //This is a type provided by Jetpack Compose. It is a state holder that allows you to read and write its value.
    // Changes to its value will trigger recompositions in the Compose UI,
    // meaning the UI will update to reflect the new value.
    val title: MutableState<String> = mutableStateOf(""),

    val description: MutableState<String> = mutableStateOf("")
)