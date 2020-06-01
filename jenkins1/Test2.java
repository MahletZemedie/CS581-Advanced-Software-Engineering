//Written by : Mahlet Zemedie
// A simple java program to test by creating a Jenkins job that will build and run using an Ant build file


public class Test2 {
	
	public String reverse (String x) {
		
		
	String temp = "";	
	char[] s = x.toCharArray();
	
	for(int i= x.length()-1; i>=0; i--) {
		
		temp += s[i];
	}
		
		return  temp;
	}


}