package com.oscar.notificaciones.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oscar.notificaciones.data.NotificationDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class NotesViewModel(
    private val dao: NotificationDao
) : ViewModel() {


    private val isSortedByDateAdded = MutableStateFlow(true)

    private var notes =
        isSortedByDateAdded.flatMapLatest { sort ->
            if (sort) {
                dao.getNotesOrderdByDateAdded()
            } else {
                dao.getNotesOrderdByTitle()
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())



    val _state = MutableStateFlow(NotificationState())
    val state =
        combine(_state, isSortedByDateAdded, notes) { state, isSortedByDateAdded, notes ->
            state.copy(
                notifications = notes
            )
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), NotificationState())

    fun onEvent(event: NotificationEvent) {
        //Using a sealed interfaces for the control structure when
        when (event) {
            //When deleting a Note
            is NotificationEvent.DeleteNotification -> {
                viewModelScope.launch {
                    dao.deleteNote(event.notification)
                }
            }

            NotificationEvent.SortNotification -> {
                isSortedByDateAdded.value = !isSortedByDateAdded.value
            }
        }
    }

}