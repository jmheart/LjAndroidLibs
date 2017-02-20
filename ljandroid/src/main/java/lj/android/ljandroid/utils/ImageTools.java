package lj.android.ljandroid.utils;

import android.net.Uri;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;

import static android.R.attr.id;
import static com.facebook.imagepipeline.request.ImageRequestBuilder.newBuilderWithSource;

/**
 * 作者：刘杰（QQ:770161055,WeChat:yjso0826）
 * 时间： 2017/2/20
 */

public class ImageTools  extends StringTools{
    /*显示图片*/
    public static void showPxFrescoImage(final SimpleDraweeView s, String url,int imgWigth,int imgHight){
        if (url.startsWith("http")) {
            /*网络图片*/
            Uri uri = Uri.parse(url);
            ImageRequest request = newBuilderWithSource(uri)
                    .setResizeOptions(new ResizeOptions(imgWigth, imgHight))
                    .build();
            PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                    .setOldController(s.getController())
                    .setImageRequest(request)
                    .build();
            s.setController(controller);
        }else{
            /*本地图片*/
            if (!url.startsWith("res")&&!url.startsWith("asset")){
                url="file://"+url;
            }
            ImageRequest request = newBuilderWithSource(Uri.parse(url))
                    .setResizeOptions(new ResizeOptions(imgWigth, imgHight))
                    .build();
            PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                    .setOldController(s.getController())
                    .setImageRequest(request)
                    .build();
            s.setController(controller);
        }
    }
    /**
     * 加载本地图片
     */
    public static void loadResDroderImage( SimpleDraweeView sm,int id, int pxwight,int pxhight)  {
        Uri uri = Uri.parse("res:///"+id);
        ImageRequest request = newBuilderWithSource(uri)
                .setResizeOptions(new ResizeOptions(pxwight, pxhight))
                .build();
        PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                .setOldController(sm.getController())
                .setImageRequest(request)
                .build();
        sm.setController(controller);
    }
    /**
     * 加载本地图片
     */
    public static void loadAssetDroderImage( SimpleDraweeView sm,String pathpath,int pxwight,int pxhight)  {
        Uri uri = Uri.parse("asset:///"+id);
        ImageRequest request = newBuilderWithSource(uri)
                .setResizeOptions(new ResizeOptions(pxwight, pxhight))
                .build();
        PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                .setOldController(sm.getController())
                .setImageRequest(request)
                .build();
        sm.setController(controller);
    }
}
