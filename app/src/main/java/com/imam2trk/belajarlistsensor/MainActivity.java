package com.imam2trk.belajarlistsensor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SensorManager mgr;
    private TextView txtList;

   @SuppressLint("MissingInflatedId")
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mgr = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        txtList = findViewById(R.id.listSensor);
        List<Sensor> sensorList = mgr.getSensorList(Sensor.TYPE_ALL);
        StringBuilder stringBuilder = new StringBuilder();

        for (Sensor s: sensorList){
            stringBuilder.append(s.getName()).append("\n");
        }
        txtList.setVisibility(View.VISIBLE);
        txtList.setText(stringBuilder);
    }
}