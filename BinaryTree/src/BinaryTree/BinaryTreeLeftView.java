package BinaryTree;

import Util.BinaryTree;
import Util.Node;

public class BinaryTreeLeftView {
	static int MAX_LEVEL = 0;

	public static void main(String[] args) {

		BinaryTree tree = BinaryTree.getBinaryTree();
		printLeftView(tree.getRoot());

	}

	private static void printLeftView(Node root) {
		printLeftViewUtil(root, 1,  MAX_LEVEL);
	}

	private static void printLeftViewUtil(Node root, int level, int maxLevel) {
		// TODO Auto-generated method stub
		if(root == null ) return; 
		if(maxLevel < level){
			System.out.println(root.getData() + " level "+ level + " maxlevel "+ maxLevel);
			maxLevel = level;
		}
		
		printLeftViewUtil(root.getLeft(), level + 1, maxLevel);
		printLeftViewUtil(root.getRight(), level+ 1, maxLevel);
	}
}
