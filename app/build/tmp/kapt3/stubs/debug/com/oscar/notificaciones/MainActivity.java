package com.oscar.notificaciones;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0003J,\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00190\"H\u0007J4\u0010$\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00190\"2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0012\u0010\'\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\b\u0010*\u001a\u00020\u0019H\u0014J\b\u0010+\u001a\u00020\u0019H\u0014J\b\u0010,\u001a\u00020\u0019H\u0003R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006-"}, d2 = {"Lcom/oscar/notificaciones/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "database", "Lcom/oscar/notificaciones/data/NotificationDatabase;", "getDatabase", "()Lcom/oscar/notificaciones/data/NotificationDatabase;", "database$delegate", "Lkotlin/Lazy;", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "locationCallback", "Lcom/google/android/gms/location/LocationCallback;", "locationRequired", "", "permissions", "", "", "[Ljava/lang/String;", "viewModel", "Lcom/oscar/notificaciones/presentation/NotesViewModel;", "getViewModel", "()Lcom/oscar/notificaciones/presentation/NotesViewModel;", "viewModel$delegate", "BuildUi", "", "currentLocation", "Lcom/google/android/gms/maps/model/LatLng;", "NotificationItem", "state", "Lcom/oscar/notificaciones/presentation/NotificationState;", "index", "", "onEvent", "Lkotlin/Function1;", "Lcom/oscar/notificaciones/presentation/NotificationEvent;", "ShowNotifications", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "starLocationUpdates", "app_debug"})
public final class MainActivity extends androidx.activity.ComponentActivity {
    private java.lang.String[] permissions = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.POST_NOTIFICATIONS"};
    private com.google.android.gms.location.FusedLocationProviderClient fusedLocationClient;
    private com.google.android.gms.location.LocationCallback locationCallback;
    private boolean locationRequired = false;
    private final kotlin.Lazy database$delegate = null;
    private final kotlin.Lazy viewModel$delegate = null;
    
    public MainActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void starLocationUpdates() {
    }
    
    @java.lang.Override
    protected void onPause() {
    }
    
    private final com.oscar.notificaciones.data.NotificationDatabase getDatabase() {
        return null;
    }
    
    private final com.oscar.notificaciones.presentation.NotesViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @androidx.compose.runtime.Composable
    private final void BuildUi(com.google.android.gms.maps.model.LatLng currentLocation) {
    }
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    public final void ShowNotifications(@org.jetbrains.annotations.NotNull
    com.oscar.notificaciones.presentation.NotificationState state, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.oscar.notificaciones.presentation.NotificationEvent, kotlin.Unit> onEvent, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.google.android.gms.maps.model.LatLng currentLocation) {
    }
    
    @androidx.compose.runtime.Composable
    public final void NotificationItem(@org.jetbrains.annotations.NotNull
    com.oscar.notificaciones.presentation.NotificationState state, int index, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.oscar.notificaciones.presentation.NotificationEvent, kotlin.Unit> onEvent) {
    }
}