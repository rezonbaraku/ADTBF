public class DisplayOctal
{
	public static void main(String [] args)
	{
		int decimalValue = 200;

		System.out.print("The octal value of the decimal number " + decimalValue + " is ");
		showOctalFromDecimal(decimalValue);
		System.out.println();
	}

	public static void showOctalFromDecimal( int n )
	{
		if ( n > 0 )
		{
			if ( n/8 > 0 )
				showOctalFromDecimal( n / 8 );
			System.out.print( n % 8 );
		}
	}
}