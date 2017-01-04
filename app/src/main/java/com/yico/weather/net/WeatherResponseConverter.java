package com.yico.weather.net;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.yico.weather.model.HeWeather5;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * ---------------------------------------------------------------
 * Author: ZhaoYidong
 * Create: 2016/12/27 16:22
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2016/12/27 16 : Create by ZhaoYidong
 * ---------------------------------------------------------------
 */
public class WeatherResponseConverter<T> implements Converter<ResponseBody, T> {

    private Type mType;
    Gson mGson = new Gson();

    public WeatherResponseConverter(Type type) {
        this.mType = type;
    }

    @Override
    public T convert(ResponseBody responseBody) throws IOException {

        if (mType instanceof HeWeather5) {
            Logger.i("mType instanceof HeWeather5");
        }

        if (mType == HeWeather5.class) {
            Logger.i("mType == HeWeather5.class");
        }

        String result = responseBody.string();
        JSONObject jsonObject = null;
        try {
            JSONArray jsonArray = new JSONObject(result).getJSONArray("HeWeather5");
            jsonObject = jsonArray.getJSONObject(0);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        T weather = mGson.fromJson(jsonObject.toString(), mType);
        return weather;


//        // 该业务是实例test，用来研究Retrofit用的。
//        if (mType instanceof ParameterizedType) {
//            Logger.i("mType instanceof ParameterizedType");
//            Type rawType = ((ParameterizedType) mType).getRawType();
//            Type actualType = ((ParameterizedType) mType).getActualTypeArguments()[0];
//
//            if (rawType == List.class && actualType == HeWeather5.class) {
//                String result = responseBody.string();
//                JSONArray jsonArray = null;
//                try {
//                    jsonArray = new JSONObject(result).getJSONArray("HeWeather5");
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//                T weather = mGson.fromJson(jsonArray.toString(), mType);
//                return weather;
//            }
//        } else {
//            Logger.i("mType ! instanceof ParameterizedType");
//        }
//        return null;
    }

}
