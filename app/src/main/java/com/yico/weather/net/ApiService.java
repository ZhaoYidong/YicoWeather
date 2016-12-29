package com.yico.weather.net;

import com.yico.weather.model.HeWeather5;
import com.yico.weather.model.HourlyForecast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * ---------------------------------------------------------------
 * Author: ZhaoYidong
 * Create: 2016/12/27 10:42
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2016/12/27 10 : Create by ZhaoYidong
 * ---------------------------------------------------------------
 */
public interface ApiService {

//    @GET("weather")
//    Call<List<HeWeather5>> getWeather(@Query("city") String city, @Query("key") String key);

    @GET("{icon}.png")
    Call<ResponseBody> downloadImage(@Path("icon") String icon);

    @GET("weather")
    Call<HeWeather5> getWeather(@Query("city") String city, @Query("key") String key);

    @GET("hourly")
    Call<HourlyForecast> getHourlyForecast(@Query("city") String city, @Query("key") String key);


}
