package main.game;

import static main.game.launcher.Sequences.borderEnabled;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import main.commom.Assister;
import main.commom.FatalExceptionList;
import main.engine.Engine;
import main.engine.ai.AI;
import main.engine.resources.Labels;
import main.engine.rule.RuleChecker;
import main.game.launcher.Sequences;


public class GameCore extends GameInterface
{
	public static int[] map= {Labels.NEUTRAL_ID,Labels.NEUTRAL_ID,Labels.NEUTRAL_ID,
			Labels.NEUTRAL_ID,Labels.NEUTRAL_ID,Labels.NEUTRAL_ID,Labels.NEUTRAL_ID
			,Labels.NEUTRAL_ID,Labels.NEUTRAL_ID};
	public static Dimension InitDimension;
	public static boolean ENDED=false;
	public static Engine engine;
	public static final GameCore GC=new GameCore();
	public static JPanel panel;
	public static int round=0;
	public static RuleChecker RULE_CHECKER=new RuleChecker();
	@Override
	public JLabel buildCB()
	{
		JLabel jLabel=new JLabel();
		jLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		jLabel.setAlignmentY(JLabel.CENTER_ALIGNMENT);
		jLabel.setOpaque(true);
		jLabel.setName(Assister.AutoStringOnBuild(1,0));
		jLabel.setIcon(Assister.AutoIconOnBuild(1,0));
		if(borderEnabled)
		{
			jLabel.setBorder(new LineBorder(Color.BLACK));
		}
		jLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource()==jLabel & jLabel.getName() == Labels.NEUTRAL)
				{
					jLabel.setName(yieldLabel());
					jLabel.setIcon(yieldIcon(jLabel.getSize()));
					commonOnMouseClick(1,0);
				}
			}
		});
		jLabel.addComponentListener(new ComponentListener()
		{
			
			@Override
			public void componentShown(ComponentEvent e){}
			
			@Override
			public void componentResized(ComponentEvent e)
			{
				BufferedImage currentIcon=switch (jLabel.getName())
				{
				case Labels.NEUTRAL:
				{
					yield Labels.NeutralIcon;
				}
				case Labels.RED:
				{
					yield Labels.RedIcon;
				}
				case Labels.BLUE:
				{
					yield Labels.BlueIcon;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + jLabel.getName());
				};
				jLabel.setIcon(Assister.iconMaker(currentIcon, jLabel.getSize()));
				jLabel.revalidate();
				jLabel.repaint();
			}
			
			@Override
			public void componentMoved(ComponentEvent e){}
			
			@Override
			public void componentHidden(ComponentEvent e){}
		});
		return jLabel;
	}

	@Override
	public JLabel buildCC()
	{
		JLabel jLabel=new JLabel();
		jLabel.setOpaque(true);
		jLabel.setName(Assister.AutoStringOnBuild(1,1));
		jLabel.setIcon(Assister.AutoIconOnBuild(1,1));
		if(borderEnabled)
		{
			jLabel.setBorder(new LineBorder(Color.BLACK));
		}
		jLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource()==jLabel & jLabel.getName() == Labels.NEUTRAL)
				{
					jLabel.setName(yieldLabel());
					jLabel.setIcon(yieldIcon(jLabel.getSize()));
					commonOnMouseClick(1,1);
				}
			}
		});
		jLabel.addComponentListener(new ComponentListener()
		{
			
			@Override
			public void componentShown(ComponentEvent e){}
			
			@Override
			public void componentResized(ComponentEvent e)
			{
				BufferedImage currentIcon=switch (jLabel.getName())
				{
				case Labels.NEUTRAL:
				{
					yield Labels.NeutralIcon;
				}
				case Labels.RED:
				{
					yield Labels.RedIcon;
				}
				case Labels.BLUE:
				{
					yield Labels.BlueIcon;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + jLabel.getName());
				};
				jLabel.setIcon(Assister.iconMaker(currentIcon, jLabel.getSize()));
				jLabel.revalidate();
				jLabel.repaint();
			}
			
			@Override
			public void componentMoved(ComponentEvent e){}
			
			@Override
			public void componentHidden(ComponentEvent e){}
		});
		return jLabel;
	}

	@Override
	public JLabel buildCT()
	{
		JLabel jLabel=new JLabel();
		jLabel.setOpaque(true);
		jLabel.setName(Assister.AutoStringOnBuild(1,2));
		jLabel.setIcon(Assister.AutoIconOnBuild(1,2));
		if(borderEnabled)
		{
			jLabel.setBorder(new LineBorder(Color.BLACK));
		}
		jLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource()==jLabel & jLabel.getName() == Labels.NEUTRAL)
				{
					jLabel.setName(yieldLabel());
					jLabel.setIcon(yieldIcon(jLabel.getSize()));
					commonOnMouseClick(1,2);
				}
			}
		});
		jLabel.addComponentListener(new ComponentListener()
		{
			
			@Override
			public void componentShown(ComponentEvent e){}
			
			@Override
			public void componentResized(ComponentEvent e)
			{
				BufferedImage currentIcon=switch (jLabel.getName())
				{
				case Labels.NEUTRAL:
				{
					yield Labels.NeutralIcon;
				}
				case Labels.RED:
				{
					yield Labels.RedIcon;
				}
				case Labels.BLUE:
				{
					yield Labels.BlueIcon;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + jLabel.getName());
				};
				jLabel.setIcon(Assister.iconMaker(currentIcon, jLabel.getSize()));
				jLabel.revalidate();
				jLabel.repaint();
			}
			
			@Override
			public void componentMoved(ComponentEvent e){}
			
			@Override
			public void componentHidden(ComponentEvent e){}
		});
		return jLabel;
	}

	@Override
	public JLabel buildLB()
	{
		JLabel jLabel=new JLabel();
		jLabel.setOpaque(true);
		jLabel.setName(Assister.AutoStringOnBuild(0,0));
		jLabel.setIcon(Assister.AutoIconOnBuild(0,0));
		if(borderEnabled)
		{
			jLabel.setBorder(new LineBorder(Color.BLACK));
		}
		jLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource()==jLabel & jLabel.getName() == Labels.NEUTRAL)
				{
					jLabel.setName(yieldLabel());
					jLabel.setIcon(yieldIcon(jLabel.getSize()));
					commonOnMouseClick(0,0);
				}
			}
		});
		jLabel.addComponentListener(new ComponentListener()
		{
			
			@Override
			public void componentShown(ComponentEvent e){}
			
			@Override
			public void componentResized(ComponentEvent e)
			{
				BufferedImage currentIcon=switch (jLabel.getName())
				{
				case Labels.NEUTRAL:
				{
					yield Labels.NeutralIcon;
				}
				case Labels.RED:
				{
					yield Labels.RedIcon;
				}
				case Labels.BLUE:
				{
					yield Labels.BlueIcon;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + jLabel.getName());
				};
				jLabel.setIcon(Assister.iconMaker(currentIcon, jLabel.getSize()));
				jLabel.revalidate();
				jLabel.repaint();
			}
			
			@Override
			public void componentMoved(ComponentEvent e){}
			
			@Override
			public void componentHidden(ComponentEvent e){}
		});
		return jLabel;
	}

	@Override
	public JLabel buildLC()
	{
		JLabel jLabel=new JLabel();
		jLabel.setOpaque(true);
		jLabel.setName(Assister.AutoStringOnBuild(0,1));
		jLabel.setIcon(Assister.AutoIconOnBuild(0,1));
		if(borderEnabled)
		{
			jLabel.setBorder(new LineBorder(Color.BLACK));
		}
		jLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource()==jLabel & jLabel.getName() == Labels.NEUTRAL)
				{
					jLabel.setName(yieldLabel());
					jLabel.setIcon(yieldIcon(jLabel.getSize()));
					commonOnMouseClick(0,1);
				}
			}
		});
		jLabel.addComponentListener(new ComponentListener()
		{
			
			@Override
			public void componentShown(ComponentEvent e){}
			
			@Override
			public void componentResized(ComponentEvent e)
			{
				BufferedImage currentIcon=switch (jLabel.getName())
				{
				case Labels.NEUTRAL:
				{
					yield Labels.NeutralIcon;
				}
				case Labels.RED:
				{
					yield Labels.RedIcon;
				}
				case Labels.BLUE:
				{
					yield Labels.BlueIcon;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + jLabel.getName());
				};
				jLabel.setIcon(Assister.iconMaker(currentIcon, jLabel.getSize()));
				jLabel.revalidate();
				jLabel.repaint();
			}
			
			@Override
			public void componentMoved(ComponentEvent e){}
			
			@Override
			public void componentHidden(ComponentEvent e){}
		});
		return jLabel;
	}

	@Override
	public JLabel buildLT()
	{
		JLabel jLabel=new JLabel();
		jLabel.setOpaque(true);
		jLabel.setName(Assister.AutoStringOnBuild(0,2));
		jLabel.setIcon(Assister.AutoIconOnBuild(0,2));
		if(borderEnabled)
		{
			jLabel.setBorder(new LineBorder(Color.BLACK));
		}
		jLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource()==jLabel & jLabel.getName() == Labels.NEUTRAL)
				{
					jLabel.setName(yieldLabel());
					jLabel.setIcon(yieldIcon(jLabel.getSize()));
					commonOnMouseClick(0,2);
				}
			}
		});
		jLabel.addComponentListener(new ComponentListener()
		{
			
			@Override
			public void componentShown(ComponentEvent e){}
			
			@Override
			public void componentResized(ComponentEvent e)
			{
				BufferedImage currentIcon=switch (jLabel.getName())
				{
				case Labels.NEUTRAL:
				{
					yield Labels.NeutralIcon;
				}
				case Labels.RED:
				{
					yield Labels.RedIcon;
				}
				case Labels.BLUE:
				{
					yield Labels.BlueIcon;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + jLabel.getName());
				};
				jLabel.setIcon(Assister.iconMaker(currentIcon, jLabel.getSize()));
				jLabel.revalidate();
				jLabel.repaint();
			}
			
			@Override
			public void componentMoved(ComponentEvent e){}
			
			@Override
			public void componentHidden(ComponentEvent e){}
		});
		return jLabel;
	}

	@Override
	public JLabel buildRB()
	{
		JLabel jLabel=new JLabel();
		jLabel.setOpaque(true);
		jLabel.setName(Assister.AutoStringOnBuild(2,0));
		jLabel.setIcon(Assister.AutoIconOnBuild(2,0));
		if(borderEnabled)
		{
			jLabel.setBorder(new LineBorder(Color.BLACK));
		}
		jLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource()==jLabel & jLabel.getName() == Labels.NEUTRAL)
				{
					jLabel.setName(yieldLabel());
					jLabel.setIcon(yieldIcon(jLabel.getSize()));
					commonOnMouseClick(2,0);
				}
			}
		});
		jLabel.addComponentListener(new ComponentListener()
		{
			
			@Override
			public void componentShown(ComponentEvent e){}
			
			@Override
			public void componentResized(ComponentEvent e)
			{
				BufferedImage currentIcon=switch (jLabel.getName())
				{
				case Labels.NEUTRAL:
				{
					yield Labels.NeutralIcon;
				}
				case Labels.RED:
				{
					yield Labels.RedIcon;
				}
				case Labels.BLUE:
				{
					yield Labels.BlueIcon;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + jLabel.getName());
				};
				jLabel.setIcon(Assister.iconMaker(currentIcon, jLabel.getSize()));
				jLabel.revalidate();
				jLabel.repaint();
			}
			
			@Override
			public void componentMoved(ComponentEvent e){}
			
			@Override
			public void componentHidden(ComponentEvent e){}
		});
		return jLabel;
	}

	@Override
	public JLabel buildRC()
	{
		JLabel jLabel=new JLabel();
		jLabel.setOpaque(true);
		jLabel.setName(Assister.AutoStringOnBuild(2,1));
		jLabel.setIcon(Assister.AutoIconOnBuild(2,1));
		if(borderEnabled)
		{
			jLabel.setBorder(new LineBorder(Color.BLACK));
		}
		jLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource()==jLabel & jLabel.getName() == Labels.NEUTRAL)
				{
					jLabel.setName(yieldLabel());
					jLabel.setIcon(yieldIcon(jLabel.getSize()));
					commonOnMouseClick(2,1);
				}
			}
		});
		jLabel.addComponentListener(new ComponentListener()
		{
			
			@Override
			public void componentShown(ComponentEvent e){}
			
			@Override
			public void componentResized(ComponentEvent e)
			{
				BufferedImage currentIcon=switch (jLabel.getName())
				{
				case Labels.NEUTRAL:
				{
					yield Labels.NeutralIcon;
				}
				case Labels.RED:
				{
					yield Labels.RedIcon;
				}
				case Labels.BLUE:
				{
					yield Labels.BlueIcon;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + jLabel.getName());
				};
				jLabel.setIcon(Assister.iconMaker(currentIcon, jLabel.getSize()));
				jLabel.revalidate();
				jLabel.repaint();
			}
			
			@Override
			public void componentMoved(ComponentEvent e){}
			
			@Override
			public void componentHidden(ComponentEvent e){}
		});
		return jLabel;
	}

	@Override
	public JLabel buildRT()
	{
		JLabel jLabel=new JLabel();
		jLabel.setOpaque(true);
		jLabel.setName(Assister.AutoStringOnBuild(2,2));
		jLabel.setIcon(Assister.AutoIconOnBuild(2,2));
		if(borderEnabled)
		{
			jLabel.setBorder(new LineBorder(Color.BLACK));
		}
		jLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource()==jLabel & jLabel.getName() == Labels.NEUTRAL)
				{
					jLabel.setName(yieldLabel());
					jLabel.setIcon(yieldIcon(jLabel.getSize()));
					commonOnMouseClick(2,2);
				}
			}
		});
		jLabel.addComponentListener(new ComponentListener()
		{
			
			@Override
			public void componentShown(ComponentEvent e){}
			
			@Override
			public void componentResized(ComponentEvent e)
			{
				BufferedImage currentIcon=switch (jLabel.getName())
				{
				case Labels.NEUTRAL:
				{
					yield Labels.NeutralIcon;
				}
				case Labels.RED:
				{
					yield Labels.RedIcon;
				}
				case Labels.BLUE:
				{
					yield Labels.BlueIcon;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + jLabel.getName());
				};
				jLabel.setIcon(Assister.iconMaker(currentIcon, jLabel.getSize()));
				jLabel.revalidate();
				jLabel.repaint();
			}
			
			@Override
			public void componentMoved(ComponentEvent e){}
			
			@Override
			public void componentHidden(ComponentEvent e){}
		});
		return jLabel;
	}

	@Override
	public void commonOnMouseClick(final int X, final int Y)
	{
		round++;
		Engine.side *= -1;
		Component[] components=panel.getComponents();
		ArrayList<String> text= new ArrayList<>();
		for (int i = 0; i < components.length; i++)
		{
			JLabel jLabel=(JLabel)components[i];
			text.add(jLabel.getName());
		}
		JLabel[][] mapps=new JLabel[3][3];
		for(int i=0; i<3;i++)
			   for(int j=0;j<3;j++)
			       mapps[i][j] = (JLabel) components[(i*3) + j]; 
		int[][] sharedMap=getMap(mapps);
		if(Sequences.AIenabled&&(AI.AI_TERM==Engine.side | round==1))
		{
			try
			{
				AI.runAI(sharedMap);
			}
			catch (Exception e)
			{
				if (e.getClass()==AWTException.class)
				{
					JOptionPane.showInternalMessageDialog(null,Assister.getExceptionWholeMessage(e),"ERROR",JOptionPane.ERROR_MESSAGE);
					if(FatalExceptionList.isFatalException(e))
					{
						System.exit(e.hashCode());
					}
				}
				if (e.getClass()==SecurityException.class)
				{
					JOptionPane.showInternalMessageDialog(null,Assister.getExceptionWholeMessage(e),"ERROR",JOptionPane.ERROR_MESSAGE);
					if(FatalExceptionList.isFatalException(e))
					{
						System.exit(e.hashCode());
					}
				}
			}			
		}
		updateMap(X, Y, -Engine.side);
		final int winner=RULE_CHECKER.chkWinner(sharedMap);
		switch (winner)
		{
		case Labels.RED_ID:
		{
			JOptionPane.showMessageDialog(null, "Red won", "We have a winner", JOptionPane.INFORMATION_MESSAGE);
			ENDED=true;
			break;
		}
		case Labels.BLUE_ID:
		{
			JOptionPane.showMessageDialog(null, "Blue won", "We have a winner", JOptionPane.INFORMATION_MESSAGE);
			ENDED=true;
			break;
		}
		default:
		{
			if(text.lastIndexOf(Labels.NEUTRAL)==-1 & !ENDED)
			{
				ENDED=true;
				JOptionPane.showMessageDialog(Engine.thisInstanceFrame, "Tile","Round Finished",JOptionPane.INFORMATION_MESSAGE);
			}
			break;
		}
		}
		if(ENDED)
		{
			engine.CB.removeMouseListener(engine.CB.getMouseListeners()[0]);
			engine.CC.removeMouseListener(engine.CC.getMouseListeners()[0]);
			engine.CT.removeMouseListener(engine.CT.getMouseListeners()[0]);
			engine.LB.removeMouseListener(engine.LB.getMouseListeners()[0]);
			engine.LC.removeMouseListener(engine.LC.getMouseListeners()[0]);
			engine.LT.removeMouseListener(engine.LT.getMouseListeners()[0]);
			engine.RB.removeMouseListener(engine.RB.getMouseListeners()[0]);
			engine.RC.removeMouseListener(engine.RC.getMouseListeners()[0]);
			engine.RT.removeMouseListener(engine.RT.getMouseListeners()[0]);
		}
		panel.revalidate();
		panel.repaint();
		Engine.thisInstanceFrame.pack();
		Engine.thisInstanceFrame.revalidate();
		Engine.thisInstanceFrame.repaint();
		
	}


	@Override
	public int[][] getMap(final JLabel[][] Org)
	{
		int[][] map=new int[3][3];
		for(int i=0; i<Org.length; i++)
		{
			for (int j = 0; j < Org[i].length; j++)
			{
				map[i][j]=stringNameToIntValue(Org[i][j].getName());
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
	public ImageIcon yieldIcon(final Dimension dimensionOfRef)
	{
		return switch (Engine.side)
		{
		case Labels.RED_ID:
		{
			
			yield Assister.iconMaker(Labels.RedIcon, dimensionOfRef);
		}
		case Labels.BLUE_ID:
		{
			
			yield Assister.iconMaker(Labels.BlueIcon, dimensionOfRef);
		}
		default:
			//this should never happen
			throw new IllegalArgumentException("Unexpected value: " + Engine.side);
		};
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
	
	private static void updateMap(final int posX, final int posY, final int ColorID)
	{
		map[posY*3+posX]=ColorID;
	}
}
