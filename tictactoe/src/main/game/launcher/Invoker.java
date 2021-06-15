package main.game.launcher;

import static main.game.launcher.Sequences.PRELAUNCH_SEQUENCE;

import java.lang.Thread.UncaughtExceptionHandler;
import main.commom.Assister;

public class Invoker
{
	public static Thread RELIEF;
	public static void invokeGame()
	{
		RELIEF=new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				while(true)
				{
			        Thread.setDefaultUncaughtExceptionHandler((UncaughtExceptionHandler) new UncaughtExceptionHandler()
					{
						
						@Override
						public void uncaughtException(Thread t, Throwable e)
						{
							Assister.ErrorReport(t, e);
						}
					});
				}
			}
		});
		PRELAUNCH_SEQUENCE.run();
		RELIEF.run();
	}

}
