package rough;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) 
	{
		Date d = new Date();
		String date = d.toString().replace(" ","_");
		
		String s = new SimpleDateFormat("dd_MM_dd_hh:mm:ss").format(d);
		
		System.out.println(date);

		System.out.println(s);
	}

}
