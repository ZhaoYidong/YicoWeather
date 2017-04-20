package com.yico.weather;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.yico.weather.view.FlowLayout;
import com.yico.weather.view.draggridview.DragGridAdapter;
import com.yico.weather.view.draggridview.DragGridView;

import java.util.ArrayList;
import java.util.List;

public class SelectCityActivity extends BaseActivity implements View.OnClickListener {

    private List<String> citys;
    private DragGridView dgvCitys;

    private FlowLayout flCitys;

    String[] texts = new String[]{
            "good", "bad", "ZhaoYidong", "it is a good day", "how are you", "ok", "fine", "name", "lan", "flowlayout demo"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);

        Toolbar toolbar = mFindViewById(R.id.toolbar);
        mSetActionBar(toolbar);

        initData();

        initView();
    }

    private void initData() {
        citys = new ArrayList<>();
        citys.add("北京");
        citys.add("上海");
        citys.add("深圳");
        citys.add("广州");
        citys.add("郑州");
        citys.add("平顶山");
        citys.add("开封");
        citys.add("洛阳");
        citys.add("新乡");
        citys.add("安阳");
        citys.add("XX");
        citys.add("OO");
    }

    private void initView() {

        dgvCitys = mFindViewById(R.id.dgv_citys);
        MAdapter mAdapter = new MAdapter(citys);
        dgvCitys.setAdapter(mAdapter);
        dgvCitys.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String city = ((TextView) view.findViewById(R.id.tv_city)).getText().toString().trim();
                Intent intent = new Intent();
                intent.putExtra("city", city);
                SelectCityActivity.this.setResult(MainActivity.ACTIVITY_RESULT_CODE_4_SELECT_CITY, intent);
                SelectCityActivity.this.finish();
            }
        });

        flCitys = mFindViewById(R.id.fl_citys);
    }

    class MAdapter extends DragGridAdapter<String> {

        public MAdapter(List list) {
            super(list);
        }

        @Override
        public View getItemView(int position, View convertView, ViewGroup parent) {
            String text = getList().get(position);
            convertView = LayoutInflater.from(SelectCityActivity.this).inflate(R.layout.item_drag_grid_view, null);
            TextView tv_text = (TextView) convertView.findViewById(R.id.tv_city);
            tv_text.setText(text);
            return convertView;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                gogogo();
                break;

            case R.id.btn_clear:
                flCitys.removeAllViews();
                break;
        }
    }

    private void gogogo() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 15; i++) {
                    mHandler.sendEmptyMessageDelayed(1, 0);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    addView();
                    break;
            }
        }
    };

    private void addView() {
        int ranHeight = dip2px(this, 30);
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ranHeight);
        lp.setMargins(dip2px(this, 10), 0, dip2px(this, 10), 0);
        TextView tv = new TextView(this);
        tv.setPadding(dip2px(this, 15), 0, dip2px(this, 15), 0);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        int index = (int) (Math.random() * texts.length);
        tv.setText(texts[index]);
        tv.setGravity(Gravity.CENTER_VERTICAL);
        tv.setLines(1);
        tv.setBackgroundResource(R.drawable.bg_tag);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SelectCityActivity.this, ((TextView) v).getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        flCitys.addView(tv, lp);
    }


    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
