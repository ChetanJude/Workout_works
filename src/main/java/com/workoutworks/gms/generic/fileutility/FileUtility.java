package com.workoutworks.gms.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String getDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis= new FileInputStream(".\\testdata\\commondata.properties");
		Properties p= new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
	}

}
