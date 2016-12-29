package com.yico.weather.model;

import com.yico.weather.model.basic.BasicBean;
import com.yico.weather.model.basic.NowBean;

/**
 * ---------------------------------------------------------------
 * Author: ZhaoYidong
 * Create: 2016/12/29 11:07
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2016/12/29 11 : Create by ZhaoYidong
 * ---------------------------------------------------------------
 */
public class Now {
    /**
     * basic : {"city":"北京","cnty":"中国","id":"CN101010100","lat":"39.904000","lon":"116.391000","update":{"loc":"2016-12-29 10:51","utc":"2016-12-29 02:51"}}
     * now : {"cond":{"code":"101","txt":"多云"},"fl":"-5","hum":"27","pcpn":"0","pres":"1038","tmp":"-1","vis":"10","wind":{"deg":"10","dir":"西风","sc":"4-5","spd":"19"}}
     * status : ok
     */

    private BasicBean basic;
    private NowBean now;

    private String status;

    public BasicBean getBasic() {
        return basic;
    }

    public void setBasic(BasicBean basic) {
        this.basic = basic;
    }

    public NowBean getNow() {
        return now;
    }

    public void setNow(NowBean now) {
        this.now = now;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
