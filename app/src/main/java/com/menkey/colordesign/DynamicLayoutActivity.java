package com.menkey.colordesign;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mac on 15/2/15.
 */
public class DynamicLayoutActivity extends FragmentActivity {

    Context mContext = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;

        LinearLayout llayout = new LinearLayout(mContext);
        llayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        llayout.setLayoutParams(layoutParams);

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

        setContentView(llayout);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,
                "This is dynamic activity", Toast.LENGTH_LONG).show();
            }
        });


    }

}
