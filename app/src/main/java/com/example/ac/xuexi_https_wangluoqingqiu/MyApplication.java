package com.example.ac.xuexi_https_wangluoqingqiu;

import android.app.Application;

import me.jessyan.autosize.AutoSize;
import me.jessyan.autosize.AutoSizeConfig;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        autosizeconfig();
    }
    private void autosizeconfig() {
        AutoSizeConfig.getInstance().setCustomFragment(true);
        AutoSize.initCompatMultiProcess(this);
    }
}
