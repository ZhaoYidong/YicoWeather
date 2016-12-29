package com.yico.weather.model.basic;

/**
 * ---------------------------------------------------------------
 * Author: ZhaoYidong
 * Create: 2016/12/29 10:29
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2016/12/29 10 : Create by ZhaoYidong
 * ---------------------------------------------------------------
 */
public class BasicBean {
    /**
     * city : 北京
     * cnty : 中国
     * id : CN101010100
     * lat : 39.904000
     * lon : 116.391000
     * update : {"loc":"2016-12-27 10:12","utc":"2016-12-27 02:12"}
     */

    private String city;
    private String cnty;
    private String id;
    private String lat;
    private String lon;
    private UpdateBean update;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCnty() {
        return cnty;
    }

    public void setCnty(String cnty) {
        this.cnty = cnty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public UpdateBean getUpdate() {
        return update;
    }

    public void setUpdate(UpdateBean update) {
        this.update = update;
    }

    @Override
    public String toString() {
        return "BasicBean{" +
                "city='" + city + '\'' +
                ", cnty='" + cnty + '\'' +
                ", id='" + id + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", update=" + update +
                '}';
    }

    public static class UpdateBean {
        /**
         * loc : 2016-12-27 10:12
         * utc : 2016-12-27 02:12
         */

        private String loc;
        private String utc;

        public String getLoc() {
            return loc;
        }

        public void setLoc(String loc) {
            this.loc = loc;
        }

        public String getUtc() {
            return utc;
        }

        public void setUtc(String utc) {
            this.utc = utc;
        }

        @Override
        public String toString() {
            return "UpdateBean{" +
                    "loc='" + loc + '\'' +
                    ", utc='" + utc + '\'' +
                    '}';
        }
    }
}