import cs445.a5.*;
import java.lang.*;
import java.util.*;

public class TernaryTester{

	public static void main(String[] args){

		//Testing an empty tree
			System.out.println("---------------------Empty Tree---------------------");
			TernaryTree<Character> emptyTree = new TernaryTree<>();
			//Checking that the tree is truely empty
			System.out.println("\tTree is empty: " + emptyTree.isEmpty());
			//Checking the height of the tree
			System.out.println("\tHeight of the tree: " + emptyTree.getHeight());
			//Checking the number of nodes in the tree
			System.out.println("\tNumber of Nodes in the tree: " + emptyTree.getNumberOfNodes());
			//checking the preorder of the tree
			System.out.println("\tPostorder: " + checkPostOrder(emptyTree));
			//checking the postorder of the tree
			System.out.println("\tPreorder: " + checkPreOrder(emptyTree));
			//checking the level order of the tree
			System.out.println("\tLevelOrder: " + checkLevelOrder(emptyTree));
			System.out.println();

		//Testing a tree with only a root
			System.out.println("---------------------Single Node---------------------");
			TernaryTree<Character> singleNode = new TernaryTree<>(new Character('A'));
			//Checking the root of the tree
			System.out.println("\tRoot of the Tree: " + singleNode.getRootData());
			//Checking if the tree is considered empty
			System.out.println("\tTree is empty: " + singleNode.isEmpty());
			//Checking the height of the tree
			System.out.println("\tHeight: " + singleNode.getHeight());
			//Checking the number of Nodes in the Tree
			System.out.println("\tNumber of Nodes: " + singleNode.getNumberOfNodes());
			//Checking the postorder of the tree
			System.out.println("\tPostorder: " + checkPostOrder(singleNode));
			//checking the preorder of the tree
			System.out.println("\tPreorder: " + checkPreOrder(singleNode));
			//checking the level order of the tree
			System.out.println("\tLevelOrder: " + checkLevelOrder(singleNode));
			System.out.println();

		//Testing a tree with only a left child
			System.out.println("---------------------Only has a left child---------------------");
			Character theRoot = new Character('A');
			TernaryTree<Character> leftChild = new TernaryTree<>(new Character('B'));
			TernaryTree<Character> theTree = new TernaryTree<>(theRoot, leftChild, null, null);
			//Checking the root of the The Tree
			System.out.println("\tRoot of the Tree: " + theTree.getRootData());
			//Checking the height of the Tree
			System.out.println("\tHeight: " + theTree.getHeight());

		System.out.println();
		System.out.println("---------------------EOF---------------------");
	}

	//checking postorder
	public static String checkPostOrder(TernaryTree<Character> theTree){
		StringBuilder builder = new StringBuilder();
		Iterator<Character> postIterator = theTree.getPostorderIterator();

		while(postIterator.hasNext()){
			builder.append(postIterator.next());
		}

		return builder.toString();

	}

	//checking preorder
	public static String checkPreOrder(TernaryTree<Character> theTree){
		StringBuilder builder = new StringBuilder();
		Iterator<Character> preIterator = theTree.getPreorderIterator();

		while(preIterator.hasNext()){
			builder.append(preIterator.next());
		}

		return builder.toString();
	}

	//chekcing level order
	public static String checkLevelOrder(TernaryTree<Character> theTree){
		StringBuilder builder = new StringBuilder();
		Iterator<Character> levelOrderIterator = theTree.getLevelOrderIterator();

		while(levelOrderIterator.hasNext()){
			builder.append(levelOrderIterator.next());
		}

		return builder.toString();
	}
}
