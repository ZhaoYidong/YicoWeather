package com.yico.weather.model.basic;

/**
 * ---------------------------------------------------------------
 * Author: ZhaoYidong
 * Create: 2016/12/29 10:35
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2016/12/29 10 : Create by ZhaoYidong
 * ---------------------------------------------------------------
 */
public class HourlyForecastBean {
    /**
     * cond : {"code":"100","txt":"晴"}
     * date : 2016-12-27 10:00
     * hum : 36
     * pop : 0
     * pres : 1038
     * tmp : 1
     * wind : {"deg":"326","dir":"西北风","sc":"微风","spd":"8"}
     */

    private CondBeanXX cond;
    private String date;
    private String hum;
    private String pop;
    private String pres;
    private String tmp;
    private WindBeanXX wind;

    public CondBeanXX getCond() {
        return cond;
    }

    public void setCond(CondBeanXX cond) {
        this.cond = cond;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getPres() {
        return pres;
    }

    public void setPres(String pres) {
        this.pres = pres;
    }

    public String getTmp() {
        return tmp;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
    }

    public WindBeanXX getWind() {
        return wind;
    }

    public void setWind(WindBeanXX wind) {
        this.wind = wind;
    }

    public static class CondBeanXX {
        /**
         * code : 100
         * txt : 晴
         */

        private String code;
        private String txt;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }
    }

    public static class WindBeanXX {
        /**
         * deg : 326
         * dir : 西北风
         * sc : 微风
         * spd : 8
         */

        private String deg;
        private String dir;
        private String sc;
        private String spd;

        public String getDeg() {
            return deg;
        }

        public void setDeg(String deg) {
            this.deg = deg;
        }

        public String getDir() {
            return dir;
        }

        public void setDir(String dir) {
            this.dir = dir;
        }

        public String getSc() {
            return sc;
        }

        public void setSc(String sc) {
            this.sc = sc;
        }

        public String getSpd() {
            return spd;
        }

        public void setSpd(String spd) {
            this.spd = spd;
        }
    }
}