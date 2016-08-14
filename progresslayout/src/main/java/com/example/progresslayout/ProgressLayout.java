package com.example.progresslayout;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;


/**
 * Created by kidcats on 2016/8/12.
 */
public class ProgressLayout extends RelativeLayout {


    private static final String TAG="prgresslayout";
    private int color;
    private int maxprogress;
    private int durction;
    private ReadyAttrs readyAttrs;
    private Rect rect;
    private int weight;//targetrect的宽高
    private int height;
    private float nowRectWeight;



    public ProgressLayout(Context context) {
        this(context,null);
    }

    public ProgressLayout(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public ProgressLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context,AttributeSet attrs) {

        setWillNotDraw(false);
        TypedArray a=context.obtainStyledAttributes(attrs, R.styleable.ProgressLayout);
        color=a.getColor(R.styleable.ProgressLayout_reaccolor, Color.parseColor(ReadyAttrs.defaultcolor));
        durction=a.getInteger(R.styleable.ProgressLayout_animationdurction, ReadyAttrs.defaultdurction);
        maxprogress=a.getInteger(R.styleable.ProgressLayout_maxprogress,100);
        a.recycle();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        if (rect==null){
            rect=new Rect(0,0,weight, height);
        }
        if (readyAttrs==null){
            readyAttrs=new ReadyAttrs();
            readyAttrs.setReacolor(color)
                    .setMaxprogress(maxprogress)
                    .setAnimationdurction(durction);
        }
        readyAttrs.setReacWeight(weight)//在layout的内部计算好相应的宽高
                .setReacHeight(height)
                .setTargetrect(rect);
        readyAttrs.drawRect(canvas);
        Log.i(TAG,"onDraw");
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    public void setProgress(int progress){
        readyAttrs.setProgress(progress);
        invalidate();
        Log.i(TAG,"setProgress()");
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        weight=w;
        height=h;
    }

    public void startAnimator(final ProgressLayout view){
        ValueAnimator animator=ValueAnimator.ofInt(view.getReadyAttrs().getProgress(),view.getReadyAttrs().getMaxprogress());
        animator.setTarget(view);
        animator.setDuration(view.getReadyAttrs().getAnimationdurction()).start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value= (int) animation.getAnimatedValue();
                view.setProgress(value);
            }
        });
        Log.i("anim","start");
    }


    public ReadyAttrs getReadyAttrs() {
        return readyAttrs;
    }

    public void setReadyAttrs(ReadyAttrs readyAttrs) {
        this.readyAttrs = readyAttrs;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    /**
     * 用于设置ObjectAnimator
     * @return
     */
    public float getNowRectWeight() {
        return nowRectWeight;
    }

    public void setNowRectWeight(float nowRectWeight) {
        this.readyAttrs.getNowRect().right= (int) nowRectWeight;
        this.nowRectWeight = nowRectWeight;
    }
}
