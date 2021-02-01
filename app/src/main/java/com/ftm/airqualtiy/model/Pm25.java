package com.ftm.airqualtiy.model;

import com.google.gson.annotations.SerializedName;

public class Pm25{

	@SerializedName("v")
	private int V;

	public void setV(int V){
		this.V = V;
	}

	public int getV(){
		return V;
	}

	@Override
 	public String toString(){
		return 
			"Pm25{" + 
			"v = '" + V + '\'' + 
			"}";
		}
}