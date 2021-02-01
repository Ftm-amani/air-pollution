package com.ftm.airqualtiy.model;

import com.google.gson.annotations.SerializedName;

public class Debug{

	@SerializedName("sync")
	private String sync;

	public void setSync(String sync){
		this.sync = sync;
	}

	public String getSync(){
		return sync;
	}

	@Override
 	public String toString(){
		return 
			"Debug{" + 
			"sync = '" + sync + '\'' + 
			"}";
		}
}