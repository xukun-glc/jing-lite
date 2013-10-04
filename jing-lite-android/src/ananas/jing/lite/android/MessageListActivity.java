package ananas.jing.lite.android;

import java.util.List;

import ananas.jing.lite.android.helper.JingAndroidClient;
import ananas.jing.lite.core.client.JingMessageOverview;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MessageListActivity extends JingActivityBase {

	private ListView _list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_message);

		this._list = (ListView) this.findViewById(R.id.message_list);
		this.__update_list();

	}

	class MyItemWrapper {

		private JingMessageOverview _item;
		private String _str;

		public MyItemWrapper(JingMessageOverview item) {
			_item = item;
		}

		public String toString() {
			if (_str == null) {

				_item.load();

				StringBuilder sb = new StringBuilder();
				if (_item.isRx()) {
					sb.append("from:");
					sb.append(_item.getFromAddress() + ";");
				} else {
					sb.append("to:");
					sb.append(_item.getToAddress() + ";");
				}
				sb.append(_item.getTitle() + ";");
				sb.append(_item.getOverview());
				_str = sb.toString();
			}
			return this._str;
		}
	}

	private void __update_list() {
		ArrayAdapter<MyItemWrapper> adapter = new ArrayAdapter<MyItemWrapper>(
				this, android.R.layout.simple_list_item_1);
		List<JingMessageOverview> list = this.getClient().getMessageManager()
				.listAll();
		for (JingMessageOverview item : list) {
			adapter.add(new MyItemWrapper(item));
		}
		this._list.setAdapter(adapter);
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
