package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class NameList {
	String fileName;
	
	private List<Name> names = new ArrayList<Name>();
	
	public NameList(String fileName, boolean firstNames) throws IOException{
		this.fileName = fileName;
		
		FileReader csvReader = new FileReader(fileName);
		BufferedReader csvBuffer = new BufferedReader(csvReader);
		
		String name;
		String gender;
		String row;
		String[] sArray;
		while((row = csvBuffer.readLine())!= null) {
			sArray = row.split(",");
			name = sArray[0];
			
			if(firstNames) {
				gender = sArray[1];
				getNames().add(new Name(name,gender));
			}
			else {
				getNames().add(new Name(name));
			}
		}
		
		csvBuffer.close();
	}

	public List<Name> getNames() {
		return names;
	}

	public void setNames(List<Name> names) {
		this.names = names;
	}
}
	
	
