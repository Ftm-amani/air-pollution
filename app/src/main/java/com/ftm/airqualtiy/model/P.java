package com.ftm.airqualtiy.model;

import com.google.gson.annotations.SerializedName;

public class P{

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
			"P{" + 
			"v = '" + V + '\'' + 
			"}";
		}
}