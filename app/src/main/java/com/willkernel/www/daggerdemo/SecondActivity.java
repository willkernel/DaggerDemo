package com.willkernel.www.daggerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.willkernel.www.daggerdemo.component.DaggerSecondActivityComponent;
import com.willkernel.www.daggerdemo.data.Car;

import javax.inject.Inject;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "Second";
    @Inject
    Car car5;

    Car car6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        DaggerSecondActivityComponent.builder()
//                .carComponent(DaggerCarComponent.builder()
//                        .waterComponent(DaggerWaterComponent.create()).build())
//                .build()
//                .inject(this);

        DaggerSecondActivityComponent.builder()
                .carComponent(((App) getApplication()).getCarComponent())
                .build()
                .inject(this);
        Log.e(TAG, "car5=" + car5.hashCode());

        car6=((App)getApplication()).getCar();
        Log.e(TAG, "car6=" + car6.hashCode());

    }
}
