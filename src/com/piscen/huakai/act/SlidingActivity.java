/*
 * Copyright (C) 2012 yueyueniao
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
package com.piscen.huakai.act;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;

import com.piscen.huakai.R;
import com.piscen.huakai.http.HttpHandler;
import com.piscen.huakai.http.HttpRequest;
import com.piscen.huakai.view.SlidingMenu;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;


public class SlidingActivity extends BaseActivity {
	SlidingMenu mSlidingMenu;
	LeftFragment leftFragment;
	RightFragment rightFragment;
	MainAct viewPageFragment;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.main);
		init();
	}
//	private void test(){
//		List<NameValuePair> list = new ArrayList<NameValuePair>();
//		new HttpRequest(FdqueryHandler).post("http://metro2.sinaapp.com/VdsController/vdsInterface", list,null);	
//	}
//		private Handler FdqueryHandler = new HttpHandler(this){
//			protected void succeed(String response) {
//				System.out.println("response"+response);
//			};
//			protected void failed(String response) {
//				System.out.println("response"+response);
//			};
//		};
	private void init() {
		mSlidingMenu = (SlidingMenu) findViewById(R.id.slidingMenu);
		mSlidingMenu.setLeftView(getLayoutInflater().inflate(
				R.layout.left_frame, null));
		mSlidingMenu.setRightView(getLayoutInflater().inflate(
				R.layout.right_frame, null));
		mSlidingMenu.setCenterView(getLayoutInflater().inflate(
				R.layout.center_frame, null));

		FragmentTransaction t = this.getSupportFragmentManager()
				.beginTransaction();
		leftFragment = new LeftFragment();
		t.replace(R.id.left_frame, leftFragment);

		rightFragment = new RightFragment();
		t.replace(R.id.right_frame, rightFragment);

		viewPageFragment = new MainAct();
		t.replace(R.id.center_frame, viewPageFragment);
		t.commit();
	}


	public void showLeft() {
		mSlidingMenu.showLeftView();
	}

	public void showRight() {
		mSlidingMenu.showRightView();
	}

}
