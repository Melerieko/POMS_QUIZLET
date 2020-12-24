package com.example.poms_quizlet.levels;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.poms_quizlet.DialogFragments.LevelFinish;
import com.example.poms_quizlet.LevelSelectionActivity;
import com.example.poms_quizlet.R;
import com.example.poms_quizlet.config.Level1_Config;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

public class Level1 extends AppCompatActivity implements View.OnClickListener{

    Button btn_one, btn_two, btn_three, btn_four;
    TextView tv_question;

    private Level1_Config question = new Level1_Config();

    private String answer;
    private int counter = 0;
    private int rightAnswers = 0;
    private int progress = 0;
    private ProgressBar pbHorizontal;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



        pbHorizontal = (ProgressBar) findViewById(R.id.progressBar);
        btn_one = (Button)findViewById(R.id.btn_one);
        btn_one.setOnClickListener(this);
        btn_two = (Button)findViewById(R.id.btn_two);
        btn_two.setOnClickListener(this);
        btn_three = (Button)findViewById(R.id.btn_three);
        btn_three.setOnClickListener(this);
        btn_four = (Button)findViewById(R.id.btn_four);
        btn_four.setOnClickListener(this);

        tv_question = (TextView)findViewById(R.id.tv_question);
        

        NextQuestion(counter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_one:
                if(btn_one.getText() == answer){
                    rightAnswers++;
                    NextQuestion(++counter);
                }else{
                    NextQuestion(++counter);
                }

                break;

            case R.id.btn_two:
                if(btn_two.getText() == answer){
                    rightAnswers++;
                    NextQuestion(++counter);
                }else{
                    NextQuestion(++counter);
                }

                break;

            case R.id.btn_three:
                if(btn_three.getText() == answer){
                    rightAnswers++;
                    NextQuestion(++counter);
                }else{
                    NextQuestion(++counter);
                }

                break;

            case R.id.btn_four:
                if(btn_four.getText() == answer){
                    rightAnswers++;
                    NextQuestion(++counter);
                }else{
                    NextQuestion(++counter);
                }

                break;
        }
    }

    private void gameOver(){
        LevelFinish level1Finish = new LevelFinish();
        Bundle bundle = new Bundle();
        bundle.putInt("userScore", rightAnswers);
        level1Finish.setArguments(bundle);
        level1Finish.show(getSupportFragmentManager(), "DialogFragmentWithSetter");
    }


    private void NextQuestion(int num){
        if(num == 10){
            gameOver();
        }
        if(num == 1){
            postProgress(progress);
        }
        else {
            progress = progress + 10;
            postProgress(progress);
        }
        String q = "questions/question" + num;
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference(q);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                tv_question.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //
            }
        });


        btn_one.setText(question.getchoice1(num));
        btn_two.setText(question.getchoice2(num));
        btn_three.setText(question.getchoice3(num));
        btn_four.setText(question.getchoice4(num));

        answer = question.getCorrectAnswer(num);

    }

    private void postProgress(int progress) {
        pbHorizontal.setProgress(progress);
        if (progress == 0) {
            pbHorizontal.setSecondaryProgress(0);
        } else {
            pbHorizontal.setSecondaryProgress(progress + 10);
        }
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(Level1.this, "Игра не завершена. Вы возвращены в главное меню", Toast.LENGTH_SHORT).show();
        Intent intentLevel1 = new Intent(Level1.this, LevelSelectionActivity.class);
        startActivity(intentLevel1);
        finish();
    }
}
