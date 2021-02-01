package com.ftm.airqualtiy.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("iaqi")
	private Iaqi iaqi;

	@SerializedName("debug")
	private Debug debug;

	@SerializedName("city")
	private City city;

	@SerializedName("aqi")
	private int aqi;

	@SerializedName("time")
	private Time time;

	@SerializedName("idx")
	private int idx;

	@SerializedName("attributions")
	private List<AttributionsItem> attributions;

	@SerializedName("dominentpol")
	private String dominentpol;

	public void setIaqi(Iaqi iaqi){
		this.iaqi = iaqi;
	}

	public Iaqi getIaqi(){
		return iaqi;
	}

	public void setDebug(Debug debug){
		this.debug = debug;
	}

	public Debug getDebug(){
		return debug;
	}

	public void setCity(City city){
		this.city = city;
	}

	public City getCity(){
		return city;
	}

	public void setAqi(int aqi){
		this.aqi = aqi;
	}

	public int getAqi(){
		return aqi;
	}

	public void setTime(Time time){
		this.time = time;
	}

	public Time getTime(){
		return time;
	}

	public void setIdx(int idx){
		this.idx = idx;
	}

	public int getIdx(){
		return idx;
	}

	public void setAttributions(List<AttributionsItem> attributions){
		this.attributions = attributions;
	}

	public List<AttributionsItem> getAttributions(){
		return attributions;
	}

	public void setDominentpol(String dominentpol){
		this.dominentpol = dominentpol;
	}

	public String getDominentpol(){
		return dominentpol;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"iaqi = '" + iaqi + '\'' + 
			",debug = '" + debug + '\'' + 
			",city = '" + city + '\'' + 
			",aqi = '" + aqi + '\'' + 
			",time = '" + time + '\'' + 
			",idx = '" + idx + '\'' + 
			",attributions = '" + attributions + '\'' + 
			",dominentpol = '" + dominentpol + '\'' + 
			"}";
		}
}