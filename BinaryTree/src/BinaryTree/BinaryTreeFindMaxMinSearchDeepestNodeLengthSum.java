package BinaryTree;

import java.util.LinkedList;

import Util.BinaryTree;
import Util.Node;

public class BinaryTreeFindMaxMinSearchDeepestNodeLengthSum {
	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.getBinaryTree();
		System.out.println("Finding 16 recursive : "+ findRecursive(tree.getRoot(), 16));
		System.out.println("Finding 15 Iterative : "+ findIterative(tree.getRoot(), 15));

		System.out.println("Sum of all binary Tree :" + getSum(tree.getRoot()));
		System.out.println( "Max data in binary Tree : " + getMax(tree.getRoot()));
		System.out.println( "Min data in binary Tree : " + getMin(tree.getRoot()));
		System.out.println("Deepest Node in binary Tree : " + getDeepestNode(tree.getRoot()));
	}



	private static int getDeepestNode(Node root) {
		// TODO Auto-generated method stub
		if(root == null) return  0;

		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);
		Node temp = null;
		while(!queue.isEmpty()){
			temp = queue.removeFirst();

			if(temp.getLeft() != null) queue.addLast(temp.getLeft());
			if(temp.getRight() != null) queue.addLast(temp.getRight());

		}
		return temp.getData();
	}



	private static int getMax(Node root) {
		// TODO Auto-generated method stub
		if(root == null) return Integer.MIN_VALUE;
		int max = root.getData();
		int lMax = getMax(root.getLeft());
		int rMax = getMax(root.getRight());
		max = max > (lMax > rMax ? lMax : rMax) ? max : (lMax > rMax ? lMax : rMax);

		return max;
	}
	private static int getMin(Node root) {
		// TODO Auto-generated method stub
		if(root == null) return Integer.MAX_VALUE;

		int lMin = getMin(root.getLeft());
		int rMin = getMin(root.getRight());

		if(lMin < rMin ){
			int min = lMin < root.getData() ? lMin : root.getData() ;
			return min;
		}else {
			int min = rMin < root.getData() ? rMin : root.getData();
			return min;
		}

	}

	private static int getSum(Node root) {
		// TODO Auto-generated method stub
		if(root == null) return 0; 
		return getSum(root.getLeft()) + getSum(root.getRight()) + root.getData();

	}

	private static boolean findIterative(Node root, int data) {
		// TODO Auto-generated method stub
		if(root == null) return false;
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);
		while(!queue.isEmpty()){
			Node temp = queue.removeFirst();
			if(temp.getData() == data){
				return true;
			}else{
				if(temp.getLeft() != null) queue.addLast(temp.getLeft());
				if(temp.getRight() != null) queue.addLast(temp.getRight());
			}
		}
		return false;

	}

	private static boolean findRecursive(Node root, int data) {
		// TODO Auto-generated method stub
		if(root == null) return false;
		if(root.getData()== data) return true;

		return findRecursive(root.getLeft(), data) || findRecursive(root.getRight(), data);
	}
}
