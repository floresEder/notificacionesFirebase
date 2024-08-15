package com.oscar.notificaciones.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface NotificationDao {

    // upsert (update and insert)
    //suspend Asynchoronous Method
    @Upsert
    suspend fun upsertNote(notification: Notification)

    @Delete
    suspend fun deleteNote(notification: Notification)

    @Query("SELECT * FROM notification ORDER BY dateAdded")
    fun getNotesOrderdByDateAdded(): Flow<List<Notification>>


    @Query("SELECT * FROM notification ORDER BY title ASC")
    fun getNotesOrderdByTitle(): Flow<List<Notification>>


}











