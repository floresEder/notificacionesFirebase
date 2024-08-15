package com.oscar.notificaciones;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/oscar/notificaciones/MessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "notificationDao", "Lcom/oscar/notificaciones/data/NotificationDao;", "onCreate", "", "onMessageReceived", "message", "Lcom/google/firebase/messaging/RemoteMessage;", "showNotification", "app_debug"})
public final class MessagingService extends com.google.firebase.messaging.FirebaseMessagingService {
    private com.oscar.notificaciones.data.NotificationDao notificationDao;
    
    public MessagingService() {
        super();
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    @java.lang.Override
    public void onMessageReceived(@org.jetbrains.annotations.NotNull
    com.google.firebase.messaging.RemoteMessage message) {
    }
    
    private final void showNotification(com.google.firebase.messaging.RemoteMessage message) {
    }
}