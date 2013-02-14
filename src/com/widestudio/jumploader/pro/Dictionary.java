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

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Dictionary extends Activity implements OnItemClickListener{

	private String[] DicDB = {
		"1. 루팅(SU) 필수",
		"2. 파티션 설정을 합니다.",
		"3. 파티션 백업을 해두는게 좋습니다.",
        "4. 플래싱 할 이미지 선택을 클릭후 리커버리 이미지 파일을 클릭",
        "5. 커널이나 리커버리를 누르면 플래싱되며 마침",
        "6. 에러사항은 개발자 정보를 클릭한 후 Feedback으로 이메일을 전송",
	};
	
	ArrayList<String> data;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.dictionary);
	    setTitle(R.string.title_activity_Dictionary);
        
        ListView Dic = (ListView)findViewById(R.id.DicDB);
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.list, DicDB);
		Dic.setAdapter(arrayAdapter);
		Dic.setOnItemClickListener(this);
	}
	
	@Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id){
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK){
			Dictionary.this.finish();
			overridePendingTransition(R.anim.rightin, R.anim.rightout);
		}
		return true;
	}
}
