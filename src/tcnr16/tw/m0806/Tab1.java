package tcnr16.tw.m0806;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Tab1 extends Activity {
	private GridView gridView;
	private int[] image = { R.drawable.wow001, R.drawable.wow002,
			R.drawable.wow003, R.drawable.wow004, R.drawable.wow005,
			R.drawable.wow006 };
	private String[] imgText = { "wow001", "wow002", "wow003", "wow004",
			"wow005", "wow006" };

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
//	                Toast.makeText(getApplicationContext(), "Your choice is " + imgText[position],
//	                        Toast.LENGTH_SHORT).show();
	            	switch(position){
	            	case 0:
	            		Intent it = new Intent();
	            		it.setClass(Tab1.this, Tab1.class);
	            		startActivity(it);
	            	break;
	            	}
	            }
	        });
	}
}
