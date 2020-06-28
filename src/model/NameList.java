package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NameList {
	String fileName;
	String[] names;
	
	public NameList(String fileName) throws IOException{
		this.fileName = fileName;
		
		FileReader csvReader = new FileReader(fileName);
		BufferedReader csvBuffer = new BufferedReader(csvReader);
		
		String row;
		while((row = csvBuffer.readLine())!= null) {
			System.out.println(row);
		}
		
		csvBuffer.close();
	}
}
	
	
