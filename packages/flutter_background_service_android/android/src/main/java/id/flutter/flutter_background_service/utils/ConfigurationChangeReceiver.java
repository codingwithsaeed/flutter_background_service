package id.flutter.flutter_background_service.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ConfigurationChangeReceiver extends BroadcastReceiver {
    public interface UiModeChangeHandler {
        void onUiModeChanged();
    }

    private UiModeChangeHandler uiModeChangeHandler;

    public ConfigurationChangeReceiver setUiChangeHandler(UiModeChangeHandler uiModeChangeHandler) {
        this.uiModeChangeHandler = uiModeChangeHandler;
        return this;
    }

    public static ConfigurationChangeReceiver instance(UiModeChangeHandler uiModeChangeHandler) {
        return new ConfigurationChangeReceiver().setUiChangeHandler(uiModeChangeHandler);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals(Intent.ACTION_CONFIGURATION_CHANGED)) {
            if (uiModeChangeHandler == null) return;

            uiModeChangeHandler.onUiModeChanged();
        }
    }
}
