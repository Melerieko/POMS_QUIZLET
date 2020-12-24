package com.example.poms_quizlet.DialogFragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.poms_quizlet.levels.Level1;

public class Level1DialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = "Даты и события:";
        String message = "На данном уровне вам предстоит проверить ваши знания в общих исторических аспектах Второй Мировой Войны";
        String button1String = "Начать";
        String button2String = "Отмена";

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);  // заголовок
        builder.setMessage(message); // сообщение
        builder.setPositiveButton(button1String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                Toast.makeText(getActivity(), "Игра началась!",
                        Toast.LENGTH_LONG).show();
                Intent intentToLevel1 = new Intent(getContext(), Level1.class);
                startActivity(intentToLevel1);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(button2String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getActivity(), "Ну как знаете...", Toast.LENGTH_LONG)
                        .show();
                dialog.dismiss();


            }
        });
        builder.setCancelable(true);

        return builder.create();
    }
}
