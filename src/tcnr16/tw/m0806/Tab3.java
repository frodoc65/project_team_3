package tcnr16.tw.m0806;

import java.util.*;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class Tab3 extends Activity {
	private ImageView tab3_img001;
	private TextView tab3_t001;
	private Button tab3_b001;
	
	private int[] image = { R.drawable.n001, R.drawable.n002,
			R.drawable.n003, R.drawable.n004, R.drawable.n005,
			R.drawable.n006 ,R.drawable.n007,R.drawable.n008 };
	private int[] imageMan = { R.drawable.n001, R.drawable.n002,
			R.drawable.n003, R.drawable.n004, R.drawable.n005,
			R.drawable.n006 ,R.drawable.n007,R.drawable.n008 };
	private String[] imgText = { "男性商品","女性商品","嬰幼兒商品","美妝保養",
								"生活3C","書籍雜誌","遊戲玩具","哩哩扣扣"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab3);
		getActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.vblue));
		initActionBar();
		setTitle("													Cloud Store");
		setupViewComponent();
	}

	private void setupViewComponent() {
		// TODO Auto-generated method stub
		//----------------------第3層--------------------------------
		Intent it =getIntent();
		
		String a=it.getStringExtra("sel02");	// 哪一個類別
		int b=Integer.parseInt(a);
		
		String c=it.getStringExtra("sel03");	// 哪一個商品
		int d=Integer.parseInt(c);
		// 商品圖片與名稱(暫時)
		tab3_img001 = (ImageView) findViewById(R.id.tab3_img001);
		tab3_t001 = (TextView) findViewById(R.id.tab3_t001);
		if (b == 0){ // 男性商品
			for (int i = 0; i < imageMan.length; i++){
				if (i == d){
					tab3_img001.setImageResource(imageMan[i]);
					tab3_t001.setText(imgText[b]+(i+1));
				}
			}
		}else {		// 其他
			for (int i = 0; i < image.length; i++){
				if (i == b)
					tab3_img001.setImageResource(image[i]);
				if (i == d)
					tab3_t001.setText(imgText[b]+(i+1));
			}
		}
		// -----------------按鈕監聽-------------------------------
		tab3_b001 = (Button) findViewById(R.id.tab3_b001);
		tab3_b001.setOnClickListener(tab3_b001on);
	}
	private OnClickListener tab3_b001on = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent it = new Intent();
			it.setClass(Tab3.this, Car.class);
			startActivity(it);
		}
	};
	private void initActionBar() {
		// TODO Auto-generated method stub
		getActionBar().setDisplayHomeAsUpEnabled(true);
	    getActionBar().setHomeButtonEnabled(true);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case android.R.id.home:
			 this.finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
