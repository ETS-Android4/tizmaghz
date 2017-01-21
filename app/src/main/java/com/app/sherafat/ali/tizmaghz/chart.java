package com.app.sherafat.ali.tizmaghz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;


public class chart extends ImageView {
    private Paint chartPaint;
    private Paint AxisPaint;
    private Paint circlePaint;
    private float xStep = 25.0f;
    private float padding=40;
    private int DATA_COUNT = 60;
    private float[] data = new float[DATA_COUNT];
    private int verMaxValue;
    private int verDeviderCount=50;
    private int verAndisScape=5;
    private int horAndisScape=5;
    private int verScaleDevider;

    public void setData(float[] Data) {
        if (Data!=null) {
            data = Data;
            DATA_COUNT = Data.length;
            invalidate();
        }
    }

    public void setVerMaxValue(int value) {
        verMaxValue = value;
        verScaleDevider=verMaxValue/verDeviderCount;
        invalidate();
    }

    public void setVerDeviderCount(int value) {
        verDeviderCount = value;
        invalidate();
    }

    public void setVerAndisScape(int value) {
        verAndisScape = value;
        invalidate();
    }

    public void setHorAndisScape(int value) {
        horAndisScape = value;
        invalidate();
    }


    public chart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialize();
    }


    public chart(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }


    public chart(Context context) {
        super(context);
        initialize();
    }

    private void initialize() {
       // generateRandomData();

        chartPaint = new Paint();
        chartPaint.setColor(Color.BLUE);
        chartPaint.setAntiAlias(true);
        chartPaint.setStyle(Paint.Style.STROKE);
        chartPaint.setTextAlign(Paint.Align.CENTER);
        chartPaint.setTextSize(12);

        AxisPaint = new Paint();
        AxisPaint.setColor(Color.BLACK);
        AxisPaint.setAntiAlias(true);
        AxisPaint.setStyle(Paint.Style.STROKE);
        AxisPaint.setTextAlign(Paint.Align.CENTER);
        AxisPaint.setTextSize(12);

        circlePaint = new Paint();
        circlePaint.setColor(Color.LTGRAY);
        circlePaint.setAntiAlias(true);
        circlePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        circlePaint.setTextAlign(Paint.Align.CENTER);
        circlePaint.setTextSize(12);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawLine(padding, padding, padding, getHeight() - padding, AxisPaint);
        canvas.drawLine(padding, getHeight() - padding, getWidth() - padding, getHeight() - padding, AxisPaint);


        for (int i=0;i<=verDeviderCount;i++) {
            canvas.drawLine(padding - 5, getHeight() - padding - i*((getHeight()-2*padding)/verDeviderCount), padding + 5,  getHeight() - padding - i*((getHeight()-2*padding)/verDeviderCount), AxisPaint);
            if(i%verAndisScape==0)
                canvas.drawText("" + i*verScaleDevider, padding - 22, getHeight() - padding - i*((getHeight()-2*padding)/verDeviderCount), AxisPaint);
        }
        float startPosition = (offset / xStep);
        float startIndex = (int) startPosition;
        int width = getWidth();
        int possibleRenderCount = (int) (width / xStep);
        if (startIndex < 1) {
            startIndex = 1;
        }
        if (startIndex < DATA_COUNT) {
            int endIndex = (int) startIndex + possibleRenderCount;
            if (endIndex >= DATA_COUNT) {
                endIndex = DATA_COUNT;
            }

            if (startIndex < DATA_COUNT) {

                for (int i = (int)startIndex; i <= endIndex; i++) {
                    canvas.drawLine(padding + xStep + (i - startIndex) * xStep, getHeight() - padding + 5, padding + xStep + (i - startIndex) * xStep, getHeight() - padding - 5, AxisPaint);
                    canvas.drawCircle(padding + xStep + (i - startIndex) * xStep,getHeight() - padding - data[i - 1] / verScaleDevider * ((getHeight() - 2 * padding) / verDeviderCount),6, circlePaint);
                    if (i%horAndisScape==0){
                        canvas.drawText("" + i,(i +1-startIndex) * xStep+padding,getHeight()-padding+20, AxisPaint);
                    }
                }


                for (int i = (int)startIndex; i < endIndex; i++) {
                    canvas.drawLine(padding + xStep + (i - startIndex) * xStep, getHeight() - padding - data[i - 1] / verScaleDevider * ((getHeight() - 2 * padding) / verDeviderCount), padding + xStep + (i+1- startIndex) * xStep, getHeight() - padding - data[i] / verScaleDevider * ((getHeight()-2*padding)/verDeviderCount), chartPaint);
                }
            }
        }
    }

    private float lastDownX;

    private float offset;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastDownX = event.getRawX();

                break;

            case MotionEvent.ACTION_MOVE:
                float currentX = event.getRawX();
                offset += lastDownX - currentX;
                if (offset < 0) {
                    offset = 0;
                }
                lastDownX = currentX;
                invalidate();
                break;

        }
        return true;
    }

}

