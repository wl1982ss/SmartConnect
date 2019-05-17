package com.example.smartconnect;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private ScrollView  detailLayout;
    private TextView    titleCity;
    private TextView    titleUpdateTime;
    private TextView    degreeText;
    private TextView    detailInfoText;
    private LinearLayout    forecastLayout;
    private TextView    aqiText;
    private TextView    pm25Text;
    private TextView    comfortText;
    private TextView    carWashText;
    private TextView    sportText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        detailLayout = (ScrollView) findViewById(R.id.detail_layout);
        titleCity   =   (TextView) findViewById(R.id.title_city);
        titleUpdateTime =   (TextView) findViewById(R.id.title_update_time);
        degreeText  =   (TextView) findViewById(R.id.degree_text);
        detailInfoText  =   (TextView)  findViewById(R.id.detail_info_text);
        forecastLayout  =   (LinearLayout)  findViewById(R.id.forecast_layout);
        aqiText =   (TextView)  findViewById(R.id.aqi_text);
        pm25Text    =   (TextView)  findViewById(R.id.pm25_text);
        comfortText =   (TextView) findViewById(R.id.comfort_text);
        carWashText =   (TextView)  findViewById(R.id.car_wash_text);
        sportText   =   (TextView)  findViewById(R.id.sport_text);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String detail_info_String = prefs.getString("detail_info", null);
        if(detail_info_String != null) {
            // 有缓存时直接解析天气数据
//            Weather weather = Utility.handleWeatherResponse(weatherString);
//            showWeatherInfo(weather);
        } else {
            // 无缓存时去服务器查询天气
//            String weatherId = getIntent().getStringExtra("weather_id");
//            weatherLayout.setVisibility(View.INVISIBLE);
//            requestWeather(weatherId);
        }
    }

}
