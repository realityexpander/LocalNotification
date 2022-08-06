package com.realityexpander.localnotification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.realityexpander.localnotification.CounterNotificationService.Companion.EXTRA_DECREMENT_AMOUNT
import com.realityexpander.localnotification.CounterNotificationService.Companion.EXTRA_INCREMENT_AMOUNT

class CounterNotificationReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val service = CounterNotificationService(context)

        val incrementAmount = intent.getIntExtra(EXTRA_INCREMENT_AMOUNT, 0)
        val decrementAmount = intent.getIntExtra(EXTRA_DECREMENT_AMOUNT, 0)

        Counter.value += incrementAmount
        Counter.value -= decrementAmount
        service.showNotification(Counter.value)
    }
}
