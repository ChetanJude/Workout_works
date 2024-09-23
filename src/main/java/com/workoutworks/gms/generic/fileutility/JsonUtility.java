package com.workoutworks.gms.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	
	public String getDataFromJsonFile(String key) throws ParseException, FileNotFoundException, IOException {
		JSONParser parser= new JSONParser();
		Object obj = parser.parse(new FileReader(".\\testdata\\usercommondata.json"));
		JSONObject j= (JSONObject) obj;
		 String data= (String) j.get(key);
		 return data;
	}

}
