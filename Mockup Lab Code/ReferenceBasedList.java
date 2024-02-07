public class ReferenceBasedList implements ListInterface
{
	private ListNode head;
	private ListNode tail;
	int numItems;

	public ReferenceBasedList()
	{
		head = tail = null;
		numItems = 0;
	}

	public int size()
	{
		return numItems;
	}
	
	public boolean isEmpty()
	{
		return (numItems == 0);
	}

	public void removeAll()
	{
		head = tail = null;
		numItems = 0;
	}

	private ListNode find(int index)
	{
		ListNode curr = head;
		for (int skip = 1; skip < index; skip++)
			curr = curr.getNext();
		return curr;
	}

	public Object get(int index) 
					  throws ListIndexOutOfBoundsException
	{
		if (index >= 1 && index <= numItems)
		{
			ListNode curr = find(index);
			return curr.getItem();
		} 
		else
		{
			throw new ListIndexOutOfBoundsException(
                     "List index out of bounds exception on get");
		}
	}

	public void add(int index, Object newDataItem)
					throws ListIndexOutOfBoundsException
	{
		if (index >= 1 && index <= numItems+1)
		{
			if ( index == 1 )
			{
				ListNode newNode = new ListNode(newDataItem, head);
				head = newNode;

				if (tail==null)
					tail = head;
			} 
			else if ( index==numItems+1 )
			{
				ListNode newNode = new ListNode(newDataItem);
				tail.setNext(newNode);
				tail = newNode;
			}
			else
			{
				ListNode prev = find(index-1);
				ListNode newNode = new ListNode(newDataItem, prev.getNext());
				prev.setNext(newNode);
			}
			numItems++;
		} 
		else
		{
			throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on add");
		}
	}

	public void insert(Object newDataItem)
	{
		this.add(1,newDataItem);
	}

	public void append(Object newDataItem)
	{
		this.add(numItems+1,newDataItem);
	}	

	public Object showFront()
	{
		return this.get(1);
	}

	public Object showLast()
	{
		return this.get(numItems);
	}

	public void remove(int index) 
					   throws ListIndexOutOfBoundsException
	{
		if (index >= 1 && index <= numItems)
		{
			if (index == 1)
			{
				head = head.getNext();
				if (head == null)
					tail = null;
			}
			else
			{
				ListNode prev = find(index-1);
				ListNode curr = prev.getNext(); 
				prev.setNext(curr.getNext());
				if (index == numItems)
					tail = prev;
			}
			numItems--;
		}
		else
		{
			throw new ListIndexOutOfBoundsException(
                   "List index out of bounds exception on remove");
		}
	}

	public boolean exists(Object dataItem)
	{
		for (ListNode tmp=head; tmp!=null; tmp=tmp.getNext())
			if (tmp.getItem().equals(dataItem))
				return true;
		return false;
	}

public Object removeLast() throws ListException
{
	if (isEmpty())
		throw new ListException("The linked list is empty");
	else
	{
		Object lastDataItem = tail.getItem();
		if (head == tail)
			head = tail = null;
		else
		{
			ListNode tmp = head;
			while (tmp.getNext().getNext() != null)
				tmp = tmp.getNext();
			tail = tmp;
			tail.setNext(null);
		}
		numItems--;
		return lastDataItem;
	}
}

public Object removeFront() throws ListException
{
	if (isEmpty())
		throw new ListException("The linked list is empty");
	else
	{
		Object frontDataItem = head.getItem();
		head = head.getNext();
		if (head == null)
			tail = null;
		numItems--;
		return frontDataItem;
	}
}


}




