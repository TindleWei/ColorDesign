package com.menkey.colordesign;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.menkey.colordesign.view.ElasticScrollView;

/**
 * Created by mac on 15/2/17.
 *
 * ElasticScrollView
 */
public class DynamicLayout3Activity extends FragmentActivity {

    Context mContext = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

        ElasticScrollView myScrollView = new ElasticScrollView(mContext);
//      myScrollView.setVerticalScrollBarEnabled(false);

        LinearLayout llayout = new LinearLayout(mContext);
        llayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        llayout.setLayoutParams(layoutParams);
        myScrollView.addView(llayout);

        TextView tv = new TextView(mContext);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(28,28,28,28);

        tv.setLayoutParams(lp);
        tv.setText("Test HaHaHa~");
        tv.setPadding(8, 8, 8, 8);

        llayout.addView(tv);

        Button btn = new Button(mContext);
        btn.setText("This is Button");
        btn.setPadding(8, 8, 8, 8);
        btn.setLayoutParams(lp);

        llayout.addView(btn);

        Button btn2 = new Button(mContext);
        btn2.setText("This is Button");
        btn2.setPadding(8, 8, 8, 8);
        btn2.setLayoutParams(lp);

        llayout.addView(btn2);

        setContentView(myScrollView);
    }
}
