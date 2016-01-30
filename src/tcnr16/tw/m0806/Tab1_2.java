package tcnr16.tw.m0806;

import java.util.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.widget.TabHost.TabSpec;

public class Tab1_2 extends Activity {
	private GridView gridView;
	private int[] image = { R.drawable.n001, R.drawable.n002,
			R.drawable.n003, R.drawable.n004, R.drawable.n005,
			R.drawable.n006 ,R.drawable.n007,R.drawable.n008 };
	private String[] imgText = { "男性商品","女性商品","嬰幼兒商品","美妝保養",
								"生活3C","書籍雜誌","遊戲玩具","哩哩扣扣"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab1);
		 initActionBar();
		setupViewComponent();
	}
	private void setupViewComponent() {
		
		//----------------------第2層--------------------------------
		 Intent it =getIntent();
		String a=it.getStringExtra("sel");
		int b=Integer.parseInt(a);
		//收到傳來的值  知道哪一個類別.再放入item.put中間///
//			Toast.makeText(getApplicationContext(), "Your choice is " + b,
//        Toast.LENGTH_SHORT).show();
		List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < image.length; i++) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("image", image[b]);
			item.put("text", imgText[b]+(i+1));
			items.add(item);}	
		
		SimpleAdapter adapter = new SimpleAdapter(this,
				items, R.layout.gridview_item, new String[]{"image", "text"},
				new int[]{R.id.image, R.id.text}); 
	        
		gridView = (GridView)findViewById(R.id.tab1_gridview);
		gridView.setNumColumns(2);
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
			public void onItemClick1(AdapterView<?> parent, View view, int position, long id) {
				switch(position){
					default:
//						Intent it = new Intent();
//						it.setClass(Tab2.this, Tab2.class);
//						startActivity(it);
					break;		
	            	}
			}
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub				
			}
		});
	}
	private void initActionBar() {
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
