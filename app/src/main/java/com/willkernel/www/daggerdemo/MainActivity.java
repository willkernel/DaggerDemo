package com.willkernel.www.daggerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.willkernel.www.daggerdemo.component.DaggerMainActivityComponent;
import com.willkernel.www.daggerdemo.data.Car;
import com.willkernel.www.daggerdemo.mapkey.DaggerMapComponent;
import com.willkernel.www.daggerdemo.mapkey.TestKey;

import java.util.Map;

import javax.inject.Inject;

import dagger.Lazy;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main";
    @Inject
    Car car1;

    //可以注入多个Car,但是重新创建了一个依赖，使用单例后两个地址一样，
    //但是在其他Activity中，地址又不一样，属于局部单例，在其他Activity重新
    //创建了注入器Component,所以Car对象的地址改变了
    //依赖在Component中是单例的（供该依赖的provide方法和对应的Component类使用同一个Scope注解。）
    //对应的Component在App中只初始化一次，每次注入依赖都使用这个Component对象。（在Application中创建该Component）
    @Inject
    Car car2;

    Car car3;
    Car car4;

    @Inject
    Lazy<Car> carLazy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        DaggerMainActivityComponent.create().inject(this);

//        DaggerMainActivityComponent.builder()
//                .carComponent(DaggerCarComponent.builder()
//                        .waterComponent(DaggerWaterComponent.create())
//                        .build())
//                .build()
//                .inject(this);

        //正确使用单例，其他Activity的地址也是一样
        DaggerMainActivityComponent.builder()
                .carComponent(((App) getApplication()).getCarComponent())
                .build()
                .inject(this);

        //SubComponent
//        DaggerWaterComponent.create()
//                .plus(new CarModule()) //返回CarComponent
//                .plus()  //返回MainActivityComponent
//                .inject(this);

        Log.e(TAG, car1.show());
        Log.e(TAG, "car1=" + car1.hashCode() + "  car2=" + car2.hashCode());

        car3 = ((App) getApplication()).getCar();
        car4 = ((App) getApplication()).getCar();
        Log.e(TAG, "car3=" + car3.hashCode() + "  car4=" + car4.hashCode());

        startActivity(new Intent(this, SecondActivity.class));

        Map<String, String> map = DaggerMapComponent.create().mapkey();
        Log.e(TAG, "map " + map.toString());

        Car carL = carLazy.get();
        Log.e(TAG, "carL " + carL.show());
    }

    /**
     * Dagger2会在构造器执行之后立即调用这个方法,使用方法注入可以提供安全的this对象，因为方法注入是在构造器之后执行的
     */
    @Inject
    public void setCar(Car car) {
        this.car1 = car;
    }

}
