package BinaryTree;

import Util.AbstractNode;
import Util.Node;

public class BinaryTreeLowestCommonAncestor extends AbstractNode{
	public static void main(String[] args) {
		Node root = getBinaryTree();
		
		Node temp = findLCA(root, 20, 25);
		System.out.println(temp.getData());
	}

	private static Node findLCA(Node root, int i, int j) {
		// TODO Auto-generated method stub
		if(root == null) return root;
		if(root.getData() == i || root.getData() == j) return root;
		
		Node left = findLCA(root.getLeft(), i, j);
		Node right = findLCA(root.getRight(), i, j);
		
		if(left!= null && right != null) return root;
		else return left != null ? left : right;
	}
}
