package com.willkernel.www.daggerdemo.mapkey;

import dagger.MapKey;

/**
 * 依赖集合
 */
@MapKey(unwrapValue = true)
public @interface TestKey {
    String value();
}
