package tcnr16.tw.m0806;
import com.navdrawer.SimpleSideDrawer;

import android.app.*;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

public class Search extends Activity {
	private SimpleSideDrawer mNav;
	private Button side_b005_1,side_b005_2;
	private Dialog mLoginDlg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		getActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.vblue));
		mNav = new SimpleSideDrawer(this);
		mNav.setLeftBehindContentView(R.layout.leftmenu);
		initActionBar();
        setupviewcomponent();
	}
	private void setupviewcomponent() {
		// TODO Auto-generated method stub
		for(int i=1;i<7;i++){
			String idname = "side_b0"+String.format("%02d", i);
			int resId = getResources().getIdentifier(idname, "id", getPackageName());
			Button btn = ((Button)findViewById(resId));
			btn.setOnClickListener(side_b001on);
			
		}
		side_b005_1 = (Button) findViewById(R.id.side_b005_1);
		side_b005_2 = (Button) findViewById(R.id.side_b005_2);
		// ------------------------------------------------
		side_b005_1.setOnClickListener(side_b001on);
		side_b005_2.setOnClickListener(side_b001on);
		// --------------------------------------------------
		side_b005_1.setVisibility(View.GONE);
		side_b005_2.setVisibility(View.GONE);
	}
	private OnClickListener side_b001on = new OnClickListener(){
		Intent it = new Intent();
		int count=0;
		@Override
		public void onClick(View v) {
			switch(v.getId()){
			case R.id.side_b001://瀏覽商品
				it.setClass(Search.this, Tab1.class);
				startActivity(it);
				break;
			case R.id.side_b002://賣東西
				it.setClass(Search.this, Sell.class);
				startActivity(it);
				break;
			case R.id.side_b003://搜尋商品
				Toast.makeText(Search.this, "已經在本頁了喔!!!!", Toast.LENGTH_SHORT).show();
				break;
			case R.id.side_b004://朋友
				Uri uri = Uri.parse("http://www.facebook.com");
				it = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(it);
				break;
			case R.id.side_b005:// 買賣狀態
				if (count == 1) {
					side_b005_1.setVisibility(View.GONE);
					side_b005_2.setVisibility(View.GONE);
					count = 0;
				} else {
					side_b005_1.setVisibility(View.VISIBLE);
					side_b005_2.setVisibility(View.VISIBLE);
					count = 1;
				}
				break;
			case R.id.side_b005_1:
				it.setClass(Search.this, Shopping.class);
				startActivity(it);
				break;
			case R.id.side_b005_2:
				it.setClass(Search.this, order1.class);
				startActivity(it);
				break;
			case R.id.side_b006:// 結帳
				it.setClass(Search.this, Car.class);
				startActivity(it);
				break;
			}
		}
	};
	private void initActionBar() {
		  getActionBar().setDisplayHomeAsUpEnabled(true);
	      getActionBar().setHomeButtonEnabled(true);
	      }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.m0806, menu);
        return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
        case android.R.id.home://側邊欄按鈕
    		mNav.toggleLeftDrawer();
        	break;
        case R.id.item1://註冊(畫面未完成lay還需增加)
        	mLoginDlg = new Dialog( Search.this);
			mLoginDlg.setTitle("登入系統");
			mLoginDlg.setCancelable(true);
			mLoginDlg.setContentView(R.layout.signin);
			mLoginDlg.show();
        	break;
        case R.id.item2://登入(sqlite配套未完成)
        	mLoginDlg = new Dialog( Search.this);
			mLoginDlg.setTitle("登入系統");
			mLoginDlg.setCancelable(true);
			mLoginDlg.setContentView(R.layout.signin);
			mLoginDlg.show();
        	break;
		}
		return super.onOptionsItemSelected(item);
	}
}
