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
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;

public class splash extends Activity{
	
	@Override
	public void onCreate(Bundle savedInstanceState){
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.splash);
	    initialize();
	    LinearLayout linear = (LinearLayout)findViewById(R.id.LinearLayout1);
	    linear.setBackgroundColor(Color.parseColor("#ff0091ce"));
	}
	
	private void initialize(){
		Handler handler = new Handler(){
			@Override
			public void handleMessage(Message msg){
				finish();
				overridePendingTransition(R.anim.rightin, R.anim.rightout);
			}
		};
		handler.sendEmptyMessageDelayed(0,2000);
	}
}
