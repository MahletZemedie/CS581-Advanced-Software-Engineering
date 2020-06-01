
/**
 * Written by: Mahlet Zemedie, 800669612
 * Purpose : count the number of unique locations in a class that each data field is accessed at by using ASM Library
 * The program below print each object data field with the name and the number of reads and writes (getfield/putfield), 
 * and the total sum of reads and writes. 
 * A final line prints "TOTAL" which is the total number of reads, writes, and all accesses for all data fields. 
 * I have used a LinkedHashMAp to store each objects data field that matches with its getstatic, putstatic, getfield, and putfield 
 * To achieve the goal of this program, I extend the ClassVisitor class (visitMethod() and visitField()) and 
 * the methodVisitor class (visitFieldInsn() ) 
 * reference :- web.cs.ucla.edu/~msb/cs239-tutorial/
 */


import java.util.Arrays;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;

public class ASMFiledAcessCounter{
	
	 //Create LinkedHashMap to store for each object data fields name corresponds to read/write when each data field is accessed 
	public static LinkedHashMap<String, List<Integer>> map = new LinkedHashMap<String, List<Integer>>();
	/**
	 * main method to takes .class file and display filed names/reads/writes
	 * 
	 */
	public static void main(String[] args) throws IOException {
		
		//scanner accept input .class file
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a class name");
        String str = input.nextLine();
       ASMFiledAcessCounter asm = new ASMFiledAcessCounter(str);
        asm.PrintEncounters();
      //System.out.println(map.entrySet());
       input.close(); 
	}
	
	/**
	 * Initialize Constructor with class and read 
	 * @param  Class Name
	 */
	public ASMFiledAcessCounter(String name)  {
		//we need to inject the class to the constructor so that we can be able to read the .class file	
		try {
			
			FileInputStream is = new FileInputStream(name); //byte code reader
			ClassReader cr = new ClassReader(is); //creates a ClassReader to parse runnable class 
	        cr.accept(cv, 0); //parse the runnable byte code and calls the corresponding classVisistor methods 
		
		   }catch(Exception e){   
            System.out.println(e);
        }
	}
/**
 * iterate through the LinkedHashMap and print the field names/reads/writes encountered
 * 
 */
    public void PrintEncounters( ) {   
    	//declare variables to store/read/writes
    	int totalGetFields=0; //reads
		int totalPutFileds=0; //writes
	
	for (Map.Entry<String, List<Integer>> entry: map.entrySet()) {
	//get reads and writes
		 int getField = entry.getValue().get(0) + entry.getValue().get(2);
		 int PutField = entry.getValue().get(1) + entry.getValue().get(3);
		 int totalAcess = getField+PutField;
		    //sum up additional reads/writes
			totalGetFields+= getField;
			totalPutFileds+=PutField;
		 //print each filednames/read/write/sum
		 System.out.printf("%s%s%d%s%d%s%d", entry.getKey(), "        " , getField , "     " , PutField , "     " , totalAcess);
		 System.out.println();
	 }
	    	//printing out the grand sum
			int Total = totalGetFields+totalPutFileds;
			System.out.printf("%s%d%s%d%s%d", "TOTAL    " , totalGetFields, "    ", totalPutFileds , "    " , Total );
				
	}
	ClassVisitor cv= new ClassVisitor(Opcodes.ASM7) {
		/**
    	 *  Initialize the fields when it is counted 
    	 *  Counter to zeros
    	 *  @param access,name,desc,signature,value
    	 */
        @Override
		public FieldVisitor visitField  (final int access, final String name, final String desc, final String signature, final Object value) {
            map.put(name, Arrays.asList(0,0,0,0));
          return super.visitField(access, name, desc, signature, value);
        } 
        /**
         * 
         * return an object of MethodVisitor 
         * @param access,name,desc,signature,exceptions
         */
        @Override
        public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
        
        	 return new MethodVisitor(Opcodes.ASM7, super.visitMethod(access, name, desc, signature, exceptions)) {
        		 /*
        		  * check if map contains filed names then update the map with reads/writes
        		  * @param opcode,owner,filedName,filedDesc
        		  */
            	 @Override
            	public void visitFieldInsn(int opcode, String owner, String fieldName, String fieldDesc) {
            		//System.out.println(opcode);
            		 //System.out.println("Get " + Opcodes.GETSTATIC);
            		 if (map.containsKey(fieldName)) {
            			 //update map values with reads/writes
            			 map.get(fieldName).set(opcode - Opcodes.GETSTATIC, (map.get(fieldName).get(opcode - Opcodes.GETSTATIC))+1);
            			
            		 	}
            		 
            		 super.visitFieldInsn(opcode, owner, fieldName, fieldDesc);
                	return;
                }//end method
            };//end
        }//end MV method 

};//end CV
	
	}//end class