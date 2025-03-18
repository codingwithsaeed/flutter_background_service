package id.flutter.flutter_background_service.utils;

import static androidx.core.app.NotificationCompat.CATEGORY_SERVICE;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;

import java.util.HashMap;

import id.flutter.flutter_background_service.R;
import id.flutter.flutter_background_service.NotificationData;

public class ServiceNotification {
    private ServiceNotification() {
    }

    protected static final HashMap<String, Integer> NOTIFICATION_DAY_ICONS = new HashMap<String, Integer>() {
        {
            put("1", R.drawable.ic_number_1);
            put("2", R.drawable.ic_number_2);
            put("3", R.drawable.ic_number_3);
            put("4", R.drawable.ic_number_4);
            put("5", R.drawable.ic_number_5);
            put("6", R.drawable.ic_number_6);
            put("7", R.drawable.ic_number_7);
            put("8", R.drawable.ic_number_8);
            put("9", R.drawable.ic_number_9);
            put("10", R.drawable.ic_number_10);
            put("11", R.drawable.ic_number_11);
            put("12", R.drawable.ic_number_12);
            put("13", R.drawable.ic_number_13);
            put("14", R.drawable.ic_number_14);
            put("15", R.drawable.ic_number_15);
            put("16", R.drawable.ic_number_16);
            put("17", R.drawable.ic_number_17);
            put("18", R.drawable.ic_number_18);
            put("19", R.drawable.ic_number_19);
            put("20", R.drawable.ic_number_20);
            put("21", R.drawable.ic_number_21);
            put("22", R.drawable.ic_number_22);
            put("23", R.drawable.ic_number_23);
            put("24", R.drawable.ic_number_24);
            put("25", R.drawable.ic_number_25);
            put("26", R.drawable.ic_number_26);
            put("27", R.drawable.ic_number_27);
            put("28", R.drawable.ic_number_28);
            put("29", R.drawable.ic_number_29);
            put("30", R.drawable.ic_number_30);
            put("31", R.drawable.ic_number_31);
        }
    };

    protected static final HashMap<String, Integer> LAYOUT_DAY_ICONS = new HashMap<String, Integer>() {
        {
            put("1", R.drawable.ic_layout_1);
            put("2", R.drawable.ic_layout_2);
            put("3", R.drawable.ic_layout_3);
            put("4", R.drawable.ic_layout_4);
            put("5", R.drawable.ic_layout_5);
            put("6", R.drawable.ic_layout_6);
            put("7", R.drawable.ic_layout_7);
            put("8", R.drawable.ic_layout_8);
            put("9", R.drawable.ic_layout_9);
            put("10", R.drawable.ic_layout_10);
            put("11", R.drawable.ic_layout_11);
            put("12", R.drawable.ic_layout_12);
            put("13", R.drawable.ic_layout_13);
            put("14", R.drawable.ic_layout_14);
            put("15", R.drawable.ic_layout_15);
            put("16", R.drawable.ic_layout_16);
            put("17", R.drawable.ic_layout_17);
            put("18", R.drawable.ic_layout_18);
            put("19", R.drawable.ic_layout_19);
            put("20", R.drawable.ic_layout_20);
            put("21", R.drawable.ic_layout_21);
            put("22", R.drawable.ic_layout_22);
            put("23", R.drawable.ic_layout_23);
            put("24", R.drawable.ic_layout_24);
            put("25", R.drawable.ic_layout_25);
            put("26", R.drawable.ic_layout_26);
            put("27", R.drawable.ic_layout_27);
            put("28", R.drawable.ic_layout_28);
            put("29", R.drawable.ic_layout_29);
            put("30", R.drawable.ic_layout_30);
            put("31", R.drawable.ic_layout_31);
        }
    };

    protected static int getNotificationDayDrawable(String day) {
        Integer icon = NOTIFICATION_DAY_ICONS.get(day);
        return icon == null ? R.drawable.ic_stat_soha : icon;
    }

    protected static int getLayoutDayDrawable(String day) {
        Integer icon = LAYOUT_DAY_ICONS.get(day);
        return icon == null ? R.drawable.ic_layout_soha : icon;
    }


    protected static RemoteViews contentView(Context context, NotificationData notificationData) {
        return RemoteViewBuilder.instance(context, R.layout.notification_layout_small)
                .add(R.id.txt_currentJalaliSmall, notificationData.getJalali(), 20)
                .add(R.id.txt_currentMiladiSmall, notificationData.getMiladi(), 16)
                .add(R.id.txt_currentHijriSmall, notificationData.getHijri(), 16)
                .build();
    }

    protected static RemoteViews bigContentView(Context context, NotificationData notificationData) {
        int adaptiveColor = ServiceUi.Theme.adaptiveColorOf(context, notificationData.getTheme());
        Bitmap currentDayBitmap = BitmapUtils.colorFilterOf(context, getLayoutDayDrawable(notificationData.getDay()), adaptiveColor);

        return RemoteViewBuilder.instance(context, R.layout.notification_layout)
                .add(R.id.img_current_day, currentDayBitmap)
                //.add(R.id.txt_currentDay, notificationData.getDay(), 25, adaptiveColor)
                .add(R.id.txt_currentJalali, notificationData.getJalali(), 20)
                .add(R.id.txt_currentMiladi, notificationData.getMiladi(), 16)
                .add(R.id.txt_currentHijri, notificationData.getHijri(), 16)
                .build();
    }


    public static NotificationCompat.Builder builder(
            Context context,
            String channelId,
            PendingIntent pi,
            NotificationData notificationData
    ) {
        return new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(getNotificationDayDrawable(notificationData.getDay()))
                .setCustomContentView(contentView(context, notificationData))
                .setCustomBigContentView(bigContentView(context, notificationData))
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setOngoing(true)
                .setCategory(CATEGORY_SERVICE)
                .setContentIntent(pi);
    }
}
