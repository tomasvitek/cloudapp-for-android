/**
 * AddBookmarkThread
 *
 * Thread for calling CloudApp's API to add a new bookmark
 *
 * @copyright   Copyright (c) 2013 Tomas Vitek
 * @author      Tomas Vitek
 */

package com.tomasvitek.android.cloudapp.threads;

import com.cloudapp.api.CloudApp;
import com.cloudapp.api.CloudAppException;
import com.cloudapp.api.model.CloudAppItem;
import com.tomasvitek.android.cloudapp.CloudAppApplication;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

public class AddBookmarkThread implements Runnable {

protected Context context;
	
protected String title, url;

Activity activity;

	public AddBookmarkThread(Context context, Activity activity, String title, String url) {
		this.context = context;
		this.activity = activity;
		this.title = title;
		this.url = url;
	}	
	
	@Override
	public void run() {
		 CloudApp api = ((CloudAppApplication) activity.getApplication()).getCloudAppApi();

	        // Add a new bookmark
	        try {
				@SuppressWarnings("unused")
				CloudAppItem bookmark = api.createBookmark(this.title, this.url);
			} catch (CloudAppException e) {
				// TODO Auto-generated catch block
				Log.e("CloudApp", e.toString());
			}
		
	}

}
