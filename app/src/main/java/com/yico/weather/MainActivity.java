package com.yico.weather;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.yico.weather.adapter.DailyForecastAdapter;
import com.yico.weather.adapter.HourlyForecastAdapter;
import com.yico.weather.model.HeWeather5;
import com.yico.weather.model.HourlyForecast;
import com.yico.weather.model.Now;
import com.yico.weather.model.basic.DailyForecast;
import com.yico.weather.model.basic.DailyForecastBean;
import com.yico.weather.net.ApiService;
import com.yico.weather.net.NetUtils;
import com.yico.weather.view.ItemMiddleWeatherInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    //head_weather_new.xml
    private TextView tvCity;
    private TextView tvCond;
    private TextView tvTmp;

    //item_recycler_view_hourly_forecast.xml
    private RecyclerView mRecyclerViewHourly;
    private HourlyForecastAdapter mHourlyAdapter;

    //item_recycler_view_daily_forecast.xml
    private RecyclerView mRecyclerViewDaily;
    private DailyForecastAdapter mDailyAdapter;

    //middle_weather_information.xml
    private ItemMiddleWeatherInfo imwiSunrise;
    private ItemMiddleWeatherInfo imwiSunset;
    private ItemMiddleWeatherInfo imwiPop;
    private ItemMiddleWeatherInfo imwiPcpn;
    private ItemMiddleWeatherInfo imwiSpd;
    private ItemMiddleWeatherInfo imwiHum;
    private ItemMiddleWeatherInfo imwiPres;
    private ItemMiddleWeatherInfo imwiVis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        getData();
    }

    protected void initView() {
        tvCity = mFindViewById(R.id.tv_city);
        tvCond = mFindViewById(R.id.tv_cond);
        tvTmp = mFindViewById(R.id.tv_tmp);

        mRecyclerViewHourly = mFindViewById(R.id.recycler_view_hourly);
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerViewHourly.setLayoutManager(linearLayoutManager);

        mRecyclerViewDaily = mFindViewById(R.id.recycler_view_daily);
        LinearLayoutManager linearLayoutManager0 = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager0.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewDaily.setLayoutManager(linearLayoutManager0);

        imwiSunrise = mFindViewById(R.id.imwi_sunrise);
        imwiSunset = mFindViewById(R.id.imwi_sunset);
        imwiPop = mFindViewById(R.id.imwi_pop);
        imwiPcpn = mFindViewById(R.id.imwi_pcpn);
        imwiSpd = mFindViewById(R.id.imwi_spd);
        imwiHum = mFindViewById(R.id.imwi_hum);
        imwiPres = mFindViewById(R.id.imwi_pres);
        imwiVis = mFindViewById(R.id.imwi_vis);
    }

    protected void getData() {
        Retrofit retrofit = NetUtils.getRetrofit();

        ApiService service = retrofit.create(ApiService.class);

        Call<HeWeather5> weather = service.getWeather("北京", NetUtils.KEY);

        weather.enqueue(new Callback<HeWeather5>() {
            @Override
            public void onResponse(Call<HeWeather5> call, Response<HeWeather5> response) {
                Now now = new Now();
                now.setBasic(response.body().getBasic());
                now.setNow(response.body().getNow());
                setData2HeadView(now);

                HourlyForecast hourlyForecast = new HourlyForecast();
                hourlyForecast.setBasic(response.body().getBasic());
                hourlyForecast.setHourly_forecast(response.body().getHourly_forecast());
                setData2RecyclerViewHourly(hourlyForecast);

                DailyForecast dailyForecast = new DailyForecast();
                dailyForecast.setBasic(response.body().getBasic());
                dailyForecast.setDaily_forecast(response.body().getDaily_forecast());
                setData2RecyclerViewDaily(dailyForecast);

                setData2MidWeatherInfo(response.body().getDaily_forecast().get(0));
            }

            @Override
            public void onFailure(Call<HeWeather5> call, Throwable t) {
                Logger.t(TAG).e(t.getMessage());
                setData2RecyclerViewHourly(null);
                setData2RecyclerViewDaily(null);
            }
        });
    }

    protected void setData2HeadView(Now now) {
        tvCity.setText(now.getBasic().getCity());
        tvCond.setText(now.getNow().getCond().getTxt());
        tvTmp.setText(now.getNow().getTmp());
    }

    protected void setData2RecyclerViewHourly(HourlyForecast hourlyForecast) {
        mHourlyAdapter = new HourlyForecastAdapter(MainActivity.this, hourlyForecast);
        mRecyclerViewHourly.setAdapter(mHourlyAdapter);
    }

    protected void setData2RecyclerViewDaily(DailyForecast dailyForecast) {
        mDailyAdapter = new DailyForecastAdapter(MainActivity.this, dailyForecast);
        mRecyclerViewDaily.setAdapter(mDailyAdapter);
    }

    protected void setData2MidWeatherInfo(DailyForecastBean bean) {
        imwiSunrise.setKey("日出：");
        imwiSunrise.setValue(bean.getAstro().getSr());

        imwiSunset.setKey("日落：");
        imwiSunset.setValue(bean.getAstro().getSs());

        if (Integer.parseInt(bean.getTmp().getMin()) < 0) {
            imwiPop.setKey("降雪概率：");
        } else {
            imwiPop.setKey("降水概率：");
        }
        imwiPop.setValue(bean.getPop() + "%");

        if (Integer.parseInt(bean.getTmp().getMin()) < 0) {
            imwiPcpn.setKey("降雪量：");
        } else {
            imwiPcpn.setKey("降水量：");
        }
        imwiPcpn.setValue(bean.getPcpn() + "毫米");

        imwiSpd.setKey("风速：");
        imwiSpd.setValue(bean.getWind().getDir() + " " + "每小时" + bean.getWind().getSpd() + "千米");

        imwiHum.setKey("相对湿度：");
        imwiHum.setValue(bean.getHum() + "%");

        imwiPres.setKey("气压：");
        imwiPres.setValue(bean.getPres() + "百帕");

        imwiVis.setKey("能见度：");
        imwiVis.setValue(bean.getVis() + "千米");
    }


}
