package com.spider.choi.wic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class contents extends AppCompatActivity {
    TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contents);
        titleText =  (TextView)findViewById(R.id.titleText);

        Intent intent = getIntent();
        ListViewItem content = (ListViewItem)intent.getSerializableExtra("listview");
        titleText.setText(content.getTitleStr());
    }
}
