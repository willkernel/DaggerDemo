package com.willkernel.www.daggerdemo.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by willkernel on 2018/3/12.
 */
@Qualifier
@Retention(RUNTIME)
public @interface CoolQualifier {
}
