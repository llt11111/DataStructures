package BinaryTree;

import java.util.ArrayList;

import Util.AbstractNode;
import Util.Node;

public class BinaryTreePrintAllPathsFromRoot extends AbstractNode {
	static int count = 0 ; 
	public static void main(String[] args) {
		Node root = getBinaryTree();
		printAllPathFromRoot(root);
		System.out.println(count);
	}

	private static void printAllPathFromRoot(Node root) {
		// TODO Auto-generated method stub
		if(root == null){
			return ;
		}
		//		int [] path = new int[10];
		//		int pathIndex = 0 ;
		ArrayList<Integer> arr = new ArrayList<>();
		//		call(root, path, pathIndex);
		call(root, arr);


	}

	private static void call(Node root, ArrayList<Integer> path/*, int pathIndex*/) {
		// TODO Auto-generated method stub
		if(root == null){
			return ;
		}
	
		path.add(root.getData());
		call(root.getLeft(), path);
		call(root.getRight(), path);
		
		if(root.getLeft() == null && root.getRight() == null) {
			print(path);
			count++;
		}
		path.remove(path.size()-1);
	}

	private static void print(ArrayList<Integer> path) {
		// TODO Auto-generated method stub
		System.out.println( path);
	}
}
