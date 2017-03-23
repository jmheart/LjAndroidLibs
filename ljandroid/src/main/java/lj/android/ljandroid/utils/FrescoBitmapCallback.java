package lj.android.ljandroid.utils;

/**
 * 作者：刘杰（QQ:770161055,WeChat:yjso0826）
 * 时间： 2017/2/21
 */

import android.net.Uri;

/**
 * Created by zhaoyong on 16/4/18.
 *
 */
public interface FrescoBitmapCallback<T> {

    void onSuccess(Uri uri, T result);

    void onFailure(Uri uri, Throwable throwable);

    void onCancel(Uri uri);
}