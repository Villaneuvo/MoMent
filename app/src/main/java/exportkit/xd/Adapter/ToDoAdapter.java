package exportkit.xd.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.CycleInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import exportkit.xd.DataBaseHelperToDo;
import exportkit.xd.R;
import exportkit.xd.TaskMain;
import exportkit.xd.ToDo;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.MyViewHolder> {

    private List<ToDo> mList = new ArrayList<>();
    private TaskMain taskMain;
    private DataBaseHelperToDo myDB;

    public ToDoAdapter(DataBaseHelperToDo myDB, TaskMain taskMain){
        this.taskMain = taskMain;
        this.myDB = myDB;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.iten_task_to_do_list, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ToDo item = mList.get(position);
        holder.txtTaskTitle.setText(item.getTask());
        holder.txtDate.setText(item.getDate());

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtTaskTitle, txtDate;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTaskTitle = itemView.findViewById(R.id.txtTaskTitle);
            txtDate = itemView.findViewById(R.id.txtDate);

        }
    }

    public Context getContext(){
        return taskMain;
    }

    public void setTask(List<ToDo> toDoList){
        this.mList = toDoList;
        notifyDataSetChanged();
    }

    public void deleteTask(int position){
        ToDo item = mList.get(position);
        myDB.deleteTask(item.getId());
        mList.remove(position);
        notifyItemRemoved(position);
    }

    public void editItem(int position){
        ToDo item = mList.get(position);

        Bundle bundle = new Bundle();
        bundle.putInt("id", item.getId());
        bundle.putString("task", item.getTask());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

}
