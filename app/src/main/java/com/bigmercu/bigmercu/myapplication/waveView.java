package com.bigmercu.bigmercu.myapplication;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by bigmercu on 2016/8/21.
 * Email: bigmercu@gmail.com
 */

public class waveView extends View {

    private Paint mPaint;
    private Paint mPaint1;
    private Path mPath;
    private Path mPath1;
    private int screenHeight;
    private int screenWidth;
    private int mStartPointX;
    private int mStartPointY;
    private int mEndPointX;
    private int mEndPointY;
    private int mWaveCount;
    private int mWaveLength = 700;
    private int mHight;
    private int mOffset;


    public waveView(Context context) {
        super(context);
    }

    public waveView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public waveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public waveView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setHight(int hight){
        mHight = dp2px(30 * hight);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenWidth = w;
        screenHeight = h;

        mPath = new Path();
        mPath1 = new Path();

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);

        mPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint1.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint1.setAntiAlias(true);
        mPaint1.setDither(true);

        mWaveCount = (int) Math.round(screenWidth / mWaveLength + 1.5)  +2;
        mHight = screenHeight / 2;

        ValueAnimator animator = ValueAnimator.ofInt(0, mWaveLength);
        animator.setDuration(1000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mOffset = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.reset();
        mPaint1.setColor(Color.argb(180,0,120,156));

        mPath.moveTo(-mWaveLength + mOffset - 60, mHight);
        for (int i = 0; i < mWaveCount; i++) {
            mPath.quadTo((-mWaveLength * 3 / 4) + (i * mWaveLength) + mOffset, mHight + 40, (-mWaveLength / 2) + (i * mWaveLength) + mOffset, mHight);
            mPath.quadTo((-mWaveLength / 4) + (i * mWaveLength) + mOffset, mHight - 40, i * mWaveLength + mOffset, mHight);
        }
        mPath.lineTo(screenWidth + 80, screenHeight);
        mPath.lineTo(-80, screenHeight);
        mPath.close();
        canvas.drawPath(mPath, mPaint1);
        canvas.translate(-80,0);
        mPaint.setColor(Color.argb(120,255,255,255));
        canvas.drawPath(mPath,mPaint1);
    }

    public int dp2px(float value) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (value * density + 0.5f);
    }

}
