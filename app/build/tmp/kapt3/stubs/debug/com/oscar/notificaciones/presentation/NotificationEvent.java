package com.oscar.notificaciones.presentation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/oscar/notificaciones/presentation/NotificationEvent;", "", "DeleteNotification", "SortNotification", "Lcom/oscar/notificaciones/presentation/NotificationEvent$DeleteNotification;", "Lcom/oscar/notificaciones/presentation/NotificationEvent$SortNotification;", "app_debug"})
public abstract interface NotificationEvent {
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/oscar/notificaciones/presentation/NotificationEvent$SortNotification;", "Lcom/oscar/notificaciones/presentation/NotificationEvent;", "()V", "app_debug"})
    public static final class SortNotification implements com.oscar.notificaciones.presentation.NotificationEvent {
        @org.jetbrains.annotations.NotNull
        public static final com.oscar.notificaciones.presentation.NotificationEvent.SortNotification INSTANCE = null;
        
        private SortNotification() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/oscar/notificaciones/presentation/NotificationEvent$DeleteNotification;", "Lcom/oscar/notificaciones/presentation/NotificationEvent;", "notification", "Lcom/oscar/notificaciones/data/Notification;", "(Lcom/oscar/notificaciones/data/Notification;)V", "getNotification", "()Lcom/oscar/notificaciones/data/Notification;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class DeleteNotification implements com.oscar.notificaciones.presentation.NotificationEvent {
        @org.jetbrains.annotations.NotNull
        private final com.oscar.notificaciones.data.Notification notification = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.oscar.notificaciones.presentation.NotificationEvent.DeleteNotification copy(@org.jetbrains.annotations.NotNull
        com.oscar.notificaciones.data.Notification notification) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public DeleteNotification(@org.jetbrains.annotations.NotNull
        com.oscar.notificaciones.data.Notification notification) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.oscar.notificaciones.data.Notification component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.oscar.notificaciones.data.Notification getNotification() {
            return null;
        }
    }
}