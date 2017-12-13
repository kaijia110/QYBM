package com.example.kai.gsonstring;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String str = "{"
                + "\"error\": 0,"
                + "\"status\": \"success\","
                + "\"date\": \"2014-05-10\","
                + "\"results\":["
                + "{"
                + "\"currentCity\":\"南京\","
                + "\"weather_data\":["
                + "{"
                + "\"date\":\"周六(今天, 实时：19℃)\","
                + "\"dayPictureUrl\": \"http://api.map.baidu.com/images/weather/day/dayu.png\","
                + "\"nightPictureUrl\": \"http://api.map.baidu.com/images/weather/night/dayu.png\","
                + "\"weather\": \"大雨\","
                + "\"wind\": \"东南风5-6级\","
                + "\"temperature\": \"18℃\""
                + "},"
                + "{"
                + "\"date\": \"周日\","
                + "\"dayPictureUrl\": \"http://api.map.baidu.com/images/weather/day/zhenyu.png\","
                + "\"nightPictureUrl\": \"http://api.map.baidu.com/images/weather/night/duoyun.png\","
                + "\"weather\": \"阵雨转多云\"," + "\"wind\": \"西北风4-5级\","
                + "\"temperature\": \"21 ~ 14℃\"" + "}" + "]" + "}" + "]"
                + "}";


        Log.i(TAG, "onCreate: "+str);
        Gson gson = new Gson();
        Status status = gson.fromJson(str, Status.class);
        Log.i(TAG, "status: "+status);
        List<Results> results = status.getResults();
        Log.i(TAG, "results: "+results);
        List<WeatherData> weatherData = null;
        for (Results result : results) {
            weatherData = result.getWeather_data();
            System.out.println("weatherData=" + weatherData);
        }

        Log.i(TAG, "单独: "+status.getDate());
//        得到的

//        dfkdklsfds



    }
}
