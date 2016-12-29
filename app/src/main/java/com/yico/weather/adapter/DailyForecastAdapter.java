package com.yico.weather.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.yico.weather.R;
import com.yico.weather.model.basic.DailyForecast;
import com.yico.weather.model.basic.DailyForecastBean;
import com.yico.weather.net.ApiService;
import com.yico.weather.net.NetUtils;
import com.yico.weather.utils.Utils;

import java.io.InputStream;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * ---------------------------------------------------------------
 * Author: ZhaoYidong
 * Create: 2016/12/29 13:43
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2016/12/29 13 : Create by ZhaoYidong
 * ---------------------------------------------------------------
 */
public class DailyForecastAdapter extends RecyclerView.Adapter<DailyForecastAdapter.ViewHolder> {
    private static final String TAG = "DailyForecastAdapter";

    private LayoutInflater mLayoutInflater;
    private DailyForecast mDailyForecast;

    public DailyForecastAdapter(Context context, DailyForecast dailyForecast) {
        mLayoutInflater = LayoutInflater.from(context);
        mDailyForecast = dailyForecast;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        TextView tvDate;
        ImageView ivWeatherIconDay;
        ImageView ivWeatherIconNight;
        TextView tvTmpMax;
        TextView tvTmpMin;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_recycler_view_daily_forecast, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.tvDate = Utils.mFindViewById(view, R.id.tv_date);
        viewHolder.ivWeatherIconDay = Utils.mFindViewById(view, R.id.iv_weather_icon_d);
        viewHolder.ivWeatherIconNight = Utils.mFindViewById(view, R.id.iv_weather_icon_n);
        viewHolder.tvTmpMax = Utils.mFindViewById(view, R.id.tv_tmp_max);
        viewHolder.tvTmpMin = Utils.mFindViewById(view, R.id.tv_tmp_min);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (mDailyForecast == null || mDailyForecast.getDaily_forecast() == null) {
            return;
        }
        DailyForecastBean dailyForecastBean = mDailyForecast.getDaily_forecast().get(position);
        holder.tvDate.setText(dailyForecastBean.getDate());
        downloadIcon(holder, position);
        holder.tvTmpMax.setText(dailyForecastBean.getTmp().getMax());
        holder.tvTmpMin.setText(dailyForecastBean.getTmp().getMin());
    }

    @Override
    public int getItemCount() {
        if (mDailyForecast == null || mDailyForecast.getDaily_forecast() == null) {
            return 3;
        }
        return mDailyForecast.getDaily_forecast().size();
    }


    private void downloadIcon(final ViewHolder holder, int position) {
        Retrofit retrofit = NetUtils.getDownloadImageRetrofit();
        ApiService service = retrofit.create(ApiService.class);
        Call<ResponseBody> call_d = service.downloadImage(mDailyForecast.getDaily_forecast().get(position).getCond().getCode_d());
        call_d.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                InputStream is = response.body().byteStream();
                Bitmap bp = BitmapFactory.decodeStream(is);
                holder.ivWeatherIconDay.setImageBitmap(bp);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Logger.t(TAG).e(t.getMessage());
            }
        });

        Call<ResponseBody> call_n = service.downloadImage(mDailyForecast.getDaily_forecast().get(position).getCond().getCode_n());
        call_n.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                InputStream is = response.body().byteStream();
                Bitmap bp = BitmapFactory.decodeStream(is);
                holder.ivWeatherIconNight.setImageBitmap(bp);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Logger.t(TAG).e(t.getMessage());
            }
        });
    }
}
