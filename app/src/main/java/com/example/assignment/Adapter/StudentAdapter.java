package com.example.assignment.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.example.assignment.Model.UserModel;
import com.example.assignment.R;
import com.example.assignment.diaLogBoxSettings.DialogSetUp;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private ArrayList<UserModel> studentList;
    @NonNull
    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_details,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.ViewHolder holder, final int position) {

        StringBuffer stringBufferUserName = new StringBuffer();
        stringBufferUserName.append("Name : "+studentList.get(position).getUserName());
        holder.username.setText(stringBufferUserName);

        StringBuffer stringBufferUserAge = new StringBuffer();
        stringBufferUserAge.append("Age :"+studentList.get(position).getUserAge());
        holder.userage.setText(stringBufferUserAge);

        StringBuffer stringBufferuserRoll = new StringBuffer();
        stringBufferuserRoll.append("Roll : "+studentList.get(position).getUserRoll());
        holder.userroll.setText(stringBufferuserRoll);


        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentList.remove(position);
                notifyDataSetChanged();
            }
        });

        holder.updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogSetUp dialogSetUp = new DialogSetUp();
                FragmentActivity activity = (FragmentActivity) v.getContext();
                dialogSetUp.updateItem(studentList.get(position).getUserName(),studentList.get(position).getUserAge(),studentList.get(position).getUserRoll());
                dialogSetUp.show(activity.getSupportFragmentManager(),"Dialog");
                studentList.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }
    public void studentDetails(ArrayList<UserModel> arrayList){
        this.studentList = arrayList;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView username;
        private TextView userage;
        private TextView userroll;
        private ImageButton deleteButton;
        private ImageButton updateButton;

        ViewHolder(View view) {
            super(view);
            this.username = view.findViewById(R.id.username);
            this.userage = view.findViewById(R.id.userage);
            this.userroll = view.findViewById(R.id.userroll);
            this.deleteButton = view.findViewById(R.id.removeButton);
            this.updateButton = view.findViewById(R.id.editButton);
        }
    }
}
