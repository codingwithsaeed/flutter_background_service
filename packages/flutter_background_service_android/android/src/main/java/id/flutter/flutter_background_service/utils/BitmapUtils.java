package id.flutter.flutter_background_service.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.util.TypedValue;

import id.flutter.flutter_background_service.R;

public class BitmapUtils {
    public static Bitmap bitmapOf(Context context, String text, float textSize, int textColor) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "iransans.ttf");
        Paint paint = new Paint();
        float sp = spToPx(context, textSize);
        paint.setTextSize(sp);
        paint.setTypeface(typeface);
        paint.setColor(textColor);
        paint.setTextAlign(Paint.Align.LEFT);
        float baseline = -paint.ascent(); // ascent() is negative
        int width = (int) (paint.measureText(text) + 0.5f); // round
        int height = (int) (baseline + paint.descent() + 0.5f);
        Bitmap image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(image);
        canvas.drawText(text, 0, baseline, paint);
        return image;
    }

    public static Bitmap colorFilterOf(Context context, int drawable, int color) {
        // Load the drawable as a bitmap
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), drawable);

        // Apply color filter to bitmap
        Bitmap filteredBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(filteredBitmap);
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(filteredBitmap, 0, 0, paint);

        return filteredBitmap;
    }

    private static int spToPx(Context context, float sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }
}
