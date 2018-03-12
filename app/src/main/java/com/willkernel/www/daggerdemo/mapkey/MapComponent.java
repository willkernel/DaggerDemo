package com.willkernel.www.daggerdemo.mapkey;

import java.util.Map;

import dagger.Component;

/**
 * Created by willkernel on 2018/3/12.
 */
@Component(modules = MapKeyModule.class)
public interface MapComponent {
    Map<String, String> mapkey();
}
