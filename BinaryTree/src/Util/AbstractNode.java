package Util;

public  class AbstractNode {
	Node root;
	
	
	public static Node getBinaryTree(){
		Node tree = new Node(20);
		tree.left = new Node(16) ;
		tree.left.left= new Node(12) ;
		tree.left.right = new Node(18) ;
		tree.left.right.right = new Node(19) ;
		tree.left.right.left = new Node(17) ;
		tree.right = new Node(25) ;
		tree.right.left= new Node(22) ;
		tree.right.right = new Node(30) ;
		return tree;
	}
}

