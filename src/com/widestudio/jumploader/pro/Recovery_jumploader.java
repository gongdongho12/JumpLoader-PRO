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
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Recovery_jumploader extends Activity{
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		startActivity(new Intent(this, splash.class));
		setTitle(R.string.app_name);
		setContentView(R.layout.recovery_jumploader);
		try{
			Runtime.getRuntime().exec("su");
			Toast.makeText(Recovery_jumploader.this,"루팅된 디바이스 입니다.", Toast.LENGTH_SHORT).show();
		}catch(Exception e){
			Toast.makeText(Recovery_jumploader.this,"이 어플을 사용하려면 루팅이 필요합니다.", Toast.LENGTH_SHORT).show();
		}
		
        final ImageButton imageButton1 = (ImageButton)findViewById(R.id.imageButton1);
        imageButton1.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
                Intent intent = new Intent(Recovery_jumploader.this, setpartition.class);
                startActivity(intent);
                overridePendingTransition(R.anim.leftin, R.anim.leftout);
            }
        });
        
        final ImageButton imageButton2 = (ImageButton)findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
                Intent intent1 = new Intent(Recovery_jumploader.this, Backupimg.class);
                startActivity(intent1);
                overridePendingTransition(R.anim.leftin, R.anim.leftout);
            }
        });
		
		final ImageButton imageButton3 = (ImageButton)findViewById(R.id.imageButton3);
		imageButton3.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
            	new AlertDialog.Builder(Recovery_jumploader.this)
    			.setIcon(R.drawable.recovery_boot_small)
    			.setTitle("리커버리 부팅")
    			.setMessage("리커버리로 부팅하시겠습니까?")
    			.setPositiveButton("확인", new DialogInterface.OnClickListener(){
    				public void onClick(DialogInterface dialog, int which){
    					try{
    						try{
    			        		String[] recovery ={"su","-c","reboot recovery"};
    			        		Runtime.getRuntime().exec(recovery);
    			        		}catch(Exception a){
    			        			a.printStackTrace();
    			        		}
    					}catch(Exception e){
    						Toast.makeText(Recovery_jumploader.this,"이 기능을 사용하려면 루팅이 필요합니다.", Toast.LENGTH_SHORT).show();
    					}
    				}
    			})
    			.setNegativeButton("취소", null)
    			.show();
            }
        });
		
		ImageButton imageButton4 = (ImageButton)findViewById(R.id.imageButton4);
		imageButton4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent2 = new Intent(Recovery_jumploader.this, Set_image.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.leftin, R.anim.leftout);
            }
        });
		
		ImageButton imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
		imageButton5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
            	new AlertDialog.Builder(Recovery_jumploader.this)
    			.setIcon(R.drawable.reboot_small)
    			.setTitle("재부팅")
    			.setMessage("재부팅하시겠습니까?")
    			.setPositiveButton("확인", new DialogInterface.OnClickListener(){
    				public void onClick(DialogInterface dialog, int which){
    					try{
    						try{
    		            		Process proc = Runtime.getRuntime().exec(new String[] { "su", "-c", "reboot" });
    		                    proc.waitFor();
    		            		}catch (Exception b){
    		            			b.printStackTrace();
    		            		}
    					}catch(Exception e){
    						Toast.makeText(Recovery_jumploader.this,"이 기능을 사용하려면 루팅이 필요합니다.", Toast.LENGTH_SHORT).show();
    					}
    				}
    			})
    			.setNegativeButton("취소", null)
    			.show();
            }
        });
		
		ImageButton imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
		imageButton6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
            	Intent intent3 = new Intent(Recovery_jumploader.this, Recoverydm.class);
                startActivity(intent3);
                overridePendingTransition(R.anim.leftin, R.anim.leftout);
            }
        });
		
		ImageButton imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
		imageButton7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
            	Intent intent4 = new Intent(Recovery_jumploader.this, WSimpormation.class);
                startActivity(intent4);
                overridePendingTransition(R.anim.leftin, R.anim.leftout);
            }
        });
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK){
			new AlertDialog.Builder(this)
			.setIcon(R.drawable.jumploaderpro_small)
			.setTitle(R.string.app_name)
			.setMessage("종료하시겠습니까?")
			.setPositiveButton("종료", new OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Recovery_jumploader.this.finish();
				}
			})
			.setNegativeButton("취소", null)
			.show();
		}
		return true;
	}
}