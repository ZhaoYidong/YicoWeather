package com.yico.weather;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.orhanobut.logger.Logger;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置Logger的总Tag
        Logger.init("Yico");

        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        //隐藏ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }

    /**
     * findViewById简写
     *
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T mFindViewById(int id) {
        //return返回view时,加上泛型T
        return (T) findViewById(id);
    }


}
