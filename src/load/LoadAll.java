package load;

import java.io.IOException;
import java.util.HashMap;

import model.NameList;
import model.Name;

public class LoadAll {

	public static void main(String[] args) throws IOException {
		//FileReader csvReader = new FileReader("SSA_Names_DB.csv");
		
		// Generate data to look for anagrams in 
		String SSA_Names = "src/load/SSA_Names_DB.csv";
		String Common_Surnames = "src/load/Common_Surnames_Census_2000.csv";
		
		NameList firstNames = new NameList(SSA_Names, true); 
		NameList lastNames = new NameList(Common_Surnames, true); 
		
		System.out.println("Loaded in data");
		
		Name anagram = new Name("emmasmith");
		
		HashMap<String,Integer> tmpCharCount = new HashMap<String,Integer>();
		int index = 0;
		int len = firstNames.getNames().size();
		
		System.out.println("Checking " + len + " first names");
		
		for(Name fn: firstNames.getNames()) {
			for(Name ln: lastNames.getNames()) {
				tmpCharCount = anagram.subtract(fn.getCharCount());
				if(tmpCharCount != null && tmpCharCount.equals(ln.getCharCount())) {
					System.out.println(fn.getName() + ln.getName());
				}
			}
			index ++;
			
			if(index%9000 == 0) {
				System.out.println("Checked "+ (double) (index/len)*100 + "% of first names");
			}
		}
		System.out.println("end");
		
	}

}
