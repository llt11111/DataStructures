package Util;

public class BTTest extends AbstractNode{
	public static void main(String[] args) {
		Node root = getBinaryTree();
		int h = height(root);
		System.out.println("height of bt  : "+ h);
	}

	private static int height(Node root) {
		// TODO Auto-generated method stub
		if(root  == null) return 0;
		int lHeight = height(root.getLeft());
		int rHeight = height(root.getRight());
		return 1 + Math.max(lHeight, rHeight);
		
		
	}
}
