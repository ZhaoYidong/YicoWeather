package com.yico.weather.view;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * ---------------------------------------------------------------
 * Author: ZhaoYidong
 * Create: 2017/1/10 17:32
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2017/1/10 17 : Create by ZhaoYidong
 * ---------------------------------------------------------------
 */
public class MySwipeRefreshLayout extends SwipeRefreshLayout{

    public MySwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
