package com.realityexpander.localnotification

import android.content.BroadcastReceiver
import android.content.Context

class CounterNotificationReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context, intent: android.content.Intent) {
        val service = CounterNotificationService(context)

        service.showNotification(++Counter.value)
    }
}
