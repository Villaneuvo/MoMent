package exportkit.xd.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import exportkit.xd.AddTitleActivity;
import exportkit.xd.DataBaseHelperToDo;
import exportkit.xd.R;
import exportkit.xd.ToDo;
import exportkit.xd.ToDoActivity;

public class AddTitleAdapter extends RecyclerView.Adapter<AddTitleAdapter.MyViewHolder> {
    private List<ToDo> mList = new ArrayList<>();
    private AddTitleActivity addTitleActivity;
    private DataBaseHelperToDo myDB;

    public AddTitleAdapter(AddTitleActivity addTitleActivity, DataBaseHelperToDo myDB){
        this.addTitleActivity = addTitleActivity;
        this.myDB = myDB;
    }

    @NonNull
    @Override
    public AddTitleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_to_do_list, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AddTitleAdapter.MyViewHolder holder, int position) {
        ToDo item = mList.get(position);
        holder.txtTitleTask.setText(item.getTitle());
        holder.txtTaskField.setText(item.getTask());
    }

    public Context getContext(){
        return addTitleActivity;
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
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitleTask = itemView.findViewById(R.id.txtTitle);
            txtTaskField = itemView.findViewById(R.id.txtField);
        }
    }
}
