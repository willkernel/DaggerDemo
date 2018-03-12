package com.willkernel.www.daggerdemo.module;

import com.willkernel.www.daggerdemo.data.Oil;

import dagger.Module;
import dagger.Provides;

/**
 * Created by willkernel on 2018/3/12.
 */
@Module
public class OilModule {
    @Provides
    public Oil provideOil(){
        return new Oil();
    }
}
