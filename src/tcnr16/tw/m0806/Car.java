package tcnr16.tw.m0806;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class Car extends Activity {
	// private ScrollView mScrollView;
	private LinearLayout mLayout;
	private Button car_b001, car_b002;// 1.取消2.確定

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.car);
		getActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.vblue));
		// --------------------------------------------
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		// --------------------------------------------
		mLayout = (LinearLayout) findViewById(R.id.car_linear);
		car_b001 = (Button) findViewById(R.id.car_b001);
		car_b002 = (Button) findViewById(R.id.car_b002);
		// mScrollView = (ScrollView) findViewById(R.id.car_sc001);
		// ------------------------textview產生----------------------
		for (int i = 1; i <= (100 * Math.random() + 1); i++) {
			TextView textView = new TextView(Car.this);
			textView.setTextSize(20.0f);
			textView.setText("Text View " + i);
			LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.FILL_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);

			mLayout.addView(textView, p);
		}
		// -----------------按鈕監聽-------------------------------
		car_b001.setOnClickListener(car_b001on);
		car_b002.setOnClickListener(car_b001on);
	}

	private OnClickListener car_b001on = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.car_b001:// 取消
				break;
			case R.id.car_b002:// 確定
				break;
			}
		}
	};

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			this.finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
