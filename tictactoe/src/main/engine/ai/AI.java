package main.engine.ai;

import static java.awt.event.KeyEvent.*;


import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;

public class AI
{
	public static int AI_TERM;
	
	public static void runAI(final int[][] General) throws AWTException,SecurityException
	{
		Robot r=new Robot();
		boolean[][] open=new boolean[3][3];
		for (int i = 0; i < General.length; i++)
		{
			for (int j = 0; j < General[i].length; j++)
			{
				open[i][j]=General[i][j]==0;
			}
		}
		int keyToPress=getKeyAlt(AIDecisionMaker.findBestMove(General));
		r.keyPress(keyToPress);
		r.keyRelease(keyToPress);
	}
	
	private static int getKeyAlt(Dimension d)
	{
		if(d.height==-1& d.width==-1)
		{
			return -10;
		}
		return switch (d.height*3+d.width) 
				{
				case 0:
				{
					yield VK_7;
				}
				case 1:
				{
					yield VK_8;
				}
				case 2:
				{
					yield VK_9;
				}
				case 3:
				{
					yield VK_4;
				}
				case 4:
				{
					yield VK_5;
				}
				case 5:
				{
					yield VK_6;
				}
				case 6:
				{
					yield VK_1;
				}
				case 7:
				{
					yield VK_2;
				}
				case 8:
				{
					yield VK_3;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: ");
				};
	}
}
