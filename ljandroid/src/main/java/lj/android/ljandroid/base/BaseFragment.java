package lj.android.ljandroid.base;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import lj.android.ljandroid.utils.DialogTools;
import lj.android.ljandroid.utils.LogUtil;
import lj.android.ljandroid.views.dialog.SimpleArcDialog;

/**
 * 作者：刘杰（QQ:770161055,WeChat:yjso0826）
 * 时间： 2017/2/20
 */

public class BaseFragment extends Fragment{
    Context mContext;
    SimpleArcDialog mDialog;//网络加载框
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=getActivity();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mDialog!=null){
            mDialog.dismiss();
        }
    }

    /*显示对话框*/
    public void showDialog(){
        mDialog= DialogTools.showSimpleArcDialog(getActivity());
    }
    /*关闭对话框*/
    public void hideDialog(){
        if (mDialog!=null){
            mDialog.dismiss();
        }
    }
    /**
     * findViewById(int id)书写简化,无须强制转换、
     * @param id
     *         控件的id
     * @return 返回指定View
     */
    @SuppressWarnings("unchecked")
    public final <E extends View> E getView(View view,int id) {
        try {
            return (E) view.findViewById(id);
        } catch (ClassCastException e) {
            LogUtil.e("Can't cast the View.",e);
            throw e;
        }
    }
    /*关闭键盘*/
    public void offKeyFromWindow(EditText editText){
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
    /*跳转activity*/
    public void goActivity(Class z){
        startActivity(new Intent(getActivity(), z));
    }
}
