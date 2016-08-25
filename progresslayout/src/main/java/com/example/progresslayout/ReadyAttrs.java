package com.example.progresslayout;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

/**
 * Created by kidcats on 2016/8/12.
 */
public class ReadyAttrs {

    private static final String TAG="readyattrs";
    public static String defaultcolor = "#FF9BF97C";
    public static int defaultdurction = 3000;
    private int reacolor;
    private float reacWeight;
    private float reacHeight;
    private int maxprogress;
    private int progress;
    private int paintalpha;
    private Rect targetrect;
    private Rect nowRect;
    private int animationdurction;
    private Paint reacpaint;


    public ReadyAttrs() {
        reacpaint = new Paint();
        reacpaint.setAlpha(10);
        nowRect=new Rect();
    }



    public ReadyAttrs setProgress(int progress) {
        this.progress = progress;
        Log.i(TAG,"setProgress()"+progress);
        return this;
    }

    /**
     * draw rect
     * @param canvas return the canvas which we use
     */
    public void drawRect(Canvas canvas) {
        int setprogress=this.getProgress();
        int right= (int) ((setprogress)*(this.getReacWeight()/maxprogress));
        nowRect.right=right;
        nowRect.bottom= (int) this.getReacHeight();
        canvas.drawRect(nowRect,reacpaint);
        Log.i(TAG,""+this.getReacHeight());
        Log.i(TAG,"inivalidate"+setprogress+"    "+this.getTargetrect().right+"     "+this.getNowRect().right);
    }




    public ReadyAttrs setPaintAlpha(int alpha){
        this.paintalpha=alpha;
        if(this.getReacpaint()==null){
            this.reacpaint=new Paint();
        }
        this.getReacpaint().setAlpha(alpha);
        return this;
    }
    public int getReacolor() {
        return reacolor;
    }

    public ReadyAttrs setReacolor(int reacolor) {
        this.reacolor = reacolor;
        if(this.getReacpaint()==null){
            this.reacpaint=new Paint();
        }
        this.getReacpaint().setColor(reacolor);
        return this;
    }

    public float getReacWeight() {
        return reacWeight;
    }

    public ReadyAttrs setReacWeight(float reacWeight) {
        this.reacWeight = reacWeight;
        return this;
    }

    public int getMaxprogress() {
        return maxprogress;
    }

    public ReadyAttrs setMaxprogress(int maxprogress) {
        this.maxprogress = maxprogress;
        return this;
    }

    public float getReacHeight() {
        return reacHeight;
    }

    public ReadyAttrs setReacHeight(float reacHeight) {
        this.reacHeight = reacHeight;
        return this;
    }

    public int getProgress() {
        return progress;
    }

    public Rect getTargetrect() {
        return targetrect;
    }

    public ReadyAttrs setTargetrect(Rect targetrect) {
        this.targetrect = targetrect;
        return this;
    }

    public Rect getNowRect() {
        return nowRect;
    }

    public ReadyAttrs setNowRect(Rect nowRect) {
        this.nowRect = nowRect;
        return this;
    }

    public int getAnimationdurction() {
        return animationdurction;
    }

    public ReadyAttrs setAnimationdurction(int animationdurction) {
        this.animationdurction = animationdurction;
        return this;
    }

    public Paint getReacpaint() {
        return reacpaint;
    }

    public ReadyAttrs setReacpaint(ReadyAttrs attrs) {
        this.reacpaint = new Paint();
        this.reacpaint.setColor(attrs.getReacolor());
        return this;
    }

}
