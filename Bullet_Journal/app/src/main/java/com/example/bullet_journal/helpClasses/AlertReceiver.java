package com.example.bullet_journal.helpClasses;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;


public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
            NotificationHelper notificationHelper = new NotificationHelper(context);

            NotificationCompat.Builder nb = notificationHelper.getChannelNotification(intent.getStringExtra("title"), intent.getStringExtra("text"));
            nb.setContentTitle(intent.getStringExtra("title"));
            notificationHelper.getManager().notify(1, nb.build());

    }
}