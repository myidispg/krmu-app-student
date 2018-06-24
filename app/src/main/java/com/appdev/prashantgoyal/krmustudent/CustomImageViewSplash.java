package com.appdev.prashantgoyal.krmustudent;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CustomImageViewSplash extends AppCompatImageView {

    public static float radius = 350.0f;

    public CustomImageViewSplash(Context context) {
        super(context);
    }

    public CustomImageViewSplash(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomImageViewSplash(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas){
        Path clipPath = new Path();
        RectF rect = new RectF(0, 0, this.getWidth(), this.getHeight());
        clipPath.addRoundRect(rect, radius, radius, Path.Direction.CW);
        canvas.clipPath(clipPath);
        super.onDraw(canvas);
    }
}
