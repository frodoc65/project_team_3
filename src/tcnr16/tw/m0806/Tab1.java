package tcnr16.tw.m0806;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Tab1 extends Activity {
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
		setupViewComponent();
	}
	private void setupViewComponent() {
		List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < image.length; i++) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("image", image[i]);
			item.put("text", imgText[i]);
			items.add(item);}	
		
		SimpleAdapter adapter = new SimpleAdapter(this,
				items, R.layout.gridview_item, new String[]{"image", "text"},
				new int[]{R.id.image, R.id.text});         
		gridView = (GridView)findViewById(R.id.tab1_gridview);
		gridView.setNumColumns(2);
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				/////////////
				int b=position;
				String mm = Integer.toString(b);
				//運用6-9 400支API傳遞函數的方法
				///////////
//				Toast.makeText(getApplicationContext(), position+"Your choice is ",
//	                        Toast.LENGTH_SHORT).show();
				switch(position){
					default:
						Intent it = new Intent();
						it.putExtra("sel", mm);
						it.setClass(Tab1.this, Tab1_2.class);
						startActivity(it);
					break;
					
	            	}
			}
		});
	}

	
}
