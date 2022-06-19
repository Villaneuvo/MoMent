
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		add_title_template
	 *	@date 		1655626416665
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


import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class add_title_template_activity extends Activity {

	private EditText InTitle;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_title_template);

		InTitle = findViewById(R.id.fill_text_title);
	}

	public void saveTitle(View view){
		if (TextUtils.isEmpty(InTitle.getText().toString().trim())){
			Toast.makeText(this, "Title cannot be empty", Toast.LENGTH_SHORT).show();
		}
		else{
			Intent i = new Intent(add_title_template_activity.this, set_task_activity.class);
			startActivity(i);
		}
	}
}
	
	