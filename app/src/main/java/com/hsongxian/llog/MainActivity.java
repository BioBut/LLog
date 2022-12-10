package com.hsongxian.llog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hsongxian.log.LLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LLog.init("Main", true);
        LLog.d();
    }
}