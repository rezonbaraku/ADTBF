public interface StackInterface
{
	public boolean isEmpty();
	public boolean isFull();
	public void popAll();
	public void push(Object newItem) throws StackException;
	public Object pop() throws StackException;
	public Object peek() throws StackException;
	public int size();
}