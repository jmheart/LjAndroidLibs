package lj.android.ljandroid.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import lj.android.ljandroid.date.Preferences;

/**
 * 作者：刘杰（QQ:770161055,WeChat:yjso0826）
 * 时间： 2017/2/20
 */

public class CommTools extends DialogTools{
    /*显示日志*/
    public static  void shwoLog(String msg){
        LogUtil.i(String.valueOf(msg));
    }
    /*打印吐司*/
    public static  void showToast(String msg){
        Toast.makeText(getContext(),String.valueOf(msg),Toast.LENGTH_SHORT).show();
    }
    /*获取屏幕的宽*/
    public static int getDisplayWidth(){
        return ScreenUtil.getDisplayWidth();
    }
    /*获取屏幕的高*/
    public static int getDisplayHeight(){
        return ScreenUtil.getDisplayHeight();
    }
    /*dip->px*/
    public static int dip2px(float dipValue){
        return ScreenUtil.dip2px(dipValue);
    }
    /*px->dip*/
    public static int px2dip(float dipValue){
        return ScreenUtil.px2dip(dipValue);
    }
    /*获取保存数据*/
    public static String getSpDate(String key){
        return Preferences.getString(key);
    }
    /*保存数据*/
    public static void saveSpString(String key,String date){
         Preferences.saveString(key,date);
    }
    /*获取设备Imei*/
    public static String getDeviceImei(){
        String imei;
        try {
            TelephonyManager tm = (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);
            imei = tm.getDeviceId();

        }catch (Exception e){
            e.printStackTrace();
            imei="";
        }
        return imei;

    }

    /*
    *2016/11/25 13:27
    *liujie
    *设置默认fragment
    **/
    public static Fragment setDefaultFragment(FragmentManager fm, Fragment DefaultFragment, int id) {
        if(!DefaultFragment.isAdded()){
            fm.beginTransaction().add(id, DefaultFragment)
                    .commitAllowingStateLoss();
        }
        return  DefaultFragment;
    }
    /*
    *2016/11/25 12:21
    *liujie
    *fragment切换
    **/
    public static Fragment switchFragment(FragmentManager fm,Fragment DefaultFragment,Fragment fragment,int id) {
        if (fragment != DefaultFragment) {
            if (!fragment.isAdded()) {
                fm.beginTransaction().hide(DefaultFragment)
                        .add(id, fragment).commitAllowingStateLoss();
            } else {
                fm.beginTransaction().hide(DefaultFragment)
                        .show(fragment).commitAllowingStateLoss();
            }
            DefaultFragment = fragment;
        }
        return DefaultFragment;
    }
}
