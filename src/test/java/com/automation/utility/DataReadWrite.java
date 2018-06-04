package com.automation.utility;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public class DataReadWrite {
	
	static String path = "./src/test/resources/testdata/InputData.data";
	/*public static boolean createDataFile() throws IOException{
		BufferedWriter bw = null;
		FileWriter fw = null;
		boolean result = false;
		try{
		File file = new File("InputData.data");
		if(file.exists()){
			file.delete();
		}
		file.createNewFile();
		fw = new FileWriter(file.getAbsoluteFile(), true);
		bw = new BufferedWriter(fw);
			
		bw.close();
		result = true;
		}catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (bw != null) {
				bw.close();
				fw.close();
			}

		}
		return result;
	}*/
	
	
	public static boolean writeDataToFile(String Property, String Data) {
		PrintWriter pw = null;
		boolean result = false;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
			pw.println(Property + "=" + Data);
			
			result = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}

		}
		return result;
	}
	
	public static void main(String arr[]) throws IOException{
		//DataReadWrite.createDataFile();
		DataReadWrite.writeDataToFile("Id", "1000");
		System.out.println(getData("id"));
	}
	
	public static String getData(String Property) throws IOException {
		 
		 Properties prop = new Properties();
		 
		 FileReader  r = new FileReader(path);
		 
		 prop.load(r);
		 
		 String value = (prop.getProperty("Id"));
		 return value;
	}

}
