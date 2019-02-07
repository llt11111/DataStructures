package BinaryTree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import Util.BinaryTree;
import Util.Node;

public class BinaryTreeTopView {
	static TreeMap<Integer, Node> topViewMap = new TreeMap<>();
	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.getBinaryTree();
		
		System.out.println("Top view BT  Recursion ");
		printTopViewRecr(tree.getRoot());
		
		for(Integer i : topViewMap.keySet()){
			System.out.print("  "+ topViewMap.get(i).getData());
		}
		System.out.println();
		printTopViewLevelOrder(tree.getRoot());
	}

	private static void printTopViewRecr(Node root) {
		// TODO Auto-generated method stub
		
		int hd = 0 ; 
		
		getTopView(root, hd, topViewMap);
		
		
	}

	private static void getTopView(Node root, int hd, TreeMap<Integer, Node> topViewMap) {
		// TODO Auto-generated method stub
		if(root == null) return;
		if(!topViewMap.containsKey(hd)){
			topViewMap.put(hd, root);
		}
//		  topViewMap.put(hd, root);  // changes for bottom view .. 
		if(root.getLeft() != null) getTopView(root.getLeft(), hd-1, topViewMap);
		if(root.getRight() != null) getTopView(root.getRight(), hd+1, topViewMap);
	}
	
	
	private static void printTopViewLevelOrder(Node root){
		
		class QNode{
			int hd; 
			Node node;
			public QNode(int hd, Node node) {
				// TODO Auto-generated constructor stub
				this.hd = hd;
				this.node = node;
			}
		}
		LinkedList<QNode> queue = new LinkedList<>();
		Map<Integer, Node> topViewMap1 = new TreeMap<>();
		
		queue.addLast(new QNode(0, root)) ;
		
		System.out.println(" Top view BT  iterator : ");
		while(queue.isEmpty() == false){
			QNode qNode = queue.removeFirst();
			if(!topViewMap1.containsKey(qNode.hd)){
				topViewMap1.put(qNode.hd, qNode.node);
			}
			
			if(qNode.node.getLeft() != null){
				queue.addLast(new QNode(qNode.hd - 1 , qNode.node.getLeft()));
			}
			
			if(qNode.node.getRight() != null){
				queue.addLast(new QNode(qNode.hd + 1 , qNode.node.getRight()));
			}
		}
		
		for(int i : topViewMap1.keySet()){
			System.out.print(" "+ topViewMap1.get(i).getData());
		}
		
	}
}
