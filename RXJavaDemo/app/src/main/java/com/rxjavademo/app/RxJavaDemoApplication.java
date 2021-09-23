package com.rxjavademo.app;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import androidx.appcompat.app.AppCompatDelegate;
import com.rxjavademo.DI.AppModule;
import com.rxjavademo.DI.DaggerHomeComponent;
import com.rxjavademo.DI.HomeComponent;
import com.rxjavademo.presenter.HomePresenter;


public class RxJavaDemoApplication extends Application {

    private static Context mContext;
    HomeComponent homeComponent;
    public RxJavaDemoApplication() {
    }
    public static Context getmContext() {
        return mContext;
    }
    public static void setmContext(Context context) {
        mContext = context;
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        mContext = this;
        RxJavaDemoApplication.setmContext(this);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        homeComponent= DaggerHomeComponent.builder().appModule(new AppModule(new HomePresenter())).build();
    }

    public HomeComponent getHomeComponent(){
        return homeComponent;
    }

}