package com.luki;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader {
	private static String hard = "hard.json";
	private static String middle = "middle.json";
	private static String simple = "simple.json";
	
	public static JSONReader getInstance(){
		return new JSONReader();
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException{
		JSONReader.getInstance().readSimple();
		JSONReader.getInstance().readMiddle();
		JSONReader.getInstance().readHard();
	}
	
	public void readSimple() throws FileNotFoundException, IOException, ParseException{
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader(simple));
		JSONObject jsonObj = (JSONObject)obj;
		
		// print out data
		String nama = (String)jsonObj.get("nama");
		String gender = jsonObj.get("gender").toString();
		long status = (Long)jsonObj.get("status");
		
		System.out.println("nama : " + nama);
		System.out.println("gender : " + gender);
		System.out.println("status : " + String.valueOf(status));
	}
	
	public void readMiddle() throws FileNotFoundException, IOException, ParseException{
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader(middle));
		JSONObject jsonObj = (JSONObject)obj;
		
		// print out data
		String nama = (String)jsonObj.get("nama");
		
		JSONArray array = (JSONArray)jsonObj.get("alamat");
		String jalan = array.get(0).toString();
		String nomor = array.get(1).toString();
		String kelurahan = array.get(2).toString();
		
		System.out.println("nama : " + nama);
		System.out.println("Jalan : " + jalan);
		System.out.println("nomor : " + nomor);
		System.out.println("kelurahan : " + kelurahan);
	}
	
	public void readHard() throws FileNotFoundException, IOException, ParseException{
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader(hard));
		JSONObject jsonObj = (JSONObject)obj;

		// print out data
		String nama = (String)jsonObj.get("nama");
		
		JSONArray alamat = (JSONArray)jsonObj.get("alamat");
		Map alamatMap = (HashMap<String, Object>)alamat.get(0);
		
		String jalan = alamatMap.get("jalan").toString();
		String no = alamatMap.get("no").toString();
		String kota = alamatMap.get("kota").toString();
		
		System.out.println("nama : " + nama);
		System.out.println("jalan : " + jalan);
		System.out.println("no : " + no);
		System.out.println("kota : " + kota);
	}
}
