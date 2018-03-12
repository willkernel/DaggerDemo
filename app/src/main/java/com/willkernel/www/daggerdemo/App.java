package com.willkernel.www.daggerdemo;

import android.app.Application;

import com.willkernel.www.daggerdemo.component.CarComponent;
import com.willkernel.www.daggerdemo.component.DaggerAppComponent;
import com.willkernel.www.daggerdemo.component.DaggerCarComponent;
import com.willkernel.www.daggerdemo.component.DaggerWaterComponent;
import com.willkernel.www.daggerdemo.data.Car;

import javax.inject.Inject;

public class App extends Application {
    private CarComponent carComponent;
    @Inject
    Car car;

    @Override
    public void onCreate() {
        super.onCreate();
        carComponent = DaggerCarComponent.builder()
                .waterComponent(DaggerWaterComponent.create())
                .build();

        DaggerAppComponent.builder()
                .carComponent(DaggerCarComponent.builder()
                        .waterComponent(DaggerWaterComponent.create()).build())
                .build()
                .inject(this);
    }

    public CarComponent getCarComponent() {
        return carComponent;
    }

    public Car getCar() {
        return car;
    }
}
