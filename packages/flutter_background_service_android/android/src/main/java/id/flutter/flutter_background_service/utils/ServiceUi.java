package id.flutter.flutter_background_service.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;

public final class ServiceUi {
    private ServiceUi() {
    }

    public enum Theme {
        purplito("#FF301728"),
        purple("#FF301452"),
        sohaBlue("#FF2B3349"),
        teal("#FF004d40"),
        indigo("#FF283593"),
        blue("#FF0d47a1"),
        crimson("#FF4D0F0F"),
        orange("#FFef6c00"),
        amber("#FFff8f00"),
        pink("#FFc2185b"),
        red("#FFb71c1c"),
        deepOrange("#FFff5722");

        public final String hexColor;

        Theme(String hexColor) {
            this.hexColor = hexColor;
        }

        public static int colorOf(String themeString) {
            try {
                return Color.parseColor(Theme.valueOf(themeString).hexColor);
            } catch (IllegalArgumentException e) {
                return Color.GRAY;
            }
        }

        public static int adaptiveColorOf(Context context, String themeString) {
            return Mode.of(context).isDark() ? Color.WHITE : colorOf(themeString);
        }
    }

    public enum Mode {
        light(Color.BLACK),
        dark(Color.WHITE);

        public final int textColor;

        Mode(int textColor) {
            this.textColor = textColor;
        }

        public final boolean isLight() {
            return this == light;
        }

        public final boolean isDark() {
            return this == dark;
        }

        public static Mode of(Context context) {
            return Utils.isNightMode(context) ? dark : light;
        }
    }
}





