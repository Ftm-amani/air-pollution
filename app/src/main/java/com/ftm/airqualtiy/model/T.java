package com.ftm.airqualtiy.model;

import com.google.gson.annotations.SerializedName;

public class T{

	@SerializedName("v")
	private double V;

	public void setV(double V){
		this.V = V;
	}

	public double getV(){
		return V;
	}

	@Override
 	public String toString(){
		return 
			"T{" + 
			"v = '" + V + '\'' + 
			"}";
		}
}