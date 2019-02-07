package BinarySearchTree;

import Util.AbstractNode;
import Util.Node;

public class CheckIsBST extends AbstractNode {
	public static void main(String[] args) {
		Node root = getBinaryTree();
		System.out.println(isBSTCheck(root, null));
		
		System.out.println(isBSTCheck1(root, null, null));
	}

	private static boolean isBSTCheck(Node root, Node prev) {
		// TODO Auto-generated method stub
		if(root != null) {
			if(!isBSTCheck(root.getLeft(), prev)){
				return false;
			}
			
			if(prev != null && root.getData() <= prev.getData()){
				return false;
			}
			
			prev = root;
			
			return isBSTCheck(root.getRight(), prev);
			
		}
		return true;
	}
	
	private static boolean isBSTCheck1(Node root, Node l , Node h){
		if(root!= null){
			if(l != null && root.getData() < l.getData() ){
				return false;
			}
			if(h != null && root.getData() > h.getData()){
				return false;
			}
			return  isBSTCheck1(root.getLeft(), l, root) && 
					isBSTCheck1(root.getRight(), root, h);
		}
		return true;
	}
}
