package BinarySearchTree;

import Util.AbstractNode;
import Util.BinaryTree;
import Util.Node;

public class ConvertBSTToSortedLinkedList extends AbstractNode{
	public static void main(String[] args) {
		Node root = getBinaryTree();
		Node prev = null;
		convertBSTToDLL(root, prev);
	}

	private static void convertBSTToDLL(Node root, Node prev) {
		// TODO Auto-generated method stub
		if(root == null){
			return ;
		}
		convertBSTToDLL(root.getLeft(), prev);
		if(prev == null) {
			prev = root;
		}else{
			root.setLeft(prev);
			prev.setRight(root);
		}
		
		prev = root;
		convertBSTToDLL(root.getRight(), prev);
		/*if(root.getLeft() == null && root.getRight() == null){
			System.out.println("root : "+ root.getData() + " root.prev "+ null + " root.next: "+ null);
			
		}else if(root.getLeft() == null){
			System.out.println("root : "+ root.getData() + " root.prev "+ null + " root.next: "+ root.getRight().getData());
			
		}else if(root.getRight() == null){
			System.out.println("root : "+ root.getData() + " root.prev "+ root.getLeft().getData() + " root.next: "+ null);
			
		}else {
			System.out.println("root : "+ root.getData() + " root.prev "+ root.getLeft().getData() + " root.next: "+ root.getRight().getData());

		}
		*/
	}
}
