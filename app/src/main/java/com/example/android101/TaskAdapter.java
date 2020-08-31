package com.example.android101;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends  RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private  List<Task> tasks;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(tasks.get(position).getTitleTask());
        holder.description.setText(tasks.get(position).getDescriptionTask());

    }

    public void setTasks(List<Task> tasks){
        this.tasks = tasks;
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_item);
            description = itemView.findViewById(R.id.description_item);



        }



    }

}
