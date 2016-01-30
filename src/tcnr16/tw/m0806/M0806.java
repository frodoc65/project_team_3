package tcnr16.tw.m0806;

import com.navdrawer.SimpleSideDrawer;

import android.app.*;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.widget.TabHost.TabSpec;


//------------------主程式第一支layout為0806---------------------------------
public class M0806 extends TabActivity {
	private SimpleSideDrawer mNav;
	private Dialog mLoginDlg;	
	private Function function;
	//--------------側邊按鈕宣告--------------------------------------------
	private Button side_b001,side_b002,side_b003,side_b004;
	//--------------滑動-------------------------------------------------
	private float x1,x2,y1,y2,xc,yc;
	private float xr=90,yr=160;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0806);
        initActionBar();//左上小按鈕返回圖示的開關
        setTitle("CloudStore");

		mNav = new SimpleSideDrawer(this);
		mNav.setLeftBehindContentView(R.layout.leftmenu);
		
        setupviewcomponent();
        
    }
	private void initActionBar() {
		  getActionBar().setDisplayHomeAsUpEnabled(true);
	      getActionBar().setHomeButtonEnabled(true);
	     
	}
	public void setupviewcomponent() {
		//---------------tab的標頭於此宣告和添加和改名(第一層)------------------
		//---------------tab1-----------------------------------------
		TabHost tabHost = getTabHost();
		Intent it = new Intent();
		it.setClass(M0806.this, Tab1.class);
    	TabSpec spec=tabHost.newTabSpec("tab1");
    	spec.setContent(it);
    	spec.setIndicator("最新消息",
    			getResources().getDrawable(android.R.drawable.ic_lock_idle_alarm));
    	tabHost.addTab(spec);
    	//---------------tab2-------------------------------------------
    	it = new Intent();
		it.setClass(M0806.this, Tab2.class);
    	spec=tabHost.newTabSpec("tab2");
    	spec.setIndicator("熱門商品",
    			getResources().getDrawable(android.R.drawable.ic_dialog_alert));
    	spec.setContent(it);
    	tabHost.addTab(spec); 	
    	tabHost.setCurrentTab(0);
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
				Toast.makeText(M0806.this, "已經在本頁了喔!!!!", Toast.LENGTH_SHORT).show();
				break;
			case R.id.side_b002://賣東西
				it.setClass(M0806.this, Sell.class);
				startActivity(it);
				break;
			case R.id.side_b003://搜尋商品
				it.setClass(M0806.this, Search.class);
				startActivity(it);
				break;
			case R.id.side_b004://朋友
				Uri uri = Uri.parse("http://www.facebook.com");
				it = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(it);
				break;
			}
		}
	};
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if(event.getAction() == MotionEvent.ACTION_DOWN){
			//action_down手指按下
			x1=event.getX();
			y1=event.getY();
		}
		if(event.getAction() == MotionEvent.ACTION_UP){
			//action_up手指離開時
			x2=event.getX();
			y2=event.getY();
			xc=x2-x1;
			yc=y2-y1;
			if(xc >   xr)    ctlnext();//右
			if(xc < -xr)    ctlprev();//左
		}
		return super.onTouchEvent(event);
	}
	public void ctlprev() {//左
		
	}
	private void ctlnext() {//右
		
	}
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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
        	mLoginDlg = new Dialog( M0806.this);
			mLoginDlg.setTitle("登入系統");
			mLoginDlg.setCancelable(true);
			mLoginDlg.setContentView(R.layout.signin);
			mLoginDlg.show();
        	break;
        case R.id.item2://登入(sqlite配套未完成)
        	mLoginDlg = new Dialog( M0806.this);
			mLoginDlg.setTitle("登入系統");
			mLoginDlg.setCancelable(true);
			mLoginDlg.setContentView(R.layout.signin);
			mLoginDlg.show();
        	break;
        }
        
        return super.onOptionsItemSelected(item);
    }
}
