package lj.android.ljandroid.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 作者：刘杰（QQ:770161055,WeChat:yjso0826）
 * 时间： 2017/2/20
 */

public class DateTools {

    /*
       *2016/11/22 15:20
       *liujie
       *时间搓得到时间
       **/
    public static String getStrTime(String time,int i) {
        String re_StrTime = null;
        SimpleDateFormat sdf = null;
        if ("".equals(time)||time==null) {
            return "";
        }
        switch (i){
            case 0:
                sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
                break;
            case 1:
                sdf = new SimpleDateFormat("yyyy.MM.dd");
                break;
            case 2:
                sdf = new SimpleDateFormat("yyyy年MM月dd日");
                break;
            default:
                sdf = new SimpleDateFormat("yyyy-MM-dd");
                break;
        }
        long loc_time = Long.valueOf(time);
        re_StrTime = sdf.format(new Date(loc_time ));
        return re_StrTime;
    }
    /*获取时间搓*/
    public static String getCurrentTimeMillis(){
      return String.valueOf(  System.currentTimeMillis());
    }

}
