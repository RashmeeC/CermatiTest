package com.testapps.frameworkConstants;

public class FrameworkConstants {
	
	private FrameworkConstants() {
	}
	private static final int EXPLICITWAIT = 30;
	private static final String URL = "https://www.cermati.com/app/gabung";

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getUrl(){
		return URL;
	}

	
}



