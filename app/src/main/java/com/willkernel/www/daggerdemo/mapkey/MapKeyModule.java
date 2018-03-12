package com.willkernel.www.daggerdemo.mapkey;


import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

/**
 * Created by willkernel on 2018/3/12.
 */
@Module
public class MapKeyModule {
    @Provides
    @IntoMap
    @TestKey("foo")
    String provideFooKey() {
        return "foo value";
    }

    @Provides
    @IntoMap
    @TestKey("bar")
    String provideBarKey() {
        return "bar value";
    }
}
