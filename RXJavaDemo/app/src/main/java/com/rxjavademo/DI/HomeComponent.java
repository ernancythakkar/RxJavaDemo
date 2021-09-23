package com.rxjavademo.DI;

import com.rxjavademo.app.MainActivity;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface HomeComponent {

    void inject(MainActivity mainActivity);

}
