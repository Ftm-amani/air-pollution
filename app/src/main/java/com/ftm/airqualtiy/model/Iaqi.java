package com.ftm.airqualtiy.model;

import com.google.gson.annotations.SerializedName;

public class Iaqi{

	@SerializedName("p")
	private P P;

	@SerializedName("pm25")
	private Pm25 pm25;

	@SerializedName("t")
	private T T;

	@SerializedName("pm10")
	private Pm10 pm10;

	public void setP(P P){
		this.P = P;
	}

	public P getP(){
		return P;
	}

	public void setPm25(Pm25 pm25){
		this.pm25 = pm25;
	}

	public Pm25 getPm25(){
		return pm25;
	}

	public void setT(T T){
		this.T = T;
	}

	public T getT(){
		return T;
	}

	public void setPm10(Pm10 pm10){
		this.pm10 = pm10;
	}

	public Pm10 getPm10(){
		return pm10;
	}

	@Override
 	public String toString(){
		return 
			"Iaqi{" + 
			"p = '" + P + '\'' + 
			",pm25 = '" + pm25 + '\'' + 
			",t = '" + T + '\'' + 
			",pm10 = '" + pm10 + '\'' + 
			"}";
		}
}