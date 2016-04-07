package com.cjj.sva.anim.controller;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import com.cjj.sva.anim.JJBaseController;

/**
 * Created by cjj on 2016/4/3.
 */
public class JJBarWithErrorIconController extends JJBaseController {
    private String mColor = "#E91E63";
    private float cx, cy, cr;
    private float sign = 0.707f;
    private float mCircleBig = 10;
    private RectF mRectF, mRectF2;
    private float mCirCleDis = 200;
    private Paint mFontPaint;

    public JJBarWithErrorIconController() {
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
        canvas.save();
        if (mPro <= 0.25) {
            canvas.drawArc(mRectF, 90, -180, false, paint);
            canvas.drawLine(mRectF2.left + cr, mRectF.top, mRectF.right - cr, mRectF.top, paint);
            canvas.drawLine(mRectF2.left + cr, mRectF.bottom, mRectF.right - cr, mRectF.bottom,
                    paint);
            canvas.drawArc(mRectF2, 90, 180, false, paint);
            canvas.drawLine(mRectF.left + cr - sign * cr / 2, cy + cr * sign / 2, mRectF.left + cr + sign * cr / 2, cy - cr * sign / 2, paint);
        } else if (mPro > 0.25 && mPro <= 0.5f) {
            canvas.drawArc(mRectF, 90, -180, false, paint);
            canvas.drawLine(mRectF2.left + cr, mRectF.top, mRectF.right - cr, mRectF.top, paint);
            canvas.drawLine(mRectF2.left + cr, mRectF.bottom, mRectF.right - cr, mRectF.bottom,
                    paint);
            canvas.drawArc(mRectF2, 90, 180, false, paint);
            canvas.drawArc(mRectF2, 90, 180, false, paint);
        } else if (mPro > 0.5f && mPro <= 0.75f) {
            canvas.drawCircle(cx, cy, cr, paint);
        } else {
            canvas.drawLine(cx + cr * sign, cy + cr * sign, cx + cr * sign + cr * sign *
                    (mPro - 0.75f) * 4, cy + cr * sign + cr * sign * (mPro - 0.75f) * 4, paint);
            canvas.drawCircle(cx, cy, cr, paint);
        }
        canvas.restore();
    }

    private void drawStartAnimView(Paint paint, Canvas canvas) {
        canvas.save();

        if (mPro <= 0.25) {
            canvas.drawLine(cx + cr * sign, cy + cr * sign, cx + cr * sign + cr * sign *
                    (1 - mPro * 4), cy + cr * sign + cr * sign * (1 - mPro * 4), paint);
            canvas.drawCircle(cx, cy, cr, paint);
        } else if (mPro > 0.25 && mPro <= 0.5f) {
            mRectF.left = cx - cr + mCirCleDis * (mPro - 0.25f) * 4;
            mRectF.right = cx + cr + mCirCleDis * (mPro - 0.25f) * 4;
            mRectF2.left = cx - cr - mCirCleDis * (mPro - 0.25f) * 4;
            mRectF2.right = cx + cr - mCirCleDis * (mPro - 0.25f) * 4;
            canvas.drawArc(mRectF, 90, -180, false, paint);
            canvas.drawLine(mRectF2.left + cr, mRectF.top, mRectF.right - cr, mRectF.top, paint);
            canvas.drawLine(mRectF2.left + cr, mRectF.bottom, mRectF.right - cr, mRectF.bottom,
                    paint);
            canvas.drawArc(mRectF2, 90, 180, false, paint);
        } else if (mPro > 0.5f && mPro <= 0.75f) {
            canvas.drawArc(mRectF, 90, -180, false, paint);
            canvas.drawLine(mRectF2.left + cr, mRectF.top, mRectF.right - cr, mRectF.top, paint);
            canvas.drawLine(mRectF2.left + cr, mRectF.bottom, mRectF.right - cr, mRectF.bottom,
                    paint);
            canvas.drawArc(mRectF2, 90, 180, false, paint);
            canvas.drawLine(mRectF.left + cr - sign * cr / 2 * (mPro - 0.5f) * 4, cy + cr *
                    sign / 2 * (mPro - 0.5f) * 4, mRectF.left + cr + sign * cr / 2 + sign *
                    cr / 2 * (1 - (mPro - 0.5f) * 4), cy - cr * sign / 2 - sign * cr / 2 *
                    (1 - (mPro - 0.5f) * 4), paint);

        } else {
            canvas.drawArc(mRectF, 90, -180, false, paint);
            canvas.drawLine(mRectF2.left + cr, mRectF.top, mRectF.right - cr, mRectF.top, paint);
            canvas.drawLine(mRectF2.left + cr, mRectF.bottom, mRectF.right - cr, mRectF.bottom,
                    paint);
            canvas.drawArc(mRectF2, 90, 180, false, paint);
            canvas.drawLine(mRectF.left + cr - sign * cr / 2, cy + cr * sign / 2, mRectF.left +
                    cr + sign * cr / 2, cy - cr * sign / 2, paint);
            canvas.drawLine(mRectF.left + cr - sign * cr / 2 * (mPro - 0.75f) * 4, cy - cr *
                    sign / 2 * (mPro - 0.75f) * 4, mRectF.left + cr + sign * cr / 2 + sign *
                    cr / 2 * (1 - (mPro - 0.75f) * 4), cy + cr * sign / 2 + sign * cr / 2 *
                    (1 - (mPro - 0.75f) * 4), paint);
        }

        canvas.restore();
    }

    private void drawNormalView(Paint paint, Canvas canvas) {
        cr = getWidth() / 15;
        cx = getWidth() / 2;
        cy = getHeight() / 2;
        mRectF.top = cy - cr;
        mRectF.bottom = cy + cr;
        mRectF2.top = cy - cr;
        mRectF2.bottom = cy + cr;

        paint.reset();
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.save();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(8);
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
        startSearchViewAnim();
    }

    @Override
    public void resetAnim() {
        if (mState == STATE_ANIM_STOP) return;
        mState = STATE_ANIM_STOP;
        startSearchViewAnim();
    }

}
