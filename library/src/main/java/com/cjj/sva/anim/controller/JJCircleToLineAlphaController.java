package com.cjj.sva.anim.controller;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import com.cjj.sva.anim.JJBaseController;

/**
 * 这是一个神奇的类，searchview释放外面的圈圈，呼吸新鲜空气！
 *
 * Created by androidcjj on 2016/4/2.
 */
public class JJCircleToLineAlphaController extends JJBaseController {
    private String mColor = "#673AB7";
    private int cx, cy, cr;
    private RectF mRectF, mRectF2;
    private float sign = 0.707f;
    private float tran = 120;

    public JJCircleToLineAlphaController() {
        mRectF = new RectF();
        mRectF2 = new RectF();
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
        if (mPro > 0.7) {
            paint.setAlpha((int) (mPro * 255));
            drawNormalView(paint, canvas);
        }
        canvas.restore();
    }

    private void drawStartAnimView(Paint paint, Canvas canvas) {
        canvas.save();
        canvas.drawLine(mRectF.left + cr + (cr * sign), mRectF.top + cr + (cr * sign),
                mRectF.left + cr + (2 * cr * sign), mRectF.top + cr + (2 * cr * sign), paint);
        canvas.drawArc(mRectF, 0, 360, false, paint);
        canvas.drawArc(mRectF2, 90, -360 * (1 - mPro), false, paint);
        if (mPro >= 0.7f) {
            canvas.drawLine((1 - mPro + 0.7f) * (mRectF2.right - 3 * cr), mRectF2.bottom,
                    (mRectF2.right - 3 * cr), mRectF2.bottom, paint);
        }
        canvas.restore();
        mRectF.left = cx - cr + tran * mPro;
        mRectF.right = cx + cr + tran * mPro;
        mRectF2.left = cx - 3 * cr + tran * mPro;
        mRectF2.right = cx + 3 * cr + tran * mPro;
    }

    private void drawNormalView(Paint paint, Canvas canvas) {
        cr = getWidth() / 50;
        cx = getWidth() / 2;
        cy = getHeight() / 2;
        mRectF.left = cx - cr;
        mRectF.right = cx + cr;
        mRectF.top = cy - cr;
        mRectF.bottom = cy + cr;

        mRectF2.left = cx - 3 * cr;
        mRectF2.right = cx + 3 * cr;
        mRectF2.top = cy - 3 * cr;
        mRectF2.bottom = cy + 3 * cr;

        canvas.save();
        paint.reset();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(4);
        paint.setStyle(Paint.Style.STROKE);

        canvas.rotate(45, cx, cy);
        canvas.drawLine(cx + cr, cy, cx + cr * 2, cy, paint);
        canvas.drawArc(mRectF, 0, 360, false, paint);
        canvas.drawArc(mRectF2, 0, 360, false, paint);
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
