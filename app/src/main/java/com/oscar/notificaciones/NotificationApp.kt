package com.oscar.notificaciones

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.google.firebase.Firebase
import com.google.firebase.messaging.messaging

class NotificationApp : Application() {



    companion object {
        const val NOTIFICATION_CHANNEL_ID = "notification_id"
    }

    override fun onCreate() {
        super.onCreate()
        Firebase.messaging.token.addOnCompleteListener{
            if(!it.isSuccessful) {
                println("el token no fue generado")
                return@addOnCompleteListener
            }
            val token = it.result
            println("El token fue generado $token")
        }
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                "Notificacion Firebase",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel.description = "Notificación recibida desde firebase"
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

}