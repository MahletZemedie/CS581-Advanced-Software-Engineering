//Written by : Mahlet Zemedie
// A simple java program to test by creating a Jenkins job that will build and run using an Ant build file
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Test2 x = new Test2();
		

		for(int i=0; i<args.length; i++) {
			
			
			
			System.out.println("The reverse of " + args[i] + " is "  + x.reverse(args[i]));
		
		}
		
		
		

	}

}
