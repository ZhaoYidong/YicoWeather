package com.yico.weather.utils;

import android.view.View;

/**
 * ---------------------------------------------------------------
 * Author: ZhaoYidong
 * Create: 2016/12/29 14:02
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2016/12/29 14 : Create by ZhaoYidong
 * ---------------------------------------------------------------
 */
public class Utils {

    public static <T extends View> T mFindViewById(View view, int id) {
        //return返回view时,加上泛型T
        return (T) view.findViewById(id);
    }

}
