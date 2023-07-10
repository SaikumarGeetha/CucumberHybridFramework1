package utils;

import java.util.Date;

public class CommonUtils 
{
	public static final int PAGE_LOAD_TIME=15;

	public static final int  IMPLICIT_TIME_OUT=10;
	public static String getEmailTimeStamp()
	{
		Date date=new Date();
		return "saikumar"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}
	


}
