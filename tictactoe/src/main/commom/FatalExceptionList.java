package main.commom;

import java.awt.AWTException;

public class FatalExceptionList
{
	@SuppressWarnings("rawtypes")
	public static final Class[] FatalExceptions= {AWTException.class, SecurityException.class, NullPointerException.class};
	
	public static final boolean isFatalException(Throwable e)
	{
		for (Class<?> classLookingAt : FatalExceptions)
		{
			if(e.getClass()==classLookingAt)
			{
				return true;
			}
		}
		return false;
	}
}
