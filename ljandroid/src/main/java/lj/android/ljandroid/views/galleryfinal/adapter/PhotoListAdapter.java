/*
 * Copyright (C) 2014 pengjianbo(pengjianbosoft@gmail.com), Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package lj.android.ljandroid.views.galleryfinal.adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ImageView;

import java.util.List;

import cn.finalteam.toolsfinal.adapter.ViewHolderAdapter;
import lj.android.ljandroid.R;
import lj.android.ljandroid.views.galleryfinal.GalleryFinal;
import lj.android.ljandroid.views.galleryfinal.model.PhotoInfo;
import lj.android.ljandroid.views.galleryfinal.widget.GFImageView;


/**
 * Desction:
 * Author:pengjianbo
 * Date:15/10/10 下午4:59
 */
public class PhotoListAdapter extends ViewHolderAdapter<PhotoListAdapter.PhotoViewHolder, PhotoInfo> {
    private onChildItemClickListener mOnChildItemClickListener;

    private List<PhotoInfo> mSelectList;
    private int mScreenWidth;
    private int mRowWidth;
    private Activity mActivity;
    public void setOnChildItemClickListener(onChildItemClickListener onChildItemClickListener){
        this.mOnChildItemClickListener=onChildItemClickListener;
    }
    public PhotoListAdapter(Activity activity, List<PhotoInfo> list, List<PhotoInfo> selectList, int screenWidth) {
        super(activity, list);
        this.mSelectList = selectList;
        this.mScreenWidth = screenWidth;
        this.mRowWidth = mScreenWidth/3;
        this.mActivity = activity;
    }
    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = inflate(R.layout.gf_adapter_photo_list_item, parent);
        setHeight(view);
        return new PhotoViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final PhotoViewHolder holder, final int position) {
        final PhotoInfo photoInfo = getDatas().get(position);
        String path = "";
        if (photoInfo != null) {
            path = photoInfo.getPhotoPath();
        }
        if (position == 0) {
            Drawable defaultDrawable = mActivity.getResources().getDrawable(R.drawable.ic_gf_default_photo);
            GalleryFinal.getCoreConfig().getImageLoader().displayImageFromRes(mActivity, path, holder.mIvThumb, defaultDrawable, mRowWidth, mRowWidth, position);
        }
        if (position != 0) {
            holder.mIvThumb.setImageResource(R.drawable.ic_gf_default_photo);
            Drawable defaultDrawable = mActivity.getResources().getDrawable(R.drawable.ic_gf_default_photo);
            GalleryFinal.getCoreConfig().getImageLoader().displayImage(mActivity, path, holder.mIvThumb, defaultDrawable, mRowWidth, mRowWidth);
        }
        holder.mView.setAnimation(null);
        if (GalleryFinal.getCoreConfig().getAnimation() > 0) {
            holder.mView.setAnimation(AnimationUtils.loadAnimation(mActivity, GalleryFinal.getCoreConfig().getAnimation()));
        }
        holder.mIvCheck.setImageResource(GalleryFinal.getGalleryTheme().getIconCheck());
        if ( GalleryFinal.getFunctionConfig().isMutiSelect() ) {
            holder.mIvCheck.setVisibility(View.VISIBLE);
            if (mSelectList.contains(photoInfo)) {
                holder.mIvCheck.setImageResource(R.mipmap.choosefilm_selected);
//				holder.mIvCheck.setBackgroundColor(GalleryFinal.getGalleryTheme().getCheckSelectedColor());
            } else {
                holder.mIvCheck.setImageResource(R.mipmap.choosefilm_normal);
//				holder.mIvCheck.setBackgroundColor(GalleryFinal.getGalleryTheme().getCheckNornalColor());
            }
            if(position==0) {
                holder.mIvCheck.setVisibility(View.GONE);
            }else {
                holder.mIvCheck.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mOnChildItemClickListener.ivCheckClick(holder.mView,position);
                    }
                });
                holder.mIvThumb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mOnChildItemClickListener.ivPreViewClick(photoInfo,holder.mView,position);
                    }
                });
            }
        } else {
            holder.mIvCheck.setVisibility(View.GONE);
       
            holder.mIvThumb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnChildItemClickListener.ivPreViewClick(photoInfo,holder.mView,position);
                }
            });
        }
        
        
        
 
    }

    private void setHeight(final View convertView) {
        int height = mScreenWidth / 3 - 8;
        convertView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height));
    }

    public static class PhotoViewHolder extends ViewHolderAdapter.ViewHolder {

        public GFImageView mIvThumb;
        public ImageView mIvCheck;
        View mView;
        public PhotoViewHolder(View view) {
            super(view);
            mView = view;
            mIvThumb = (GFImageView) view.findViewById(R.id.iv_thumb);
            mIvCheck = (ImageView) view.findViewById(R.id.iv_check);
        }
    }
    public interface  onChildItemClickListener{
		/**
         * 图片显示右上角小图标显示页面
         */
        void ivCheckClick(View view, int position);

		/**
         * 图片点击事件显示
         */
        void ivPreViewClick(PhotoInfo photoInfo, View view, int position);
        
        
    }
}
