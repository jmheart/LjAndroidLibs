package lj.android.ljandroid.utils;

import android.app.Activity;
import android.content.Context;

import lj.android.ljandroid.R;
import lj.android.ljandroid.views.dialog.ArcConfiguration;
import lj.android.ljandroid.views.dialog.SimpleArcDialog;
import lj.android.ljandroid.views.dialog.SimpleArcLoader;

/**
 * 作者：刘杰（QQ:770161055,WeChat:yjso0826）
 * 时间： 2017/2/20
 */

public class DialogTools extends ImageTools {
    /*
    *2016/10/14 11:42
    *liujie
    *网络加载框
    **/
    public static SimpleArcDialog showSimpleArcDialog(Context context){
        if (context instanceof Activity &&((Activity) context).isFinishing()){
            return null;
        }
        final SimpleArcDialog mDialog = new SimpleArcDialog(context);
        ArcConfiguration configuration = new ArcConfiguration(context);
        configuration.setLoaderStyle(SimpleArcLoader.STYLE.SIMPLE_ARC);
        configuration.setText("请求中...");
        configuration.setColors(new int[]{context.getResources().getColor(R.color.orng)});
        configuration.setTextColor(context.getResources().getColor(R.color.text_888888));
        mDialog.setConfiguration(configuration);
        mDialog.setCanceledOnTouchOutside(false);// 设置点击屏幕Dialog不消失
        mDialog.show();
        return mDialog;
    }
}
