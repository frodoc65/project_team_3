package tcnr16.tw.m0806;

import java.util.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.widget.TabHost.TabSpec;

public class Tab2 extends Activity {
	private GridView gridView2;
	private TextView tab_t001;
	private int[] image = { R.drawable.n001, R.drawable.n002,
			R.drawable.n003, R.drawable.n004, R.drawable.n005,
			R.drawable.n006 ,R.drawable.n007,R.drawable.n008 };
	private int[] imageMan = { R.drawable.n001, R.drawable.n002,
			R.drawable.n003, R.drawable.n004, R.drawable.n005,
			R.drawable.n006 ,R.drawable.n007,R.drawable.n008};
	private String[] imgText = { "男性商品","女性商品","嬰幼兒商品","美妝保養",
								"生活3C","書籍雜誌","遊戲玩具","哩哩扣扣"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab1);
		getActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.vblue));
		 initActionBar();
		setupViewComponent();
	}
	private void setupViewComponent() {
		tab_t001 = (TextView)findViewById(R.id.tab1_t001);
		tab_t001.setText("商品瀏覽");
		setTitle("													Cloud Store");
		//----------------------第2層--------------------------------
		Intent it =getIntent();
		final String a=it.getStringExtra("sel");
		int b=Integer.parseInt(a);
		//收到傳來的值  知道哪一個類別.再放入item.put中間///
//			Toast.makeText(getApplicationContext(), "Your choice is " + b,
//        Toast.LENGTH_SHORT).show();
		List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
		if (b == 0){	//如果是男性商品
			for (int i = 0; i < imageMan.length; i++) {
				Map<String, Object> item = new HashMap<String, Object>();
				item.put("image", imageMan[i]);
				item.put("text", imgText[b]+(i+1));
				items.add(item);}	
		}else{
			for (int i = 0; i < image.length; i++) {
				Map<String, Object> item = new HashMap<String, Object>();
				item.put("image", image[b]);
				item.put("text", imgText[b]+(i+1));
				items.add(item);}	
		}
		SimpleAdapter adapter = new SimpleAdapter(this,
				items, R.layout.gridview_item, new String[]{"image", "text"},
				new int[]{R.id.image, R.id.text}); 
	        
		gridView2 = (GridView)findViewById(R.id.tab1_gridview);
		gridView2.setNumColumns(2);
		gridView2.setAdapter(adapter);
		gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub	
				String mm = Integer.toString(position);
				switch (position) {
					default:
						Intent it = new Intent();
						it.putExtra("sel02", a);	// 哪一個類別
						it.putExtra("sel03", mm);	// 哪一個商品
						it.setClass(Tab2.this, Tab3.class);
						startActivity(it);
						break;
				}
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
