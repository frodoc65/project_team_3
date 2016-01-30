package tcnr16.tw.m0806;

import com.navdrawer.SimpleSideDrawer;

import android.app.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.widget.TabHost.TabSpec;


//------------------主程式第一支layout為0806---------------------------------
public class M0806 extends TabActivity {
	private SimpleSideDrawer mNav;
	private Dialog mLoginDlg;	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0806);
        initActionBar();//左上小按鈕返回圖示的開關

		mNav = new SimpleSideDrawer(this);
		mNav.setLeftBehindContentView(R.layout.leftmenu);
		
        setupviewcomponent();
        
    }
	private void initActionBar() {
		  getActionBar().setDisplayHomeAsUpEnabled(true);
	      getActionBar().setHomeButtonEnabled(true);
	}
	private void setupviewcomponent() {
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
