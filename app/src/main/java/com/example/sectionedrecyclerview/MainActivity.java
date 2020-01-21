package com.example.sectionedrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.sectionedrecyclerview.fragments.FriendFragment;
import com.example.sectionedrecyclerview.fragments.HomeFragment;
import com.example.sectionedrecyclerview.fragments.ReceiptFragment;
import com.example.sectionedrecyclerview.fragments.SearchFragment;
import com.example.sectionedrecyclerview.fragments.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mFrameLayout;
    private BottomNavigationView mBottomNavigationView;
    public static final String TAG = "main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate-method");

        mFrameLayout = findViewById(R.id.main_frame_layout_id);
        mBottomNavigationView = findViewById(R.id.ac_main_bottom_nav_id);
        mBottomNavigationView.setOnNavigationItemSelectedListener(listener);
        onClickFragment(new HomeFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.ac_menu_home_id:
                    Log.i(TAG, "menu_home_selected");
                    onClickFragment(new HomeFragment());
                    return true;
                case R.id.ac_menu_receipt_id:
                    Log.i(TAG, "menu_receipt_selected");
                    onClickFragment(new ReceiptFragment());
                    return true;
                case R.id.ac_menu_people_id:
                    Log.i(TAG, "menu_friends_selected");
                    onClickFragment(new FriendFragment());
                    return true;
                case R.id.ac_menu_search_id:
                    Log.i(TAG, "menu_search_selected");
                    onClickFragment(new SearchFragment());
                    return true;
                case R.id.ac_menu_settings_id:
                    Log.i(TAG, "menu_settings_selected");
                    onClickFragment(new SettingFragment());
                    return true;
                default:
                    return false;
            }
        }
    };

    private void onClickFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout_id, fragment).commit();
    }
}
