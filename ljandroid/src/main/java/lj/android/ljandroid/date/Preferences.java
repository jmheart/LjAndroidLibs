package lj.android.ljandroid.date;

import android.content.Context;
import android.content.SharedPreferences;

import lj.android.ljandroid.utils.LJTools;

/*保存用户数据*/
public class Preferences {
    public static final String USER_CONFIG_NAME="USER_CONFIG_NAME";//用户信息的保存应用key
    /*
    *2016/12/7 10:21
    *liujie
    *保存数据
    **/
    public static void saveString(String key, String value) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(key, value);
        editor.commit();
    }
    /*获取数据*/
    public static String getString(String key) {
        return getSharedPreferences().getString(key, "");
    }
    /*
    *2016/12/7 10:20
    *liujie
    *清除USER_CONFIG_NAME下所有数据
    **/
    public static void clearAllDate(){
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.clear();
        editor.commit();
    }
    /*
    *2016/12/7 10:21
    *liujie
    *获取SharedPreferences
    **/
    private static SharedPreferences getSharedPreferences(){
        return LJTools.getContext().getSharedPreferences(USER_CONFIG_NAME, Context.MODE_PRIVATE);
    }
}
