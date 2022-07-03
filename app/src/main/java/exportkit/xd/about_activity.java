package exportkit.xd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class about_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(about_activity.this, profile_activity.class);
        startActivity(i);
        overridePendingTransition(0,0);
    }

    public void postIgDaffa(View view){
        String URL = "https://www.instagram.com/daffa_reza_/";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));

        startActivity(browserIntent);
    }

    public void postIgDicky(View view){
        String URL = "https://www.instagram.com/dickysstwn/";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));

        startActivity(browserIntent);
    }

    public void postIgSalim(View view){
        String URL = "https://www.instagram.com/leamxxs/";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));

        startActivity(browserIntent);
    }

    public void postIgYudha(View view){
        String URL = "https://www.instagram.com/sahrul.yudha/";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));

        startActivity(browserIntent);
    }

    public void toDo(View view){
        Intent i = new Intent(about_activity.this, ToDoActivity.class);
        startActivity(i);
    }

    public void finance(View view){
        Intent i = new Intent(about_activity.this, FinanceActivity.class);
        startActivity(i);
    }

    public void home(View view){
        Intent i = new Intent(about_activity.this, HomeActivity.class);
        startActivity(i);
    }
}