package main.game.style;

import static main.GameCore.panel;

import java.awt.Color;

public class Style
{

	public static final Runnable PANEL_STYLE=new Runnable()
	{
		@Override
		public void run()
		{
			panel.setBackground(Color.WHITE);		
		}
	};

}
