package com.realityexpander.localnotification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.realityexpander.localnotification.CounterNotificationService.Companion.EXTRA_INCREMENT_AMOUNT

class CounterNotificationReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val service = CounterNotificationService(context)

        val incrementAmount = intent.getIntExtra(EXTRA_INCREMENT_AMOUNT, 1)

        Counter.value += incrementAmount
        service.showNotification(Counter.value)
    }
}


//Intent showFullQuoteIntent = new Intent(this, ShowFullQuoteActivity.class);
//showFullQuoteIntent.putExtra(INTENT_KEY, randomQuote);
//
//// both of these approaches now work: FLAG_CANCEL, FLAG_UPDATE; the uniqueInt may be the real solution.
////PendingIntent pendingIntent = PendingIntent.getActivity(this, uniqueInt, showFullQuoteIntent, PendingIntent.FLAG_CANCEL_CURRENT);
//int uniqueInt = (int) (System.currentTimeMillis() & 0xfffffff);
//PendingIntent pendingIntent = PendingIntent.getActivity(this, uniqueInt, showFullQuoteIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//
//Notification notification = new NotificationCompat.Builder(this)
//.setTicker(randomQuote)
//.setSmallIcon(android.R.drawable.ic_menu_view)
//.setContentTitle(randomQuote)
//.setContentText(randomQuote)
//.setContentIntent(pendingIntent)
//.setAutoCancel(true)
//.build();
//
//NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//notificationManager.notify(0, notification);