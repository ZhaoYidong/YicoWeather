package com.yico.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.orhanobut.logger.Logger;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.init("Yico");
    }

    protected <T extends View> T mFindViewById(int id) {
        //return返回view时,加上泛型T
        return (T) findViewById(id);
    }
}
