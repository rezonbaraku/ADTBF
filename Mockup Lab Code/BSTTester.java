
// STUDENT NAME: Tron Baraku 
// -----------------------------------------

public class BSTTester {
	public static void main(String[] args)  {

		//Exercise 1.i
		BinarySearchTree myTree = new BinarySearchTree();
		
		myTree.insert(23); //This could be myTree.insert(new Integer(23)) but eclipse complains that it is deprecated 
		myTree.insert(14);
		myTree.insert(10);
		myTree.insert(19);
		myTree.insert(16);
		myTree.insert(38);
		myTree.insert(47);
		myTree.insert(39);
		
		//Exercise 1.ii
		
		myTree.inOrderTraversal();
		System.out.println();
		
		myTree.preOrderTraversal();
		System.out.println();
		
		myTree.postOrderTraversal();
		System.out.println();
		System.out.println();
		
		
		//Exercise 2
		System.out.println("Is the number 16 a leaf: " + myTree.isLeaf(16));
		System.out.println("Is the number 19 a leaf: " + myTree.isLeaf(19));
		System.out.println();
		
		
		//Exercise 3
		myTree.plusPlus();
		
		//Viewing the results of the plusPlus method 
		myTree.inOrderTraversal();
		System.out.println();
		System.out.println();
		
		
		//Exercise 4
		BinarySearchTree stupidTree = new BinarySearchTree();
		
		stupidTree.insert(10);
		stupidTree.insert(20);
		stupidTree.insert(30);
		stupidTree.insert(40);
		stupidTree.insert(50);
		stupidTree.insert(60);
		
		System.out.println("Is the BST from Exercise 1 stupid: " + myTree.isTheBinaryTreeStupid());
		System.out.println("Is the second BST stupid: " + stupidTree.isTheBinaryTreeStupid());



	}
}
