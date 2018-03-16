package com.chen.gittestdemo;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.test.myapplication.WebViewActivityDm;


public class ExitDialog extends Dialog {

    Context mcContext;

    public ExitDialog(Context context, int theme) {
        super(context, theme);
        mcContext = context;
    }

    public ExitDialog(Context context) {
        super(context);
        mcContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exit);

        TextView cancle = (TextView) findViewById(R.id.btn_myinfo_cancel);
        cancle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                dismiss();

            }
        });
        TextView exit = (TextView) findViewById(R.id.btn_myinfo_sure);
        exit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                dismiss();
                Intent it = new Intent(mcContext, WebViewActivityDm.class);
                mcContext.startActivity(it);

            }
        });
    }
}
