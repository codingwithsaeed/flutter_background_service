package id.flutter.flutter_background_service.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ConfigurationChangeReceiver extends BroadcastReceiver {
    public interface ConfigurationChangeHandler {
        void onConfigurationChanged();
    }

    private ConfigurationChangeHandler changeHandler;

    public ConfigurationChangeReceiver setUiChangeHandler(ConfigurationChangeHandler changeHandler) {
        this.changeHandler = changeHandler;
        return this;
    }

    public static ConfigurationChangeReceiver instance(ConfigurationChangeHandler changeHandler) {
        return new ConfigurationChangeReceiver().setUiChangeHandler(changeHandler);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals(Intent.ACTION_CONFIGURATION_CHANGED)) {
            if (changeHandler == null) return;

            changeHandler.onConfigurationChanged();
        }
    }
}
