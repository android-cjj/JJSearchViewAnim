package com.cjj.sva.anim.controller;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.cjj.sva.anim.JJBaseController;

/**
 * 这是一个神奇的类，SearchView可以放大缩小，别私用哦！
 *
 * Created by androidcjj on 2016/4/2.
 */
public class JJScaleCircleAndTailController extends JJBaseController {
    private String mColor = "#2196F3";
    private int cx, cy, cr, scr;

    @Override
    public void draw(Canvas canvas, Paint paint) {
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
        drawSearchView(paint, canvas, false);
    }

    private void drawStartAnimView(Paint paint, Canvas canvas) {
        drawNormalView(paint, canvas);
        drawSearchView(paint, canvas, true);
    }

    private void drawSearchView(Paint paint, Canvas canvas, boolean start) {
        drawNormalView(paint, canvas);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(cx, cy, (cr - 25) * (start ?
                mPro : 1 - mPro), paint);
        canvas.rotate(130, cx, cy);

        canvas.save();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(25);
        canvas.drawLine(cx + cr/2 + cr/2 * (start ? mPro : 1 - mPro)
                + 20, cy, (cx + cr + getWidth() / 5 *
                (start ? mPro : 1 - mPro)), cy, paint);
        canvas.restore();
    }

    private void drawNormalView(Paint paint, Canvas canvas) {
        cr = getWidth() / 6;
        cx = getWidth() / 2;
        cy = getHeight() / 2;
        scr = getWidth() / 18;

        canvas.drawColor(Color.parseColor(mColor));
        paint.reset();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        canvas.drawCircle(cx, cy, cr, paint);

        canvas.save();
        paint.setColor(Color.parseColor(mColor));
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        canvas.rotate(130, cx, cy);
        canvas.drawLine(cx + scr + 10, cy, cx + scr * 2, cy, paint);
        canvas.drawCircle(cx, cy, scr, paint);
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
