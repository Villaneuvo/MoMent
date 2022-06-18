package exportkit.xd;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;

public class splash_screen_activity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent i = new Intent(splash_screen_activity.this, login_session_activity.class);
				startActivity(i);
				finish();
			}
		}, 3000);

	}
}
	
	