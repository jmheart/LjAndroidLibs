package lj.android.ljandroid.adapter.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;


/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class SlideInBottomAnimation implements BaseAnimation {
    public int animationHight=0;
    @Override
    public Animator[] getAnimators(View view) {
        int hight=view.getMeasuredHeight();
        if (hight>0){
            animationHight=hight;
        }
        return new Animator[]{ObjectAnimator.ofFloat(view, "translationY", animationHight, 0)
        };
    }
}
