package com.example.a86130.zhangmiaoyin.presenter;

import android.util.Log;

import com.example.a86130.zhangmiaoyin.App;
import com.example.a86130.zhangmiaoyin.base.BasePresenter;
import com.example.a86130.zhangmiaoyin.component.DaggerHomeComponent;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

public class HomePresenter extends BasePresenter {
    @Inject
    OkHttpClient okHttpClient;

    public HomePresenter() {
        DaggerHomeComponent.builder().
                appComponent(App.daggerAppComponent()).
                build().
                inject(this);
    }

    //向M层请求数据
    @Override
    public void start(Object obj) {
        super.start(obj);
        Log.e("TAG", okHttpClient.toString());
        if (obj instanceof Integer) {
            Integer type = (Integer) obj;
            switch (type) {
                case 0:
                    Log.e("TAG", "第一个Fragment开始加载数据了....");
                    break;
                case 1:
                    Log.e("TAG", "第二个Fragment开始加载数据了....");
                    break;
                case 2:
                    Log.e("TAG", "第三个Fragment开始加载数据了...");
                    break;
                case 3:
                    Log.e("TAG", "第四个Fragment开始加载数据了....");
                    break;

            }
        }
    }
}
