package BinaryTree;

import java.util.LinkedList;

import Util.ModifiedNode;

public class BinaryTreeConnectNodeOnSameLevel {
	
	public static void main(String[] args) {
		/*	20
		  12       25
		10 13   22*/
		ModifiedNode root = new ModifiedNode(20);
		root.setLeft(new ModifiedNode(12));
		
		root.getLeft().setLeft(new ModifiedNode(10));
		root.getLeft().setRight(new ModifiedNode(13));
		
		root.setRight(new ModifiedNode(25));
		root.getRight().setLeft(new ModifiedNode(22));
		
//		root = connectLevels(root);
		
		root = fillNextSiblig(root);
		
		print(root);
		System.out.println();
		
	}

	private static ModifiedNode fillNextSiblig(ModifiedNode root) {
		// TODO Auto-generated method stub
		if(root  == null) return null;
		if(root.getLeft() != null){
			root.getLeft().setNext(root.getRight());
		}
		if(root.getRight() != null){
			root.getRight().setNext(root.getNext() != null ? root.getNext().getLeft(): null);
		}
		fillNextSiblig(root.getLeft());
		fillNextSiblig(root.getRight());
		return root;
		
	}

	private static void print(ModifiedNode root) {
		// TODO Auto-generated method stub
		LinkedList<ModifiedNode>  queue = new LinkedList<>();
		queue.addLast(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			while(size > 0){
				ModifiedNode temp = queue.removeFirst();
				if(temp.getNext() != null){
					System.out.println(" temp.getData : "+ temp.getData() + 
							" temp.getNext : "+ temp.getNext().getData());
				}else{
					System.out.println(" temp.getData : "+ temp.getData() + 
							" temp.getNext : "+ temp.getNext());
				}
				
				if(temp.getLeft() != null){
					queue.addLast(temp.getLeft());
				}
				if(temp.getRight() != null){
					queue.addLast(temp.getRight());
				}
				
				size--;
			}
			
		}
	}

	private static ModifiedNode connectLevels(ModifiedNode root) {
		// TODO Auto-generated method stub
		LinkedList<ModifiedNode>  queue = new LinkedList<>();
		queue.addLast(root);
		
		
		while(!queue.isEmpty()){
			ModifiedNode prev = null;
			int size = queue.size();
			while(size > 0){
				ModifiedNode temp = queue.removeFirst();
				
				if(temp.getLeft() != null){
					queue.addLast(temp.getLeft());
				}
				if(temp.getRight() != null){
					queue.addLast(temp.getRight());
				}
				if(prev != null){
					prev.setNext(temp);
					prev = temp;
				}else{
					prev = temp;
				}
				size--;
			}
			prev.setNext(null);
			
		}
		
		return root;
	}
}
