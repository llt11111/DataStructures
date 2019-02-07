package Util;


public class ModifiedNode {
	ModifiedNode left;
	ModifiedNode right;
	ModifiedNode next;
	public ModifiedNode getLeft() {
		return left;
	}
	public int getData() {
		return data;
	}
	
	public void setLeft(ModifiedNode left) {
		this.left = left;
	}
	public ModifiedNode getRight() {
		return right;
	}
	public void setRight(ModifiedNode right) {
		this.right = right;
	}
	public ModifiedNode getNext() {
		return next;
	}
	public void setNext(ModifiedNode next) {
		this.next = next;
	}
	int data;
	public ModifiedNode(int data) {
		// TODO Auto-generated constructor stub
		this.data = data;


	}
}
