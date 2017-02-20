package lj.android.ljandroid.base;

import android.app.Application;
import android.graphics.Bitmap;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.QualityInfo;

import java.util.concurrent.TimeUnit;

import lj.android.ljandroid.net.okhttp.OkHttpUtils;
import lj.android.ljandroid.net.okhttp.log.LoggerInterceptor;
import okhttp3.OkHttpClient;

/**
 * 作者：刘杰（QQ:770161055,WeChat:yjso0826）
 * 时间： 2017/2/20
 */

public class BaseApplication extends Application {
    public static BaseApplication mBaseApplication;
    public static BaseApplication getmBaseApplication() {
        return mBaseApplication;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mBaseApplication=this;
        inintFresco();
        ininOkHttpClient();
    }
    /*初始化图片框架*/
    private void inintFresco(){
        ProgressiveJpegConfig config = new ProgressiveJpegConfig() {
            @Override
            public int getNextScanNumberToDecode(int i) {
                return 0;
            }
            @Override
            public QualityInfo getQualityInfo(int i) {
                return null;
            }
        };
        ImagePipelineConfig imagePipelineConfig = ImagePipelineConfig.newBuilder(this)
                .setProgressiveJpegConfig(config)
                .setBitmapsConfig(Bitmap.Config.RGB_565)
                .build();
        Fresco.initialize(getApplicationContext(), imagePipelineConfig);//图片
    }
    /*初始化网络请求框架*/
    private void ininOkHttpClient(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }
}
