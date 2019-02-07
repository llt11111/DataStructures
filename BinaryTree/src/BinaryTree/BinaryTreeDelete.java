package BinaryTree;

import Util.BinaryTree;
import Util.Node;

public class BinaryTreeDelete {
	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.getBinaryTree();
		Node root = deleteTree(tree.getRoot());
		System.out.println("Is tree deleted : "+ (root == null));
	}

	private static Node deleteTree(Node root) {
		// TODO Auto-generated method stub
		if(root == null) return null;
		deleteTree(root.getLeft());
		deleteTree(root.getRight());
		return null;
	}
}
