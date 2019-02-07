/*generate bt from given preorder having property 
 * that all node have 0 or 2 child*/
package BinaryTree;

import Util.Node;

public class BinaryTreeSpatialProperty {
	public static void main(String[] args) {
		String pre = "10100";  //lLlLL
		Node root = generateBinaryTree(pre, 0);
		
//		print(root);
	}

	private static void print(Node root) {
		// TODO Auto-generated method stub
		if(root == null) return ;
		else{
			print(root.getLeft());
			System.out.print(" "+ (root.getData() -'0'));
			print(root.getRight());
		}
	}

	private static Node generateBinaryTree(String pre, int index) {
		// TODO Auto-generated method stub
		if(index >= pre.length()) return null;
		Node temp = new Node(pre.charAt(index));
		System.out.println("processing "+ temp.getData());
		if(pre.charAt(index) == 0) return temp;
		index++;
		temp.setLeft(generateBinaryTree(pre, index));
		index++;
		temp.setRight(generateBinaryTree(pre, index));
		
		return temp;
	}
}
