public class BSTTester
{
	public static void main(String[] args) 
	{
		BinarySearchTree aBST = new BinarySearchTree();

		aBST.insert(new Integer(20));
		aBST.insert(new Integer(15));
		aBST.insert(new Integer(10));
		aBST.insert(new Integer(5));
		aBST.insert(new Integer(25));
		aBST.insert(new Integer(30));
		aBST.insert(new Integer(40));

		System.out.print( "In order traversal: " );
		aBST.inOrderTraversal();

		System.out.print( "\nPre order traversal: " );
		aBST.preOrderTraversal();

		System.out.print( "\nPost order traversal: " );
		aBST.postOrderTraversal();
		System.out.println();
		

		aBST.printSmallestChild();
		System.out.println();
		
		System.out.print( "Biggest " );
		aBST.biggest();
		System.out.println();

		System.out.print( "The ancestors of 40 are: " );
		aBST.ancestorsIterative( new Integer(45) );
		System.out.println();

		
	}
}
