package tcnr16.tw.m0806;


import com.navdrawer.SimpleSideDrawer;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Sell extends Activity {
	private SimpleSideDrawer mNav;
	private Dialog mLoginDlg;	
	private Button side_b001,side_b002,side_b003,side_b004;
	private Function function;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sell);
		initActionBar();//左上小按鈕返回圖示的開關

		mNav = new SimpleSideDrawer(this);
		mNav.setLeftBehindContentView(R.layout.leftmenu);
		setupviewcomponent();
	}
	private void setupviewcomponent() {
		//-----------------側邊按鈕宣告-----------------------------------------
    	side_b001 = (Button)findViewById(R.id.side_b001);
    	side_b002 = (Button)findViewById(R.id.side_b002);
    	side_b003 = (Button)findViewById(R.id.side_b003);
    	side_b004 = (Button)findViewById(R.id.side_b004);
    	side_b001.setOnClickListener(side_b001on);
    	side_b002.setOnClickListener(side_b001on);
    	side_b003.setOnClickListener(side_b001on);
    	side_b004.setOnClickListener(side_b001on);
		
	}
	//----------------------------側邊欄按鈕監聽-----------------------------------
		private OnClickListener side_b001on = new OnClickListener(){
			Intent it = new Intent();
			@Override
			public void onClick(View v) {
				switch(v.getId()){
				case R.id.side_b001://瀏覽商品
					it.setClass(Sell.this, M0806.class);
					startActivity(it);
					break;
				case R.id.side_b002://賣東西
					Toast.makeText(Sell.this, "已經在本頁了喔!!!!", Toast.LENGTH_SHORT).show();
					break;
				case R.id.side_b003://搜尋商品
					break;
				case R.id.side_b004://朋友
					break;
				}
			}
		};
	public void initActionBar() {
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
        	mLoginDlg = new Dialog( Sell.this);
			mLoginDlg.setTitle("登入系統");
			mLoginDlg.setCancelable(true);
			mLoginDlg.setContentView(R.layout.signin);
			mLoginDlg.show();
        	break;
        case R.id.item2://登入(sqlite配套未完成)
        	mLoginDlg = new Dialog( Sell.this);
			mLoginDlg.setTitle("登入系統");
			mLoginDlg.setCancelable(true);
			mLoginDlg.setContentView(R.layout.signin);
			mLoginDlg.show();
        	break;
        }
		return super.onOptionsItemSelected(item);
	}
	
}
