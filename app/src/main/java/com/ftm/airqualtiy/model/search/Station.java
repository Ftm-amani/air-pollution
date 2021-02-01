package com.ftm.airqualtiy.model.search;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Station{

	@SerializedName("geo")
	private List<Double> geo;

	@SerializedName("country")
	private String country;

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

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
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
			"Station{" + 
			"geo = '" + geo + '\'' + 
			",country = '" + country + '\'' + 
			",name = '" + name + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}