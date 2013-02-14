/*
 * Copyright 2013 WideStudio
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.widestudio.jumploader.pro;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class WSimpormation extends Activity implements OnItemClickListener{
	private String[] StringDB = {
		"Wide Studio팀은 안드로이드 관련 ROM 및 Application을 제작/개발 하는 팀입니다.",
		"팀장 & 개발자 : WS dongho(강동호)",
		"디자이너 : Piece(강호진)",
		"점프로더 프로 사용법",
		"Version : RC 2.1",
		"FeedBack",};
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState){
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.wsimpormation);
	    setTitle(R.string.title_activity_WSimpormation);
		
	    ListView AppDB = (ListView)findViewById(R.id.AppDB);
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.list, StringDB);
		AppDB.setAdapter(arrayAdapter);
		AppDB.setOnItemClickListener(this);
	}
        
    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id){
    	if(position==0){
    		
    	}else if(position==1){
    		Toast toast = Toast.makeText(WSimpormation.this, "카카오톡ID : ka1273", Toast.LENGTH_SHORT);
			toast.show();
    	}else if(position==2){
    		Toast toast = Toast.makeText(WSimpormation.this, "카카오톡ID : ghojin", Toast.LENGTH_SHORT);
			toast.show();
    	}else if(position==3){
    		Intent intent = new Intent(WSimpormation.this, Dictionary.class);
            startActivity(intent);
            overridePendingTransition(R.anim.leftin, R.anim.leftout);
    	}else if(position==4){
    		
    	}else if(position==5){
    		Uri uri = Uri.parse("mailto:gongdongho12@gmail.com");
    		Intent it = new Intent(Intent.ACTION_SENDTO, uri);
    		startActivity(it);
            overridePendingTransition(R.anim.leftin, R.anim.leftout);
    	}
	}
    @Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK){
			WSimpormation.this.finish();
			overridePendingTransition(R.anim.rightin, R.anim.rightout);
		}
		return true;
	}
}