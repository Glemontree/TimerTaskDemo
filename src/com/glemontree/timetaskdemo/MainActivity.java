package com.glemontree.timetaskdemo;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	private int secondLeft = 6;
	private TextView textView;
	Timer timer = new Timer();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView) findViewById(R.id.texttime);
	}
	
	public void begin(View view) {
		timer.schedule(task, 1000, 1000);
	}
	
	TimerTask task = new TimerTask() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					secondLeft--;
					textView.setText("" + secondLeft);
					if (secondLeft < 0) {
						timer.cancel();
						textView.setText("倒计时结束");
					}
				}
			});
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
