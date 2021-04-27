package main.engine.ai;

import static java.awt.event.KeyEvent.VK_1;
import static java.awt.event.KeyEvent.VK_2;
import static java.awt.event.KeyEvent.VK_3;
import static java.awt.event.KeyEvent.VK_4;
import static java.awt.event.KeyEvent.VK_5;
import static java.awt.event.KeyEvent.VK_6;
import static java.awt.event.KeyEvent.VK_7;
import static java.awt.event.KeyEvent.VK_8;
import static java.awt.event.KeyEvent.VK_9;
import static java.awt.event.KeyEvent.VK_AT;

import java.awt.AWTException;
import java.awt.Robot;

public class AI
{
	public static void runAI(final int[][] General, final int[][] RED, final int[][] BLUE) throws AWTException
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
		int keyToPress=getKey(General, RED, BLUE);
		r.keyPress(keyToPress);
		r.keyRelease(keyToPress);
	}
	
	private static int getKey(final int[][] General, final int[][] RED, final int[][] BLUE)
	{
		for (int i = 0; i < General.length; i++)
		{
			for (int j = 0; j < General[i].length; j++)
			{
				if (General[i][j]==0)
				{
					int loca = (i*3+j);
					return switch (loca)
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
						throw new IllegalArgumentException("Unexpected value: " + loca);
					};
				}
			}
		}
		return VK_AT;
	}
}
