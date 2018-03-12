package com.willkernel.www.daggerdemo.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by willkernel on 2018/3/12.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface HotQualifier {
}
