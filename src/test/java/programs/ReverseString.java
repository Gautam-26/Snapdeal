package programs;

public class ReverseString {

	public static void main(String[] args) 
	{
		String name = "Gautam";
		char[] ch = name.toCharArray();
		String rev = "";
		for(int i=ch.length-1; i>=0; i--)
		{
			rev+=name.charAt(i);
		}

		
		System.out.println(rev);
	}

}
