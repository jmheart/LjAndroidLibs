package lj.android.ljandroid.views.banner.transformer;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

public class StackPageTransformer extends BGAPageTransformer {

    @Override
    public void handleInvisiblePage(View view, float position) {
    }

    @Override
    public void handleLeftPage(View view, float position) {
    }

    @Override
    public void handleRightPage(View view, float position) {
        ViewHelper.setTranslationX(view, -view.getWidth() * position);
    }

}