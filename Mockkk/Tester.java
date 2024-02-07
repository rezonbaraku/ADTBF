
public class Tester {
	public static void main(String[] args) {

		/* Add your code as well as the answers to text questions (as comments) */
		/*
		 * Don't forget to include the number of the questions (Part X Question Y) as
		 * comments
		 */

//		Part1 1.a
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(34);
		tree.insert(22);
		tree.insert(87);
		tree.insert(5);
		tree.insert(22);
		tree.insert(76);
		tree.insert(90);
		tree.insert(33);
		tree.insert(75);
		tree.insert(86);
//		1.b
		System.out.println(tree.height());
		tree.ancestorsRecursive(75);
		System.out.println("THe in order traversal is");
		tree.inOrderTraversal();
		tree.plusPlus();
		System.out.println("THe in order traversal is");
		tree.inOrderTraversal();

//		1.c
//		The Big Oh notation of a balanced Binary Search Tree to search for an element is log n
//		since if it is balanced it always halves the number of nodes it needs to search to find the element by each check

//		Trying the getParent method
		TreeNode t = new TreeNode(75);
		System.out.println();
	try {
		System.out.println();
			System.out.println(tree.getParent(t).getItem());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		

//		Part 2 - 1
		ReferenceBasedList linkedList = new ReferenceBasedList();
		linkedList.append("Lens");
		linkedList.append("Alan");
		linkedList.append("Carlyn");
		linkedList.append("Nick");
		linkedList.append("Bob");

		linkedList.insert("Costas");
		linkedList.append("Paola");
//		for(int i = 1; i <= linkedList.size(); i++) {
//			System.out.println(linkedList.get(i));
//		}

//		Part 2 - 2
		CreateSampleBooks();

//		Part 2 - 3 first question same as 1.c

//		Part 2 - 3
		testQueues();

		/*
		 * Part 3 - 1 The mystery method finds whether a text ( which is represented as
		 * a list of characters) can be read in the same way from both sides from the
		 * beginning to end or vice versa
		 * 
		 * a. The number of calls depends on the length of the list and since it is
		 * shifting both indexes towards the center each time by one, the stack will
		 * contain half the length of calls. In case of odd length, it will be rounded
		 * up. And since it is recursive solution it requires one more call than
		 * necessary. n/2(rounded up) + 1 calls
		 * 
		 * b. the result for our example is true: since rotator is pronounced the same
		 * way from both sides
		 * 
		 * c. isPalindrome, which checks if the array of characters which represents a
		 * string which is a text, is a palindrome or not
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

	}

	public static void CreateSampleBooks() {
		Book b1 = new Book(823, "Lord of the Rings");
		Book b2 = new Book(323, "Lord of the Kings");
		Book b3 = new Book(642, "Lord of the Strings");
		Book b4 = new Book(223, "Lord of the Slings");
		Book b5 = new Book(191, "Lord of the Pings");
		Book b6 = new Book(587, "Lord of the Springs");
		Book b7 = new Book(792, "Lord of the Drinks");
		StackReferenceBased stack = new StackReferenceBased();
		stack.push(b6);
		stack.push(b4);
		stack.push(b2);
		stack.push(b5);
		stack.push(b1);

		StackReferenceBased temp = new StackReferenceBased();

		try {
			while (stack.peek() != null) {
				Book t = (Book) stack.pop();
				System.out.println(t);
				temp.push(t);
			}
		} catch (Exception e) {

		}
//		while(stack.peek() != null) {
//			Book t = (Book) stack.pop();
//			System.out.println(t);
//			temp.push(t);
//		}
//		for(int i = 1; i <= temp.size(); i++) {
//			stack.push(temp.pop());
//		}

		try {
			while (temp.peek() != null) {
				Book t = (Book) temp.pop();
//				System.out.println(t);
				stack.push(t);
			}
		} catch (Exception e) {

		}

		while (true) {
			if (stack.peek() == b6) {
				stack.pop();
				break;
			} else {
				temp.push(stack.pop());
			}
		}

		try {
			while (temp.peek() != null) {
				Book t = (Book) temp.pop();
//				System.out.println(t);
				stack.push(t);
			}
		} catch (Exception e) {

		}

//		try {
//			while(stack.peek() != null) {
//				Book t = (Book) stack.pop();
//				System.out.println(t);
//				temp.push(t);
//			}
//		}catch(Exception e){
//			
//		}
//		
//		try {
//			while(temp.peek() != null) {
//				Book t = (Book) temp.pop();
////				System.out.println(t);
//				stack.push(t);
//			}
//		}catch(Exception e){
//			
//		}

	}

	public static boolean equalQueues(QueueReferenceBased q1, QueueReferenceBased q2) {
		QueueReferenceBased hold = new QueueReferenceBased();
		if (q1.size() != q2.size())
			return false;
		else {
			boolean flag = true;
			while (!q1.isEmpty()) {
				Object q1el = q1.dequeue();
				Object q2el = q2.dequeue();
				if (!q1el.equals(q2el)) {
					flag = false;
					break;
				}
				hold.enqueue(q1el);
				hold.enqueue(q2el);
			}
			int i = 1;
			while (!hold.isEmpty()) {
				if (i % 2 == 0) {
					q2.enqueue(hold.dequeue());
				} else {
					q1.enqueue(hold.dequeue());
				}
				i++;
			}
			return flag;
		}

	}

	public static void testQueues() {

		/* create a queue and call it left */
		QueueReferenceBased left = new QueueReferenceBased();
		/* create a queue and call it right */
		QueueReferenceBased right = new QueueReferenceBased();
		/* populate the left queue with the values "A", "B", "C" (in this order) */
		left.enqueue("A");
		left.enqueue("B");
		left.enqueue("C");
		/* populate the right queue with the values "A", "B", "C" (in this order) */
		right.enqueue("A");
		right.enqueue("B");
		right.enqueue("C");

		if ( /* properly call the method equalQueuesAgain */equalQueues(left, right))
			System.out.println("Yes, they are equal.");
		else
			System.out.println("No, they are not equal.");

		System.out.println("Left Queue is:");
		while (!left.isEmpty())
			System.out.println(left.dequeue());

		System.out.println("Right Queue is:");
		while (!right.isEmpty())
			System.out.println(right.dequeue());
	}
};
