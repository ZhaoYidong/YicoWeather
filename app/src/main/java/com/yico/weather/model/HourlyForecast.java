package com.yico.weather.model;

import com.yico.weather.model.basic.BasicBean;
import com.yico.weather.model.basic.HourlyForecastBean;

import java.util.List;

/**
 * ---------------------------------------------------------------
 * Author: ZhaoYidong
 * Create: 2016/12/29 10:37
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2016/12/29 10 : Create by ZhaoYidong
 * ---------------------------------------------------------------
 */
public class HourlyForecast {
    /**
     * basic : {"city":"北京","cnty":"中国","id":"CN101010100","lat":"39.904000","lon":"116.391000","update":{"loc":"2016-12-29 09:53","utc":"2016-12-29 01:53"}}
     * hourly_forecast : [{"cond":{"code":"100","txt":"晴"},"date":"2016-12-29 10:00","hum":"30","pop":"0","pres":"1038","tmp":"0","wind":{"deg":"245","dir":"南风","sc":"微风","spd":"3"}},{"cond":{"code":"100","txt":"晴"},"date":"2016-12-29 13:00","hum":"20","pop":"0","pres":"1036","tmp":"2","wind":{"deg":"193","dir":"南风","sc":"微风","spd":"6"}},{"cond":{"code":"100","txt":"晴"},"date":"2016-12-29 16:00","hum":"24","pop":"0","pres":"1034","tmp":"-3","wind":{"deg":"183","dir":"南风","sc":"微风","spd":"8"}},{"cond":{"code":"100","txt":"晴"},"date":"2016-12-29 19:00","hum":"30","pop":"0","pres":"1034","tmp":"-4","wind":{"deg":"207","dir":"南风","sc":"微风","spd":"7"}},{"cond":{"code":"101","txt":"多云"},"date":"2016-12-29 22:00","hum":"35","pop":"0","pres":"1034","tmp":"-5","wind":{"deg":"208","dir":"北风","sc":"微风","spd":"3"}}]
     * status : ok
     */

    private BasicBean basic;
    private List<HourlyForecastBean> hourly_forecast;

    private String status;

    public BasicBean getBasic() {
        return basic;
    }

    public void setBasic(BasicBean basic) {
        this.basic = basic;
    }

    public List<HourlyForecastBean> getHourly_forecast() {
        return hourly_forecast;
    }

    public void setHourly_forecast(List<HourlyForecastBean> hourly_forecast) {
        this.hourly_forecast = hourly_forecast;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}