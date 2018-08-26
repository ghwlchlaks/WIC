package com.spider.choi.wic;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

public class subject extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{
    static final String[] LIST_MENU = {"LIST1", "LIST2", "LIST3"};
    ListView dataList;
    SwipeRefreshLayout mSwipeRefreshLayout;
    FloatingActionButton addContentsBtn,searchContentsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        mSwipeRefreshLayout = findViewById(R.id.swipe_layout);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, LIST_MENU);
        dataList = (ListView)findViewById(R.id.dataList);
        dataList.setAdapter(adapter);

        dataList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strText = (String) parent.getItemAtPosition(position) ;
                Toast.makeText(getApplicationContext(), strText, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), contents.class);
                intent.putExtra("title", strText);
                startActivity(intent);
            }
        });

        addContentsBtn =(FloatingActionButton)findViewById(R.id.addContentsBtn);
        searchContentsBtn =(FloatingActionButton)findViewById(R.id.searchContentsBtn);
        addContentsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), addContents.class);
                startActivity(intent);
            }
        });
        searchContentsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "searchContextBtn clicked!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onRefresh() {
        Toast.makeText(getApplicationContext(), "refreshing~", Toast.LENGTH_SHORT).show();
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
