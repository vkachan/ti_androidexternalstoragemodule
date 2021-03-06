/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package dk.mikkendigital.mkdfs;

import java.io.File;
import java.util.Map;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;

import android.os.Environment;

import android.content.Context;


@Kroll.module(name="Mkdfs", id="dk.mikkendigital.mkdfs")
public class MkdfsModule extends KrollModule
{

	// Standard Debugging variables
	private static final String LCAT = "MkdfsModule";
	private static final boolean DBG = TiConfig.LOGD;
	
	//State info
	private static TiApplication m_app; 

	// You can define constants with @Kroll.constant, for example:
	// @Kroll.constant public static final String EXTERNAL_NAME = value;
	
	public MkdfsModule()
	{
		super();
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app)
	{
		// put module init code that needs to run when the application is created
		Log.d(LCAT, "inside onAppCreate");
		m_app = app;
	}
	
	// Methods
	@Kroll.method
	@Kroll.getProperty
	public String getTestString() 
	{
		return "victor";
	}

	@Kroll.method
	@Kroll.getProperty
	public String getExternalStorageDirectory() 
	{
		File f = Environment.getExternalStorageDirectory();
		if (!f.exists())
			f.mkdirs();
		return f.getAbsolutePath();
	}

	@Kroll.method
	@Kroll.getProperty
	public String getExternalFilesDir() 
	{
		File f = m_app.getExternalFilesDir(null);
		if (!f.exists())
			f.mkdirs();
		return f.getAbsolutePath();
	}	

	@Kroll.method
	@Kroll.getProperty
	public String getPackageName() 
	{
		return m_app.getPackageName();
	}
	
	@Kroll.method
	@Kroll.getProperty
	public String[] getExternalFilesDirs() 
	{
		File[] f = m_app.getExternalFilesDirs(null);
		String[] dirs = new String[f.length];  
		for (int i = 0; i < f.length; i ++) {
			if (!f[i].exists())
				f[i].mkdirs();
			dirs[i] = f[i].getAbsolutePath();
		}
		return dirs;
	}	
}

