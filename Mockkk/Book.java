public class Book implements Comparable<Book>
{
	private int isbn;
	private String title;

	public Book(int x, String y) {
		isbn = x;
		title = y;
	}

	public void setIsbn(int x) {
		isbn = x;
	}

	public void setTitle(String x) {
		title = x;
	}

	public int getIsbn() {
		return isbn;
	}

	public String setTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "ISBN: " + isbn + " Title: " + title ;
	}

	@Override
	public int compareTo(Book x) {
		if ( this.isbn<x.getIsbn() )
			return -1;
		else if ( this.isbn>x.getIsbn() )
			return 1;
		else
			return 0;
	}
};