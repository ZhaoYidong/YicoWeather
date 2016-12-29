package com.yico.weather.model;

import com.yico.weather.model.basic.BasicBean;
import com.yico.weather.model.basic.DailyForecastBean;
import com.yico.weather.model.basic.HourlyForecastBean;
import com.yico.weather.model.basic.NowBean;

import java.util.List;

/**
 * ---------------------------------------------------------------
 * Author: ZhaoYidong
 * Create: 2016/12/27 11:51
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2016/12/27 11 : Create by ZhaoYidong
 * ---------------------------------------------------------------
 */
public class HeWeather5 {
    /**
     * aqi : {"city":{"aqi":"32","co":"1","no2":"42","o3":"25","pm10":"32","pm25":"23","qlty":"优","so2":"9"}}
     * basic : {"city":"北京","cnty":"中国","id":"CN101010100","lat":"39.904000","lon":"116.391000","update":{"loc":"2016-12-27 10:12","utc":"2016-12-27 02:12"}}
     * daily_forecast : [{"astro":{"mr":"05:24","ms":"15:42","sr":"07:34","ss":"16:56"},"cond":{"code_d":"100","code_n":"101","txt_d":"晴","txt_n":"多云"},"date":"2016-12-27","hum":"47","pcpn":"0.0","pop":"0","pres":"1035","tmp":{"max":"2","min":"-7"},"uv":"1","vis":"10","wind":{"deg":"201","dir":"南风","sc":"微风","spd":"9"}},{"astro":{"mr":"06:17","ms":"16:25","sr":"07:35","ss":"16:57"},"cond":{"code_d":"101","code_n":"100","txt_d":"多云","txt_n":"晴"},"date":"2016-12-28","hum":"50","pcpn":"0.0","pop":"0","pres":"1035","tmp":{"max":"3","min":"-7"},"uv":"1","vis":"10","wind":{"deg":"337","dir":"北风","sc":"3-4","spd":"15"}},{"astro":{"mr":"07:08","ms":"17:13","sr":"07:35","ss":"16:57"},"cond":{"code_d":"100","code_n":"101","txt_d":"晴","txt_n":"多云"},"date":"2016-12-29","hum":"37","pcpn":"0.0","pop":"0","pres":"1036","tmp":{"max":"1","min":"-6"},"uv":"1","vis":"10","wind":{"deg":"186","dir":"南风","sc":"微风","spd":"8"}}]
     * hourly_forecast : [{"cond":{"code":"100","txt":"晴"},"date":"2016-12-27 10:00","hum":"36","pop":"0","pres":"1038","tmp":"1","wind":{"deg":"326","dir":"西北风","sc":"微风","spd":"8"}},{"cond":{"code":"100","txt":"晴"},"date":"2016-12-27 13:00","hum":"27","pop":"0","pres":"1036","tmp":"5","wind":{"deg":"242","dir":"西南风","sc":"微风","spd":"5"}},{"cond":{"code":"100","txt":"晴"},"date":"2016-12-27 16:00","hum":"43","pop":"0","pres":"1034","tmp":"3","wind":{"deg":"185","dir":"南风","sc":"微风","spd":"8"}},{"cond":{"code":"100","txt":"晴"},"date":"2016-12-27 19:00","hum":"59","pop":"0","pres":"1034","tmp":"0","wind":{"deg":"188","dir":"南风","sc":"微风","spd":"9"}},{"cond":{"code":"100","txt":"晴"},"date":"2016-12-27 22:00","hum":"71","pop":"0","pres":"1033","tmp":"-2","wind":{"deg":"195","dir":"西南风","sc":"微风","spd":"8"}}]
     * now : {"cond":{"code":"101","txt":"多云"},"fl":"-7","hum":"30","pcpn":"0","pres":"1038","tmp":"0","vis":"10","wind":{"deg":"350","dir":"西北风","sc":"4-5","spd":"23"}}
     * status : ok
     * suggestion : {"air":{"brf":"中","txt":"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。"},"comf":{"brf":"较不舒适","txt":"白天天气晴好，但仍会使您感觉偏冷，不很舒适，请注意适时添加衣物，以防感冒。"},"cw":{"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},"drsg":{"brf":"冷","txt":"天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。"},"flu":{"brf":"较易发","txt":"天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。"},"sport":{"brf":"较不宜","txt":"天气较好，但考虑天气寒冷，推荐您进行各种室内运动，若在户外运动请注意保暖并做好准备活动。"},"trav":{"brf":"较适宜","txt":"天气较好，同时又有微风伴您一路同行。稍冷，较适宜旅游，您仍可陶醉于大自然的美丽风光中。"},"uv":{"brf":"弱","txt":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"}}
     */

    private AqiBean aqi;
    private BasicBean basic;
    private NowBean now;
    private SuggestionBean suggestion;
    private List<DailyForecastBean> daily_forecast;
    private List<HourlyForecastBean> hourly_forecast;

    private String status;

    public AqiBean getAqi() {
        return aqi;
    }

    public void setAqi(AqiBean aqi) {
        this.aqi = aqi;
    }

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

    public SuggestionBean getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(SuggestionBean suggestion) {
        this.suggestion = suggestion;
    }

    public List<DailyForecastBean> getDaily_forecast() {
        return daily_forecast;
    }

    public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
        this.daily_forecast = daily_forecast;
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

    @Override
    public String toString() {
        return "HeWeather5{" +
                "aqi=" + aqi +
                ", basic=" + basic +
                ", now=" + now +
                ", status='" + status + '\'' +
                ", suggestion=" + suggestion +
                ", daily_forecast=" + daily_forecast +
                ", hourly_forecast=" + hourly_forecast +
                '}';
    }

    public static class AqiBean {
        /**
         * city : {"aqi":"32","co":"1","no2":"42","o3":"25","pm10":"32","pm25":"23","qlty":"优","so2":"9"}
         */

        private CityBean city;

        public CityBean getCity() {
            return city;
        }

        public void setCity(CityBean city) {
            this.city = city;
        }

        public static class CityBean {
            /**
             * aqi : 32
             * co : 1
             * no2 : 42
             * o3 : 25
             * pm10 : 32
             * pm25 : 23
             * qlty : 优
             * so2 : 9
             */

            private String aqi;
            private String co;
            private String no2;
            private String o3;
            private String pm10;
            private String pm25;
            private String qlty;
            private String so2;

            public String getAqi() {
                return aqi;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }

            public String getCo() {
                return co;
            }

            public void setCo(String co) {
                this.co = co;
            }

            public String getNo2() {
                return no2;
            }

            public void setNo2(String no2) {
                this.no2 = no2;
            }

            public String getO3() {
                return o3;
            }

            public void setO3(String o3) {
                this.o3 = o3;
            }

            public String getPm10() {
                return pm10;
            }

            public void setPm10(String pm10) {
                this.pm10 = pm10;
            }

            public String getPm25() {
                return pm25;
            }

            public void setPm25(String pm25) {
                this.pm25 = pm25;
            }

            public String getQlty() {
                return qlty;
            }

            public void setQlty(String qlty) {
                this.qlty = qlty;
            }

            public String getSo2() {
                return so2;
            }

            public void setSo2(String so2) {
                this.so2 = so2;
            }
        }
    }

    public static class SuggestionBean {
        /**
         * air : {"brf":"中","txt":"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。"}
         * comf : {"brf":"较不舒适","txt":"白天天气晴好，但仍会使您感觉偏冷，不很舒适，请注意适时添加衣物，以防感冒。"}
         * cw : {"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"}
         * drsg : {"brf":"冷","txt":"天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。"}
         * flu : {"brf":"较易发","txt":"天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。"}
         * sport : {"brf":"较不宜","txt":"天气较好，但考虑天气寒冷，推荐您进行各种室内运动，若在户外运动请注意保暖并做好准备活动。"}
         * trav : {"brf":"较适宜","txt":"天气较好，同时又有微风伴您一路同行。稍冷，较适宜旅游，您仍可陶醉于大自然的美丽风光中。"}
         * uv : {"brf":"弱","txt":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"}
         */

        private AirBean air;
        private ComfBean comf;
        private CwBean cw;
        private DrsgBean drsg;
        private FluBean flu;
        private SportBean sport;
        private TravBean trav;
        private UvBean uv;

        public AirBean getAir() {
            return air;
        }

        public void setAir(AirBean air) {
            this.air = air;
        }

        public ComfBean getComf() {
            return comf;
        }

        public void setComf(ComfBean comf) {
            this.comf = comf;
        }

        public CwBean getCw() {
            return cw;
        }

        public void setCw(CwBean cw) {
            this.cw = cw;
        }

        public DrsgBean getDrsg() {
            return drsg;
        }

        public void setDrsg(DrsgBean drsg) {
            this.drsg = drsg;
        }

        public FluBean getFlu() {
            return flu;
        }

        public void setFlu(FluBean flu) {
            this.flu = flu;
        }

        public SportBean getSport() {
            return sport;
        }

        public void setSport(SportBean sport) {
            this.sport = sport;
        }

        public TravBean getTrav() {
            return trav;
        }

        public void setTrav(TravBean trav) {
            this.trav = trav;
        }

        public UvBean getUv() {
            return uv;
        }

        public void setUv(UvBean uv) {
            this.uv = uv;
        }

        public static class AirBean {
            /**
             * brf : 中
             * txt : 气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。
             */

            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class ComfBean {
            /**
             * brf : 较不舒适
             * txt : 白天天气晴好，但仍会使您感觉偏冷，不很舒适，请注意适时添加衣物，以防感冒。
             */

            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class CwBean {
            /**
             * brf : 较适宜
             * txt : 较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。
             */

            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class DrsgBean {
            /**
             * brf : 冷
             * txt : 天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。
             */

            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class FluBean {
            /**
             * brf : 较易发
             * txt : 天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。
             */

            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class SportBean {
            /**
             * brf : 较不宜
             * txt : 天气较好，但考虑天气寒冷，推荐您进行各种室内运动，若在户外运动请注意保暖并做好准备活动。
             */

            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class TravBean {
            /**
             * brf : 较适宜
             * txt : 天气较好，同时又有微风伴您一路同行。稍冷，较适宜旅游，您仍可陶醉于大自然的美丽风光中。
             */

            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class UvBean {
            /**
             * brf : 弱
             * txt : 紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。
             */

            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }
    }


}

