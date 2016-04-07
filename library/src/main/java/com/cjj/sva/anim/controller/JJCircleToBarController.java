package com.cjj.sva.anim.controller;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import com.cjj.sva.anim.JJBaseController;

/**
 * 这是一个神奇的类，SearchView变成bar,f**k,不想写了，太多了。
 * <p>
 * Created by cjj on 2016/4/3.
 */
public class JJCircleToBarController extends JJBaseController {
    private String mColor = "#E91E63";
    private float cx, cy, cr;
    private float sign = 0.707f;
    private float mCircleBig = 10;
    private RectF mRectF, mRectF2;
    private float mCirCleDis = 200;
    private Paint mFontPaint;

    public JJCircleToBarController() {
        mRectF = new RectF();
        mRectF2 = new RectF();
        mFontPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mFontPaint.setStrokeWidth(1);
        mFontPaint.setColor(Color.WHITE);
        mFontPaint.setStyle(Paint.Style.FILL);
        mFontPaint.setTextSize(40);
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawColor(Color.parseColor(mColor));
        switch (mState) {
            case STATE_ANIM_NONE:
                drawNormalView(paint, canvas);
                break;
            case STATE_ANIM_START:
                drawStartAnimView(paint, canvas);
                break;
            case STATE_ANIM_STOP:
                drawStopAnimView(paint, canvas);
                break;
        }
    }

    private void drawStopAnimView(Paint paint, Canvas canvas) {
        drawNormalView(paint, canvas);

    }

    private void drawStartAnimView(Paint paint, Canvas canvas) {
        canvas.save();

        if (mPro <= 0.1f) {
            canvas.drawLine(cx + cr * sign, cy + cr * sign, cx + cr * sign + cr * sign *
                    (1 - mPro * 10), cy + cr * sign + cr * sign * (1 - mPro * 10), paint);
            canvas.drawCircle(cx, cy, cr, paint);
        } else if (mPro > 0.1f && mPro <= 0.2) {
            canvas.drawCircle(cx, cy, cr + (mPro - 0.1f) * mCircleBig * 10, paint);
        } else if (mPro > 0.2 && mPro <= 0.3) {
            mRectF.left = cx - cr - mCircleBig + mCirCleDis * (mPro - 0.2f) * 10;
            mRectF.right = cx + cr + mCircleBig + mCirCleDis * (mPro - 0.2f) * 10;
            canvas.drawArc(mRectF, 0, 360, false, paint);
        } else if (mPro > 0.3 && mPro <= 0.4) {
            mRectF2.left = cx - cr - mCircleBig + mCirCleDis * (1 - (mPro - 0.3f) * 10);
            mRectF2.right = cx + cr + mCircleBig + mCirCleDis * (1 - (mPro - 0.3f) * 10);
            canvas.drawArc(mRectF, 90, -180, false, paint);
            canvas.drawLine(mRectF2.left + cr + mCircleBig, mRectF.top, mRectF.right - cr - mCircleBig, mRectF.top, paint);
            canvas.drawLine(mRectF2.left + cr + mCircleBig, mRectF.bottom, mRectF.right - cr - mCircleBig, mRectF.bottom, paint);
            canvas.drawArc(mRectF2, 90, 180, false, paint);
        } else if (mPro > 0.4 && mPro <= 0.5) {
            mRectF2.left = cx - cr - mCircleBig - mCirCleDis * (mPro - 0.4f) * 10;
            mRectF2.right = cx + cr + mCircleBig - mCirCleDis * (mPro - 0.4f) * 10;
            canvas.drawArc(mRectF, 90, -180, false, paint);
            canvas.drawLine(mRectF2.left + cr + mCircleBig, mRectF.top, mRectF.right - cr - mCircleBig, mRectF.top, paint);
            canvas.drawLine(mRectF2.left + cr + mCircleBig, mRectF.bottom, mRectF.right - cr - mCircleBig, mRectF.bottom, paint);
            canvas.drawArc(mRectF2, 90, 180, false, paint);
        } else if (mPro > 0.5 && mPro <= 0.6) {
            canvas.drawArc(mRectF, 90, -180, false, paint);
            canvas.drawLine(mRectF2.left + cr + mCircleBig, mRectF.top, mRectF.right - cr - mCircleBig, mRectF.top, paint);
            canvas.drawLine(mRectF2.left + cr + mCircleBig, mRectF.bottom, mRectF.right - cr - mCircleBig, mRectF.bottom, paint);
            canvas.drawArc(mRectF2, 90, 180, false, paint);

            if (mPro > 0.5f && mPro <= 0.52f) {
                canvas.drawText("J", cx - mCirCleDis, cy + cr / 2, mFontPaint);
            } else if (mPro > 0.52 && mPro <= 0.53f) {
                canvas.drawText("JJ", cx - mCirCleDis, cy + cr / 2, mFontPaint);
            } else if (mPro > 0.53 && mPro <= 0.54f) {
                canvas.drawText("JJ Search", cx - mCirCleDis, cy + cr / 2, mFontPaint);
            } else if (mPro > 0.54 && mPro <= 0.55f) {
                canvas.drawText("JJ Search Anim", cx - mCirCleDis, cy + cr / 2, mFontPaint);
            } else {
                canvas.drawText("JJ Search Animations", cx - mCirCleDis, cy + cr / 2, mFontPaint);
            }
        } else if (mPro > 0.6 && mPro <= 0.7) {
            canvas.drawCircle(cx, cy, cr + mCircleBig, paint);
            canvas.drawLine(cx - cr / 2 + 4, cy + cr / 2, cx - cr / 2 + 4 - cr / 2, cy - cr / 2 + 8, paint);
            canvas.drawLine(cx - cr / 2 + 4, cy + cr / 2, (cx + cr - 4), (cy - cr / 2), paint);
        } else {
            canvas.drawCircle(cx, cy, cr + mCircleBig, paint);
            canvas.drawText("BUG", cx - cr / 2 - 8, cy + cr / 2, mFontPaint);
            //年轻的骚年啊 收尾工作交给你了
        }

        canvas.restore();
    }

    private void drawNormalView(Paint paint, Canvas canvas) {
        cr = getWidth() / 15;
        cx = getWidth() / 2;
        cy = getHeight() / 2;
        mRectF.top = cy - cr - mCircleBig;
        mRectF.bottom = cy + cr + mCircleBig;
        mRectF2.top = cy - cr - mCircleBig;
        mRectF2.bottom = cy + cr + mCircleBig;

        paint.reset();
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.save();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(4);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(cx, cy, cr, paint);
        canvas.drawLine(cx + cr * sign, cy + cr * sign, cx + cr * 2 * sign,
                cy + cr * 2 * sign, paint);
        canvas.restore();
    }

    @Override
    public void startAnim() {
        if (mState == STATE_ANIM_START) return;
        mState = STATE_ANIM_START;
        startSearchViewAnim(0, 1, 3000);
    }

    @Override
    public void resetAnim() {
        if (mState == STATE_ANIM_STOP) return;
        mState = STATE_ANIM_STOP;
        startSearchViewAnim();
    }


}
