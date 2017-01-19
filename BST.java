package BST_A2;

public class BST implements BST_Interface {
	public BST_Node root;
	int size;

	public BST() {
		size = 0;
		root = null;
	}

	// used for testing, please leave as is
	public BST_Node getRoot() {
		return root;
	}

	public boolean insert(String s) {
		if (root == null){
			BST_Node newNode = new BST_Node(s);
			root = newNode;
			size = size + 1;
			//System.out.println("root created " + newNode.data);
			return true;
		} else {
			boolean success;
			success = root.insertNode(s);
			if(success == true){
				size = size + 1;
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean remove(String s) {
		if(root == null){
			return false;
		} else if(s.compareTo(root.data) == 0){
			if(root.right == null && root.left == null){
				//System.out.println("root " + root.data + " removed no children");
				root = null;
				size = 0;
				return true;
			} else if(root.left != null && root.right == null){
				//System.out.println("root " + root.data + " removed left child");
				root = root.left;
				size = size - 1;
				return true;		
			} else if(root.right != null && root.left == null){
				//System.out.println("root " + root.data + " removed right child");
				root = root.right;
				size = size - 1;
				return true;
			} else if(root.right != null && root.left != null){
				BST_Node minNode = new BST_Node(s);
				minNode = root.right.findMin();
				if(root.removeNode(minNode.data)){
					//System.out.println("replace " + root.data + " with " + minNode.data);
					root.data = minNode.data;
					size = size - 1;
					return true;
				}
			} else {
				  return false;
			  }
		} else {
			boolean success;
			success = root.removeNode(s);
			if(success == true){
				size = size - 1;
				return true;
			} else {
				return false;
			}
		}
		return false;

	}

	public String findMin() {
		if(root == null){
			return null;
		} else {
			return root.findMin().data;
		}
	}

	public String findMax() {
		if(root == null){
			return null;
		} else {
			return root.findMax().data;
		}
	}

	public boolean empty() {
		if(size == 0 || root == null){
			return true;
		} else {
			return false;
		}
	}

	public boolean contains(String s) {
		if(root == null){
			return false;
		} else {
			return root.containsNode(s);
		}
	}

	public int size() {
		return size;
	}

	public int height() {
		if(this.empty() == true){
			return -1;
		} else {
			return root.getHeight();
		}
	}

}