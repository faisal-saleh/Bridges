package com.rnextension;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Gravity;
import android.widget.FrameLayout;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.rnextension.sphere.Photo;
import com.rnextension.sphere.GLPhotoView;
import com.rnextension.sphere.RotateInertia;

import java.io.IOException;
import java.net.URL;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PanoramaImageManager extends SimpleViewManager<FrameLayout> {

    public static final String REACT_CLASS = "RCTPanoramaImage";
    public static final int PHOTO_VIEW_ID = 1234567890;

    @Nonnull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Nonnull
    @Override
    protected FrameLayout createViewInstance(@Nonnull ThemedReactContext reactContext) {
        GLPhotoView photoView = new GLPhotoView(reactContext);
        Bitmap image = BitmapFactory.decodeResource(reactContext.getResources(), R.drawable.two);
        photoView.setTexture(new Photo(image, 0.0, 0.0, 0.0));

        photoView.setId(PHOTO_VIEW_ID);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        photoView.setLayoutParams(params);

        FrameLayout layout = new FrameLayout(reactContext);
        layout.addView(photoView);
        return layout;
    }

    @ReactProp(name = "alpha")
    public void setAlpha(FrameLayout view, @Nullable float alpha) {
        GLPhotoView photoView = view.findViewById(PHOTO_VIEW_ID);
        photoView.setAlpha(alpha);
    }

    @ReactProp(name = "rotateInertia")
    public void setRotateInertia(FrameLayout view, @Nullable int rotateInertia) {
        GLPhotoView photoView = view.findViewById(PHOTO_VIEW_ID);
        switch (rotateInertia) {
            case 1:
                photoView.setmRotateInertia(RotateInertia.INERTIA_50);
                break;
            case 2:
                photoView.setmRotateInertia(RotateInertia.INERTIA_100);
                break;
            default:
                photoView.setmRotateInertia(RotateInertia.INERTIA_0);

        }
    }


}