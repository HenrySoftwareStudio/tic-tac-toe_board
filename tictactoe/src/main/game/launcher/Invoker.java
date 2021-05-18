package main.game.launcher;

import static main.game.launcher.Sequences.PRELAUCH_SEQUENCE;

import java.lang.Thread.UncaughtExceptionHandler;
import javax.swing.JOptionPane;

import main.commom.Assister;
import main.commom.FatalExceptionList;

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
							JOptionPane.showInternalMessageDialog(null,t.toString()+
									", had an exception,this may be fatal,\ndetails:\n"+Assister.getExceptionWholeMessage(e),"ERROR",JOptionPane.ERROR_MESSAGE);
							if(FatalExceptionList.isFatalException(e))
							{
								System.exit(e.hashCode());
							}
						}
					});
				}
			}
		});
		PRELAUCH_SEQUENCE.run();
		RELIEF.run();
	}

}
