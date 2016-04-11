package com.cjj.sva.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PathMeasure;
import android.support.annotation.IntDef;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;

import com.cjj.sva.utils.LogHelper;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/**
 * 这是一个神奇的controller，神奇你妹啊...妹啊...啊。
 * <p/>
 * Created by androidcjj on 2016/4/1.
 */
public abstract class JJBaseController {
    public static final int STATE_ANIM_NONE = 0;
    public static final int STATE_ANIM_START = 1;
    public static final int STATE_ANIM_STOP = 2;
    public static final int DEFAULT_ANIM_TIME = 500;
    public static final float DEFAULT_ANIM_STARTF = 0;
    public static final float DEFAULT_ANIM_ENDF = 1;

    protected float mPro = -1;
    private WeakReference<View> mSearchView;
    protected float[] mPos = new float[2];

    @IntDef({STATE_ANIM_NONE,STATE_ANIM_START, STATE_ANIM_STOP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    @State
    protected int mState = STATE_ANIM_NONE;

    public int getState() {
        return mState;
    }

    public void setState(int state) {
        mState = state;
    }

    public void setSearchView(View searchView) {
        this.mSearchView = new WeakReference<>(searchView);
    }

    public View getSearchView() {
        return mSearchView != null ? mSearchView.get() : null;
    }

    /**
     * 获取view的宽度
     *
     * @return
     */
    public int getWidth() {
        return getSearchView() != null ? getSearchView().getWidth() : 0;
    }

    /**
     * 获取view的高度
     *
     * @return
     */
    public int getHeight() {
        return getSearchView() != null ? getSearchView().getHeight() : 0;
    }

    /**
     * 绘制就交给我儿子们去做吧
     *
     * @param canvas
     * @param paint
     */
    public abstract void draw(Canvas canvas, Paint paint);

    /**
     * 开启搜索动画
     */
    public void startAnim() {
    }

    /**
     * 重置搜索动画
     */
    public void resetAnim() {
    }


    public ValueAnimator startSearchViewAnim() {
        ValueAnimator valueAnimator = startSearchViewAnim(DEFAULT_ANIM_STARTF, DEFAULT_ANIM_ENDF,
                DEFAULT_ANIM_TIME);
        return valueAnimator;
    }

    public ValueAnimator startSearchViewAnim(float startF, float endF, long time) {
        ValueAnimator valueAnimator =startSearchViewAnim(startF, endF, time, null);
        return valueAnimator;
    }

    public ValueAnimator startSearchViewAnim(float startF, float endF, long time, final PathMeasure pathMeasure) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(startF, endF);
        valueAnimator.setDuration(time);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mPro = (float) valueAnimator.getAnimatedValue();
                if (null != pathMeasure)
                    pathMeasure.getPosTan(mPro, mPos, null);
                getSearchView().invalidate();
            }
        });
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        });
        if (!valueAnimator.isRunning()) {
            valueAnimator.start();
        }
        mPro = 0;
        return valueAnimator;
    }

}
