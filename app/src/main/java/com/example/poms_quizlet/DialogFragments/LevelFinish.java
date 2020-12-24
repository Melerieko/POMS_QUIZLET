package com.example.poms_quizlet.DialogFragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.poms_quizlet.LevelSelectionActivity;

import java.util.Objects;

public class LevelFinish extends DialogFragment {
    int userScore;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = "Игра окончена!";
        String message;
        String button1String = "Вернуться в меню";

        if (getArguments() != null) {
            userScore = getArguments().getInt("userScore");
        }

        if(userScore == 10){
            message = "Великолепно!\nВы ответили правильно на " + userScore + " вопроса(ов) из 10.";
        }
        else if (userScore >= 8 && userScore < 10){
            message = "Отлично!\nВы ответили правильно на " + userScore + " вопроса(ов) из 10.";
        }
        else if (userScore >= 6 && userScore < 8){
            message = "Хорошо!\nВы ответили правильно на " + userScore + " вопроса(ов) из 10.";
        }
        else if (userScore >= 4 && userScore < 6){
            message = "Так себе!\nВы ответили правильно на " + userScore + " вопроса(ов) из 10.";
        }
        else if (userScore >= 1 && userScore < 4){
            message = "Плохо!\nВы ответили правильно на " + userScore + " вопроса(ов) из 10.";
        }
        else {
            message = "Ужасно!\nВы не дали ни одного правильного ответа...";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
        builder.setTitle(title);  // заголовок
        builder.setMessage(message); // сообщение
        builder.setPositiveButton(button1String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intentToSelection = new Intent(getContext(), LevelSelectionActivity.class);
                startActivity(intentToSelection);
                dialog.dismiss();
            }
        });
        builder.setCancelable(true);

        return builder.create();
    }
}
