/**
 * Written by: Mahlet Zemedie, 800669612
 * Goal of the assignment :The goal of this assignment is to create a control flow graph of each method in a class,
 *  and print out the instructions in the method annotated with the basic block they are in. 
 *   I have used the asm-7.3.1.jar, asm-tree-7.3.1.jar and asm-all-6.1_AlPHA.jar files.
 **
 * purpose of this class: 
 *  This class will print out the OP codes with each block number they are in. 
 * 
 * 
 * reference : https://asm.ow2.io/asm4-guide.pdf
 * 
 */



import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.analysis.AnalyzerException;
import org.objectweb.asm.util.Printer;


public class BasicBlock {

	// list to store Opcodes
	
	public ArrayList<String>  Opcode;
	
	public BasicBlock () {
		this.Opcode = new ArrayList<String>();
	}
	
	/**
	 * Method to print opcode and block numbers 
	 * @param mn 
	 * @param Blocknbr
	 */
	
	public void Printopcode (MethodNode mn, int Blocknbr ) {
		  
	       for (AbstractInsnNode in:  mn.instructions.toArray()) {
		    	if (in.getOpcode() >= 0) {
		    		Opcode.add(Printer.OPCODES[in.getOpcode()]);
		    	}
		    	}
		   
		    for (String s: Opcode) {
		    	System.out.println(Blocknbr + " : " +  s.toLowerCase());
			    }
     }
	
	
	public static void main(String args []) throws IOException, AnalyzerException {
		
		// Main method 
		
		//scanner accept input as .class file
		
	    Scanner input = new Scanner(System.in);
	    System.out.println("Please enter class name");
	    String s = input.nextLine();
	    
		
	    FileInputStream in = new FileInputStream(s);
		ClassReader classReader = new ClassReader(in);
		ClassNode classNode = new ClassNode();
		classReader.accept(classNode, 0);
      
        // iterate through each Method.  
		
		Iterator<MethodNode> itr = classNode.methods.iterator();
		int Blocknbr = 0;   
		while (itr.hasNext()) {
		++Blocknbr;   
		MethodNode mn = itr.next();
		
	    System.out.print("==> Analyzing Method: " + mn.name + "\n");
	     
	     // print opcodes and blocknbr
	    
	    BasicBlock bb = new BasicBlock();
	    bb.Printopcode(mn,Blocknbr);
	     
	     // print cc
	    CyclomaticComplexity cc = new CyclomaticComplexity();
	    cc.printSucc(classNode.name, mn);
	     
	    input.close();
	}
	

}
	
}