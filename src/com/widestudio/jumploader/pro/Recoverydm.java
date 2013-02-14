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

//import jsm.JSpiner.JSpiner_parser.*;
import android.app.Activity;
import android.os.Bundle;
import android.os.Build;
import android.view.KeyEvent;
import android.widget.TextView;

public class Recoverydm extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState){
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.recoverydm);
	    setTitle(R.string.title_activity_recoverydm);
		TextView device = (TextView) findViewById(R.id.device);
		String name = "기기명 : " + Build.MODEL + " / API : " + Build.VERSION.SDK_INT;
		device.setText(name);
		TextView DB = (TextView)findViewById(R.id.textView1);
		DB.setText("온라인 리커버리 이미지 준비중입니다.");
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK){
			Recoverydm.this.finish();
			overridePendingTransition(R.anim.rightin, R.anim.rightout);
		}
		return true;
	}
}