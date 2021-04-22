package main;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import main.engine.Engine;
import main.engine.resources.Labels;

public class GameCore extends GameInterface
{
	public static final GameCore GC=new GameCore();
	public static JPanel panel;
	@Override
	public JLabel buildLT()
	{
		JLabel jLabel=new JLabel(Labels.NEUTRAL);
		jLabel.setOpaque(false);
		jLabel.setName("LT");
		jLabel.setBorder(new LineBorder(Color.BLACK));
		jLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource()==jLabel & jLabel.getText() == Labels.NEUTRAL)
				{
					jLabel.setOpaque(true);
					jLabel.setBackground(getColorFromSide());
					jLabel.setText(yieldLabel());
					jLabel.setForeground(Color.WHITE);
					commonOnMouseClick();
				}
			}
		});
		return jLabel;
	}

	@Override
	public JLabel buildCT()
	{
		JLabel jLabel=new JLabel(Labels.NEUTRAL);
		jLabel.setOpaque(false);
		jLabel.setName("CT");
		jLabel.setBorder(new LineBorder(Color.BLACK));
		jLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource()==jLabel & jLabel.getText() == Labels.NEUTRAL)
				{
					jLabel.setOpaque(true);
					jLabel.setBackground(getColorFromSide());
					jLabel.setText(yieldLabel());
					jLabel.setForeground(Color.WHITE);
					commonOnMouseClick();
				}
			}
		});
		return jLabel;
	}

	@Override
	public JLabel buildRT()
	{
		JLabel jLabel=new JLabel(Labels.NEUTRAL);
		jLabel.setOpaque(false);
		jLabel.setName("RT");
		jLabel.setBorder(new LineBorder(Color.BLACK));
		jLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource()==jLabel & jLabel.getText() == Labels.NEUTRAL)
				{
					jLabel.setOpaque(true);
					jLabel.setBackground(getColorFromSide());
					jLabel.setForeground(Color.WHITE);
					jLabel.setText(yieldLabel());
					commonOnMouseClick();
				}
			}
		});
		return jLabel;
	}

	@Override
	public JLabel buildLC()
	{
		JLabel jLabel=new JLabel(Labels.NEUTRAL);
		jLabel.setOpaque(false);
		jLabel.setName("LC");
		jLabel.setBorder(new LineBorder(Color.BLACK));
		jLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource()==jLabel & jLabel.getText() == Labels.NEUTRAL)
				{
					jLabel.setOpaque(true);
					jLabel.setBackground(getColorFromSide());
					jLabel.setForeground(Color.WHITE);
					jLabel.setText(yieldLabel());
					commonOnMouseClick();
				}
			}
		});
		return jLabel;
	}

	@Override
	public JLabel buildCC()
	{
		JLabel jLabel=new JLabel(Labels.NEUTRAL);
		jLabel.setOpaque(false);
		jLabel.setName("CC");
		jLabel.setBorder(new LineBorder(Color.BLACK));
		jLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource()==jLabel & jLabel.getText() == Labels.NEUTRAL)
				{
					jLabel.setOpaque(true);
					jLabel.setBackground(getColorFromSide());
					jLabel.setText(yieldLabel());
					jLabel.setForeground(Color.WHITE);
					commonOnMouseClick();
				}
			}
		});
		return jLabel;
	}

	@Override
	public JLabel buildRC()
	{
		JLabel jLabel=new JLabel(Labels.NEUTRAL);
		jLabel.setOpaque(false);
		jLabel.setName("RC");
		jLabel.setBorder(new LineBorder(Color.BLACK));
		jLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource()==jLabel & jLabel.getText() == Labels.NEUTRAL)
				{
					jLabel.setOpaque(true);
					jLabel.setBackground(getColorFromSide());
					jLabel.setText(yieldLabel());
					jLabel.setForeground(Color.WHITE);
					commonOnMouseClick();
				}
			}
		});
		return jLabel;
	}

	@Override
	public JLabel buildLB()
	{
		JLabel jLabel=new JLabel(Labels.NEUTRAL);
		jLabel.setOpaque(false);
		jLabel.setName("LB");
		jLabel.setBorder(new LineBorder(Color.BLACK));
		jLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource()==jLabel & jLabel.getText() == Labels.NEUTRAL)
				{
					jLabel.setOpaque(true);
					jLabel.setBackground(getColorFromSide());
					jLabel.setText(yieldLabel());
					jLabel.setForeground(Color.WHITE);
					commonOnMouseClick();
				}
			}
		});
		return jLabel;
	}

	@Override
	public JLabel buildCB()
	{
		JLabel jLabel=new JLabel(Labels.NEUTRAL);
		jLabel.setOpaque(false);
		jLabel.setName("CB");
		jLabel.setBorder(new LineBorder(Color.BLACK));
		jLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource()==jLabel & jLabel.getText() == Labels.NEUTRAL)
				{
					jLabel.setOpaque(true);
					jLabel.setBackground(getColorFromSide());
					jLabel.setText(yieldLabel());
					jLabel.setForeground(Color.WHITE);
					commonOnMouseClick();
				}
			}
		});
		return jLabel;
	}

	@Override
	public JLabel buildRB()
	{
		JLabel jLabel=new JLabel(Labels.NEUTRAL);
		jLabel.setOpaque(false);
		jLabel.setName("RB");
		jLabel.setBorder(new LineBorder(Color.BLACK));
		jLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource()==jLabel & jLabel.getText() == Labels.NEUTRAL)
				{
					jLabel.setOpaque(true);
					jLabel.setBackground(getColorFromSide());
					jLabel.setForeground(Color.WHITE);
					jLabel.setText(yieldLabel());
					commonOnMouseClick();
				}
			}
		});
		return jLabel;
	}

	@Override
	public void commonOnMouseClick()
	{
		Engine.side *= -1;
		Component[] components=panel.getComponents();
		ArrayList<String> text= new ArrayList<>();
		for (int i = 0; i < components.length; i++)
		{
			JLabel jLabel=(JLabel)components[i];
			text.add(jLabel.getText());
		}
		if(text.lastIndexOf(Labels.NEUTRAL)==-1)
		{
			JOptionPane.showMessageDialog(null, "Round Finished");
		}
		JLabel[][] mapps=new JLabel[3][3];
		for(int i=0; i<3;i++)
			   for(int j=0;j<3;j++)
			       mapps[i][j] = (JLabel) components[(i*3) + j]; 
		int[][] sharedMap=getMap(mapps);
		getBlueMap(sharedMap);
		getRedMap(sharedMap);
		panel.repaint();
	}

	@Override
	public String yieldLabel()
	{
		return switch (Engine.side)
		{
		case Labels.BLUE_ID:
		{
			yield Labels.BLUE;
		}
		case Labels.RED_ID:
		{
			yield Labels.RED;
		}
		default:
			//this should never happen
			throw new IllegalArgumentException("Unexpected value: " + Engine.side);
		};
	}

	@Override
	public int[][] getMap(final JLabel[][] Org)
	{
		int[][] map=new int[3][3];
		for(int i=0; i<Org.length; i++)
		{
			for (int j = 0; j < Org[i].length; j++)
			{
				map[i][j]=stringNameToIntValue(Org[i][j].getText());
			}
		}
		return map;
	}

	@Override
	public int stringNameToIntValue(final String Name)
	{
		if(Name.equals(Labels.RED))
		{
			return Labels.RED_ID;
		}
		else if (Name.equals(Labels.BLUE)) 
		{
			return Labels.BLUE_ID;
		}
		else
		{
			return Labels.NEUTRAL_ID;
		}
	}

	@Override
	public Color getColorFromSide()
	{
		return switch (Engine.side)
		{
		case Labels.BLUE_ID:
		{
			yield Labels.BLUE_COLOR;
		}
		case Labels.RED_ID:
		{
			yield Labels.RED_COLOR;
		}
		default:
			//this should never happen
			throw new IllegalArgumentException("Unexpected value: " + Engine.side);
		};
	}

	@Override
	public int[][] getRedMap(final int[][] publicMap)
	{
		int[][] outputMap=new int[3][3];
		for (int i = 0; i < publicMap.length; i++)
		{
			for (int j = 0; j < publicMap[i].length; j++)
			{
				outputMap[i][j]=(publicMap[i][j]==Labels.RED_ID)? 1:0;				
			}
		}
		return outputMap;
	}

	@Override
	public int[][] getBlueMap(final int[][] publicMap)
	{
		int[][] outputMap=new int[3][3];
		for (int i = 0; i < publicMap.length; i++)
		{
			for (int j = 0; j < publicMap[i].length; j++)
			{
				outputMap[i][j]=(publicMap[i][j]==Labels.BLUE_ID)? 1:0;				
			}
		}
		return outputMap;
	}
}
