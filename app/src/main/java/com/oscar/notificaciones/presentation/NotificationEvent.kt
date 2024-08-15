package com.oscar.notificaciones.presentation

import com.oscar.notificaciones.data.Notification


//What does a sealed interface do?
//https://kotlinlang.org/docs/sealed-classes.html

sealed interface NotificationEvent {
    object SortNotification: NotificationEvent

    data class DeleteNotification(val notification: Notification): NotificationEvent

}
