package com.cjj.sva;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.cjj.sva.anim.JJBaseController;
import com.cjj.sva.anim.controller.JJChangeArrowController;

/**
 * 这是一个神奇的类，今天心情郁闷
 * <p>
 * Created by androidcjj on 2016/4/1.
 */
public class JJSearchView extends View {
    private Paint mPaint;
    private Path mPath;
    private JJBaseController mController = new JJChangeArrowController();

    public JJSearchView(Context context) {
        this(context, null);
    }

    public JJSearchView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public JJSearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(4);

        mPath = new Path();
    }

    public void setController(JJBaseController controller) {
        this.mController = controller;
        mController.setSearchView(this);
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mController.draw(canvas, mPaint);
    }

    public void startAnim() {
        if (mController != null)
            mController.startAnim();
    }

    public void resetAnim() {
        if (mController != null)
            mController.resetAnim();
    }

}
