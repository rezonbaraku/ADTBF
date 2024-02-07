// You will be adding methods in this file but AT THE END OF THE FILE !!!
// -------------------------------------------------------------------

public class BinarySearchTree
{
	private TreeNode root;
	
	public BinarySearchTree() {
		root = null;	
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insert( Object item ) {
		root = insertItem( root , (Comparable) item );
	}

	private TreeNode insertItem( TreeNode tNode , Comparable item ) {
		TreeNode newSubtree;

		if ( tNode == null ) {
			tNode = new TreeNode(item);
			return tNode;
		}

		else if ( item.compareTo( tNode.getItem() ) < 0 ) {
			newSubtree = insertItem( tNode.getLeft() , item );
			tNode.setLeft( newSubtree );
			return tNode;
		}

		else if ( item.compareTo( tNode.getItem() ) > 0 ) {
			newSubtree = insertItem( tNode.getRight() , item );
			tNode.setRight( newSubtree );
			return tNode;
		}
	
		else
			return tNode;
	}

	public void inOrderTraversal() {
		inOrderTraversal( root );
	}

	private void inOrderTraversal( TreeNode tNode ) {
		if ( tNode != null ) {
			inOrderTraversal( tNode.getLeft() );
			System.out.print( tNode.getItem() + " " );
			inOrderTraversal( tNode.getRight() );
		}
	}

	public void preOrderTraversal() {
		preOrderTraversal( root );
	}

	private void preOrderTraversal( TreeNode tNode ) {
		if ( tNode != null ) {
			System.out.print( tNode.getItem() + " " );
			preOrderTraversal( tNode.getLeft() );
			preOrderTraversal( tNode.getRight() );
		}
	}

	public void postOrderTraversal() {
		postOrderTraversal( root );
	}

	private void postOrderTraversal( TreeNode tNode ) {
		if ( tNode != null ) {
			postOrderTraversal( tNode.getLeft() );
			postOrderTraversal( tNode.getRight() );
			System.out.print( tNode.getItem() + " " );
		}
	}

	public void delete( Object item ) throws TreeException
	{
		root = deleteItem( root , (Comparable) item );
	}

	protected TreeNode deleteItem( TreeNode tNode , Comparable item ) {
		TreeNode newSubtree;
		if ( tNode == null )
			throw new TreeException( "TreeException: Item not found" );
		else {
			Comparable nodeItem = (Comparable)tNode.getItem();

			if (item.compareTo( nodeItem ) == 0)
				tNode = deleteNode( tNode );
			else if ( item.compareTo( nodeItem ) < 0 ) {
				newSubtree = deleteItem( tNode.getLeft() , item );
				tNode.setLeft( newSubtree );
			}
			else {
				newSubtree = deleteItem( tNode.getRight() , item );
				tNode.setRight( newSubtree );
			}
		}
		return tNode;
	}

	protected TreeNode deleteNode( TreeNode tNode )
	{
		Comparable replacementItem;

	    if ( ( tNode.getLeft() == null ) && ( tNode.getRight() == null ) )
			return null;
		else if ( tNode.getLeft() == null )
			return tNode.getRight();
		else if ( tNode.getRight() == null )
			return tNode.getLeft();
		else {
			replacementItem = findLeftmost( tNode.getRight() );
			tNode.setItem( replacementItem );
			tNode.setRight( deleteLeftmost( tNode.getRight() ) );
			return tNode;
		}
	}

	protected Comparable findLeftmost( TreeNode tNode )
	{
		if ( tNode.getLeft() == null )
			return ( Comparable )tNode.getItem();
		else
			return findLeftmost( tNode.getLeft() );
	}

	protected TreeNode deleteLeftmost( TreeNode tNode )
	{
		if ( tNode.getLeft() == null )
			return tNode.getRight();
		else {
			tNode.setLeft( deleteLeftmost( tNode.getLeft() ) );
			return tNode;
		}
	}

	public Comparable retrieve( Object item ) {
		return retrieveItem( root , (Comparable)item );
	}

	protected Comparable retrieveItem( TreeNode tNode , Comparable searchItem ) {
		Comparable treeItem;
    
		if ( tNode == null )
			treeItem = null;
		else {
			Comparable nodeItem = (Comparable)tNode.getItem();
      
			if ( searchItem.compareTo( nodeItem ) == 0 )
				treeItem = (Comparable)tNode.getItem();

			else if ( searchItem.compareTo( nodeItem ) < 0 )
				treeItem = retrieveItem( tNode.getLeft() , searchItem );

			else 
				treeItem = retrieveItem( tNode.getRight() , searchItem );
		}
		return treeItem;
	}
	
	// Private method that determines if a specific item exists in the BST
	// If the item exists the method returns the REFERENCE to the node. Otherwise, it returns null.
	private TreeNode find( Comparable searchItem )
	{
		TreeNode tmpNode = root;

		while ( ( tmpNode != null )  &&
			    ( searchItem.compareTo( (Comparable)tmpNode.getItem() ) != 0 ) )
		{
			if ( searchItem.compareTo( (Comparable)tmpNode.getItem() ) > 0 )
				tmpNode = tmpNode.getRight();
			else if ( searchItem.compareTo( (Comparable)tmpNode.getItem() ) < 0 )
				tmpNode = tmpNode.getLeft();
		}

		return tmpNode;
	}

	public void clearTree() {
		root = null;
	}

	// Prints the smallest node in tree (lab 7)
	public void printSmallestChild() {
		TreeNode tmpNode = root;
	
		if ( isEmpty() )
			System.out.println( "The tree is empty" );

		else {
			while ( tmpNode.getLeft() != null )
				tmpNode = tmpNode.getLeft();
			System.out.println( "The smallest Node in the tree is " + tmpNode.getItem() );
		}
	}

	// Prints the ancestors of a node in tree (lab 7). It assumes that the node exists in the tree
	public void ancestorsIterative( Comparable item ) {
		TreeNode tmpNode = root;
	
		if ( !isEmpty() ) {
			while ( ( item.compareTo( tmpNode.getItem() ) != 0 ) ) {
				System.out.print( tmpNode.getItem() + " " );

				if ( item.compareTo( tmpNode.getItem() ) > 0 )
					tmpNode = tmpNode.getRight();
				else if ( item.compareTo( tmpNode.getItem() ) < 0 )
					tmpNode = tmpNode.getLeft();
			}
		}
	}

	// Recursive method that prints the ancestors of a node in tree. It assumes that the node exists in the tree
	public void ancestorsRecursive( Object item ) {
		if ( !isEmpty() )
			root = ancestorsR( root , (Comparable)item );
	}

	private TreeNode ancestorsR( TreeNode tNode , Comparable searchItem ) {
		TreeNode newSubTree;
		
		Comparable nodeItem = (Comparable)tNode.getItem();

		if ( searchItem.compareTo( nodeItem ) > 0 ) {
			System.out.print( nodeItem + "-" );
			newSubTree = ancestorsR( tNode.getRight() , searchItem );
			tNode.setRight( newSubTree );
			return tNode;
		}
		else if ( searchItem.compareTo( nodeItem ) < 0 ) {
			System.out.print( nodeItem + "-" );	
			newSubTree = ancestorsR( tNode.getLeft() , searchItem );
			tNode.setLeft( newSubTree );
			return tNode;
		}
		else
			return tNode;
	}

	// Returns Sum of items (lab 7)
	public int sum() {
		return sumOfItems( root );
	}

	private int sumOfItems( TreeNode tNode ) {
		if ( tNode == null )
			return 0;
		else
			return ( ( (Integer)( tNode.getItem() ) ).intValue()
			+ sumOfItems( tNode.getLeft() ) + sumOfItems( tNode.getRight() ) );
	}

	// Returns number of nodes in tree (lab 8)
	public int sizeOf() {
		return numberOfNodes(root);
	}

	private int numberOfNodes( TreeNode tNode ) {
		if ( tNode == null )
			return 0;
		else
			return ( 1 + numberOfNodes( tNode.getLeft() ) + numberOfNodes( tNode.getRight() ) );
	}

	// Prints the largest node in tree (lab 8)
	public void printLargestChild() {
		TreeNode tmpNode = root;
	
		if ( isEmpty() )
			System.out.println( "The tree is empty" );
		else {
			while ( tmpNode.getRight() != null )
				tmpNode = tmpNode.getRight();
			System.out.println( "The largest node in the tree is " + tmpNode.getItem() );
		}
	}

	// Determines if an item exists in the tree (lab 8). Utilizes private method: find
	public boolean exists( Object item ) {
		if ( find( (Comparable)item ) == null ) 
			return false;
		else
			return true;
	}

	// Returns the height of the tree (lab 8)
	public int height() {
		return height( root );
	}

	private int height( TreeNode tNode ) {
		if ( tNode == null )
			return 0;
		else
			return 1 + java.lang.Math.max( height( tNode.getLeft() ) , height( tNode.getRight() ) );
	}

	// Returns how many nodes have two children (lab 8)
	int twoChildren() {
		return twoChildren(root);
	}

	int twoChildren(TreeNode tmpnode) {
	    if (tmpnode==null)
	        return 0;

	    if ( (tmpnode.getLeft()!=null) && (tmpnode.getRight()!=null)   )
	        return 1 + twoChildren(tmpnode.getLeft()) + twoChildren(tmpnode.getRight());

	    return twoChildren(tmpnode.getLeft()) + twoChildren(tmpnode.getRight());
	}
/* ------------------- ADD YOUR METHODS BELOW THIS LINE ------------------- */


	public void plusPlus() {
	    plusPlus(root);
	}

	private void plusPlus(TreeNode node) {
	    if (node != null) {
	        // Traverse left subtree
	        plusPlus(node.getLeft());
	        // Traverse right subtree
	        plusPlus(node.getRight());
	        // Add 1 to the value of the current node
	        int value = (int) node.getItem();
	        node.setItem(value + 1);
	    }
	}
	
	
//	public void plusPlus() {
//	    plusPlusWithoutRecursion(root);
//	}
//
//	private void plusPlusWithoutRecursion(TreeNode root) {
//	    if (root == null) return;
//	    
//	    Stack<TreeNode> stack = new Stack<>();
//	    stack.push(root);
//	    
//	    while (!stack.isEmpty()) {
//	        TreeNode node = stack.pop();
//	        // Add 1 to the value of the current node
//	        int value = (int) node.getItem();
//	        node.setItem(value + 1);
//	        
//	        // Push right child first so that left child is processed first (LIFO order)
//	        if (node.getRight() != null) {
//	            stack.push(node.getRight());
//	        }
//	        if (node.getLeft() != null) {
//	            stack.push(node.getLeft());
//	        }
//	    }
//	}




/* -------------------------- END OF YOUR METHODS ------------------------- */

} // Do not delete this bracket - it is the end of the class