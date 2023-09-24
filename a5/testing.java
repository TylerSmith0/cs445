package cs445.a5;

import java.util.*;
import java.lang.*;

public class testing{

  public static void main(String[] args){
    // Initialize a TernaryTree
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
			checkPostOrder(emptyTree);
			//checking the postorder of the tree
			checkPreOrder(emptyTree);
			//checking the level order of the tree
			checkLevelOrder(emptyTree);
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
			checkPostOrder(singleNode);
			//checking the preorder of the tree
			checkPreOrder(singleNode);
			//checking the level order of the tree
			checkLevelOrder(singleNode);
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
      System.out.println("\tNumber of Nodes: " + theTree.getNumberOfNodes());
      //Checking the postorder of the tree
			checkPostOrder(theTree);
			//checking the preorder of the tree
			checkPreOrder(theTree);
			//checking the level order of the tree
			checkLevelOrder(theTree);
      theTree.getInorderIterator();
			System.out.println();



    // Testing tree with only a middle child
    System.out.println("---------------------Only has a middle child---------------------");
    TernaryTree<Character> middleChild = new TernaryTree<>(new Character('C'));
    theTree.setTree(theRoot, null, middleChild, null);
    //Checking the root of the The Tree
    System.out.println("\tRoot of the Tree: " + theTree.getRootData());
    //Checking the height of the Tree
    System.out.println("\tHeight: " + theTree.getHeight());
    // Checking Num of Nodes
    System.out.println("\tNumber of Nodes: " + theTree.getNumberOfNodes());
    //Checking the postorder of the tree
    checkPostOrder(theTree);
    //checking the preorder of the tree
    checkPreOrder(theTree);
    //checking the level order of the tree
    checkLevelOrder(theTree);
    System.out.println();



    // Testing tree with only a right child
    System.out.println("---------------------Only has a right child---------------------");
    TernaryTree<Character> rightChild = new TernaryTree<>(new Character('D'));
    theTree.setTree(theRoot, null, null, rightChild);
    //Checking the root of the The Tree
    System.out.println("\tRoot of the Tree: " + theTree.getRootData());
    //Checking the height of the Tree
    System.out.println("\tHeight: " + theTree.getHeight());
    // Checking Num of Nodes
    System.out.println("\tNumber of Nodes: " + theTree.getNumberOfNodes());
    //Checking the postorder of the tree
    checkPostOrder(theTree);
    //checking the preorder of the tree
    checkPreOrder(theTree);
    //checking the level order of the tree
    checkLevelOrder(theTree);
    System.out.println();



    /*
                                A
                           /    |        \
                      B          C            D
                  /   |  \     /   \            \
              E       F   G   H      I            J
    */


    System.out.println("=============== MEGA TREEEEEEEEE! ====================");
    TernaryTree<String> megaTree = new TernaryTree<>("A");
    TernaryTree<String> theleftChild = new TernaryTree<>();
    TernaryTree<String> themiddleChild = new TernaryTree<>();
    TernaryTree<String> therightChild = new TernaryTree<>();
    TernaryTree<String> leftLeftChild = new TernaryTree<>("E");
    TernaryTree<String> leftMiddleChild = new TernaryTree<>("F");
    TernaryTree<String> leftRightChild = new TernaryTree<>("G");
    TernaryTree<String> middleLeftChild = new TernaryTree<>("H");
    TernaryTree<String> middleRightChild = new TernaryTree<>("I");
    TernaryTree<String> rightRightChild = new TernaryTree<>("J");
    theleftChild.setTree(new String("B"), leftLeftChild, leftMiddleChild, leftRightChild);
    themiddleChild.setTree(new String("C"), middleLeftChild, null, middleRightChild);
    therightChild.setTree(new String("D"), null, null, rightRightChild);
    megaTree.setTree(new String("A"), theleftChild, themiddleChild, therightChild);

    System.out.println("\tRoot of the Tree: " + megaTree.getRootData());
    //Checking the height of the Tree
    System.out.println("\tHeight: " + megaTree.getHeight());
    // Checking Num of Nodes
    System.out.println("\tNumber of Nodes: " + megaTree.getNumberOfNodes());
    //Checking the postorder of the tree
    Iterator<String> megapostIterator = megaTree.getPostorderIterator();
    System.out.print("\tPostorder:\t");
		while(megapostIterator.hasNext()){
      System.out.print("  " + megapostIterator.next() + " ");
		}
    System.out.println("");
    //checking the preorder of the tree
    Iterator<String> megapreIterator = megaTree.getPreorderIterator();
    System.out.print("\tPreorder:\t");
    while(megapreIterator.hasNext()){
      System.out.print("  " + megapreIterator.next() + " ");
    }    //checking the level order of the tree
    System.out.println("");

    Iterator<String> megaLevelIterator = megaTree.getLevelOrderIterator();
    System.out.print("\tLevel Order:\t");
    while(megaLevelIterator.hasNext()){
      System.out.print("  " + megaLevelIterator.next() + " ");
    }    System.out.println();

    System.out.println("The height of megaTree is " + megaTree.getHeight());



    // Testing tree with only a right child
    System.out.println("---------------------Only has a left and middle child---------------------");
    TernaryTree<Character> lChild = new TernaryTree<>(new Character('B'));
    TernaryTree<Character> mChild = new TernaryTree<>(new Character('C'));

    theTree.setTree(theRoot, lChild, mChild, null);
    //Checking the root of the The Tree
    System.out.println("\tRoot of the Tree: " + theTree.getRootData());
    //Checking the height of the Tree
    System.out.println("\tHeight: " + theTree.getHeight());
    // Checking Num of Nodes
    System.out.println("\tNumber of Nodes: " + theTree.getNumberOfNodes());
    //Checking the postorder of the tree
    checkPostOrder(theTree);
    //checking the preorder of the tree
    checkPreOrder(theTree);
    //checking the level order of the tree
    checkLevelOrder(theTree);
    System.out.println();




    // Testing tree with only a right child
    System.out.println("---------------------Only has a left and right child---------------------");
    //TernaryTree<Character> leftChild = new TernaryTree<>(new Character('B'));
    TernaryTree<Character> rChild = new TernaryTree<>(new Character('D'));

    theTree.setTree(theRoot, lChild, null, rChild);
    //Checking the root of the The Tree
    System.out.println("\tRoot of the Tree: " + theTree.getRootData());
    //Checking the height of the Tree
    System.out.println("\tHeight: " + theTree.getHeight());
    // Checking Num of Nodes
    System.out.println("\tNumber of Nodes: " + theTree.getNumberOfNodes());
    //Checking the postorder of the tree
    checkPostOrder(theTree);
    //checking the preorder of the tree
    checkPreOrder(theTree);
    //checking the level order of the tree
    checkLevelOrder(theTree);
    System.out.println();




    // Testing tree with only a right child
    System.out.println("---------------------Only has a middle and right child---------------------");
    TernaryTree<Character> midChild = new TernaryTree<>(new Character('C'));
    //TernaryTree<Character> rightChild = new TernaryTree<>(new Character('D'));

    theTree.setTree(theRoot, null, midChild, rChild);
    //Checking the root of the The Tree
    System.out.println("\tRoot of the Tree: " + theTree.getRootData());
    //Checking the height of the Tree
    System.out.println("\tHeight: " + theTree.getHeight());
    // Checking Num of Nodes
    System.out.println("\tNumber of Nodes: " + theTree.getNumberOfNodes());
    //Checking the postorder of the tree
    checkPostOrder(theTree);
    //checking the preorder of the tree
    checkPreOrder(theTree);
    //checking the level order of the tree
    checkLevelOrder(theTree);
    System.out.println();





    // Testing tree with only a right child
    System.out.println("---------------------Has left, middle, and right child---------------------");
    TernaryTree<Character> leeftChild = new TernaryTree<>(new Character('B'));

    //TernaryTree<Character> middleChild = new TernaryTree<>(new Character('C'));
    //TernaryTree<Character> rightChild = new TernaryTree<>(new Character('D'));

    theTree.setTree(theRoot, leeftChild, midChild, rChild);
    //Checking the root of the The Tree
    System.out.println("\tRoot of the Tree: " + theTree.getRootData());
    //Checking the height of the Tree
    System.out.println("\tHeight: " + theTree.getHeight());
    // Checking Num of Nodes
    System.out.println("\tNumber of Nodes: " + theTree.getNumberOfNodes());
    //Checking the postorder of the tree
    checkPostOrder(theTree);
    //checking the preorder of the tree
    checkPreOrder(theTree);
    //checking the level order of the tree
    checkLevelOrder(theTree);
    System.out.println();





		System.out.println();
		System.out.println("---------------------EOF---------------------");

	}

	//checking postorder
	public static void checkPostOrder(TernaryTree<Character> theTree){
		StringBuilder builder = new StringBuilder();
		Iterator<Character> postIterator = theTree.getPostorderIterator();
    System.out.print("\tPostorder:\t");
		while(postIterator.hasNext()){
      System.out.print("  " + postIterator.next() + " ");
		}
    System.out.println("");


	}

	//checking preorder
	public static void checkPreOrder(TernaryTree<Character> theTree){
		StringBuilder builder = new StringBuilder();
		Iterator<Character> preIterator = theTree.getPreorderIterator();
    System.out.print("\tPreorder:\t");
		while(preIterator.hasNext()){
			System.out.print("  " + preIterator.next() + " ");
		}
    System.out.println("");

	}

	//chekcing level order
	public static void checkLevelOrder(TernaryTree<Character> theTree){
		StringBuilder builder = new StringBuilder();
		Iterator<Character> levelOrderIterator = theTree.getLevelOrderIterator();
    System.out.print("\tLevel Order:\t");
		while(levelOrderIterator.hasNext()){
      System.out.print("  " + levelOrderIterator.next() + " ");
		}
    System.out.println("");
	}


  }
