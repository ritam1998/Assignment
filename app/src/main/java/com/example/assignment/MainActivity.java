package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.assignment.Adapter.StudentAdapter;
import com.example.assignment.Model.UserModel;
import com.example.assignment.diaLogBoxSettings.DialogSetUp;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DialogSetUp.DialogListner {

    private Dialog dialog;
    private ArrayList<UserModel> arrayList;
    private StudentAdapter studentAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton = findViewById(R.id.addButton);
        recyclerView = findViewById(R.id.recyclerView);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        arrayList = new ArrayList<UserModel>();
    }

    private void openDialog() {

        DialogSetUp dialogSetUp = new DialogSetUp();
        dialogSetUp.setCancelable(false);
        dialogSetUp.show(getSupportFragmentManager(),"Dialog");
    }

    @Override
    public void addedStudentdetails(String username, String age, String roll) {
        adapterSettings(username,age,roll);
    }

    private void adapterSettings(String username, String age, String roll){

        arrayList.add(new UserModel(username,age,roll));

        studentAdapter = new StudentAdapter();
        studentAdapter.studentDetails(arrayList);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(studentAdapter);
    }
}
