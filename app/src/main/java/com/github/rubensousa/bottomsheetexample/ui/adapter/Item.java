package com.github.rubensousa.bottomsheetexample.ui.adapter;

import android.support.annotation.DrawableRes;

public class Item {

    private int mDrawableRes;

    private String mTitle;

    public Item(@DrawableRes int drawable, String title) {
        mDrawableRes = drawable;
        mTitle = title;
    }

    public int getDrawableResource() {
        return mDrawableRes;
    }

    public String getTitle() {
        return mTitle;
    }

}
