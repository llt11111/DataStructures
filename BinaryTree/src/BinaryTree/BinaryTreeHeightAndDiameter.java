package BinaryTree;

import Util.BinaryTree;
import Util.Node;

public class BinaryTreeHeightAndDiameter {
	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.getBinaryTree();
		System.out.println("Height of Binary Tree : "+ getHeight(tree.getRoot()));
		System.out.println("Diameter of BT : "+ getDiameter1(tree.getRoot(), 0));
		
		Node rootNode = BinaryTree.getRootNode();
		System.out.println("height of another binary tree :: "+ getDiameter(rootNode));
	}

	private static int getHeight(Node root) {
		// TODO Auto-generated method stub
		if(root == null) return 0;
		int lHeight = getHeight(root.getLeft());
		int rHeight = getHeight(root.getRight());
		
		return Math.max(lHeight, rHeight) + 1;

	}
	
	private static int getDiameter(Node root) {
		// TODO Auto-generated method stub
		if(root == null) return 0;
		int lHeight = getHeight(root.getLeft());
		int rHeight = getHeight(root.getRight());
		
		int lDia = getDiameter(root.getLeft());
		int rDia = getDiameter(root.getRight());
		return lHeight + rHeight +1;

	}
	private static int getDiameter1(Node root, int h) {
		// TODO Auto-generated method stub
		if(root == null) return 0;
		int lHeight = getHeight(root.getLeft());
		int rHeight = getHeight(root.getRight());
		h = Math.max(lHeight, rHeight) + 1;
		int lDia = getDiameter1(root.getLeft(), h);
		int rDia = getDiameter1(root.getRight(), h);
		
		return Math.max(lHeight + rHeight + 1 , Math.max(lDia, rDia) );

	}
}
