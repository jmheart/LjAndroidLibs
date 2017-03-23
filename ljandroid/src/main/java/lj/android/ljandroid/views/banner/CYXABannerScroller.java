package lj.android.ljandroid.views.banner;

import android.content.Context;
import android.widget.Scroller;

/**
 * 作者:liujie
 * 描述:
 */
public class CYXABannerScroller extends Scroller {
    private int mDuration = 1000;

    public CYXABannerScroller(Context context, int duration) {
        super(context);
        mDuration = duration;
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        super.startScroll(startX, startY, dx, dy, mDuration);
    }
}