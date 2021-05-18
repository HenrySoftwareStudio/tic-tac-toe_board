package main.game.style;

import static main.game.GameCore.GC;
import static main.game.GameCore.engine;
import static main.game.GameCore.panel;
import static main.game.GameCore.ENDED;
import static main.game.launcher.Sequences.RESTART_SEQUENCE;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

import main.engine.resources.Labels;

public class Style
{	
	public static final Runnable PANEL_STYLE=new Runnable()
	{
		@SuppressWarnings("serial")
		@Override
		public void run()
		{
			panel.setBackground(Color.WHITE);		
			panel.getInputMap().put(KeyStroke.getKeyStroke('7'), "7");
			panel.getActionMap().put("7", new AbstractAction()
			{
				private JLabel jLabel=engine.LT;
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(jLabel.getName() == Labels.NEUTRAL &!ENDED)
					{
						jLabel.setName(GC.yieldLabel());
						jLabel.setIcon(GC.yieldIcon(jLabel.getSize()));
						GC.commonOnMouseClick();
					}
				}
			});
			panel.getInputMap().put(KeyStroke.getKeyStroke('8'), "8");
			panel.getActionMap().put("8", new AbstractAction()
			{
				private JLabel jLabel=engine.CT;
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(jLabel.getName() == Labels.NEUTRAL &!ENDED)
					{
						jLabel.setName(GC.yieldLabel());
						jLabel.setIcon(GC.yieldIcon(jLabel.getSize()));
						GC.commonOnMouseClick();
					}
				}
			});
			panel.getInputMap().put(KeyStroke.getKeyStroke('9'), "9");
			panel.getActionMap().put("9", new AbstractAction()
			{
				private JLabel jLabel=engine.RT;
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(jLabel.getName() == Labels.NEUTRAL &!ENDED)
					{
						jLabel.setName(GC.yieldLabel());
						jLabel.setIcon(GC.yieldIcon(jLabel.getSize()));
						GC.commonOnMouseClick();
					}
				}
			});
			panel.getInputMap().put(KeyStroke.getKeyStroke('4'), "4");
			panel.getActionMap().put("4", new AbstractAction()
			{
				private JLabel jLabel=engine.LC;
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(jLabel.getName() == Labels.NEUTRAL &!ENDED)
					{
						jLabel.setName(GC.yieldLabel());
						jLabel.setIcon(GC.yieldIcon(jLabel.getSize()));
						GC.commonOnMouseClick();
					}	
				}
			});
			panel.getInputMap().put(KeyStroke.getKeyStroke('5'), "5");
			panel.getActionMap().put("5", new AbstractAction()
			{
				private JLabel jLabel=engine.CC;
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(jLabel.getName() == Labels.NEUTRAL &!ENDED)
					{
						jLabel.setName(GC.yieldLabel());
						jLabel.setIcon(GC.yieldIcon(jLabel.getSize()));
						GC.commonOnMouseClick();
					}		
				}
			});
			panel.getInputMap().put(KeyStroke.getKeyStroke('6'), "6");
			panel.getActionMap().put("6", new AbstractAction()
			{
				private JLabel jLabel=engine.RC;
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(jLabel.getName() == Labels.NEUTRAL &!ENDED)
					{
						jLabel.setName(GC.yieldLabel());
						jLabel.setIcon(GC.yieldIcon(jLabel.getSize()));
						GC.commonOnMouseClick();
					}			
				}
			});
			panel.getInputMap().put(KeyStroke.getKeyStroke('1'), "1");
			panel.getActionMap().put("1", new AbstractAction()
			{
				private JLabel jLabel=engine.LB;
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(jLabel.getName() == Labels.NEUTRAL &!ENDED)
					{
						jLabel.setName(GC.yieldLabel());
						jLabel.setIcon(GC.yieldIcon(jLabel.getSize()));
						GC.commonOnMouseClick();
					}
				}
			});
			panel.getInputMap().put(KeyStroke.getKeyStroke('2'), "2");
			panel.getActionMap().put("2", new AbstractAction()
			{
				private JLabel jLabel=engine.CB;
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(jLabel.getName() == Labels.NEUTRAL &!ENDED)
					{
						jLabel.setName(GC.yieldLabel());
						jLabel.setIcon(GC.yieldIcon(jLabel.getSize()));
						GC.commonOnMouseClick();
					}	
				}
			});
			panel.getInputMap().put(KeyStroke.getKeyStroke('3'), "3");
			panel.getActionMap().put("3", new AbstractAction()
			{
				private JLabel jLabel=engine.RB;
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(jLabel.getName() == Labels.NEUTRAL &!ENDED)
					{
						jLabel.setName(GC.yieldLabel());
						jLabel.setIcon(GC.yieldIcon(jLabel.getSize()));
						GC.commonOnMouseClick();
					}	
				}
			});
			panel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_F5,0), "F5");
			panel.getActionMap().put("F5", new AbstractAction()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					RESTART_SEQUENCE.run();
				}
			});
		}
	};

}
