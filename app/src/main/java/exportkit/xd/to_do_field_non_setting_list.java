package exportkit.xd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class to_do_field_non_setting_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_field_non_setting_list);
    }

    public void backToDo(View view){
        Intent i = new Intent(to_do_field_non_setting_list.this, to_do_activity.class);
        startActivity(i);
    }

    public void openSetting(View view){
        Intent i = new Intent(to_do_field_non_setting_list.this, to_do_field_1_activity.class);
        startActivity(i);
    }

    public void addTask(View view){
        Intent i = new Intent(to_do_field_non_setting_list.this, set_task_activity.class);
        startActivity(i);
    }
}