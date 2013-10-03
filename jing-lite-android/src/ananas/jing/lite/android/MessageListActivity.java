package ananas.jing.lite.android;

import ananas.jing.lite.android.helper.JingAndroidClient;
import android.os.Bundle;
import android.view.Menu;

public class MessageListActivity extends JingActivityBase {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_message);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onServiceStatusChanged(JingAndroidClient jac,
			String newStatus) {
		// TODO Auto-generated method stub

	}

}
