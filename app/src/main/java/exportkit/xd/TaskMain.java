package exportkit.xd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import exportkit.xd.Adapter.ToDoAdapter;

public class TaskMain extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private DataBaseHelperToDo myDB;
    private ToDoAdapter taskAdapter;
    private int mt = 802, ml = 807;
    private RelativeLayout btnAddTask;


    private List<ToDo> taskList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_field_non_setting_list);

        taskList = new ArrayList<>();

        getSupportActionBar().hide();

        btnAddTask = findViewById(R.id.btnAddTask);
        mRecyclerView = findViewById(R.id.recycler_view_to_do);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new ToDoAdapter(myDB, this);
        mRecyclerView.setAdapter(taskAdapter);
        myDB = new DataBaseHelperToDo(TaskMain.this);

        taskList = myDB.getAllTask();

        if(taskList.isEmpty()){
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(ml, (mt*2) - 150, 0, 0);
            btnAddTask.setLayoutParams(lp);
        } else{
            int mulp = taskList.size()/2;
            if (taskList.size() <= 3){
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(ml, (mt*2) + 150, 0, 0);
                btnAddTask.setLayoutParams(lp);
            } else{
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(ml, (mt*mulp) + 175, 0, 0);
                btnAddTask.setLayoutParams(lp);
            }
        }

        taskAdapter.setTask(taskList);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(TaskMain.this, ToDoActivity.class);
        startActivity(i);
    }

    public void backToDo(View view){
        Intent i = new Intent(TaskMain.this, ToDoActivity.class);
        startActivity(i);
    }

    public void openSetting(View view){
        Intent i = new Intent(TaskMain.this, to_do_field_1_activity.class);
        startActivity(i);
    }

    public void addTask(View view){
        Intent i = new Intent(TaskMain.this, set_task_activity.class);
        startActivity(i);
    }
}