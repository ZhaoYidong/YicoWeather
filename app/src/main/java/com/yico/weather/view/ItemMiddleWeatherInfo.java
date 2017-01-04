package com.yico.weather.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yico.weather.R;

/**
 * ---------------------------------------------------------------
 * Author: ZhaoYidong
 * Create: 2016/12/30 02:25
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2016/12/30 02 : Create by ZhaoYidong
 * ---------------------------------------------------------------
 */
public class ItemMiddleWeatherInfo extends LinearLayout {

    private TextView tvKey;
    private TextView tvValue;

    public ItemMiddleWeatherInfo(Context context) {
        this(context, null);
    }

    public ItemMiddleWeatherInfo(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 导入布局
        LayoutInflater.from(context).inflate(R.layout.item_middle_weather_information, this, true);
        tvKey = (TextView) findViewById(R.id.tv_key);
        tvValue = (TextView) findViewById(R.id.tv_value);

    }

    public void setKey(String text) {
        tvKey.setText(text);
    }

    public void setValue(String text) {
        tvValue.setText(text);
    }

}
