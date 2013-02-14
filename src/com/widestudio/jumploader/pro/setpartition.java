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
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class setpartition extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setpartition);
        setTitle(R.string.title_activity_setpartition);
        final EditText kernel = (EditText) findViewById(R.id.kernel);
        final EditText recovery = (EditText) findViewById(R.id.recovery);
        final EditText efs = (EditText) findViewById(R.id.efs);
        SharedPreferences Partition = getSharedPreferences("Partition", 0);
        final Editor editor = Partition.edit();
        
        final Button kernel1 = (Button)findViewById(R.id.set1);
        kernel1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
		        String getEdit = kernel.getText().toString();
		        if(getEdit.getBytes().length <= 0){
		        	Toast.makeText(setpartition.this, "값을 입력하세요", Toast.LENGTH_SHORT).show();
		        }else{
	            	editor.putString("Kernel", kernel.getText().toString());
	                editor.commit();
	                Toast.makeText(setpartition.this,"저장완료", Toast.LENGTH_SHORT).show();
		        }
            }
        });
        
        final Button recovery1 = (Button)findViewById(R.id.set2);
        recovery1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
            	String getEdit = recovery.getText().toString();
		        if(getEdit.getBytes().length <= 0){
		        	Toast.makeText(setpartition.this, "값을 입력하세요", Toast.LENGTH_SHORT).show();
		        }else{
		        	editor.putString("Recovery", recovery.getText().toString());
		        	editor.commit();
		        	Toast.makeText(setpartition.this,"저장완료", Toast.LENGTH_SHORT).show();
		        }
            }
        });
        
        final Button efs1 = (Button)findViewById(R.id.set3);
        efs1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
            	String getEdit = efs.getText().toString();
		        if(getEdit.getBytes().length <= 0){
		        	Toast.makeText(setpartition.this, "값을 입력하세요", Toast.LENGTH_SHORT).show();
		        }else{
		        	editor.putString("EFS", efs.getText().toString());
		        	editor.commit();
		        	Toast.makeText(setpartition.this,"저장완료", Toast.LENGTH_SHORT).show();
		        }
            }
        });
        
        String KD = Partition.getString("Kernel", "");
        kernel.setText(KD);
        String RD = Partition.getString("Recovery", "");
        recovery.setText(RD);
        String ED = Partition.getString("EFS", "");
        efs.setText(ED);
	}
    @Override
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode==KeyEvent.KEYCODE_BACK){
			new AlertDialog.Builder(this)
			.setIcon(R.drawable.pat_small)
			.setTitle(R.string.title_activity_setpartition)
			.setMessage("메뉴로 돌아가시겠습니까?")
			.setPositiveButton("확인", new OnClickListener(){
				public void onClick(DialogInterface dialog, int which){
					setpartition.this.finish();
					overridePendingTransition(R.anim.rightin, R.anim.rightout);
				}
			})
			.setNegativeButton("취소", null)
			.show();
		}
		return true;
	}
}