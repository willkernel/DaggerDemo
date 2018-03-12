package com.willkernel.www.daggerdemo.component;

import com.willkernel.www.daggerdemo.data.Water;
import com.willkernel.www.daggerdemo.module.WaterModule;
import com.willkernel.www.daggerdemo.qualifier.CoolQualifier;
import com.willkernel.www.daggerdemo.qualifier.HotQualifier;

import dagger.Component;

/**
 * @Module标记在类上面
 * @Provodes标记在方法上 表示可以通过这个方法获取依赖
 */
@Component(modules = WaterModule.class)
public interface WaterComponent {
    @HotQualifier
    Water getHotWater();

    @CoolQualifier
    Water getCoolWater();

    //subcomponent使用
//    CarComponent plus(CarModule carModule);
}