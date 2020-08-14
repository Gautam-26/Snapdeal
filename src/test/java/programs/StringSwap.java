package programs;

public class StringSwap {

	public static void main(String[] args) 
	{
		String name = "Gautam Varma";
		
		String[] names = name.split(" ");
		int len = names.length;
		
		String rev = "";
		
		
		for(int i=len-1; i>=0; i--)
		{
			rev+=names[i]+" ";
		}

		System.out.println(rev);
	}

}
