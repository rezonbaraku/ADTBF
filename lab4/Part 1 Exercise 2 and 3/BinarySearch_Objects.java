public class RecursiveMethods {
  /** Recursive binary search method (in RecursiveMethods.java).
      @param items The array being searched
      @param target The object being searched for
      @param first The subscript of the first element
      @param last The subscript of the last element
      @return The subscript of target if found; otherwise -1.
   */
  private static int binarySearch(Object[] items, Comparable target,
                                  int first, int last) {
    int middle = (first + last) / 2; // index for next probe
    if (first > last)
      return -1; // base case for unsuccessful search
    else {
      int compResult = target.compareTo(items[middle]);
      if (compResult == 0)
        return middle; // base case for successful search
      else if (compResult < 0)
        return binarySearch(items, target, first, middle - 1);
      else
        return binarySearch(items, target, middle + 1, last);
    }
  }

  /** Wrapper for recursive binary search method (in RecursiveMethods.java).
      @param items The array being searched
      @param target The object being searched for
      @return The subscript of target if found; otherwise -1.
   */
  public static int binarySearch(Object[] items, Comparable target) {
    return binarySearch(items, target, 0, items.length - 1);
  }
