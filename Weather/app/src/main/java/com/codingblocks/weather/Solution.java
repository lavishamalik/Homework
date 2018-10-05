package com.codingblocks.weather;

import android.content.Intent;

public class Solution {
    Float temp,temp_max,temp_min;
            Integer humidity;
            String dt_txt;



    public Solution(Float temp, Float temp_max, Float temp_min, Integer humidity, String dt_txt) {
        this.temp = temp;
        this.temp_max = temp_max;
        this.temp_min = temp_min;
        this.humidity = humidity;
        this.dt_txt = dt_txt;
    }

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public Float getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(Float temp_max) {
        this.temp_max = temp_max;
    }

    public Float getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(Float temp_min) {
        this.temp_min = temp_min;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public String getDt_txt() {
        return dt_txt;
    }
}
