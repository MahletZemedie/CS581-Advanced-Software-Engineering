
public class JmlHomework
{

/*@ spec_public @*/ int x;
/*@ spec_public @*/ int y;
//@ public invariant x+y >= 0;
/*@ ensures \result == a ==> (a>b); 
    ensures \result == b ==>(a<b); 
*/ 
// Returns the maximum of the arguments.
public int max(int a, int b)
{
   
   if(a==b)
      return a;
   if (a > b)
      return a;
   return b;
}

// Returns the argument a but limiting its value
// to the range (-absCutoff, +absCutoff); if a is
// outside this range the return value is the closest
// endpoint of the range.
//@ requires absCutoff > 0;
/*@ ensures \result == a ==> (a>=0 && a< absCutoff) | (a<0 && a> -absCutoff);
  @ ensures \result == absCutoff ==> (a>=0 && a>= absCutoff) ;
  @ ensures \result == -absCutoff ==> (a<0 && a<= -absCutoff) ;
*/
public int limit(int a, int absCutoff)
{
   if (a >= 0) {
      if (a < absCutoff)
         return a;
      return absCutoff;
   } else {
      if (a > -absCutoff)
         return a;
      return -absCutoff;
   }
}

// No ensures, this method demonstrates how 
// invariants are checked.
// (note the requires below are only so that
//  ESC checking doesn't encounter int overflows)
//@ requires newx < 10000 && newx > -10000;
//@ requires newy < 10000 && newy > -10000;
public void update(int newx, int newy)
{
   // cannot add code here
   x = newx;  // cannot change this line
   y = newy;  // cannot change this line
   // can only add code here
	if(x<0){
		x= -1 * x;
	}

	if(y<0){

	y=-1 * y;

	}
}

// Returns true if key is in array, false otherwise.
//@ requires vals != null && vals.length > 0;
/*@ ensures \result == true ==> 
   (\exists int i; 0<=i && i<vals.length; vals[i] ==key);
   ensures \result == false==> 
   (\forall int i; 0<=i && i<vals.length; vals[i] != key);
*/
public boolean find(int vals[], int key)
{
   int i;
   i = 0;
   while (i >=0 && i<vals.length) {
      if (vals[i] == key)
         return true;
      i++;
   }
   return false;
}



// Main
public static void main(String args[])
{  JmlHomework o = new JmlHomework();
   int v;
   v = o.max(76,32);
   System.out.println("max() = "+v);
   v = o.limit(32,10);
   System.out.println("limit() = "+v);
   o.update(45,69);
   int a[] = {1,2,3,4,5};
   boolean f = o.find(a,3);
   //System.out.println("find = " + f);

}

}
