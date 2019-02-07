/*
 * level order - queue 
 * level order operaiton - queue + null insert / take queue count
 * level order spiral form - queue + null insert / queue count + flag to reverse
 * level order spiral after 2 levels - queue + null/queuecount + flag + global level count 
 * */
package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import Util.BinaryTree;
import Util.Node;

public class LevelOrderReverseAndSpiralForm {

	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.getBinaryTree();
		levelOrderTraversalInReverse(tree.getRoot());

		LevelOrderInSpiralForm(tree.getRoot());
		System.out.println();
		LevelOrderInSpiralFormOnAlternativeLines(tree.getRoot());
		System.out.println();
		levelOrderInSpiralFormInsertingNullInEnd(tree.getRoot());
	}

	private static void levelOrderTraversalInReverse(Node root) {
		// TODO Auto-generated method stub
		LinkedList<Node> queue  = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		List<Integer> simpleList = new ArrayList<>();
		queue.addLast(root);
		while(queue.isEmpty() != true){
			Node temp = queue.removeFirst();
			simpleList.add(temp.getData());
			stack.push(temp.getData());
			if(temp.getLeft() != null){
				queue.addLast(temp.getLeft());
			}
			if(temp.getRight() != null){
				queue.addLast(temp.getRight());
			}	
		}
		System.out.println("Reverse Level Order : ");
		while(!stack.isEmpty()){
			System.out.print("  "+stack.pop());
		}

		System.out.println("\nActual Level Order : ");
		for(Integer i : simpleList){
			System.out.print("  "+ i);
		}
	}


	private static void LevelOrderInSpiralForm(Node root){
		LinkedList<Node> queue  = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		List<Integer> simpleList = new ArrayList<>();
		queue.addLast(root);
		boolean reverseOnNextLine = false;
		while(queue.isEmpty() != true){
			int size = queue.size();
			for(int i = 0 ; i < size ; i++){
				Node temp = queue.removeFirst();
				simpleList.add(temp.getData());

				if(reverseOnNextLine){
					stack.push(temp.getData());
				}else{
					System.out.print(" => "+temp.getData());
				}
				if(temp.getLeft() != null){
					queue.addLast(temp.getLeft());
				}
				if(temp.getRight() != null){
					queue.addLast(temp.getRight());
				}	
			}
			while(!stack.isEmpty()){

				System.out.print(" --> "+ stack.pop() );
			}

			reverseOnNextLine = !reverseOnNextLine ;
			/*if(reverseOnNextLine)  reverseOnNextLine = false;
			else reverseOnNextLine = true;
*/
		}


		System.out.println("\nActual Level Order : ");
		for(Integer i : simpleList){
			System.out.print("  "+ i);
		}


	}

	private static void LevelOrderInSpiralFormOnAlternativeLines(Node root){
		LinkedList<Node> queue  = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		List<Integer> simpleList = new ArrayList<>();
		queue.addLast(root);
		boolean reverseOnNextLine = false;
		int lineCount = 0;
		while(queue.isEmpty() != true){
			int size = queue.size();
			lineCount++;
			for(int i = 0 ; i < size ; i++){
				Node temp = queue.removeFirst();
				simpleList.add(temp.getData());

				if(reverseOnNextLine){
					stack.push(temp.getData());
				}else{
					System.out.print(" => "+temp.getData());
				}
				if(temp.getLeft() != null){
					queue.addLast(temp.getLeft());
				}
				if(temp.getRight() != null){
					queue.addLast(temp.getRight());
				}	
			}
			while(!stack.isEmpty()){

				System.out.print(" --> "+ stack.pop() );
			}
			if(lineCount == 2){

				if(reverseOnNextLine)  reverseOnNextLine = false;
				else reverseOnNextLine = true;
				lineCount = 0;
			}
		}
		System.out.println("\nActual Level Order : ");
		for(Integer i : simpleList){
			System.out.print("  "+ i);
		}
	}

	private static void levelOrderInSpiralFormInsertingNullInEnd(Node root){
		if(root == null){
			return;
		}
		LinkedList<Node> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		queue.addLast(root);
		queue.addLast(null);
		boolean reverseNextLine = false;
		while(!queue.isEmpty()){
			Node temp = queue.removeFirst();
			if(temp == null){
				// push on stack and reverse 
				if(reverseNextLine==false)
					reverseNextLine = true;
				else reverseNextLine = false;

				//				reverseNextLine ^= true;

				while(!stack.isEmpty()){
					System.out.print(" -> "+ stack.pop());
				}
				queue.addLast(null);
			}else {
				if(reverseNextLine){
					stack.push(temp.getData());
				}else{
					System.out.print(" => "+ temp.getData());
				}
				if(temp.getLeft() != null){
					queue.addLast(temp.getLeft());
				}
				if(temp.getRight() != null){
					queue.addLast(temp.getRight());
				}
			}
		}
	}


}
