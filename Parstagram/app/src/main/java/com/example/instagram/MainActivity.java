package com.example.instagram;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv;
    final FragmentManager fragmentManager = getSupportFragmentManager();
    final Fragment postFragment = new PostFragment();
    final Fragment profileFragment = new StoryFragment();
    final Fragment storyFragment = new StoryFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv = findViewById(R.id.bnvMain);

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.postNav:
                        fragment = postFragment;
                        break;
                    case R.id.profileNav:
                        fragment = profileFragment;
                        break;
                    case R.id.storyNav:
                        fragment = storyFragment;
                        break;
                    default:
                        fragment = storyFragment;
                }
                fragmentManager.beginTransaction().replace(R.id.frameContainer, fragment).commit();
                return true;
            }
        });
        if (savedInstanceState == null) {
            bnv.setSelectedItemId(R.id.storyFragment);
            fragmentManager.beginTransaction().replace(R.id.frameContainer, storyFragment).commit();
        }
    }

}