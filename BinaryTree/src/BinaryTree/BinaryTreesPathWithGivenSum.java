package BinaryTree;

import Util.AbstractNode;
import Util.Node;

public class BinaryTreesPathWithGivenSum extends AbstractNode {
	public static void main(String[] args) {
		Node root = getBinaryTree();
		int sum = 48; 
		boolean pathExist = isPathWithGivenSumExist(root, sum);
		System.out.println(" Is Path Exist : "+ pathExist);
	}

	private static boolean isPathWithGivenSumExist(Node root, int sum) {
		// TODO Auto-generated method stub
		System.out.println("sum "+ sum);
		if(root == null) return sum == 0;
		
		int remainingSum = sum - root.getData();
		
//		if( remainingSum < 0) return false;
		System.out.println("remaining sum "+ remainingSum);
		
		return isPathWithGivenSumExist(root.getLeft(), remainingSum) ||
		isPathWithGivenSumExist(root.getRight(), remainingSum);
	}
}
