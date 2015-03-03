package com.menkey.colordesign.util;

import android.os.Build;
import android.view.View;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mac on 15/3/3.
 * <p/>
 * while {@link View#generateViewId()} require API Level >= 17, this tool is compatibe with all API.
 * <p/>
 * according to current API Level, it decide weather using system API or not.<br>
 * so you can use {@link ViewIdGenerator#generateViewId()} and {@link View#generateViewId()} in the
 * same time and don't worry about getting same id
 */
public class ViewIdGenerator {

    /**
     * An {@code int} value that may be updated atomically.
     */
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

    /**
     * 动态生成View ID
     * API LEVEL 17 以上View.generateViewId()生成
     * API LEVEL 17 以下需要手动生成
     */
    public static int generateViewId() {

        if (Build.VERSION.SDK_INT < 17) {
            for (; ; ) {
                final int result = sNextGeneratedId.get();
                // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
                int newValue = result + 1;
                if (newValue > 0x00FFFFFF)
                    newValue = 1; // Roll over to 1, not 0.
                if (sNextGeneratedId.compareAndSet(result, newValue)) {
                    return result;
                }
            }
        } else {
            return View.generateViewId();
        }
    }
}