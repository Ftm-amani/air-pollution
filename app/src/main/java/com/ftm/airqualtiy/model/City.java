package com.ftm.airqualtiy.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class City{

	@SerializedName("geo")
	private List<Double> geo;

	@SerializedName("name")
	private String name;

	@SerializedName("url")
	private String url;

	public void setGeo(List<Double> geo){
		this.geo = geo;
	}

	public List<Double> getGeo(){
		return geo;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"City{" + 
			"geo = '" + geo + '\'' + 
			",name = '" + name + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}