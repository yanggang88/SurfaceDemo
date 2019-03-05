package com.example.admin.surface_demo_kto;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

import java.util.Random;

import static java.lang.Thread.sleep;

public class SurfaceViewJ extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    SurfaceHolder surfaceHolder;
    Canvas canvas;
    boolean isNew = false;
    Paint paint;
    int width = 0;
    int heigh = 0;
    public SurfaceViewJ(Context context) {
        super(context);
        initView(context);
    }

    public SurfaceViewJ(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public SurfaceViewJ(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @SuppressLint("NewApi")
    public SurfaceViewJ(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        isNew = true;
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        isNew = false;
    }

    @Override
    public void run() {
        while (isNew) {
            drawJ();
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void drawJ() {
        try {
            canvas = surfaceHolder.lockCanvas();
            int x = new Random().nextInt(width);
            int y = new Random().nextInt(heigh);
            canvas.drawCircle(x, y, 10, paint);
        } catch (Exception e) {

        } finally {
            if (canvas != null) {
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }

    }

    void initView(Context context) {
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        paint = new Paint();
        paint.setColor(Color.RED);
        WindowManager windowManager = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        width = windowManager.getDefaultDisplay().getWidth();
        heigh = windowManager.getDefaultDisplay().getHeight();
    }
}
