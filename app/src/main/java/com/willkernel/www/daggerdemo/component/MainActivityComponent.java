package com.willkernel.www.daggerdemo.component;

import com.willkernel.www.daggerdemo.MainActivity;
import com.willkernel.www.daggerdemo.scope.ActivityScope;
import com.willkernel.www.daggerdemo.scope.ApplicationScope;

import javax.inject.Scope;

import dagger.Component;
import dagger.Subcomponent;

/**
 * 在Component中指定Module
 * MainActivityComponent依赖CarComponent
 * 而dagger2规定使用单例的Component,子Component也必须标注@Scope
 * 但是不能标注@Singleton,不允许，单例依赖单例不符合设计原则
 * 需要自定义一个@Scope，例如ActivityScope
 * @Singleton 需要在@Provide和@Component,还有MainActivityComponent中同时使用
 * 能够顺利编译，保持局部单例
 */
//@Component(modules = {WaterModule.class, OilModule.class})
//public interface MainActivityComponent {
//    void inject(MainActivity mainActivity);
//}

@ActivityScope
@Component(dependencies = CarComponent.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}

//@Subcomponent
//public interface MainActivityComponent {
//    void inject(MainActivity mainActivity);
//}