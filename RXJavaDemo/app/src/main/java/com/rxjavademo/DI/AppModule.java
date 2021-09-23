package com.rxjavademo.DI;

import com.rxjavademo.presenter.HomePresenter;
import com.rxjavademo.utils.SharedPrefUtils;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by nancy
 */

@Module
public class AppModule {
    private HomePresenter homePresenter;

    public AppModule(HomePresenter homePresenter){this.homePresenter=homePresenter;}

    @Provides
    @Singleton
    public SharedPrefUtils<String> getUtil(){
        return new SharedPrefUtils();
    }

    @Provides
    @Singleton
    public HomePresenter getHomePresenter(){
        return homePresenter;
    }

}
