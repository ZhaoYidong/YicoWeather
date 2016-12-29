package com.yico.weather.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.yico.weather.R;
import com.yico.weather.model.HourlyForecast;
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
public class HourlyForecastAdapter extends RecyclerView.Adapter<HourlyForecastAdapter.ViewHolder> {
    private static final String TAG = "HourlyForecastAdapter";

    private LayoutInflater mLayoutInflater;
    private HourlyForecast mHourlyForecast;

    public HourlyForecastAdapter(Context context, HourlyForecast hourlyForecast) {
        mLayoutInflater = LayoutInflater.from(context);
        mHourlyForecast = hourlyForecast;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        TextView tvDate;
        ImageView ivWeatherIcon;
        TextView tvTmp;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_recycler_view_hourly_forecast, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.tvDate = Utils.mFindViewById(view, R.id.tv_date);
        viewHolder.ivWeatherIcon = Utils.mFindViewById(view, R.id.iv_weather_icon);
        viewHolder.tvTmp = Utils.mFindViewById(view, R.id.tv_tmp);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvDate.setText(cutTime(mHourlyForecast.getHourly_forecast().get(position).getDate()));
        downloadIcon(holder, position);
        holder.tvTmp.setText(mHourlyForecast.getHourly_forecast().get(position).getTmp());
    }

    @Override
    public int getItemCount() {
        return mHourlyForecast.getHourly_forecast().size();
    }

    private String cutTime(String date) {
        if (TextUtils.isEmpty(date)) {
            return "";
        }
        return date.split(" ")[1];
    }

    private void downloadIcon(final ViewHolder holder, int position) {
        Retrofit retrofit = NetUtils.getDownloadImageRetrofit();
        ApiService service = retrofit.create(ApiService.class);
        Call<ResponseBody> call = service.downloadImage(mHourlyForecast.getHourly_forecast().get(position).getCond().getCode());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                InputStream is = response.body().byteStream();
                Bitmap bp = BitmapFactory.decodeStream(is);
                holder.ivWeatherIcon.setImageBitmap(bp);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Logger.t(TAG).e(t.getMessage());
            }
        });


    }
}
