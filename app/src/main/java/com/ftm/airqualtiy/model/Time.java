package com.ftm.airqualtiy.model;

import com.google.gson.annotations.SerializedName;

public class Time{

	@SerializedName("s")
	private String S;

	@SerializedName("tz")
	private String tz;

	@SerializedName("v")
	private int V;

	public void setS(String S){
		this.S = S;
	}

	public String getS(){
		return S;
	}

	public void setTz(String tz){
		this.tz = tz;
	}

	public String getTz(){
		return tz;
	}

	public void setV(int V){
		this.V = V;
	}

	public int getV(){
		return V;
	}

	@Override
 	public String toString(){
		return 
			"Time{" + 
			"s = '" + S + '\'' + 
			",tz = '" + tz + '\'' + 
			",v = '" + V + '\'' + 
			"}";
		}
}