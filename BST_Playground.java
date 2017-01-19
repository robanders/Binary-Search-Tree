package BST_A2;

public class BST_Playground {

  public static void main(String[]args){
	  
	  
	  BST_Interface tree = new BST();
		
		System.out.println("size at beginning: " + tree.size());
		System.out.println("empty at beginning " + tree.empty());
		System.out.println("height with null root: " + tree.height());
		
		String r = new String("R");
		String o = new String("O");
		String b = new String("B");
		String e = new String("E");
		String r2 = new String("R");
		String t = new String("T");
		String d = new String("D");
		String n = new String("N");
		String x = new String("X");
		String s = new String("S");
		String p = new String("P");
		String q = new String("Q");
		String l = new String("L");
		String m = new String("M");
		String a = new String("A");
		
		System.out.println("height " + tree.height());
		
		tree.insert(n);
		tree.insert(l);
		tree.insert(r);
		tree.insert(a);
		tree.insert(m);
		tree.insert(o);
		tree.insert(x);
		tree.insert(b);

		
		//tree.insert(q);
		//tree.insert(e);
		//tree.insert(r2);
		//tree.insert(t);
		//tree.insert(s);
		
		System.out.println("size: " + tree.size());
		System.out.println("empty at end: " + tree.empty());
		
		//System.out.println("contains T " + tree.contains("B"));
		//System.out.println("contains T " + tree.contains("S"));
		//System.out.println("min " + tree.findMin());
		//System.out.println("max " + tree.findMax());
		//System.out.println("height " + tree.height());
		System.out.println(tree.remove(l));
		System.out.println("size: " + tree.size());
		
		/*System.out.println("contains N " + tree.contains(n));
		System.out.println("contains L " + tree.contains(l));
		System.out.println("contains R " + tree.contains(r));
		System.out.println("contains B " + tree.contains(a));
		System.out.println("contains M " + tree.contains(m));
		System.out.println("contains O " + tree.contains(o));
		System.out.println("contains X " + tree.contains(x));
		System.out.println("contains B " + tree.contains(b)); */
		
	}

 
 

  static void printLevelOrder(BST tree){ 
  //will print your current tree in Level-Order
    int h=tree.getRoot().getHeight();
    for(int i=0;i<=h;i++){
      printGivenLevel(tree.getRoot(), i);
    }
    
  }
  static void printGivenLevel(BST_Node root,int level){
    if(root==null)return;
    if(level==0)System.out.print(root.data+" ");
    else if(level>0){
      printGivenLevel(root.left,level-1);
      printGivenLevel(root.right,level-1);
    }
  }
}