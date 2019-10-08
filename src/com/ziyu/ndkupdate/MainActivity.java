package com.ziyu.ndkupdate;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {
	
	static{
		System.loadLibrary("mdiff");
	}
	
	static{
		System.loadLibrary("mpatch");
	}
	
	private String oldPath;
	private String newPath;
	private String patchPath;
	//合成的apk路径
	private String installPath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		oldPath=Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"old.apk";
		newPath=Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"new.apk";
		patchPath=Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"patch.apk";
		installPath=Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"install.apk";
		
	}
	
	
	public void diff(View view){
		diffApk(oldPath, newPath, patchPath);
	}
	
	public void patch(View view){
		patchApk(oldPath, installPath, patchPath);
	}
	
	
	static native void diffApk(String oldApkPath,String newApkPath,String patchPath);
	
	static native void patchApk(String oldApkPath,String installApkPath,String patchPath);
}
