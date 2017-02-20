package lj.android.ljandroid.net;

import java.util.Map;

import lj.android.ljandroid.base.BaseApplication;
import lj.android.ljandroid.net.okhttp.OkHttpUtils;
import lj.android.ljandroid.net.okhttp.callback.StringCallback;
import lj.android.ljandroid.utils.BaseMap;
import lj.android.ljandroid.utils.LogUtil;
import okhttp3.Call;

/**
 * 作者：刘杰（QQ:770161055,WeChat:yjso0826）
 * 时间： 2017/2/20
 */

public class LjNet {
    public static  void post(String url,Map<String,String> map,final LjNetCallBack nLjNetCallBack){
        if (map==null){
            map=new BaseMap();
        }
        if (!NetworkUtils.isNetworkAvailable(BaseApplication.getmBaseApplication().getApplicationContext())){
            nLjNetCallBack.onFial("网络连接断开了~");
            return;
        }
        OkHttpUtils.post().params(map).url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                log(e.toString());
                nLjNetCallBack.onFial(e.toString());
            }
            @Override
            public void onResponse(String response, int id) {
                log(response);
                nLjNetCallBack.onSuccess(response);
            }
        });
    }
    public static  void post(String url,Map<String,String> map){
        post(url, map, new LjNetCallBack() {
            @Override
            public void onSuccess(String date) {

            }
            @Override
            public void onFial(String date) {

            }
        });
    }
    public static  void get(String url,Map<String,String> map,final LjNetCallBack nLjNetCallBack){
        if (map==null){
            map=new BaseMap();
        }
        if (!NetworkUtils.isNetworkAvailable(BaseApplication.getmBaseApplication().getApplicationContext())){
            nLjNetCallBack.onFial("网络连接断开了~");
            return;
        }
        OkHttpUtils.get().params(map).url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                log(e.toString());
                nLjNetCallBack.onFial(e.toString());
            }
            @Override
            public void onResponse(String response, int id) {
                log(response);
                nLjNetCallBack.onSuccess(response);
            }
        });
    }
    public static  void get(String url,Map<String,String> map){
        get(url, map, new LjNetCallBack() {
            @Override
            public void onSuccess(String date) {

            }
            @Override
            public void onFial(String date) {
            }
        });
    }
    public static void log(String log){
        LogUtil.i("网络请求->>>"+log);
    }
}
