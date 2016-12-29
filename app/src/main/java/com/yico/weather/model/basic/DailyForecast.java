package com.yico.weather.model.basic;

import java.util.List;

/**
 * ---------------------------------------------------------------
 * Author: ZhaoYidong
 * Create: 2016/12/29 15:22
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2016/12/29 15 : Create by ZhaoYidong
 * ---------------------------------------------------------------
 */
public class DailyForecast {
    /**
     * basic : {"city":"北京","cnty":"中国","id":"CN101010100","lat":"39.904000","lon":"116.391000","update":{"loc":"2016-12-29 14:51","utc":"2016-12-29 06:51"}}
     * daily_forecast : [{"astro":{"mr":"07:08","ms":"17:13","sr":"07:35","ss":"16:57"},"cond":{"code_d":"100","code_n":"101","txt_d":"晴","txt_n":"多云"},"date":"2016-12-29","hum":"33","pcpn":"0.0","pop":"0","pres":"1036","tmp":{"max":"4","min":"-7"},"uv":"1","vis":"10","wind":{"deg":"183","dir":"南风","sc":"微风","spd":"6"}},{"astro":{"mr":"07:57","ms":"18:06","sr":"07:35","ss":"16:58"},"cond":{"code_d":"502","code_n":"502","txt_d":"霾","txt_n":"霾"},"date":"2016-12-30","hum":"39","pcpn":"0.0","pop":"0","pres":"1030","tmp":{"max":"2","min":"-6"},"uv":"1","vis":"10","wind":{"deg":"138","dir":"南风","sc":"微风","spd":"9"}},{"astro":{"mr":"08:41","ms":"19:02","sr":"07:35","ss":"16:59"},"cond":{"code_d":"502","code_n":"502","txt_d":"霾","txt_n":"霾"},"date":"2016-12-31","hum":"39","pcpn":"0.0","pop":"0","pres":"1027","tmp":{"max":"5","min":"-5"},"uv":"1","vis":"10","wind":{"deg":"138","dir":"南风","sc":"微风","spd":"1"}}]
     * status : ok
     */

    private BasicBean basic;
    private List<DailyForecastBean> daily_forecast;

    private String status;

    public BasicBean getBasic() {
        return basic;
    }

    public void setBasic(BasicBean basic) {
        this.basic = basic;
    }

    public List<DailyForecastBean> getDaily_forecast() {
        return daily_forecast;
    }

    public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
        this.daily_forecast = daily_forecast;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
