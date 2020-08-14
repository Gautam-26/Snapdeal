package programs;

import java.util.ArrayList;
import java.util.List;

public class MergeArray {

	public static void main(String[] args) 
	{
		int[] arr1 = {12,24,36,48,60,72};
		int[] arr2 = {6,18,24,30,42,45,50,66};

		List<Integer> list = new ArrayList<>();

		int p1 = 0;
		int p2 = 0;


		while(p1 < arr1.length && p2 < arr2.length)
		{
			if(arr1[p1] < arr2[p2])
			{
				list.add(arr1[p1]);
				p1++;

			}
			else if(arr1[p1] >= arr2[p2])
			{
				list.add(arr2[p2]);
				p2++;
			}
		}
		
		while(p1 < arr1.length)
		{
			list.add(arr1[p1]);
			p1++;
		}
		
		while(p2 < arr2.length)
		{
			list.add(arr2[p2]);
			p2++;
		}
		
		for(int i : list)
			System.out.print(i+" ");


	}

}
