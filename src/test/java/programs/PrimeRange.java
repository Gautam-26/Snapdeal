package programs;

import java.util.Scanner;

public class PrimeRange {

	public static void main(String[] args) 
	{

		Scanner s = new Scanner(System.in);
		System.out.println("Enter the start Range");
		int start = s.nextInt();

		System.out.println("Enter the end Range");
		int end = s.nextInt();

		boolean flag = false;

		while(start < end)
		{
			for(int i=2; i <=start/2; i++)
			{
				if(start % i ==0)
				{
					flag = true;
					System.out.println(start+" is not a Prime");
					break;
				}
				else if(i == start/2)
				{
					System.out.println(start+" is Prime");
				}
			}

			start++;


		}

	}

}
