package id.flutter.flutter_background_service.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import id.flutter.flutter_background_service.BackgroundService;

public class MediaPlayerReceiver extends BroadcastReceiver {

    public interface MediaPlayerListener {
        void playSound(int soundId, boolean loop);
        void stopSound();
    }

    private MediaPlayerListener listener;

    public MediaPlayerReceiver setCloseListener(MediaPlayerListener listener) {
        this.listener = listener;
        return this;
    }

    public static MediaPlayerReceiver instance(MediaPlayerListener listener) {
        return new MediaPlayerReceiver().setCloseListener(listener);
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && listener != null) {
            if (intent.getAction().equals(BackgroundService.ACTION_PLAY_SOUND)) {
                int soundId = intent.getIntExtra(BackgroundService.EXTRA_SOUND_ID, 0);
                boolean loop = intent.getBooleanExtra(BackgroundService.EXTRA_SOUND_LOOP, false);
                if (soundId != 0) {
                    listener.playSound(soundId, loop);
                }
                return;
            }

            if (intent.getAction().equals(BackgroundService.ACTION_STOP_SOUND)) {
                listener.stopSound();
            }
        }
    }
}
