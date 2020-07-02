package model;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Name {
	private String name;
	String gender;
	boolean isFirstName;
	
	private HashMap<String,Integer> charCount = new HashMap<String,Integer>();
	
	public Name(String name) {
		this.setName(name.toLowerCase().replaceAll("\\s+",""));
		this.isFirstName = false;
		
		makeCharMap();
		
	}
	
	public Name(String name, String gender) {
		this.setName(name.toLowerCase().replaceAll("\\s+",""));
		this.isFirstName = true;
		this.gender = gender;
		
		makeCharMap();
		
	}
	
	private void makeCharMap() {
		for(String c: getName().split("")) {
			int cVal;
			if(getCharCount().putIfAbsent(c, 1) != null) {
				cVal = getCharCount().get(c);
				getCharCount().put(c,cVal+1);
			}
		}
	}
	
	public HashMap<String,Integer> subtract(HashMap<String,Integer> subCharCount) {
		HashMap<String,Integer> diffMap = new HashMap<String,Integer>();
		
		// check if subtracting hash map has a key that local map does not
		for(String k: subCharCount.keySet()) {
			if(!this.charCount.containsKey(k)) {
				return null;
			}
		}
		
		String tmpKey;
		int tmpVal;
		for(Map.Entry<String, Integer> set: this.charCount.entrySet()) {
			tmpKey = set.getKey();
			if(subCharCount.containsKey(tmpKey)) {
				tmpVal = set.getValue()- subCharCount.get(tmpKey) ;
				
				if(tmpVal > 0) {
					diffMap.put(tmpKey,tmpVal);
				}
				else if(tmpVal < 0) {
					return null;
				}
			}
			else {
				diffMap.put(tmpKey,set.getValue());
			}
		}
		return diffMap;
	}

	public HashMap<String,Integer> getCharCount() {
		return charCount;
	}

	public void setCharCount(HashMap<String,Integer> charCount) {
		this.charCount = charCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/*
	private void setHistogram() {
		int index;
		for(char c : name.toCharArray()) {
			index = ((int) c)-97;
			charHistogram[index] += 1;
		}
	}
	
	public String sort(String str) {
		char[] temp = str.toCharArray();
		Arrays.sort(temp);
		
		return new String(temp);
	}
	*/
}
