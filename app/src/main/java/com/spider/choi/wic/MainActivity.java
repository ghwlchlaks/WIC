package com.spider.choi.wic;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "TESTING : ";
    static final String[] LIST_MENU = {"LIST1", "LIST2", "LIST3"};

    ImageView WIC, Community, Trip, Computer;

    Toolbar mainToolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    RelativeLayout mainRelative;

    View drawer_header;
    ImageView ivProfile;
    Button loginBtn, logoutBtn;
    TextView tvName;
    LinearLayout mostContents;
    ListView mostList;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WIC = (ImageView)findViewById(R.id.WIC);
        Community = (ImageView)findViewById(R.id.Community);
        Trip = (ImageView)findViewById(R.id.Trip);
        Computer = (ImageView)findViewById(R.id.Computer);

        mainToolbar = (Toolbar) findViewById(R.id.mainToolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        mainRelative = (RelativeLayout) findViewById(R.id.main_Relative);

        drawer_header = navigationView.getHeaderView(0);
        ivProfile = (ImageView)drawer_header.findViewById(R.id.ivProfile);
        tvName = (TextView)drawer_header.findViewById(R.id.tvName);
        mostContents = (LinearLayout)drawer_header.findViewById(R.id.mostContents);
        mostList = (ListView)drawer_header.findViewById(R.id.mostList);
        loginBtn= (Button)drawer_header.findViewById(R.id.loginBtn);
        logoutBtn= (Button)drawer_header.findViewById(R.id.logoutBtn);

        checkedLogin(); //isLogin
        Button.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.loginBtn:
                        login();
                        break;
                    case R.id.logoutBtn:
                        logout();
                        break;
                }
            }
        };
        loginBtn.setOnClickListener(clickListener);
        logoutBtn.setOnClickListener(clickListener);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, LIST_MENU);
        mostList.setAdapter(adapter);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.daimajia);
        RoundedBitmapDrawable  mDrawable = RoundedBitmapDrawableFactory.create(getResources(),bitmap);
        mDrawable.setCircular(true);
        ivProfile.setImageDrawable(mDrawable);

        setSupportActionBar(mainToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        Log.e(TAG, "app start!");

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();

                int id = menuItem.getItemId();
                String title = (String) menuItem.getTitle();
                switch (title) {
                    case "HOME":
                        Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
        WIC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), subject.class);
                startActivity(intent);
            }
        });
        Community.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), subject.class);
                startActivity(intent);
            }
        });
        Trip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), subject.class);
                startActivity(intent);
            }
        });
        Computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), subject.class);
                startActivity(intent);
            }
        });
    }

    private void checkedLogin() {
        //로그인 되어있는지 검사 후 첫화면 login logout button의 visibility 처리
    }

    private void logout(){
        //logout 처리 후
        loginBtn.setVisibility(View.VISIBLE);
        logoutBtn.setVisibility(View.INVISIBLE);
    }

    private void login() {
        // login 처리 후
        loginBtn.setVisibility(View.INVISIBLE);
        logoutBtn.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
