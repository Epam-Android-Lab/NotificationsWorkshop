package com.example.notifivationsworkshop

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import com.example.notifivationsworkshop.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            startedFrom.text = intent.startFromText
            createNotificationChannel.setOnClickListener { createNotificationChannel() }
            showNotification.setOnClickListener(::showNotification)
            showNotificationGroup.setOnClickListener(::showNotificationGroup)
            showCustomNotification.setOnClickListener(::showCustomNotification)
        }
    }

    private fun showNotification(view: View) {
        createNotificationChannel()
        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(Random.nextInt(), simpleNotificationBuilder.setContentIntent(pendingIntent).build())
        }
    }

    private fun showNotificationGroup(view: View) {
        NotificationManagerCompat.from(this).apply {
            notify(Random.nextInt(), newMessageNotification1)
            notify(Random.nextInt(), newMessageNotification2)
            notify(SUMMARY_ID, summaryNotification)
        }
    }

    private fun showCustomNotification(view: View) {
        createNotificationChannel()
        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(Random.nextInt(), customNotification)
        }
    }

    private val Intent.startFromText
        get() = when (getBooleanExtra(FROM_NOTIFICATION_KEY, false)) {
            true -> "Started from notification"
            false -> "Started from launcher"
        }
}
