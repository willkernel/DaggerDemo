package com.willkernel.www.daggerdemo.module;

import com.willkernel.www.daggerdemo.data.CoolWater;
import com.willkernel.www.daggerdemo.data.HotWater;
import com.willkernel.www.daggerdemo.data.Water;
import com.willkernel.www.daggerdemo.qualifier.CoolQualifier;
import com.willkernel.www.daggerdemo.qualifier.HotQualifier;

import dagger.Module;
import dagger.Provides;

/**
 * @Module标记在类上面
 * @Provodes标记在方法上 表示可以通过这个方法获取依赖
 */
@Module
public class WaterModule {
//    @Provides
//    Water provideWater(){
//        return new HotWater();
//    }

    /**
     * 不同名字,加上限定符,@Named(),@Qualifier
     */
    @Provides
    @HotQualifier
//    @Named("HotQualifier")
    Water provideHotWater() {
        return new HotWater();
    }

    @Provides
    @CoolQualifier
//    @Named("Cool")
    Water provideCoolWater() {
        return new CoolWater();
    }

//    另外的一种方式，这里Water是抽象类，可以考虑其他对象Light灯光
//    @Provides
//    Water providePot(@CoolQualifier Water w) {
//        return new Water(w);
//    }
}
