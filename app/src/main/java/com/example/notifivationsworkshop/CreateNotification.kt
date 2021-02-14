package com.example.notifivationsworkshop

import android.app.Activity
import android.app.PendingIntent
import android.content.Intent
import androidx.core.app.NotificationCompat

val Activity.simpleNotificationBuilder: NotificationCompat.Builder
    get() = NotificationCompat.Builder(this, CHANNEL_ID)
        .setSmallIcon(R.drawable.notification_icon)
        .setContentTitle("Workshop notification")
        .setContentText("Just a notification. Nothing to see. Move along.")
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

// Create an explicit intent for an Activity in your app
val Activity.notificationIntent
    get() = Intent(this, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        putExtra(FROM_NOTIFICATION_KEY, true)
    }

val Activity.pendingIntent: PendingIntent
    get() = PendingIntent.getActivity(this, 0, notificationIntent, 0)


const val FROM_NOTIFICATION_KEY = "FROM_NOTIFICATION_KEY"
