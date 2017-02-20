package lj.android.ljandroid.base;

import android.content.Context;

import java.util.ArrayList;

import lj.android.ljandroid.adapter.BaseQuickAdapter;

/**
 * 作者：刘杰（QQ:770161055,WeChat:yjso0826）
 * 时间： 2017/2/20
 */

public abstract class BaseAdapter <T> extends BaseQuickAdapter<T> {
    Context mContext;
    public BaseAdapter(Context context, int layoutId){
        super(layoutId, new ArrayList<T>());
        this.mContext=context;
    }
}
