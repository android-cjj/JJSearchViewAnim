package com.cjj.sva.anim.controller;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import com.cjj.sva.anim.JJBaseController;

/**
 * 这是一个神奇的效果，SearchView可以转圈圈生成尾巴！
 * <p/>
 * Created by androidcjj on 2016/4/2.
 */
public class JJAroundCircleBornTailController extends JJBaseController {
    private String mColor = "#2196F3";
    private String mColorTran = "#50FFFFFF";
    private int mAngle = 10;
    private RectF mRectF;
    private int cx, cy, cr;

    public JJAroundCircleBornTailController() {
        mRectF = new RectF();
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
        paint.reset();
        canvas.save();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(14);
        paint.setStyle(Paint.Style.STROKE);
        canvas.rotate(45, cx, cy);
        canvas.drawLine(cx + cr, cy, cx + cr * 2, cy, paint);
        canvas.drawCircle(cx, cy, cr, paint);
        canvas.restore();
    }

    private void drawStartAnimView(Paint paint, Canvas canvas) {
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor(mColorTran));
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        canvas.rotate(45, cx, cy);
        canvas.drawCircle(cx, cy, cr, paint);
        mRectF.left = cx - cr;
        mRectF.right = cx + cr;
        mRectF.top = cy - cr;
        mRectF.bottom = cy + cr;

        if (mPro <= 0.2) {
            canvas.drawLine(cx + cr, cy, cx + cr + cr * (.2f - mPro),
                    cy, paint);
            canvas.save();
            paint.setAntiAlias(true);
            paint.setColor(Color.WHITE);
            canvas.drawArc(mRectF, 6, -14, false, paint);
            canvas.restore();
        } else if (mPro > 0.2 && mPro < 4.5) {
            canvas.save();
            paint.setColor(Color.WHITE);
            mAngle += 20;
            canvas.rotate(mAngle, getWidth() / 2, getHeight() / 2);
            canvas.drawArc(mRectF, 0, mAngle / 4, false, paint);
            canvas.restore();
        } else {
            canvas.save();
            paint.setAntiAlias(true);
            paint.setColor(Color.WHITE);
            paint.setStrokeWidth(14);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawLine(cx + cr, cy, cx + cr + cr * ((mPro - 4.5f) * 2), cy, paint);
            canvas.drawCircle(cx, cy, cr, paint);
            canvas.restore();
        }

    }

    private void drawNormalView(Paint paint, Canvas canvas) {
        cr = getWidth() / 15;
        cx = getWidth() / 2;
        cy = getHeight() / 2;

        paint.reset();
        paint.setAntiAlias(true);
        canvas.save();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(14);
        paint.setStyle(Paint.Style.STROKE);
        canvas.rotate(45, cx, cy);
        canvas.drawLine(cx + cr, cy, cx + cr * 2, cy, paint);
        canvas.drawCircle(cx, cy, cr, paint);
        canvas.restore();
    }

    @Override
    public void startAnim() {
        if (mState == STATE_ANIM_START) return;
        mState = STATE_ANIM_START;
        startSearchViewAnim(0, 5, 2000);
    }

    @Override
    public void resetAnim() {
        if (mState == STATE_ANIM_STOP) return;
        mState = STATE_ANIM_STOP;
        mAngle = 0;
        startSearchViewAnim();
    }

}

