package BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import Util.BinaryTree;
import Util.Node;

public class BinaryTreeVerticalView {
	static TreeMap<Integer, List<Node>> treeMap = new TreeMap<>();
	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.getBinaryTree();
		System.out.println("print vertical view Iterative : ");
		printVerticalView(tree.getRoot());
		
		System.out.println("\nprint vertical view recursive : ");
		printVerticalViewRecur(tree.getRoot());
		for(Integer i : treeMap.keySet()){
			for(Node n : treeMap.get(i)){
				System.out.print("  "+ n.getData());
			}
		}

	}

	private static void printVerticalViewRecur(Node root) {
		// TODO Auto-generated method stub
		int hd = 0 ;
		
		getVerticalViewRecur(root, hd, treeMap);
	}

	private static void getVerticalViewRecur(Node root, int hd, TreeMap<Integer, List<Node>> treeMap) {
		// TODO Auto-generated method stub
		if(root == null) return;
		if(treeMap.containsKey(hd)){
			List<Node> list = treeMap.get(hd);
			list.add(root);
			treeMap.put(hd, list);
		}else{
			LinkedList<Node> list = new LinkedList<>();
			list.add(root);
			treeMap.put(hd, list);
		}
		getVerticalViewRecur(root.getLeft(), hd -1, treeMap);
		getVerticalViewRecur(root.getRight(), hd +1, treeMap);
	}

	private static void printVerticalView(Node root) {
		class QNode implements Comparable<Integer>{
			int hd;
			Node root;
			public QNode( int hd, Node root) {
				// TODO Auto-generated constructor stub
				this.hd = hd;
				this.root = root;
			}
			@Override
			public int compareTo(Integer o) {
				// TODO Auto-generated method stub
				return this.hd - o;
			}
		}
		LinkedList<QNode> queue  = new LinkedList<>();
		TreeMap<Integer, List<QNode>> map = new TreeMap<>();
		queue.push(new QNode(0, root));
		while(!queue.isEmpty()){
			QNode temp = queue.poll();
			if(!map.containsKey(temp.hd)){
				List<QNode> list = new LinkedList<>();
				list.add(temp);
				map.put(temp.hd, list);
			}else{
				List<QNode> list = map.get(temp.hd);
				list.add(temp);
				map.put(temp.hd, list);
			}

			if(temp.root.getLeft() != null){
				queue.push(new QNode(temp.hd -1 , temp.root.getLeft()));
			}
			if(temp.root.getRight() != null){
				queue.push(new QNode(temp.hd +1 , temp.root.getRight()));
			}
		}
		
		for(Entry<Integer, List<QNode>> qEntry : map.entrySet()){
			for(QNode q : qEntry.getValue()){
				System.out.print(q.root.getData() + "  ");
			}
		}

	}
}
