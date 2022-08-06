package com.realityexpander.localnotification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class CounterNotificationService(
    private val context: Context
) {

    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNotification(counter: Int) {
        val activityIntent = Intent(context, MainActivity::class.java)
        val activityPendingIntent = PendingIntent.getActivity(
            context,
            101,
            activityIntent,
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                PendingIntent.FLAG_IMMUTABLE // prevent crash for API >= 31
            } else {
                0
            }
        )

        val incrementIntent = Intent(context, CounterNotificationReceiver::class.java)
        val incrementPendingIntent = PendingIntent.getBroadcast(
            context,
            102,
            incrementIntent,
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                PendingIntent.FLAG_IMMUTABLE // prevent crash for API >= 31
            } else {
                0
            }
        )

        val notification = NotificationCompat.Builder(context, COUNTER_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_counter_channel)
            .setContentTitle("Counter")
            .setContentText("The count is $counter")
//            .setStyle(
//                NotificationCompat.BigTextStyle()
//                    .bigText("The count is $counter")
//            )
            .setContentIntent(activityPendingIntent)
            .addAction(R.drawable.ic_counter_channel,
                "Increment",
                incrementPendingIntent
            )
            .build()

        notificationManager.notify(COUNTER_NOTIFICATION_ID, notification)
    }

    companion object {
        const val COUNTER_CHANNEL_ID = "counter_channel"
        const val COUNTER_NOTIFICATION_ID = 1
    }
}