package tcnr16.tw.m0806;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.navdrawer.SimpleSideDrawer;

import android.app.*;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.*;
import android.view.View.*;
import android.widget.*;

//------------------主程式第一支layout為0806---------------------------------
public class M0806 extends Activity {
	private SimpleSideDrawer mNav;
	private Dialog mLoginDlg;
	private Function function;
	// --------------側邊按鈕宣告--------------------------------------------
	private Button side_b001, side_b002, side_b003, side_b004, side_b005,
			side_b006;
	// --------------滑動-------------------------------------------------
	// private float x1,x2,y1,y2,xc,yc;
	// private float xr=90,yr=160;
	// --------------------gridview---------------------------------------
	private GridView gridView;
	private int[] image = { R.drawable.n001, R.drawable.n002, R.drawable.n003,
			R.drawable.n004, R.drawable.n005, R.drawable.n006, R.drawable.n007,
			R.drawable.n008 };
	private String[] imgText = { "男性商品", "女性商品", "嬰幼兒商品", "美妝保養", "生活3C",
			"書籍雜誌", "遊戲玩具", "哩哩扣扣" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab1);
		initActionBar();// 左上小按鈕返回圖示的開關
		setTitle("CloudStore");

		mNav = new SimpleSideDrawer(this);
		mNav.setLeftBehindContentView(R.layout.leftmenu);
		getActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.vblue));

		setupviewcomponent();

	}

	private void initActionBar() {
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		
	}

	public void setupviewcomponent() {
		// -----------------主頁----------------------------------------
		List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < image.length; i++) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("image", image[i]);
			item.put("text", imgText[i]);
			items.add(item);
		}

		SimpleAdapter adapter = new SimpleAdapter(this, items,
				R.layout.gridview_item, new String[] { "image", "text" },
				new int[] { R.id.image, R.id.text });
		gridView = (GridView) findViewById(R.id.tab1_gridview);
		gridView.setNumColumns(2);
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// ///////////
				int b = position;
				String mm = Integer.toString(b);
				// 運用6-9 400支API傳遞函數的方法
				// /////////
				// Toast.makeText(getApplicationContext(),
				// position+"Your choice is ",
				// Toast.LENGTH_SHORT).show();
				switch (position) {
				default:
					Intent it = new Intent();
					it.putExtra("sel", mm);
					it.setClass(M0806.this, Tab1_2.class);
					startActivity(it);
					break;

				}
			}
		});
		// -----------------側邊按鈕宣告-----------------------------------------
		side_b001 = (Button) findViewById(R.id.side_b001);
		side_b002 = (Button) findViewById(R.id.side_b002);
		side_b003 = (Button) findViewById(R.id.side_b003);
		side_b004 = (Button) findViewById(R.id.side_b004);
		side_b005 = (Button) findViewById(R.id.side_b005);
		side_b006 = (Button) findViewById(R.id.side_b006);
		side_b001.setOnClickListener(side_b001on);
		side_b002.setOnClickListener(side_b001on);
		side_b003.setOnClickListener(side_b001on);
		side_b004.setOnClickListener(side_b001on);
		side_b005.setOnClickListener(side_b001on);
		side_b006.setOnClickListener(side_b001on);
	}

	// ----------------------------側邊欄按鈕監聽-----------------------------------
	private OnClickListener side_b001on = new OnClickListener() {
		Intent it = new Intent();

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.side_b001:// 瀏覽商品
				Toast.makeText(M0806.this, "已經在本頁了喔!!!!", Toast.LENGTH_SHORT)
						.show();
				break;
			case R.id.side_b002:// 賣東西
				it.setClass(M0806.this, Sell.class);
				startActivity(it);
				break;
			case R.id.side_b003:// 搜尋商品
				it.setClass(M0806.this, Search.class);
				startActivity(it);
				break;
			case R.id.side_b004:// 朋友
				Uri uri = Uri.parse("http://www.facebook.com");
				it = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(it);
				break;
			case R.id.side_b005:// 買賣狀態
				it.setClass(M0806.this, Car.class);
				startActivity(it);
				break;
			case R.id.side_b006:// 結帳
				it.setClass(M0806.this, Car.class);
				startActivity(it);
				break;

			}
		}
	};

	// @Override
	// public boolean onTouchEvent(MotionEvent event) {
	// if(event.getAction() == MotionEvent.ACTION_DOWN){
	// //action_down手指按下
	// x1=event.getX();
	// y1=event.getY();
	// }
	// if(event.getAction() == MotionEvent.ACTION_UP){
	// //action_up手指離開時
	// x2=event.getX();
	// y2=event.getY();
	// xc=x2-x1;
	// yc=y2-y1;
	// if(xc > xr) ctlnext();//右
	// if(xc < -xr) ctlprev();//左
	// }
	// return super.onTouchEvent(event);
	// }
	// public void ctlprev() {//左
	//
	// }
	// private void ctlnext() {//右
	//
	// }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.m0806, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:// 側邊欄按鈕
			mNav.toggleLeftDrawer();
			break;
		case R.id.item1:// 註冊(畫面未完成lay還需增加)
			mLoginDlg = new Dialog(M0806.this);
			mLoginDlg.setTitle("登入系統");
			mLoginDlg.setCancelable(true);
			mLoginDlg.setContentView(R.layout.signin);
			mLoginDlg.show();
			break;
		case R.id.item2:// 登入(sqlite配套未完成)
			mLoginDlg = new Dialog(M0806.this);
			mLoginDlg.setTitle("登入系統");
			mLoginDlg.setCancelable(true);
			mLoginDlg.setContentView(R.layout.signin);
			mLoginDlg.show();
			break;
		}

		return super.onOptionsItemSelected(item);
	}
}
