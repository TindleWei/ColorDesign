package com.menkey.colordesign.util;

/**
 * Created by mac on 15/3/4.
 */

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Toast工具类
 *
 * 单例类
 */
public class T {

    private static Toast toast = null;

    private static LinearLayout toastView = null;

    private static  int textId = 0;

    private static Context context = null;

    /**
     * Toast.LENGTH_LONG
     */
    public static void l(String msg) {

        createToast(context);

        toast.setDuration(Toast.LENGTH_LONG);
        setText(msg);
        toast.show();

    }

    /**
     * Toast.LENGTH_SHORT
     */
    public static void s(String msg) {

        createToast(context);

        toast.setDuration(Toast.LENGTH_SHORT);
        setText(msg);
        toast.show();

    }

    private static void setText(String msg) {

        TextView tv = (TextView) toastView.findViewById(textId);
        if (tv != null) {
            tv.setText(msg);
        }
    }

    private static void createToast(Context context) {

        if (toastView == null) {
            toastView = new LinearLayout(context);
            toastView.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            toastView.setLayoutParams(layoutParams);
            toastView.setBackgroundColor(Color.GRAY);

            TextView textView = new TextView(context);
            textView.setText("");
            textView.setPadding(10, 10, 10, 10);
            textView.setTextColor(Color.WHITE);
            textView.setLayoutParams(layoutParams);
            // 注意设置ID
            textId = ViewIdGenerator.generateViewId();
            textView.setId(textId);

            toastView.addView(textView);
        }

        if (toast == null) {
            toast = new Toast(context);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.setView(toastView);
        }
    }
}