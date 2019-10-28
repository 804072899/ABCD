package com.example.myapplication_mvp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseApp extends Application {

    public static Context mContext;
    public static HashMap<String,Object> map;
    public static SharedPreferences sharedPreferences;
    public static List<Activity> list;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext = this;
        map = new HashMap<>();
        sharedPreferences = getSharedPreferences("mysp",MODE_PRIVATE);
        list = new ArrayList<>();
    }

    public static Context getContext(){
      return mContext;
    };

    public static SharedPreferences getSharedPreferences(){
        if (sharedPreferences!=null){
            return sharedPreferences;
        }
        return null;
    };

    public static void exit(){
        //退出所有的Activity
        if (list!=null && list.size()>0){
            for (Activity activity: list) {
                activity.finish();
            }
        }
        //退出进程
        System.exit(0);
    }

    public static void clearActivity(){
        if (list!=null){
            list.clear();
            list=null;
        }
    }

    public static void putObj(String key,Object object){
        if (map!=null){
            map.put(key,object);
        }
    }

    public static Object getObject(String key){
        if (map != null && map.size()>0){
            return map.get(key);
        }
        return null;
    };

    public static void clearMap(){
        if (map != null){
            map.clear();
            map=null;
        }
    }
}
