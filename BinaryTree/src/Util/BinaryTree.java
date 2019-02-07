package Util;


public class BinaryTree {
	Node root;

	/*      20 
	 *   16     25
	 * 12  18  22  30
	 *    17 19
	 *  
	 *  
	 *  */
	public BinaryTree() {
		// TODO Auto-generated constructor stub
	}
	
	public Node getRoot(){
		return root;
	}

	public static Node getRootNode(){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);
		root.left.right.left.right = new Node(7);
		root.left.left.left = new Node(8);
		return root;
	}
	public static BinaryTree getBinaryTree(){
		BinaryTree tree  = new BinaryTree();
		tree.root = new Node(20);
		tree.root.left = new Node(16) ;
		tree.root.left.left= new Node(12) ;
		tree.root.left.right = new Node(18) ;
		tree.root.left.right.right = new Node(19) ;
		tree.root.left.right.left = new Node(17) ;
		tree.root.right = new Node(25) ;
		tree.root.right.left= new Node(22) ;
		tree.root.right.right = new Node(30) ;

		return tree;
	}
}
