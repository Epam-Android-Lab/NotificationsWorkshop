package com.example.notifivationsworkshop

import android.app.Activity
import android.app.Notification
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat

// Get the layouts to use in the custom notification
val Activity.notificationLayout
    get() = RemoteViews(packageName, R.layout.notification_custom_layout)

// Apply the layouts to the notification
val Activity.customNotification: Notification
    get() = NotificationCompat.Builder(this, CHANNEL_ID)
        .setSmallIcon(R.drawable.notification_icon)
        .setStyle(NotificationCompat.DecoratedCustomViewStyle())
        .setCustomContentView(notificationLayout)
        .build()

