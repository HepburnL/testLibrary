package com.example.activitytest;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取到当前实例的类名，通过log打印
        Log.d("BaseActivity",getClass().getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector .removeActivity(this);
    }
}
