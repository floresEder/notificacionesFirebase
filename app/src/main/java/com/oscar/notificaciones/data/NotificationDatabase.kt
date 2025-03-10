package com.oscar.notificaciones.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [Notification::class],
    version = 1
)
abstract class NotificationDatabase: RoomDatabase(){
    abstract fun notificationsDao(): NotificationDao


    companion object {
        @Volatile private var INSTANCE: NotificationDatabase? = null

        fun getDatabase(context: Context): NotificationDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotificationDatabase::class.java,
                    "notifications.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }


}