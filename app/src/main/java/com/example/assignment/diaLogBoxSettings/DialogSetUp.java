package com.example.assignment.diaLogBoxSettings;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.assignment.R;

public class DialogSetUp extends AppCompatDialogFragment {

    private EditText username;
    private EditText userage;
    private EditText userroll;

    private DialogListner listner;

    private String UserName;
    private String UserAge;
    private String UserRoll;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog,null);

        builder.setView(view)
                .setTitle("Student Details")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String userName = username.getText().toString();
                        String userAge = userage.getText().toString();
                        String userRoll = userroll.getText().toString();

                        if(userName.equals("") || userAge.equals("") || userRoll.equals("")){
                            Toast.makeText(getContext(),"Enter Student Details",Toast.LENGTH_LONG).show();
                        }else {
                            listner.addedStudentdetails(userName,userAge,userRoll);
                        }
                    }
                });

        username = view.findViewById(R.id.userName);
        userage = view.findViewById(R.id.userAge);
        userroll = view.findViewById(R.id.userRoll);

        username.setText(UserName);
        userage.setText(UserAge);
        userroll.setText(UserRoll);

        return builder.create();
    }
    public void updateItem(String userName, String userAge, String userRoll){

        this.UserName = userName;
        this.UserAge = userAge;
        this.UserRoll = userRoll;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listner = (DialogListner)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+"must implements listner");
        }
    }

    public interface DialogListner{
        void addedStudentdetails(String username,String age,String roll);
    }
}
