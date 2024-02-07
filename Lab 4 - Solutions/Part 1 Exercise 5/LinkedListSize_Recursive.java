/** Finds the size of a list.
    @param head The head of the current list
    @RETURN THE SIZE OF THE CURRENT LIST
 */
private int size(Node aListNode)
{
	if (aListNode == null)
		return 0;
	else
		return 1 + size(aListNode.getNext());
}

/** Wrapper method for finding the size of a list.
    @return The size of the list
 */
public int size()
{
	return size(head);
}