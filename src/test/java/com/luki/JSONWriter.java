package com.luki;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONWriter {
	// singleton pattern :P  biar ga perlu bikin objek banyak
	public static JSONWriter getInstance(){
		return new JSONWriter();
	}
	
	public static void main(String[] args){
		JSONWriter.getInstance().writeSimple();
		JSONWriter.getInstance().writeMiddle();
		JSONWriter.getInstance().writeHard();
	}
	
	public void writeSimple(){
		JSONObject obj = new JSONObject();
		obj.put("nama", "luki");
		obj.put("alamat", "depok");
		obj.put("gender", "M");
		obj.put("status", new Integer(1));
		
		try{
			FileWriter file = new FileWriter("simple.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();
			
			System.out.println("Simple JSON created");
		}
		catch(IOException ie){
			ie.printStackTrace();
		}
	}
	
	public void writeMiddle(){
		JSONObject obj = new JSONObject();
		obj.put("nama", "luki");
		
		// create list to store array-like in json
		JSONArray array = new JSONArray();
		array.add("Jl pepaya 1");
		array.add("no. 75");
		array.add("Pancoranmas, Depok");
		
		obj.put("alamat", array);
		
		try{
			FileWriter file = new FileWriter("middle.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();
			
			System.out.println("Middle JSON created");
		}
		catch(IOException ie){
			ie.printStackTrace();
		}
	}
	
	public void writeHard(){
		JSONObject obj = new JSONObject();
		obj.put("nama", "luki");
		
		// associative arrays
		Map<String, Object> alamatMap = new HashMap<String, Object>();
		alamatMap.put("jalan", "cisanggiri 2");
		alamatMap.put("no", new Integer(22));
		alamatMap.put("kota", "jakarta");
		
		JSONArray alamat = new JSONArray();
		alamat.add(alamatMap);
		obj.put("alamat", alamat);
		
		try{
			FileWriter file = new FileWriter("hard.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();
			
			System.out.println("Hard JSON created");
		}
		catch(IOException ie){
			ie.printStackTrace();
		}
	}
}