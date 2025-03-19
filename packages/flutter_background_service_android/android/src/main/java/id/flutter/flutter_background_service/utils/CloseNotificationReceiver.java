package id.flutter.flutter_background_service.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationManagerCompat;

import id.flutter.flutter_background_service.BackgroundService;

public class CloseNotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals(ServiceNotification.ACTION_CLOSE_NOTIF)) {
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
            int id = intent.getIntExtra(ServiceNotification.EXTRA_NOTIF_ID, -1000);
            notificationManager.cancel(id);
            context.sendBroadcast(new Intent(BackgroundService.ACTION_STOP_SOUND));
        }
    }
}
