package com.CsvReading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {

	public static void main(String[] args) {
		String line="";
		String path = System.getProperty("user.dir");
		File file= new File(path+"\\Onboarding Request Template .csv");
		try {
		BufferedReader br=new BufferedReader(new FileReader(file));
		
		while((line=br.readLine())!=null) {
			String[] data = line.split(",");
			System.out.println(data.length);
		}
		br.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
