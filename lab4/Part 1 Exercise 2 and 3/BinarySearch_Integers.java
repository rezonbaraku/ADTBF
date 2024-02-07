// Note: java -Xms32m -Xmx128m BinarySearch_Integers
// Searches the array items anArray[first] through anArray[last] for value by using a binary search.
// Precondition: 0 <= first, last <= SIZE-1, where SIZE is the maximum size of the array, and
// anArray[first] <= anArray[first+1] <= ... <= anArray[last].
// Postcondition: If value is in the array, the method returns the index of the array item that
// equals value; otherwise the method returns -1.

public class BinarySearch_Integers
{
	public static void main(String [] args)
	{
		int arraySize = 13000000;
		int [] integerArray = new int[arraySize];
		int indexOfElement;
		int element = 9565345;
		long timeBefore, timeAfter, ellapsedTimeInMills;
		double ellapsedTimeInSecs;

		System.out.println("Filling the arrray with " + arraySize + " values. Please wait ...");
		timeBefore = System.currentTimeMillis();				  // Get the current time

		for (int i=0; i<arraySize; i++)
			integerArray[i] = i;

		timeAfter = System.currentTimeMillis();					  // Get the current time
		ellapsedTimeInSecs = (double)(timeAfter-timeBefore)/1000; // Calculate the ellapsed time in seconds
		ellapsedTimeInMills = (timeAfter-timeBefore);			  // Calculate the ellapsed time in milliseconds
		System.out.println("It took " + ellapsedTimeInSecs + " secs or " + ellapsedTimeInMills + " milisecs to fill in the array with values.\n");

		System.out.println("Sequentially search for the element " + element + " in the array. Please wait ...");
		timeBefore = System.currentTimeMillis();				  // Get the current time

		indexOfElement = sequentialSearch(integerArray, arraySize, element);

		timeAfter = System.currentTimeMillis();					  // Get the current time
		ellapsedTimeInSecs = (double)(timeAfter-timeBefore)/1000; // Calculate the ellapsed time in seconds
		ellapsedTimeInMills = (timeAfter-timeBefore);			  // Calculate the ellapsed time in milliseconds

		if (indexOfElement == -1)
			System.out.println("It took " + ellapsedTimeInSecs + " secs or " + ellapsedTimeInMills + " milisecs to determine that the value " + element + " is not in the array.");
		else
			System.out.println("It took " + ellapsedTimeInSecs + " secs or " + ellapsedTimeInMills + " milisecs to find that the value " + element + " exists in location " + indexOfElement);

		System.out.println("\nBinary searching for the element " + element + " in the array. Please wait ...");
		timeBefore = System.currentTimeMillis();				  // Get the current time

		indexOfElement = binarySearch(integerArray, 0, arraySize, element);

		timeAfter = System.currentTimeMillis();					  // Get the current time
		ellapsedTimeInSecs = (double)(timeAfter-timeBefore)/1000; // Calculate the ellapsed time in seconds
		ellapsedTimeInMills = (timeAfter-timeBefore);			  // Calculate the ellapsed time in milliseconds

		if (indexOfElement == -1)
			System.out.println("It took " + ellapsedTimeInSecs + " secs or " + ellapsedTimeInMills + " milisecs to determine that the value " + element + " is not in the array.\n");
		else
			System.out.println("It took " + ellapsedTimeInSecs + " secs or " + ellapsedTimeInMills + " milisecs to find that the value " + element + " exists in location " + indexOfElement + ".\n");
	}

	public static int binarySearch(int anArray[], int first, int last, int value)
	{
		int index;
		if (first > last)     // value not in original array
			index = -1;
		else				  // If value is in anArray, anArray[first]<=value<=anArray[last]
		{
			int mid = (first + last)/2;
			if (value == anArray[mid])
				index = mid;  // value found at anArray[mid]
			else if (value < anArray[mid])
				index = binarySearch(anArray,first,mid-1, value);
			else
				index = binarySearch(anArray,mid+1,last,value);
		}
		return index;
	}

	public static int sequentialSearch(int anArray[], int arraySize, int element)
	{
		int index = -1;

		for (int i=0; i<arraySize; i++)
		{
			if (anArray[i] == element)
			{
				index = i;
				break;
			}
		}
		return index;
	}
}