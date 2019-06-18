package com.example.myexperiment02_mvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.myexperiment02_mvvm.entity.News;

public class NewsViewModel extends AndroidViewModel {

    // 将预在页面绑定的数据，声明为与页面生命周期绑定的MutableLiveData可变类型
    // 可以想象为一个能够绑定到视图页面的容器
    public MutableLiveData<News> newsMutableLiveData = new MutableLiveData<>();

    public NewsViewModel(@NonNull Application application) {
        super(application);
        News news = new News(1, "the popularization of the 5G", "happiness");
        newsMutableLiveData.setValue(news); // 主线程中更新数据
    }

    public void change() {
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                News news = newsMutableLiveData.getValue();
                news.content = "HAWEI is leading in 5G";
                newsMutableLiveData.postValue(news);
            }catch (InterruptedException e) {
            }
        }).start();
    }
}
