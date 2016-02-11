package tcnr16.tw.m0806;


import java.util.*;

import com.navdrawer.SimpleSideDrawer;

import android.app.*;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

public class order1 extends ListActivity {
	private SimpleSideDrawer mNav;
	private Dialog mLoginDlg;	
	private Button side_b005_1, side_b005_2;
	private Function function;
	
	 private ArrayList<String> recSet;
	 String msg = null;
	private TextView sab_title; 
	List<Map<String, Object>> mList;
	
	
	
	private int[] image = { R.drawable.n001, R.drawable.n002,
			R.drawable.n003, R.drawable.n004, R.drawable.n005,
			R.drawable.n006 ,R.drawable.n007,R.drawable.n008 };
	private String[] imgText = { "男性商品店名","女性商品店名","嬰幼兒商品店名","美妝保養店名",
								"生活3C店名","書籍雜誌店名","遊戲玩具店名","哩哩扣扣店名"};
	private String[] seller = { "章1宜","章2宜","章3宜","章4宜",
			"章5宜","章6宜","章7宜","章8宜"};
	private String[] number = { "1","1","1","1","1","1","1","1"};
	private String[] price = { "20","30","50","80","1000","5000","350","1500"};
	private String[] date = { "20","30","50","80","1000","5000","350","1500"};//日期
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.transaction);
		initActionBar();//左上小按鈕返回圖示的開關
		getActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.drawable.vblue));
		setTitle("													Cloud Store");
		mNav = new SimpleSideDrawer(this);
		mNav.setLeftBehindContentView(R.layout.leftmenu);
		setupviewcomponent();
	}
	private void setupviewcomponent() {
		//-----------------側邊按鈕宣告-----------------------------------------
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
    	//--------------列表title-------------------------------------
    	sab_title = (TextView)findViewById(R.id.sab_title);
    	sab_title.setText("購物列表");
    	//--------------列表宣告----------------------------------
  	  mList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < image.length; i++) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("image", image[i]);
			item.put("text", imgText[i]);
			item.put("number", number[i]);
			item.put("price", price[i]);
			item.put("seller", seller[i]);
			mList.add(item);}	
		
		SimpleAdapter adapter = new SimpleAdapter(this,
				mList, R.layout.transaction_list, new String[]{"image", "text","number","price","seller"},
				new int[]{R.id.imageView1, R.id.shop001,R.id.shop002,R.id.shop003,R.id.shop004}); 
		  
		  setListAdapter(adapter);
		  
		  ListView listview = getListView();
		  listview.setTextFilterEnabled(true);
		  listview.setOnItemClickListener(listviewOnItemClkLis);
		
	}
		//------------------------------列表監聽--------------------------
	 AdapterView.OnItemClickListener listviewOnItemClkLis = new AdapterView.OnItemClickListener() {
		  public void onItemClick(AdapterView<?> parent, View view, int position,
		    long id) {
		  }
		 };
	
	


		//----------------------------側邊欄按鈕監聽-----------------------------------
		// ----------------------------側邊欄按鈕監聽-----------------------------------
			private OnClickListener side_b001on = new OnClickListener() {
				Intent it = new Intent();
				int count=0;
				@Override
				public void onClick(View v) {
					switch (v.getId()) {
					case R.id.side_b001:// 瀏覽商品
						it.setClass(order1.this, Tab1.class);
						startActivity(it);
						break;
					case R.id.side_b002:// 賣東西
						it.setClass(order1.this, Sell.class);
						startActivity(it);
						break;
					case R.id.side_b003:// 搜尋商品
						it.setClass(order1.this, Search.class);
						startActivity(it);
						break;
					case R.id.side_b004:// 朋友
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
						it.setClass(order1.this, Shopping.class);
						startActivity(it);
						break;
					case R.id.side_b005_2:
						it.setClass(order1.this, order1.class);
						startActivity(it);
						break;
					case R.id.side_b006:// 結帳
						it.setClass(order1.this, Car.class);
						startActivity(it);
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
    		side_b005_1.setVisibility(View.GONE);
			side_b005_2.setVisibility(View.GONE);
        	break;
        case R.id.item1://註冊(畫面未完成lay還需增加)
        	mLoginDlg = new Dialog( order1.this);
			mLoginDlg.setTitle("登入系統");
			mLoginDlg.setCancelable(true);
			mLoginDlg.setContentView(R.layout.signin);
			mLoginDlg.show();
        	break;
        case R.id.item2://登入(sqlite配套未完成)
        	mLoginDlg = new Dialog( order1.this);
			mLoginDlg.setTitle("登入系統");
			mLoginDlg.setCancelable(true);
			mLoginDlg.setContentView(R.layout.signin);
			mLoginDlg.show();
        	break;
        }
		return super.onOptionsItemSelected(item);
	}
	
}
