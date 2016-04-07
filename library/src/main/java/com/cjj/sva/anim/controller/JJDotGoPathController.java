package com.cjj.sva.anim.controller;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;

import com.cjj.sva.anim.JJBaseController;

/**
 * 这是一个神奇的类，一个神奇的点跑来跑去，你丫不累吗？
 * <p/>
 * Created by cjj on 2016/4/2.
 */
public class JJDotGoPathController extends JJBaseController {
    private String mColor = "#4CAF50";
    private float cx, cy, cr;
    private RectF mIntRectF, mOutRectF;
    private float sign = 0.707f;
    private Path mPath;
    private PathMeasure mPathMeasure;
    private float mPadding = 25;
    private float mCircleScaleIn = 20;
    private boolean isDrawDot = true;
    private float mArcTemp = 1;
    private Path mArcPath;
    private Paint mArcPaint;

    public JJDotGoPathController() {
        mIntRectF = new RectF();
        mOutRectF = new RectF();
        mPath = new Path();
        mArcPath = new Path();
        mArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setStrokeWidth(10);
        mArcPaint.setColor(Color.WHITE);
        mPathMeasure = new PathMeasure(mPath, false);
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
        if (mPro <= 0.2) {
            canvas.drawCircle(cx, cy, cr - mCircleScaleIn * mPro, paint);
            canvas.drawLine(cx + cr * sign + cr * sign * mPro * 5, cy + cr * sign +
                    cr * sign * mPro * 5, cx + cr * 2 * sign, cy + cr * 2 * sign, paint);
        } else if (mPro > 0.2 && mPro < mPathMeasure.getLength() - 20) {
            canvas.drawCircle(cx, cy, cr, paint);
            if (mPos[0] >= cx - 0.5f && mPos[0] <= cx + 0.5f && mPos[1] == cy) {
                if (isDrawDot) {
                    canvas.drawCircle(mPos[0], mPos[1], 2, paint);
                    isDrawDot = false;
                } else {
                    isDrawDot = true;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                isDrawDot = true;
                canvas.drawCircle(mPos[0], mPos[1], 2, paint);
            }

            if (mPos[0] <= cx + cr * sign) {
                mArcPath.reset();
                mArcPath.moveTo(cx + cr, cy);
                mArcTemp += 2;
                if (mArcTemp <= 20) {
                    mArcPath.quadTo(cx + cr * sign + mArcTemp, cy + cr * sign, cx, cy + cr);
                }
                canvas.drawPath(mArcPath, mArcPaint);
            }
        } else {
            canvas.drawCircle(cx, cy, cr, paint);
            canvas.drawLine(cx + cr * sign, cy + cr * sign, cx + cr * 2 * sign,
                    cy + cr * 2 * sign, paint);
        }
        canvas.restore();
    }

    private void drawNormalView(Paint paint, Canvas canvas) {
        cr = getWidth() / 10;
        cx = getWidth() / 2;
        cy = getHeight() / 2;
        mIntRectF.left = cx - cr;
        mIntRectF.right = cx + cr;
        mIntRectF.top = cy - cr;
        mIntRectF.bottom = cy + cr;

        mPath.moveTo(cx + cr * 2 * sign, cy + cr * 2 * sign);
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                mPath.lineTo(cx + 0.5f, cy);
            } else {
                mPath.lineTo(cx - 0.5f, cy);
            }
        }
        mPath.lineTo(cx, cy);
        mPath.lineTo(cx, cy);
        mPath.lineTo(cx - cr * sign, cy + cr * sign - mPadding);
        mPath.lineTo(cx - cr * sign, cy - cr * sign + mPadding);
        mPath.lineTo(cx + cr - mPadding, cy);
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                mPath.lineTo(cx + 0.5f, cy);
            } else {
                mPath.lineTo(cx - 0.5f, cy);
            }
        }
        mPath.lineTo(cx, cy);
        mPath.lineTo(cx + cr * 2 * sign, cy + cr * 2 * sign);
        mPathMeasure.setPath(mPath, false);

        paint.reset();
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.save();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(10);
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
        AnimatorSet set = new AnimatorSet();
        ValueAnimator v2 = startSearchViewAnim(0, mPathMeasure.getLength(), 3000, mPathMeasure);
        v2.setStartDelay(500);
        set.play(startSearchViewAnim()).before(v2);
    }

    @Override
    public void resetAnim() {
        if (mState == STATE_ANIM_STOP) return;
        mState = STATE_ANIM_STOP;
        mArcTemp = 1;
        startSearchViewAnim();
    }


}
