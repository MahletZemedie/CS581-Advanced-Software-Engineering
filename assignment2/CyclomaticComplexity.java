/**
 * Written by: Mahlet Zemedie, 800669612
 * Goal of the assignment: The goal of this assignment is to create a control flow graph of each method in a class,
 *  and print out the instructions in the method annotated with the basic block they are in. 
 *  I have used the asm-7.3.1.jar, asm-tree-7.3.1.jar and asm-all-6.1_AlPHA.jar files.
 **
 * Purpose of this class :
 * This class will print the Cyclomatic Complexity along with edge and node. 
 * 
 * reference : https://asm.ow2.io/asm4-guide.pdf
 * 
 */

import java.util.HashSet;
import java.util.Set;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.analysis.Analyzer;
import org.objectweb.asm.tree.analysis.AnalyzerException;
import org.objectweb.asm.tree.analysis.BasicInterpreter;
import org.objectweb.asm.tree.analysis.Frame;

public class CyclomaticComplexity {
	
	public class Node extends Frame {
		Set< Node> successors = new HashSet<Node>();

	    public Node(int nLocals, int nStack) {
	        super(nLocals, nStack);
	    }

	    public Node(Frame src) {
	        super(src);
	    }
	}
	
	
	public CyclomaticComplexity () {}
	
	
	Analyzer a = new Analyzer(new BasicInterpreter()) {
        protected Frame newFrame(int nLocals, int nStack) {
            return new Node(nLocals, nStack);
        }

        protected Frame newFrame(Frame src) {
            return new Node(src);
        }

        @Override
        protected void newControlFlowEdge(int src, int dst) {
            Node s = (Node) getFrames()[src];
            Node d = (Node) getFrames()[dst];
            s.successors.add(d);

            
        }


    };
    
   /**
    * Method to print number of nodes, edges and CyclomaticComplexity
    * @param owner
    * @param mn
    * @throws AnalyzerException
    */
   public void printSucc(String owner, MethodNode mn ) throws AnalyzerException {
   
    a.analyze(owner, mn);

    Frame[] frames = a.getFrames();
    int edges = 0;
    int nodes = 0;
    for (int i = 0; i < frames.length; ++i) {

     if (frames[i] != null) {
        	edges += ((Node) frames[i]).successors.size();
        	nodes += 1;

        }
    
    }
    
    System.out.println("Edges " + edges);
    System.out.println("nodes " + nodes);
    System.out.println("CC: " + (edges - nodes + 2));
    
   }

}

