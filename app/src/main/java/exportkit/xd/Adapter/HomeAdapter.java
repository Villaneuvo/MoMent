package exportkit.xd.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import exportkit.xd.DataBaseHelperToDo;
import exportkit.xd.HomeActivity;
import exportkit.xd.R;
import exportkit.xd.ToDo;
import exportkit.xd.ToDoActivity;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    private List<ToDo> mList = new ArrayList<>();
    private HomeActivity homeActivity;
    private DataBaseHelperToDo myDB;

    public HomeAdapter(HomeActivity homeActivity, DataBaseHelperToDo myDB) {
        this.homeActivity = homeActivity;
        this.myDB = myDB;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_to_do_list, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ToDo item = mList.get(position);
        holder.txtTitleTask.setText(item.getTitle());
        holder.txtTaskField.setText(item.getTask());

        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(homeActivity, ToDoActivity.class);
                homeActivity.startActivity(i);
            }
        });
    }

    public Context getContext(){
        return homeActivity;
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
        ImageView btnDetail;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            btnDetail = itemView.findViewById(R.id.btndetail);
            txtTitleTask = itemView.findViewById(R.id.txtTitle);
            txtTaskField = itemView.findViewById(R.id.txtField);
        }
    }

}

