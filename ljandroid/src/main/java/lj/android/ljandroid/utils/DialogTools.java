package lj.android.ljandroid.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import lj.android.ljandroid.R;
import lj.android.ljandroid.iback.IBack;
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
    /*换一换的弹出框*/
    public static PopupWindow choseThirdDialog(Activity context, String one, String two, String third, String content, final IBack iBack){
        final PopupWindow inputDialog = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.chose_third_dialog_layout, null);// 得到加载view
        ((TextView)v.findViewById(R.id.tv_content)).setText(content);
        Button buttonOne=((Button)v.findViewById(R.id.btn_one));
        buttonOne.setText(one);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputDialog != null)
                    inputDialog.dismiss();
                iBack.onIback(String.valueOf(1));
            }
        });
        Button buttonTwo= ((Button)v.findViewById(R.id.btn_two));
        buttonTwo.setText(two);
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputDialog != null)
                    inputDialog.dismiss();
                iBack.onIback(String.valueOf(2));
            }
        });
        Button buttonThid=((Button)v.findViewById(R.id.btn_third));
        if (!isStringNull(third)){
            buttonThid.setText(third);
            buttonThid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (inputDialog != null)
                        inputDialog.dismiss();
                    iBack.onIback(String.valueOf(3));
                }
            });
        }else{
            buttonThid.setVisibility(View.GONE);
        }

        inputDialog.setContentView(v);
        inputDialog.setFocusable(true);//设置SelectPicPopupWindow弹出窗体可点击
        //inputDialog.setAnimationStyle(R.style.AnimBottom); //设置SelectPicPopupWindow弹出窗体动画效果
        ColorDrawable dw = new ColorDrawable(0xb0000000); //实例化一个ColorDrawable颜色为半透明
        inputDialog.setBackgroundDrawable(dw);//设置SelectPicPopupWindow弹出窗体的背景
        v.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                int height = v.findViewById(R.id.lin_input).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        if (inputDialog!=null)
                            inputDialog.dismiss();
                    }
                }
                return true;
            }
        });
        inputDialog.showAtLocation(context.getWindow().getDecorView(), Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
        return inputDialog;
    }
}
