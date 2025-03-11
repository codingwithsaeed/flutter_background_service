package id.flutter.flutter_background_service.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

import java.util.HashMap;

public class RemoteViewBuilder {
    protected final Context context;
    protected final Integer viewId;

    protected final RemoteViews view;
    protected final int textColor;

    protected HashMap<Integer, Bitmap> bitmaps;

    private RemoteViewBuilder(Context context, Integer viewId) {
        this.context = context;
        this.viewId = viewId;

        this.view = new RemoteViews(context.getApplicationContext().getPackageName(), viewId);
        this.textColor = ServiceUi.Mode.of(context).textColor;

        bitmaps = new HashMap<>();
    }

    public static RemoteViewBuilder instance(Context context, Integer viewId) {
        return new RemoteViewBuilder(context, viewId);
    }

    public RemoteViewBuilder add(int drawable, String text, int textSize) {
        return this.add(drawable, BitmapUtils.bitmapOf(this.context, text, textSize, this.textColor));
    }

    public RemoteViewBuilder add(int drawable, String text, int textSize, Integer textColor) {
        return this.add(drawable, BitmapUtils.bitmapOf(this.context, text, textSize, textColor));
    }

    public RemoteViewBuilder add(int drawable, Bitmap bitmap) {
        this.bitmaps.put(drawable, bitmap);
        return this;
    }


    public RemoteViews build() {
        this.setBitmaps();
        return this.view;
    }

    protected void setBitmaps() {
        for (Integer drawable : this.bitmaps.keySet()) {
            this.view.setImageViewBitmap(drawable, this.bitmaps.get(drawable));
        }
    }
}
