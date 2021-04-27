package main.game.style;

import static main.game.GameCore.GC;
import static main.game.GameCore.engine;
import static main.game.GameCore.panel;
import static main.game.launcher.Sequences.RESTART_SEQUENCE;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
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
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(engine.LT.getText() == Labels.NEUTRAL)
					{
						engine.LT.setOpaque(true);
						engine.LT.setBackground(GC.getColorFromSide());
						engine.LT.setText(GC.yieldLabel());
						engine.LT.setForeground(Color.WHITE);
						GC.commonOnMouseClick();
					}
				}
			});
			panel.getInputMap().put(KeyStroke.getKeyStroke('8'), "8");
			panel.getActionMap().put("8", new AbstractAction()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(engine.CT.getText() == Labels.NEUTRAL)
					{
						engine.CT.setOpaque(true);
						engine.CT.setBackground(GC.getColorFromSide());
						engine.CT.setText(GC.yieldLabel());
						engine.CT.setForeground(Color.WHITE);
						GC.commonOnMouseClick();
					}
				}
			});
			panel.getInputMap().put(KeyStroke.getKeyStroke('9'), "9");
			panel.getActionMap().put("9", new AbstractAction()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(engine.RT.getText() == Labels.NEUTRAL)
					{
						engine.RT.setOpaque(true);
						engine.RT.setBackground(GC.getColorFromSide());
						engine.RT.setText(GC.yieldLabel());
						engine.RT.setForeground(Color.WHITE);
						GC.commonOnMouseClick();			
					}
				}
			});
			panel.getInputMap().put(KeyStroke.getKeyStroke('4'), "4");
			panel.getActionMap().put("4", new AbstractAction()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(engine.LC.getText() == Labels.NEUTRAL)
					{
						engine.LC.setOpaque(true);
						engine.LC.setBackground(GC.getColorFromSide());
						engine.LC.setText(GC.yieldLabel());
						engine.LC.setForeground(Color.WHITE);
						GC.commonOnMouseClick();			
					}		
				}
			});
			panel.getInputMap().put(KeyStroke.getKeyStroke('5'), "5");
			panel.getActionMap().put("5", new AbstractAction()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(engine.CC.getText() == Labels.NEUTRAL)
					{
						engine.CC.setOpaque(true);
						engine.CC.setBackground(GC.getColorFromSide());
						engine.CC.setText(GC.yieldLabel());
						engine.CC.setForeground(Color.WHITE);
						GC.commonOnMouseClick();			
					}			
				}
			});
			panel.getInputMap().put(KeyStroke.getKeyStroke('6'), "6");
			panel.getActionMap().put("6", new AbstractAction()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(engine.RC.getText() == Labels.NEUTRAL)
					{
						engine.RC.setOpaque(true);
						engine.RC.setBackground(GC.getColorFromSide());
						engine.RC.setText(GC.yieldLabel());
						engine.RC.setForeground(Color.WHITE);
						GC.commonOnMouseClick();			
					}				
				}
			});
			panel.getInputMap().put(KeyStroke.getKeyStroke('1'), "1");
			panel.getActionMap().put("1", new AbstractAction()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(engine.LB.getText() == Labels.NEUTRAL)
					{
						engine.LB.setOpaque(true);
						engine.LB.setBackground(GC.getColorFromSide());
						engine.LB.setText(GC.yieldLabel());
						engine.LB.setForeground(Color.WHITE);
						GC.commonOnMouseClick();			
					}	
				}
			});
			panel.getInputMap().put(KeyStroke.getKeyStroke('2'), "2");
			panel.getActionMap().put("2", new AbstractAction()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(engine.CB.getText() == Labels.NEUTRAL)
					{
						engine.CB.setOpaque(true);
						engine.CB.setBackground(GC.getColorFromSide());
						engine.CB.setText(GC.yieldLabel());
						engine.CB.setForeground(Color.WHITE);
						GC.commonOnMouseClick();			
					}			
				}
			});
			panel.getInputMap().put(KeyStroke.getKeyStroke('3'), "3");
			panel.getActionMap().put("3", new AbstractAction()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(engine.RB.getText() == Labels.NEUTRAL)
					{
						engine.RB.setOpaque(true);
						engine.RB.setBackground(GC.getColorFromSide());
						engine.RB.setText(GC.yieldLabel());
						engine.RB.setForeground(Color.WHITE);
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
