package exportkit.xd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class help_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
    }

    public void home(View view){
        Intent i = new Intent(help_activity.this, HomeActivity.class);
        startActivity(i);
    }

    public void toDo(View view){
        Intent i = new Intent(help_activity.this, ToDoActivity.class);
        startActivity(i);
    }

    public void finance(View view){
        Intent i = new Intent(help_activity.this, FinanceActivity.class);
        startActivity(i);
    }

    public void profile(View view){
        Intent i = new Intent(help_activity.this, profile_activity.class);
        startActivity(i);
    }
}