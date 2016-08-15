package com.example.checkbox;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Checkable;

/**
 * Created by bigmercu on 16/7/23.
 * Email:bigmercu@gmail.com
 */

public class BBox extends View implements Checkable{

    private static final String TAG = BBox.class.getSimpleName();
    private int hSize = dp2px(100);
    private int wSize = dp2px(100);
    private int textSize = dp2px(15);
    private int wStart = dp2px(1);
    private int hStart = dp2px(1);
    private int Duration = 300;
    private int strokeWidth = dp2px(8);
    private int colorBefore = Color.BLACK;
    private int colorAfter = Color.RED;
    private String boxText = "CheckBox";
    private Paint mPaint;
    private Paint mPaintAfter;
    private Paint mPaintText;
    private Path mPath;
    private Path mDst;
    private PathMeasure pathMeasure;
    private float pathLenth;
    private int AnimationValue = 255;
    private int AnimationValue1;
    private float AnimationValue2;
    private float AnimationValue3;
    private float AnimationValue4;
    private ValueAnimator valueAnimator;
    private ValueAnimator valueAnimator1;
    private ValueAnimator valueAnimator2;
    private ValueAnimator valueAnimator3;
    private ValueAnimator valueAnimator4;
    private float cAnimationValue = 0;
    private float cAnimationValue1 = 0;
    private float cAnimationValue2 = 255;
    private ValueAnimator cValueAnimator;
    private ValueAnimator cValueAnimator1;
    private ValueAnimator cValueAnimator2;
    private boolean checked = false;
    private boolean isHook = true;
    private int mScreenWidth,mSreenHeight;
    private OnCheckedChangeListener mOnCheckedChangeListener;

    public BBox(Context context) {
        super(context);
    }

    public BBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();

        if(attrs != null){
            TypedArray array = getContext().obtainStyledAttributes(attrs,R.styleable.BBox);
            colorAfter = array.getColor(R.styleable.BBox_color_after,Color.RED);
            colorBefore = array.getColor(R.styleable.BBox_color_before,Color.BLACK);
            boxText = array.getString(R.styleable.BBox_check_text);
            isHook = array.getInt(R.styleable.BBox_check_style, 1) == 1;
            if(boxText == null){
                boxText = "CheckBox";
            }
            array.recycle();
        }else {
            if(strokeWidth > 15) {
                strokeWidth = dp2px(5);
            }
        }


        mPaint.setColor(colorBefore);
        mPaint.setStrokeWidth(strokeWidth);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeCap(Paint.Cap.SQUARE);

        mPaintAfter = new Paint();
        mPaintText = new Paint();

        mPaintAfter.setColor(colorAfter);
        mPaintAfter.setStrokeWidth(strokeWidth);
        mPaintAfter.setStyle(Paint.Style.STROKE);
        mPaintAfter.setAntiAlias(true);
        mPaintAfter.setStrokeCap(Paint.Cap.SQUARE);

        mPaintText.setColor(Color.BLACK);
//        mPaintText.setStrokeWidth(strokeWidth);
        mPaintText.setAntiAlias(true);
        mPaintText.setStyle(Paint.Style.STROKE);
        mPaintText.setTextSize(textSize);
        mPaintText.setAntiAlias(true);

        mPath = new Path();
        pathMeasure = new PathMeasure();

        mPath.addRect(wStart,hStart,wSize + wStart,hSize + hStart, Path.Direction.CW);
        pathMeasure.setPath(mPath,true);
        pathLenth = pathMeasure.getLength();

        mDst = new Path();

        if(isHook) {

            valueAnimator = ValueAnimator.ofInt(255, 0);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    AnimationValue = (int) animation.getAnimatedValue();
                }
            });

            valueAnimator1 = ValueAnimator.ofInt(180, 225);
            valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    AnimationValue1 = (int) animation.getAnimatedValue();
                }
            });

            valueAnimator2 = ValueAnimator.ofFloat(hSize + wSize, wSize * 2 / 5);
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    AnimationValue2 = (float) animation.getAnimatedValue();
                }
            });

            valueAnimator3 = ValueAnimator.ofFloat(hSize + wSize, hSize + wSize * 2);
            valueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    AnimationValue3 = (float) animation.getAnimatedValue();
                }
            });

            valueAnimator4 = ValueAnimator.ofFloat((float) 0.0, (float) 0.207555);
            valueAnimator4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    AnimationValue4 = (float) animation.getAnimatedValue();
                    postInvalidate();
                }
            });


            valueAnimator.setDuration(Duration / 2);
            valueAnimator1.setDuration(Duration);
            valueAnimator2.setDuration(Duration);
            valueAnimator3.setDuration(Duration);
            valueAnimator4.setDuration(Duration);
            valueAnimator.setInterpolator(new DecelerateInterpolator());
            valueAnimator1.setInterpolator(new DecelerateInterpolator());
            valueAnimator2.setInterpolator(new DecelerateInterpolator());
            valueAnimator3.setInterpolator(new DecelerateInterpolator());
            valueAnimator4.setInterpolator(new DecelerateInterpolator());
        }else {
            cValueAnimator = ValueAnimator.ofFloat(0,(int)(hSize * 0.41));
            cValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    cAnimationValue = (float) animation.getAnimatedValue();
                }
            });


            cValueAnimator1 = ValueAnimator.ofFloat(0,wSize/2);
            cValueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    cAnimationValue1 = (float) animation.getAnimatedValue();
                }
            });


            cValueAnimator2 = ValueAnimator.ofFloat(255,0);
            cValueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    cAnimationValue2 = (float) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
            cValueAnimator.setDuration(Duration);
            cValueAnimator1.setDuration(Duration);
            cValueAnimator2.setDuration(Duration);
            cValueAnimator.setInterpolator(new DecelerateInterpolator());
            cValueAnimator1.setInterpolator(new DecelerateInterpolator());
            cValueAnimator2.setInterpolator(new DecelerateInterpolator());
        }
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setChecked(!checked);
            }
        });
    }

    public BBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int paddingLeft = getPaddingLeft() + 10;
        int paddingRight = getPaddingRight() + 10;
        int paddingTop = getPaddingTop() + 10;
        int paddingBottom = getPaddingBottom() + 10;


        textSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 15, getResources().getDisplayMetrics());

        if(widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(2* strokeWidth +  wStart + wSize  + 20 + paddingLeft + textSize * boxText.length(),hStart + hSize + paddingTop + paddingBottom + 2 * strokeWidth);
            Log.d(TAG, wStart+" "+ wSize +" "+ textSize * boxText.length() + "   " +boxText.length());
        }else if(widthSpecMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(2* strokeWidth +wStart + wSize + paddingLeft + 20 +  textSize * boxText.length(),widthSpecSize);
        }else if(heightSpecMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(heightSpecSize,hStart + hSize + paddingTop + paddingBottom+ 2 * strokeWidth);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    public void setChecked(boolean set){
        if(checked == set){
            return;
        }else {
            if(checked){
                animationReverse();
            }else {
                animationStart();
            }
            checked = set;
        }
        if(mOnCheckedChangeListener != null){
            mOnCheckedChangeListener.onChange(checked);
        }
        invalidate();
    }

    public boolean isChecked(){
        return checked;
    }

    @Override
    public void toggle() {
        setChecked(!checked);
    }


    public void setText(String text){
        boxText = text;
        invalidate();
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mScreenWidth = w;
        mSreenHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mDst.reset();

        int paddingLeft = getPaddingLeft() + 10;
        int paddingRight = getPaddingRight() + 10;
        int paddingTop = getPaddingTop() + 10;
        int paddingBottom = getPaddingBottom() + 10;



        if(isHook) {

            mDst.lineTo(0,0);
            canvas.translate(wStart + paddingLeft, hStart + paddingTop);
            canvas.drawText(boxText, wStart + paddingLeft + wSize + 18, (hSize + textSize )/2, mPaintText);
            //确保图形在正中
            canvas.translate(-AnimationValue4 * wSize, -AnimationValue4 * hSize * 2);
            /**
             * 如果 startWithMoveTo 为 true, 则被截取出来到Path片段保持原状，如果 startWithMoveTo 为 false，
             * 则会将截取出来的 Path 片段的起始点移动到 dst 的最后一个点，以保证 dst 的连续性。
             * */

            pathMeasure.getSegment(AnimationValue3, pathLenth, mDst, true);
            pathMeasure.getSegment(0, wSize * 2 / 5, mDst, true);
            pathMeasure.getSegment(wSize * 2 / 5, AnimationValue2, mDst, true);
            mPaint.setAlpha(AnimationValue);
            mPaintAfter.setAlpha(255 - AnimationValue);

            canvas.rotate(AnimationValue1, wStart  + wSize / 2, hStart  + hSize / 2);
            canvas.drawPath(mDst, mPaint);
            canvas.drawPath(mDst, mPaintAfter);
        }else {
            mDst.lineTo(0,0);
            canvas.translate(wStart+ paddingLeft , hStart + paddingTop );

            canvas.drawText(boxText, wStart + paddingLeft + wSize + 18, (hSize + textSize )/2, mPaintText);
            mDst.moveTo((float) (wStart + cAnimationValue * 0.2), (float) (hStart + cAnimationValue * 0.2));
            mDst.lineTo(wStart + wSize/2, (float) (hStart + cAnimationValue + cAnimationValue * 0.2));
            mDst.lineTo((float) (wStart+ wSize - cAnimationValue * 0.2), (float) (hStart + cAnimationValue * 0.2));
            mDst.lineTo((float) (wStart+ wSize -cAnimationValue - cAnimationValue * 0.2),hSize/2 + hStart );
            mDst.lineTo((float) (wStart+ wSize - cAnimationValue * 0.2), (float) (hStart  + hSize - cAnimationValue * 0.2));
            mDst.lineTo(wStart+ wSize/2, (float) (hStart  + hSize - cAnimationValue - cAnimationValue * 0.2));
            mDst.lineTo((float) (wStart + cAnimationValue * 0.2), (float) (hStart  + hSize - cAnimationValue * 0.2));
            mDst.lineTo((float) (wStart + cAnimationValue + cAnimationValue * 0.2),hStart  + hSize/2);
            mDst.lineTo((float) (wStart + cAnimationValue * 0.2), (float) (hStart + cAnimationValue * 0.2));
            mPaint.setAlpha((int) cAnimationValue2);
            canvas.drawPath(mDst,mPaint);
            mPaintAfter.setAlpha((int) (255-cAnimationValue2));
            canvas.drawPath(mDst,mPaintAfter);
        }

    }



    private void animationStart(){
        if(isHook) {
            valueAnimator.start();
            valueAnimator1.start();
            valueAnimator2.start();
            valueAnimator3.start();
            valueAnimator4.start();
        }else {
            cValueAnimator.start();
            cValueAnimator1.start();
            cValueAnimator2.start();
        }
    }

    private void animationReverse(){
        if(isHook) {
            valueAnimator.reverse();
            valueAnimator1.reverse();
            valueAnimator2.reverse();
            valueAnimator3.reverse();
            valueAnimator4.reverse();
        }else {
            cValueAnimator.reverse();
            cValueAnimator1.reverse();
            cValueAnimator2.reverse();
        }
    }


    public int dp2px(float value) {
        final float scale = getContext().getResources().getDisplayMetrics().densityDpi;
        return (int) (value * (scale / 160) + 0.5f);
    }


    public interface  OnCheckedChangeListener{
        void onChange(boolean checked);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        this.mOnCheckedChangeListener = listener;
    }
}
