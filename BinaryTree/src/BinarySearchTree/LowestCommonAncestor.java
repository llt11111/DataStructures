package BinarySearchTree;

import Util.AbstractNode;
import Util.Node;

public class LowestCommonAncestor extends AbstractNode{

	public static void main(String[] args) {
		String s1 = new String("abc");
		String s2 = "abc";
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		Node root = getBinaryTree();
		
		Node temp = findLCA(root, 20, 25);
		System.out.println(temp.getData());
	}

	private static Node findLCA(Node root, int i, int j) {
		// TODO Auto-generated method stub
		if(root == null) return null;
		
		if(root.getData() > i && root.getData() > j){
			return findLCA(root.getLeft(), i, j);
		}
		if(root.getData() < i && root.getData() < j){
			return findLCA(root.getRight(), i, j);
		}
		return root;
		
		/*
		 * normal bs method ::
		 * if(root == null) return root;
		if(root.getData() == i || root.getData() == j) return root;
		
		Node left = findLCA(root.getLeft(), i, j);
		Node right = findLCA(root.getRight(), i, j);
		
		if(left!= null && right != null) return root;
		else return left != null ? left : right;*/
	}
}
