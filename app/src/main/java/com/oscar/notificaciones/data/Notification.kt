package com.oscar.notificaciones.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Notification(

    val title: String?,
    val description: String?,
    val dateAdded: Long,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
