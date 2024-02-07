public class BinarySearchTree
{
	private TreeNode root;
	
	public BinarySearchTree()
	{
		root = null;	
	}

	public boolean isEmpty()
	{
		return root == null;
	}

	public void insert( Object item )
	{
		root = insertItem( root , (Comparable) item );
	}

	private TreeNode insertItem( TreeNode tNode , Comparable item )
	{
		TreeNode newSubtree;

		if ( tNode == null )
		{
			tNode = new TreeNode(item);
			return tNode;
		}

		else if ( item.compareTo( tNode.getItem() ) < 0 )
		{
			newSubtree = insertItem( tNode.getLeft() , item );
			tNode.setLeft( newSubtree );
			return tNode;
		}

		else if ( item.compareTo( tNode.getItem() ) > 0 )
		{
			newSubtree = insertItem( tNode.getRight() , item );
			tNode.setRight( newSubtree );
			return tNode;
		}
	
		else
			return tNode;
	}

	public void inOrderTraversal()
	{
		inOrderTraversal( root );
	}

	private void inOrderTraversal( TreeNode tNode )
	{
		if ( tNode != null )
		{
			inOrderTraversal( tNode.getLeft() );
			System.out.print( tNode.getItem() + " " );
			inOrderTraversal( tNode.getRight() );
		}
	}

	public void preOrderTraversal()
	{
		preOrderTraversal( root );
	}

	private void preOrderTraversal( TreeNode tNode )
	{
		if ( tNode != null )
		{
			System.out.print( tNode.getItem() + " " );
			preOrderTraversal( tNode.getLeft() );
			preOrderTraversal( tNode.getRight() );
		}
	}

	public void postOrderTraversal()
	{
		postOrderTraversal( root );
	}

	private void postOrderTraversal( TreeNode tNode )
	{
		if ( tNode != null )
		{
			postOrderTraversal( tNode.getLeft() );
			postOrderTraversal( tNode.getRight() );
			System.out.print( tNode.getItem() + " " );
		}
	}

	public int sum()
	{
		return sumOfItems( root );
	}

	private int sumOfItems( TreeNode tNode )
	{
		if (tNode == null)
			return 0;
		else
			return ( ( (Integer)( tNode.getItem() ) ).intValue() + sumOfItems( tNode.getLeft() ) + sumOfItems( tNode.getRight() ) );
	}


	public void ancestorsIterative( Comparable item )
	{
		TreeNode tmpNode = root;
	
		if ( !isEmpty() )
		{
	     	/* The ancestor method assumes that the item exists in the tree */
			while ( ( item.compareTo( tmpNode.getItem() ) != 0 ) )
			{
				System.out.print( tmpNode.getItem() + " " );

				if ( item.compareTo( tmpNode.getItem() ) > 0 )
					tmpNode = tmpNode.getRight();
				else if ( item.compareTo( tmpNode.getItem() ) < 0 )
					tmpNode = tmpNode.getLeft();
			}
			System.out.println( " out of loop " );
		}
	}

	public void printSmallestChild() 
	{
		TreeNode tmpNode = root;
	
		if ( isEmpty() )
			System.out.println( "The tree is empty" );

		else {
			while ( tmpNode.getLeft() != null )
				tmpNode = tmpNode.getLeft();
			System.out.println( "The smallest Node in the tree is " + tmpNode.getItem() );
		}
	}

}

