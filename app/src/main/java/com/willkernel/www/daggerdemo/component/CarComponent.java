package com.willkernel.www.daggerdemo.component;

import com.willkernel.www.daggerdemo.data.Car;
import com.willkernel.www.daggerdemo.module.CarModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = CarModule.class, dependencies = WaterComponent.class)
public interface CarComponent {
    Car getCar();
}

//@Subcomponent(modules = CarModule.class)
//public interface CarComponent{
//    MainActivityComponent plus();
//}