package main.game.launcher;

import static main.game.GameCore.GC;
import static main.game.GameCore.engine;
import static main.game.GameCore.panel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import main.engine.Engine;
import main.engine.resources.Labels;
import main.game.GameCore;
import main.game.style.Style;

public class Sequences
{
	private static Dimension OldD;
	public static boolean AIenabled;
	public static final Runnable PRELAUCH_SEQUENCE=new Runnable()
	{
		
		@Override
		public void run()
		{
			VARABLE_INITIALIZER_SEQUENCE.run();
			JPanel jPanel=new JPanel(new GridLayout(1,2));
			ButtonGroup buttonGroup=new ButtonGroup();
			JPanel subJPanel=new JPanel(new GridLayout(2, 1));
			JRadioButton buttonAI=new JRadioButton("play against AI");
			buttonAI.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					AIenabled=true;				
				}
			});
			JRadioButton buttonP=new JRadioButton("play against human");
			buttonP.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					AIenabled=false;				
				}
			});
			buttonGroup.add(buttonAI);
			buttonGroup.add(buttonP);
			buttonAI.setSelected(true);
			subJPanel.add(buttonAI);
			subJPanel.add(buttonP);
			jPanel.add(subJPanel);
			JOptionPane.showInternalMessageDialog(null, jPanel, "Select mode", JOptionPane.QUESTION_MESSAGE);
			JPanel jPanel2=new JPanel(new GridLayout(1,2));
			ButtonGroup buttonGroup2=new ButtonGroup();
			JPanel subJPanel2=new JPanel(new GridLayout(2, 1));
			JRadioButton buttonRed=new JRadioButton("Start round as red");
			buttonAI.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					Engine.side=Labels.RED_ID;			
				}
			});
			JRadioButton buttonBlue=new JRadioButton("Start round as blue");
			buttonBlue.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					Engine.side=Labels.BLUE_ID;					
				}
			});
			buttonGroup2.add(buttonRed);
			buttonGroup2.add(buttonBlue);
			buttonRed.setSelected(true);
			subJPanel2.add(buttonRed);
			subJPanel2.add(buttonBlue);
			jPanel2.add(subJPanel2);
			JOptionPane.showInternalMessageDialog(null, jPanel2, "Select mode", JOptionPane.QUESTION_MESSAGE);
			LAUNCH_SEQUENCE.run();
		}
	};
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
			JLabel[] toBeUsed = new JLabel[] {GC.buildLT(),GC.buildCT(),GC.buildRT(),GC.buildLC(),GC.buildCC(),GC.buildRC(),GC.buildLB(),GC.buildCB(),GC.buildRB()};
			Engine tempEng= new Engine(toBeUsed);
			engine=tempEng;
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
			PRELAUCH_SEQUENCE.run();
		}
	};
	
	public static final Runnable VARABLE_INITIALIZER_SEQUENCE=new Runnable()
	{
		public void run()
		{
			Engine.side=Labels.RED_ID;
			AIenabled=true;
		}
	};
}
