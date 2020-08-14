package programs;

import java.util.Scanner;

public class Fibonocci {

	public static void main(String[] args) 
	{
	
		int a=0,b=1;
		int num=0;
		System.out.println("Enter up to which value");
		Scanner s = new Scanner(System.in);
		num = s.nextInt();
		
		System.out.print(a+" ");
		System.out.print(b+" ");
		int c=a+b;
		
		while(c < num)
		{
			System.out.print(c+" ");
			a=b;
			b=c;
			c=a+b;
		}
		
		
		
	}

}
