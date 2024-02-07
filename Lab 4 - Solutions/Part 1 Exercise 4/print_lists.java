
public void printList1()
{
	for (ListNode tmp=head; tmp!=null; tmp=tmp.getNext())
		System.out.println(tmp.getItem());
}

public void printList2()
{
	print(head);
}
	
private void print(ListNode aNode)
{
	if ( aNode != null)
	{
		System.out.println(aNode.getItem());
		print(aNode.getNext());
		// putting the system.out.println here will print the list backwards
	}
}