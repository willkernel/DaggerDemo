package com.willkernel.www.daggerdemo.module;

import com.willkernel.www.daggerdemo.data.Car;
import com.willkernel.www.daggerdemo.data.Water;
import com.willkernel.www.daggerdemo.qualifier.CoolQualifier;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @Module标记在类上面
 * @Provodes标记在方法上 表示可以通过这个方法获取依赖
 */
@Module
public class CarModule {
    @Provides
    @Singleton
    Car provideCar(@CoolQualifier Water water){
        return new Car(water);
    }
}
