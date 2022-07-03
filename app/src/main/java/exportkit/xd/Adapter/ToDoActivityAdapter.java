package exportkit.xd.Adapter;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.Task;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import exportkit.xd.DataBaseHelperToDo;
import exportkit.xd.R;
import exportkit.xd.TaskMain;
import exportkit.xd.ToDo;
import exportkit.xd.ToDoActivity;

public class ToDoActivityAdapter extends RecyclerView.Adapter<ToDoActivityAdapter.MyViewHolder> {
    private List<ToDo> mList = new ArrayList<>();
    private ToDoActivity todoMain;
    private DataBaseHelperToDo myDB;

    public ToDoActivityAdapter(ToDoActivity todoMain, DataBaseHelperToDo myDB){
        this.todoMain = todoMain;
        this.myDB = myDB;
    }

    @NonNull
    @Override
    public ToDoActivityAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_to_do_list, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoActivityAdapter.MyViewHolder holder, int position) {
        ToDo item = mList.get(position);
        holder.txtTitleTask.setText(item.getTitle());
        holder.txtTaskField.setText(item.getTask());

        holder.btndetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(todoMain, TaskMain.class);
                todoMain.startActivity(i);
            }
        });
    }

    public Context getContext(){
        return todoMain;
    }

    public void setTask(List<ToDo> toDoList){
        this.mList = toDoList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitleTask, txtTaskField;
        ImageView btndetail;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            btndetail = itemView.findViewById(R.id.btndetail);
            txtTitleTask = itemView.findViewById(R.id.txtTitle);
            txtTaskField = itemView.findViewById(R.id.txtField);
        }
    }
}
