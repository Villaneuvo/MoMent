
	 
	/*
     *	This content is generated from the API File Info.
     *	(Alt+Shift+Ctrl+I).
     *
     *	@desc
     *	@file 		splash_screen
     *	@date 		1655561316054
     *	@title 		Converting Desain
     *	@author
     *	@keywords
     *	@generator 	Export Kit v1.3.figma
     *
     */


    package exportkit.xd;

    import android.app.Activity;
    import android.content.Intent;
    import android.os.Bundle;


    import android.view.View;
    import android.widget.ImageView;
    import android.widget.TextView;

    public class change_password extends Activity {

        @Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.change_password);

        }

        public void changePassword(View view){
            Intent i = new Intent(change_password.this, profile_activity.class);
            startActivity(i);
        }
    }
	
	