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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;


public class Shopping extends ListActivity {
	private SimpleSideDrawer mNav;
	private Dialog mLoginDlg;
	//-------------------------------------------
	private ArrayList<String> recSet; 
	List<Map<String, Object>> mList;
	private Button side_b001, side_b002, side_b003, side_b004, side_b005,
	side_b005_1, side_b005_2, side_b006;
	private int[] image = { R.drawable.phoo, R.drawable.phoo,
			R.drawable.phoo, R.drawable.phoo, R.drawable.phoo,
			R.drawable.phoo ,R.drawable.phoo,R.drawable.phoo };
	private String[] Text = { "男性商品店名","女性商品店名","嬰幼兒商品店名","美妝保養店名",
								"生活3C店名","書籍雜誌店名","遊戲玩具店名","哩哩扣扣店名"};
	private String[] shop002 = { "1","2","2","4","3","5","7","9"};
	private String[] shop004 = { "已出貨","未出貨","以下架","已出貨","已出貨","未出貨","已售完","已售完"};
	private String[] shop003 = { "20","30","50","80","100","50","35","15"};
//	private String[] date = { "20","30","50","80","1000","5000","350","1500"};//日期

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.transaction);
		mNav = new SimpleSideDrawer(this);
		mNav.setLeftBehindContentView(R.layout.leftmenu);

		getActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.drawable.vblue));
		setupView();
		initActionBar();
		
	}

	private void initActionBar() {
			  getActionBar().setDisplayHomeAsUpEnabled(true);
		      getActionBar().setHomeButtonEnabled(true);
	}

	private void setupView() {
		// TODO Auto-generated method stub
		side_b001 = (Button) findViewById(R.id.side_b001);
		side_b002 = (Button) findViewById(R.id.side_b002);
		side_b003 = (Button) findViewById(R.id.side_b003);
		side_b004 = (Button) findViewById(R.id.side_b004);
		side_b005 = (Button) findViewById(R.id.side_b005);
		side_b005_1 = (Button) findViewById(R.id.side_b005_1);
		side_b005_2 = (Button) findViewById(R.id.side_b005_2);
		side_b006 = (Button) findViewById(R.id.side_b006);
		// ------------------------------------------------
		side_b001.setOnClickListener(side_b001on);
		side_b002.setOnClickListener(side_b001on);
		side_b003.setOnClickListener(side_b001on);
		side_b004.setOnClickListener(side_b001on);
		side_b005.setOnClickListener(side_b001on);
		side_b005_1.setOnClickListener(side_b001on);
		side_b005_2.setOnClickListener(side_b001on);
		side_b006.setOnClickListener(side_b001on);
		// --------------------------------------------------
		side_b005_1.setVisibility(View.GONE);
		side_b005_2.setVisibility(View.GONE);
		
		mList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < image.length; i++) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("image", image[i]);
			item.put("text", Text[i]);
			item.put("shop002", shop002[i]);
			item.put("shop003", shop003[i]);
			item.put("shop004", shop004[i]);
			mList.add(item);}	
		
		SimpleAdapter adapter = new SimpleAdapter(this,
				mList, R.layout.transaction_list, new String[]{"image", "text","shop002","shop003","shop004"},
				new int[]{R.id.imageView1, R.id.shop001,R.id.shop002,R.id.shop003,R.id.shop004}); 

		  setListAdapter(adapter);
	}
	// ----------------------------側邊欄按鈕監聽-----------------------------------
		private OnClickListener side_b001on = new OnClickListener() {
			Intent it = new Intent();

			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.side_b001:// 瀏覽商品
					it.setClass(Shopping.this, M0806.class);
					startActivity(it);
					break;
				case R.id.side_b002:// 賣東西
					it.setClass(Shopping.this, Sell.class);
					startActivity(it);
					break;
				case R.id.side_b003:// 搜尋商品
					it.setClass(Shopping.this, Search.class);
					startActivity(it);
					break;
				case R.id.side_b004:// 朋友
					Uri uri = Uri.parse("http://www.facebook.com");
					it = new Intent(Intent.ACTION_VIEW, uri);
					startActivity(it);
					break;
				case R.id.side_b005:// 買賣狀態
					side_b005_1.setVisibility(View.VISIBLE);
					side_b005_2.setVisibility(View.VISIBLE);
					break;
				case R.id.side_b005_1:
					it.setClass(Shopping.this, Shopping.class);
					startActivity(it);
					break;
				case R.id.side_b005_2:
					it.setClass(Shopping.this, order1.class);
					startActivity(it);
					break;
				case R.id.side_b006:// 結帳
					it.setClass(Shopping.this, Car.class);
					startActivity(it);
					break;
				}
			}
		};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.m0806, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:// 側邊欄按鈕
			mNav.toggleLeftDrawer();
			side_b005_1.setVisibility(View.GONE);
			side_b005_2.setVisibility(View.GONE);
			break;
		case R.id.item1:// 註冊(畫面未完成lay還需增加)
			mLoginDlg = new Dialog(Shopping.this);
			mLoginDlg.setTitle("登入系統");
			mLoginDlg.setCancelable(true);
			mLoginDlg.setContentView(R.layout.signin);
			mLoginDlg.show();
			break;
		case R.id.item2:// 登入(sqlite配套未完成)
			mLoginDlg = new Dialog(Shopping.this);
			mLoginDlg.setTitle("登入系統");
			mLoginDlg.setCancelable(true);
			mLoginDlg.setContentView(R.layout.signin);
			mLoginDlg.show();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
