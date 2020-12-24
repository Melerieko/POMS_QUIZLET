package com.example.poms_quizlet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.poms_quizlet.*;
import com.example.poms_quizlet.DialogFragments.Level1DialogFragment;
import com.example.poms_quizlet.DialogFragments.Level2DialogFragment;
import com.example.poms_quizlet.DialogFragments.Level3DialogFragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class LevelSelectionActivity extends AppCompatActivity{

    //TextView description;
    Button btnLevel1;
    Button btnLevel2;
    Button btnLevel3;
    Button btnLevel4;
    Button btnBack;

    private long backPressedTime;
    private Toast backToast;

    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelselection);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        btnLevel1 = (Button) findViewById(R.id.button_level1);
        btnLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                Level1DialogFragment level1DialogFragment = new Level1DialogFragment();
                level1DialogFragment.show(manager, "myDialog");

                /*Intent intentLevel1 = new Intent(LevelSelectionActivity.this, Level1.class);
                startActivity(intentLevel1);
                finish();*/
            }
        });
        btnLevel2 = (Button) findViewById(R.id.button_level2);
        btnLevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                Level2DialogFragment level2DialogFragment = new Level2DialogFragment();
                level2DialogFragment.show(manager, "myDialog");
            }
        });
        btnLevel3 = (Button) findViewById(R.id.button_level3);
        btnLevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                Level3DialogFragment level3DialogFragment = new Level3DialogFragment();
                level3DialogFragment.show(manager, "myDialog");
            }
        });
        btnLevel4 = (Button) findViewById(R.id.button_level4);
        btnLevel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnBack = (Button) findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBegining = new Intent(LevelSelectionActivity.this, MainActivity.class);
                startActivity(intentBegining);
            }
        });

    }

    @Override
    public void onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            onStop();
        } else{
            backToast = Toast.makeText(getBaseContext(), "Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
