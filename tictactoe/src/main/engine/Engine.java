package main.engine;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Engine
{
	public static JFrame thisInstanceFrame;
	public static int side;
	public JPanel Panel;
	public JLabel LT;
	public JLabel CT;
	public JLabel RT;
	public JLabel LC;
	public JLabel CC;
	public JLabel RC;
	public JLabel LB;
	public JLabel CB;
	public JLabel RB;
	
	public Engine(final JLabel[] ToBeUsed)
	{
		Panel=new JPanel(new GridLayout(3,3,4,4));
		if(ToBeUsed.length!=9)
		{
			//throw new IllegalArgumentException("ToBeUsed length is wrong");
		}
		for (int i = 0; i < ToBeUsed.length; i++)
		{
			switch (i)
			{
			case 0:
			{
				LT=ToBeUsed[i];
				break;
			}
			case 1:
			{
				CT=ToBeUsed[i];
				break;
			}
			case 2:
			{
				RT=ToBeUsed[i];
				break;
			}
			case 3:
			{
				LC=ToBeUsed[i];
				break;
			}
			case 4:
			{
				CC=ToBeUsed[i];
				break;
			}
			case 5:
			{
				RC=ToBeUsed[i];
				break;
			}
			case 6:
			{
				LB=ToBeUsed[i];
				break;
			}
			case 7:
			{
				CB=ToBeUsed[i];
				break;
			}
			case 8:
			{
				RB=ToBeUsed[i];
				break;
			}
			}
		}
		build();
	}
	
	private void build()
	{
		Panel.add(LT);
		Panel.add(CT);
		Panel.add(RT);
		Panel.add(LC);
		Panel.add(CC);
		Panel.add(RC);
		Panel.add(LB);
		Panel.add(CB);
		Panel.add(RB);
	}
	
	public JPanel getProduct()
	{
		return Panel;
	}
	

}
