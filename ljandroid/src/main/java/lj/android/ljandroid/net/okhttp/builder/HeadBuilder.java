package lj.android.ljandroid.net.okhttp.builder;


import lj.android.ljandroid.net.okhttp.OkHttpUtils;
import lj.android.ljandroid.net.okhttp.request.OtherRequest;
import lj.android.ljandroid.net.okhttp.request.RequestCall;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,id).build();
    }
}
