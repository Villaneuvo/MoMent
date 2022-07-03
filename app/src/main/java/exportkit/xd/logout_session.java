package exportkit.xd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class logout_session extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout_session);
    }

    public void confirmLogout(View view){
        Intent i = new Intent(logout_session.this, login_session_activity.class);
        startActivity(i, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        finish();
    }

    public void backToProfile(View view){
        Intent i = new Intent(logout_session.this, profile_activity.class);
        startActivity(i);
        finish();
    }
}