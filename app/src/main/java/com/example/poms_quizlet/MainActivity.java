package com.example.poms_quizlet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText playerName;
    Button btnGoToLevelSelection;

    private long backPressedTime;
    private Toast backToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



        playerName = (EditText) findViewById(R.id.playerNameField);
        btnGoToLevelSelection = (Button) findViewById(R.id.btnGoToLevelSelection);
        btnGoToLevelSelection.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){

        String playerNameString = playerName.getText().toString();

        boolean checkForEmptyPlayerNameField = playerNameString.equals("");

        if (checkForEmptyPlayerNameField) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Введите своё имя", Toast.LENGTH_SHORT);
            toast.show();
        }

        if (!checkForEmptyPlayerNameField){
            Intent intent = new Intent(getApplicationContext(), LevelSelectionActivity.class);
            startActivity(intent);
            finish();
        }
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