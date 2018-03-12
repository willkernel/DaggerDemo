package com.willkernel.www.daggerdemo.data;

import javax.inject.Inject;

/**
 * Created by willkernel on 2018/3/12.
 */

public class Car {
    Water water;
    Oil oil;
//Error:(16, 12) 错误: Types may only contain one @Inject constructor.
//    @Inject
//    public Car() {
//    }

//    /**
//     * Water 抽象类，@Inject无法提供实例
//     * 加上限定符@CoolQualifier
//     */
//    @Inject
//    public Car(@CoolQualifier Water water, Oil oil) {
//        this.water = water;
//        this.oil = oil;
//    }

    @Inject
    public Car(Water water) {
        this.water = water;
        oil = new Oil();
    }

    public String show() {
        return "Car oil=" + oil.oil() + "  vol=" + water.vol();
    }
}
