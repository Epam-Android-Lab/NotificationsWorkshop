package com.example.notifivationsworkshop

import android.app.Activity
import android.app.Notification
import androidx.core.app.NotificationCompat

//use constant ID for notification used as group summary
const val SUMMARY_ID = 0
const val GROUP_KEY_WORK_EMAIL = "com.android.example.WORK_EMAIL"

val Activity.newMessageNotification1: Notification
    get() = NotificationCompat.Builder(this, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_notify_email_status)
        .setContentTitle("Alex Faarborg Check this out")
        .setContentText("You will not believe...")
        .setGroup(GROUP_KEY_WORK_EMAIL)
        .build()

val Activity.newMessageNotification2: Notification
    get() = NotificationCompat.Builder(this, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_notify_email_status)
        .setContentTitle("Jeff Chang Launch Party")
        .setContentText("Please join us to celebrate the...")
        .setGroup(GROUP_KEY_WORK_EMAIL)
        .build()

val Activity.summaryNotification: Notification
    get() = NotificationCompat.Builder(this, CHANNEL_ID)
        .setContentTitle("New emails")
        //set content text to support devices running API level < 24
        .setContentText("Two new messages")
        .setSmallIcon(R.drawable.ic_notify_summary_status)
        //build summary info into InboxStyle template
        .setStyle(
            NotificationCompat.InboxStyle()
                .addLine("Alex Faarborg Check this out")
                .addLine("Jeff Chang Launch Party")
                .setBigContentTitle("2 new messages")
                .setSummaryText("janedoe@example.com")
        )
        //specify which group this notification belongs to
        .setGroup(GROUP_KEY_WORK_EMAIL)
        //set this notification as the summary for the group
        .setGroupSummary(true)
        .build()
