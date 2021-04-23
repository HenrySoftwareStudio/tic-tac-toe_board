package main.game;

import static main.GameCore.GC;
import static main.GameCore.panel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import main.GameCore;
import main.engine.Engine;
import main.game.style.Style;

public class Sequences
{
	private static Dimension OldD;
	public static final Runnable LAUNCH_SEQUENCE=new Runnable()
	{
		
		@Override
		public void run()
		{
			JFrame frame=new JFrame("tic-tac-toe");
			JMenuBar jMenuBar=new JMenuBar();
			JMenu jMenu=new JMenu("Game");
			JMenuItem jMenuItem=new JMenuItem("Restart");
			jMenuItem.addActionListener(new ActionListener()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					RESTART_SEQUENCE.run();			
				}
			});
			jMenu.add(jMenuItem);
			jMenuBar.add(jMenu);
			frame.setJMenuBar(jMenuBar);
			frame.setMinimumSize((OldD==null)? new Dimension(100, 100):OldD);
			Engine tempEng= new Engine(new JLabel[] {GC.buildLT(),GC.buildCT(),GC.buildRT(),GC.buildLC(),GC.buildCC(),GC.buildRC(),GC.buildLB(),GC.buildCB(),GC.buildRB()});
			panel=tempEng.getProduct();
			Style.PANEL_STYLE.run();
			frame.add(GameCore.panel);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
			frame.setVisible(true);
			Engine.thisInstanceFrame=frame;
		}
	};
	
	public static final Runnable RESTART_SEQUENCE=new Runnable()
	{
		
		@Override
		public void run()
		{
			OldD=Engine.thisInstanceFrame.getSize();
			Engine.thisInstanceFrame.dispose();
			LAUNCH_SEQUENCE.run();
		}
	};
}
