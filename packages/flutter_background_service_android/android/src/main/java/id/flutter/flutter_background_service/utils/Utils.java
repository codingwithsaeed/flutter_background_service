package id.flutter.flutter_background_service.utils;

import android.content.Context;
import android.content.res.Configuration;

public class Utils {
    public static boolean isNightMode(Context context) {
        int nightModeFlags = context.getApplicationContext().getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        return nightModeFlags == Configuration.UI_MODE_NIGHT_YES;
    }
}
