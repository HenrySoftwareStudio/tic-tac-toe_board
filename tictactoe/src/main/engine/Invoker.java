package main.engine;

import javax.swing.JFrame;
import javax.swing.JLabel;

import main.GameCore;
import main.game.style.Style;
import static main.GameCore.panel;

import java.awt.Dimension;

import static main.GameCore.GC;

public class Invoker
{
	public static void invokeGame()
	{
		JFrame frame=new JFrame("tic-tac-toe");
		frame.setMinimumSize(new Dimension(100, 100));
		start();
		frame.add(GameCore.panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		frame.setVisible(true);
	}
	
	private static void start()
	{
		Engine tempEng= new Engine(new JLabel[] {GC.buildLT(),GC.buildCT(),GC.buildRT(),GC.buildLC(),GC.buildCC(),GC.buildRC(),GC.buildLB(),GC.buildCB(),GC.buildRB()});
		panel=tempEng.getProduct();
		Style.PANEL_STYLE.run();
	}

}
