package com.eshreef.help;

import android.app.Application;

import com.eshreef.help.di.AppComponent;
import com.eshreef.help.di.DaggerAppComponent;

public class SikiApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
