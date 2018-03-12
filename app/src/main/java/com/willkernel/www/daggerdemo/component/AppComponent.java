package com.willkernel.www.daggerdemo.component;

import com.willkernel.www.daggerdemo.App;
import com.willkernel.www.daggerdemo.scope.ApplicationScope;


import dagger.Component;

@ApplicationScope
@Component(dependencies = CarComponent.class)
public interface AppComponent {
    void inject(App app);
}
