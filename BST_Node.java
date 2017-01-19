package BST_A2;

public class BST_Node {
  String data;
  BST_Node left;
  BST_Node right;
  
  BST_Node(String data){ 
	  this.data=data;
	  this.left = null;
	  this.right = null;
  }



  /*public String getData(){ return data; }
  public BST_Node getLeft(){ return left; }
  public BST_Node getRight(){ return right; } */
  
  public boolean containsNode(String s){ 
	  int compare = s.compareTo(this.data);
	  if (compare == 0){
		  //System.out.println( s + "found it ");
		  return true;  
	  } else if(compare < 0){
		  //going left
		  if(this.left == null){
			  return false;
		  } else {
			  return this.left.containsNode(s);
		  }
	  } else if (compare > 0){
		  //going right
		  if(this.right == null){
			  return false;
		  } else {
			  return this.right.containsNode(s);
		  }
	  } 
	  return false; 
  }
  
  public boolean insertNode(String s){ 
	  //3 cases
	  int compare = s.compareTo(this.data);
	  if (compare == 0){
		  //System.out.println( s + "already in tree ");
		  return false;  
	  } else if(compare < 0){
		  //going left
		  if(this.left == null){
			  BST_Node leftNode = new BST_Node(s);
			  this.left = leftNode;
			  //System.out.println(s + " insert left of " + this.data);
			  return true;
		  } else {
			  return this.left.insertNode(s);
		  }
		  
	  } else if (compare > 0){
		  //going right
		  if(this.right == null){
			  BST_Node rightNode = new BST_Node(s);
			  this.right = rightNode;
			  //System.out.println(s + " insert right of " + this.data);
			  return true;
		  } else {
			  return this.right.insertNode(s);
		  }
	  } 
	  return false;
  }
  
  public boolean removeNode(String s){
	  //'this' is parent node
	  //this.left or this.right are the removed nodes
	  int compare = s.compareTo(this.data);
	  if(compare == 0){
		  //System.out.println("this should not happen " + s + " " + this.data);
		  return false;
	  } else if (compare < 0){ //going left
		  if(this.left == null){
			  //System.out.println(s + "not found to the left of " + this.data);
			  return false;
		  } else if(s.compareTo(this.left.data) == 0){ //found node to be removed
			  System.out.println(s + " found left of  " + this.data);
			  if(this.left.left == null && this.left.right == null){ //no children
				  this.left = null;
				  //System.out.println(s + " has no children remove it.");
				  return true;
			  } else if (this.left.left != null && this.left.right == null){ //left child only
				  this.left = this.left.left;
				  //System.out.println(s + " has a left child only remove it.");
				  return true;
			  } else if (this.left.left == null && this.left.right != null){ //right child only
				  this.left = this.left.right;
				  //System.out.println(s + " has a right child only remove it.");
				  return true;
			  } else { //both children
				  //System.out.println(s + " has two children. ");
				  BST_Node minNode = new BST_Node(s);
				  minNode = this.left.right.findMin();
				  if(this.left.removeNode(minNode.data)){
					  //System.out.println("replace " + this.left.data + " with " + minNode.data);
					  this.left.data = minNode.data;
					  return true;
				  } else {
					  return false;
				  }
			  }
		  } else {
			  return this.left.removeNode(s);
		  }
	  } else if (compare > 0){ //going right
		  if(this.right == null){
			  //System.out.println(s + "not found to the right of " + this.data);
			  return false;
		  } else if(s.compareTo(this.right.data) == 0){ //found node to be removed
			  //System.out.println(s + " found right of  " + this.data);
			  if(this.right.left == null && this.right.right == null){ //no children
				  this.right = null;
				  //System.out.println(s + " has no children remove it.");
				  return true;
			  } else if (this.right.left != null && this.right.right == null){ //left child only
				  this.right = this.right.left;
				  //System.out.println(s + " has a left child only remove it.");
				  return true;
			  } else if (this.right.left == null && this.right.right != null){ //right child only
				  this.right = this.right.right;
				  //System.out.println(s + " has a right child only remove it.");
				  return true;
			  } else { //both children
				  //System.out.println(s + " has two children. ");
				  BST_Node minNode = new BST_Node(s);
				  minNode = this.right.right.findMin();
				  if(this.right.removeNode(minNode.data)){
					  //System.out.println("replace " + this.right.data + " with " + minNode.data);
					  this.right.data = minNode.data;
					  return true;
				  } else {
					  return false;
				  }
			  }
		  } else {
			  return this.right.removeNode(s);
		  }
	  }
	  
	  return false; 
  }
  
  public BST_Node findMin(){
	  if (this.left == null){
		  return this;
	  } else {
		 return this.left.findMin();
	  }
  }
  
  public BST_Node findMax(){ 
	  if(this.right == null){
		  return this;
	  } else {
		  return this.right.findMax();
	  }
  }
  public int getHeight(){
	  int leftHeight;
	  int rightHeight;
	  //height of left subtree
	  if(this.left == null){
		  leftHeight = -1;
	  } else {
		  leftHeight = this.left.getHeight();
	  }
	  //height of right subtree
	  if(this.right == null){
		  rightHeight = -1;
	  } else {
		  rightHeight = this.right.getHeight();
	  }
	  //compare subtrees
	  if(rightHeight >= leftHeight){
		  return rightHeight + 1;
	  } else {
		  return leftHeight + 1;
	  }
  }
  
  public String toString(){
    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
            +",Right: "+((this.right!=null)?right.data:"null");
  }
}