package com.yico.weather.net;

import retrofit2.Retrofit;

/**
 * ---------------------------------------------------------------
 * Author: ZhaoYidong
 * Create: 2016/12/27 10:06
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2016/12/27 10 : Create by ZhaoYidong
 * ---------------------------------------------------------------
 */
public class NetUtils {
    //My Key
    public static final String KEY = "ae70b2a5f0044e068c6791b3448d8860";
    //GuoLin's Key
    //public static final String KEY = "bc0418b57b2d4918819d3974ac1285d9";

    public NetUtils() {}


    private static class NetUtilsHolder {
        private static NetUtils instance = new NetUtils();
    }

    public static NetUtils getInstance() {
        return NetUtilsHolder.instance;
    }


    private static class RetrofitHolder {
        private static Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://free-api.heweather.com/v5/")
                .addConverterFactory(new WeatherConverterFactory())
                .build();
    }

    public static Retrofit getRetrofit() {
        return RetrofitHolder.retrofit;
    }

    private static class DownloadIconRetrofitHolder {
        private static Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://files.heweather.com/cond_icon/")
                .build();
    }

    public static Retrofit getDownloadImageRetrofit() {
        return DownloadIconRetrofitHolder.retrofit;
    }


}
