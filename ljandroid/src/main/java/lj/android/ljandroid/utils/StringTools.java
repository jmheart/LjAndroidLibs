package lj.android.ljandroid.utils;

import android.text.InputFilter;
import android.text.LoginFilter;
import android.widget.EditText;

/**
 * 作者：刘杰（QQ:770161055,WeChat:yjso0826）
 * 时间： 2017/2/20
 */

public class StringTools extends DateTools{
    /*
*2016/11/22 15:13
*liujie
*判断字符串是否为空
**/
    public static boolean isStringNull(String msg){
        if (msg==null){
            return true;
        }
        if (msg.isEmpty()){
            return true;
        }
        return false;
    }
    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0 || str.equalsIgnoreCase("null");
    }
    public static boolean isStringNull(Object... msg){
        for(Object temp:msg){
            if (isStringNull(temp)){
                return true;
            }
        }
        return false;
    }
    public static boolean isStringNull(Object msg){
        if (msg==null){
            return true;
        }
        if (msg.toString().isEmpty()){
            return true;
        }
        return false;
    }
    /*
    *2016/11/22 15:17
    *liujie
    *null转换为String
    **/
    public static String nullTString(String msg){
        if (msg==null){
            return "";
        }
        if (msg.isEmpty()){
            return "";
        }
        if ("null".equals(msg)){
            return "";
        }
        return msg;
    }
    /*
    *2016/11/22 15:06
    *liujie
    *字符串连接
    **/
    public static String addString(String... args){
        StringBuilder  sb = new StringBuilder();
        for(String temp:args)
            sb.append(temp);
        if (sb!=null)
            return sb.toString();
        return "";
    }
    /*
    *2016/11/22 15:11
    *liujie
    *字符转int
    **/
    public static int stringToInt(String msg){
        int resut=0;
        if (isStringNull(msg)){
            return resut;
        }
        try {
            resut= Integer.parseInt(msg);
        }catch (Exception e){
            e.printStackTrace();
        }
        return resut;
    }
    /*
  *2016/11/22 15:22
  *liujie
  *double 保留2位小数点
  **/
    public static String doubToString(Double d)  {
        return new java.text.DecimalFormat("0.0").format(d);
    }
    /*
    *2016/11/22 15:22
    *liujie
    *double 保留2位小数点
    **/
    public static String doub2String(Double d)  {
        return new java.text.DecimalFormat("0.00").format(d);
    }
    public static String moneyDoub2String(int i)  {
        double d=i/100.00;
        return new java.text.DecimalFormat("0.00").format(d);
    }
    public static String float2String(float d)  {
        return new java.text.DecimalFormat("0.00").format(d);
    }
    /*
    *2016/11/22 15:24
    *liujie
    *字符串转double
    **/
    public static double string2Doub(String msg){
        double d=0;
        try {
            d=Double.parseDouble(msg);
        }catch (Exception e){
            e.printStackTrace();
        }
        return d;
    }
    /*
    *2016/11/22 15:28
    *liujie
    *object 转int
    **/
    public static int objectToInt(Object object){
        int resut=0;
        if (object==null){
            return resut;
        }
        try {
            resut=Integer.parseInt(object.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return resut;
    }
    /**
     * 判定输入汉字
     * @param c
     * @return
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }
    /**
     * 检测String是否全是中文
     * @param name
     * @return
     */
    public static boolean checkNameChese(String name)
    {
        boolean res=true;
        try {
            char [] cTemp = name.toCharArray();
            for(int i=0;i<name.length();i++)
            {
                if(!isChinese(cTemp[i]))
                {
                    if (!".".equals(name.substring(i,i+1))){
                        res=false;
                        break;
                    }

                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return res;
    }
    /*设置中文过滤条件*/
    public static  void setEditTextFilters(EditText mEditText){
        InputFilter[] filters = new InputFilter[1];
        filters[0] = new MyInputFilter("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789,`~.';!@#$%^&*()_+=");
        mEditText.setFilters(filters);
    }
    public static class MyInputFilter extends LoginFilter.UsernameFilterGeneric {
        private String mAllowedDigits;
        public MyInputFilter(String digits ) {
            mAllowedDigits = digits;
        }
        @Override
        public boolean isAllowed(char c) {
            if (mAllowedDigits.indexOf(c) != -1) {
                return true;
            }
            return false;
        }
    }
}
