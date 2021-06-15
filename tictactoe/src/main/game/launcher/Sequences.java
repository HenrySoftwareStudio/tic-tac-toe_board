package main.game.launcher;

import static main.game.GameCore.GC;
import static main.game.GameCore.engine;
import static main.game.GameCore.panel;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import main.commom.Assister;
import main.engine.Engine;
import main.engine.ai.AI;
import main.engine.resources.Labels;
import main.game.GameCore;
import main.game.launcher.setting.ColorSelection;
import main.game.style.Style;

public class Sequences
{
	public static boolean metaExist=true;
	public static boolean borderEnabled=true;
	public static Dimension OldD;
	private static final int INIT_ID=Labels.RED_ID;
	public static boolean AIenabled;
	public static final Runnable PRELAUNCH_SEQUENCE=new Runnable()
	{
		
		@Override
		public void run()
		{
			VARABLE_INITIALIZER_SEQUENCE.run();
			GET_META_INFO.run();
			ASK_ENEMY.run();
			ASK_COLOR.run();
			FINAL_CHECK_SEQUENCE.run();
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
			JMenu jMenuGame=new JMenu("Game");
			JMenu jMenuSetting=new JMenu("setting");
			JMenuItem jMenuItemRestart=new JMenuItem("Relaunch (F5)");
			JMenuItem jMenuItemRelaunch=new JMenuItem("Reset Game (F6)");
			JMenuItem jMenuItemSetRed=new JMenuItem("set red icon");
			JMenuItem jMenuItemSetBlue=new JMenuItem("set blue icon");
			JMenuItem jMenuItemSetNeu=new JMenuItem("set neutral icon");
			JMenuItem jMenuItemSetBorder=new JMenuItem("toggle icon Border Current:"+((borderEnabled)?"On":"Off"));
			jMenuItemRestart.setToolTipText("Clean Restart the Program (F5)");
			jMenuItemRestart.addActionListener(new ActionListener()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					RESTART_SEQUENCE.run();					
				}
			});
			jMenuItemRelaunch.setToolTipText("Reset Game State, only effective if the game have not yet ended (F6)");
			jMenuItemRelaunch.addActionListener(new ActionListener()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					RELAUNCH_SEQUENCE.run();			
				}
			});
			jMenuItemSetRed.setToolTipText("Set Icon Used For Red Side");
			jMenuItemSetRed.addActionListener(new ActionListener()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(metaExist)
					{
						final FileDialog dialog=new FileDialog(frame, "select Red file");
						dialog.setFile("*.gif");
						dialog.setVisible(true);
						dialog.setMultipleMode(false);
						try
						{
							Assister.writeFileToMeta(dialog.getDirectory()+dialog.getFile(), ColorSelection.RED);
						}
						catch (IOException e1)
						{
						}
					}
				}
			});
			jMenuItemSetBlue.setToolTipText("Set Icon Used For Blue Side");
			jMenuItemSetBlue.addActionListener(new ActionListener()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(metaExist)
					{
						final FileDialog dialog=new FileDialog(frame, "select Blue file");
						dialog.setFile("*.gif");
						dialog.setVisible(true);
						dialog.setMultipleMode(false);
						try
						{
							Assister.writeFileToMeta(dialog.getDirectory()+dialog.getFile(), ColorSelection.BLUE);
						}
						catch (IOException e1)
						{
						}
					}
				}
			});
			jMenuItemSetNeu.setToolTipText("Set Icon Used For Unoccupied Squares");
			jMenuItemSetNeu.addActionListener(new ActionListener()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(metaExist)
					{
						final FileDialog dialog=new FileDialog(frame, "select Neutral file");
						dialog.setFile("*.gif");
						dialog.setVisible(true);
						dialog.setMultipleMode(false);
						try
						{
							Assister.writeFileToMeta(dialog.getDirectory()+dialog.getFile(), ColorSelection.NEUTRAL);
						}
						catch (IOException e1)
						{
						}
					}
				}
			});
			jMenuItemSetBorder.setToolTipText("Enable/Disable Border");
			jMenuItemSetBorder.addActionListener(new ActionListener()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					borderEnabled=!borderEnabled;
					Engine.thisInstanceFrame.dispose();
					LAUNCH_SEQUENCE.run();
				}
			});
			jMenuGame.add(jMenuItemRelaunch);
			jMenuGame.add(jMenuItemRestart);
			jMenuSetting.add(jMenuItemSetRed);
			jMenuSetting.add(jMenuItemSetBlue);
			jMenuSetting.add(jMenuItemSetNeu);
			jMenuSetting.add(jMenuItemSetBorder);
			jMenuBar.add(jMenuGame);
			jMenuBar.add(jMenuSetting);
			frame.setJMenuBar(jMenuBar);
			frame.setMinimumSize(new Dimension(100, 100));
			frame.setPreferredSize((OldD==null)? new Dimension(100, 100):OldD);
			frame.setSize((OldD==null)? new Dimension(100, 100):OldD);
			frame.setLocationRelativeTo(null);
			engine=new Engine(new JLabel[] {GC.buildLT(),GC.buildCT(),GC.buildRT(),GC.buildLC(),GC.buildCC(),GC.buildRC(),GC.buildLB(),GC.buildCB(),GC.buildRB()});
			panel=engine.getProduct();
			Style.PANEL_STYLE.run();
			frame.add(GameCore.panel);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.addComponentListener(new ComponentListener()
			{
				
				@Override
				public void componentShown(ComponentEvent e){}
				
				@Override
				public void componentResized(ComponentEvent e)
				{
					frame.setPreferredSize(frame.getSize());
				}
				
				@Override
				public void componentMoved(ComponentEvent e){}
				
				@Override
				public void componentHidden(ComponentEvent e){}
			});
			frame.addWindowListener(new WindowListener()
			{
				
				@Override
				public void windowOpened(WindowEvent e){}
				
				@Override
				public void windowIconified(WindowEvent e){}
				
				@Override
				public void windowDeiconified(WindowEvent e){}
				
				@Override
				public void windowDeactivated(WindowEvent e){}
				
				@Override
				public void windowClosing(WindowEvent e)
				{
					try
					{
						if(metaExist)
						{
							Dimension currentSize=Engine.thisInstanceFrame.getSize();
							Scanner metaDataFile=new Scanner("");
							metaDataFile.useDelimiter("\n");
							try
							{
								metaDataFile = new Scanner(new File("Meta.metadata"));
							}
							catch (FileNotFoundException e0)
							{
								e0.printStackTrace();
							}
							String metaText[]=new String[6];
							try
							{
								for (int i = 0; i < metaText.length; i++)
								{
									metaText[i]=(metaDataFile.hasNextLine())? metaDataFile.nextLine():"";
								}
							}
							catch (Exception e1)
							{
								e1.printStackTrace();
							}
							for (int i = 0; i < metaText.length; i++)
							{
								if(metaText[i].contains("dDimension") & !metaText[i].contains("IdvDimension"))
								{
									metaText[i]="dDimension:"+currentSize.width+","+currentSize.height+";";
								}
							}
							for (int i = 0; i < metaText.length; i++)
							{
								if(metaText[i].contains("IdvDimension"))
								{
									metaText[i]="IdvDimension:"+engine.LT.getWidth()+","+engine.LT.getHeight()+";";
								}
							}
							for (int i = 0; i < metaText.length; i++)
							{
								if(metaText[i].contains("border"))
								{
									metaText[i]="border:"+((borderEnabled)?1:0)+";";
								}
							}
							metaDataFile.close();
							FileWriter writeTo=null;
							try
							{
								writeTo=new FileWriter(new File("Meta.metadata"));
								String finalMessage="";
								for (int i = 0; i < metaText.length; i++)
								{
									finalMessage+=metaText[i]+"\n";
								}
								writeTo.write(finalMessage);
								writeTo.flush();
							}
							catch (IOException e2)
							{
								Assister.ErrorReport(Thread.currentThread(), e2);
							}
							finally 
							{
								writeTo.close();
							}
						}
					}
					catch (Exception e0) 
					{
						Assister.ErrorReport(Thread.currentThread(), e0);
					}
					
				}
				
				@Override
				public void windowClosed(WindowEvent e){}
				
				@Override
				public void windowActivated(WindowEvent e){}
			});
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
			GameCore.ENDED=false;
			Engine.thisInstanceFrame.dispose();
			PRELAUNCH_SEQUENCE.run();
		}
	};
	
	public static final Runnable VARABLE_INITIALIZER_SEQUENCE=new Runnable()
	{
		public void run()
		{
			Engine.side=INIT_ID;
			AIenabled=true;
		}
	};
	
	public static final Runnable FINAL_CHECK_SEQUENCE=new Runnable()
	{
		
		@Override
		public void run()
		{
			if (AIenabled)
			{
				AI.AI_TERM=-1*Engine.side;
			}			
		}
	};
	
	public static final Runnable ASK_ENEMY=new Runnable()
	{
		public void run()
		{
			JPanel jPanel=new JPanel(new GridLayout(1,2));
			ButtonGroup buttonGroup=new ButtonGroup();
			JPanel subJPanel=new JPanel(new GridLayout(2, 1));
			JRadioButton buttonAI=new JRadioButton("play against AI");
			JRadioButton buttonP=new JRadioButton("play against human");			
			
			buttonAI.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					AIenabled=true;				
				}
			});

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
		}
	};
	
	public static final Runnable ASK_COLOR=new Runnable()
	{
		public void run()
		{
			JPanel jPanel2=new JPanel(new GridLayout(1,2));
			ButtonGroup buttonGroup2=new ButtonGroup();
			JPanel subJPanel2=new JPanel(new GridLayout(2, 1));
			JRadioButton buttonRed=new JRadioButton("Start round as red");
			buttonRed.addActionListener(new ActionListener()
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
		}
	};
	
	public static final Runnable GET_META_INFO=new Runnable()
	{
		
		@Override
		public void run()
		{
			Scanner metaDataFile=new Scanner("");
			try
			{
				metaDataFile = new Scanner(new File("Meta.metadata"));
			}
			catch (FileNotFoundException e1)
			{
				JOptionPane.showInternalMessageDialog(null, "Meta.metadata file is not found,\nthis file is critical to the program's normal functioning\n"
						+ "default setting will be used",
						"File Not Fould", JOptionPane.ERROR_MESSAGE);
				metaExist=false;
			}
			String metaText=null;
			try
			{
				while (metaDataFile.hasNextLine())
				{
					metaText+=metaDataFile.nextLine();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			metaDataFile.close();
			metaDataFile=null;
			System.gc();
			
			BufferedImage redBufferedImage=null;
			BufferedImage blueBufferedImage=null;
			BufferedImage neutralBufferedImage=null;
			if(metaExist)
			{
				final int RedStyleLocation=metaText.indexOf("Red:")+4;
				final int RedStyleLocationEnd=metaText.indexOf(";", RedStyleLocation);
				final String RedStylePath=metaText.substring(RedStyleLocation, RedStyleLocationEnd);
				try
				{
					redBufferedImage=ImageIO.read(new File(RedStylePath));
					
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				Labels.RedIcon=redBufferedImage;
				
				
				final int BlueStyleLocation=metaText.indexOf("Blue:")+5;
				final int BlueStyleLocationEnd=metaText.indexOf(";", BlueStyleLocation);
				final String BlueStylePath=metaText.substring(BlueStyleLocation, BlueStyleLocationEnd);
				try
				{
					blueBufferedImage=ImageIO.read(new File(BlueStylePath));
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				Labels.BlueIcon=blueBufferedImage;
				
				
				final int NeutralStyleLocation=metaText.indexOf("Neutral:")+8;
				final int NeutralStyleLocationEnd=metaText.indexOf(";", NeutralStyleLocation);
				final String NeutralStylePath=metaText.substring(NeutralStyleLocation, NeutralStyleLocationEnd);
				try
				{
					neutralBufferedImage=ImageIO.read(new File(NeutralStylePath));
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				Labels.NeutralIcon=neutralBufferedImage;
				
				final int Dimension=metaText.indexOf("dDimension:")+11;
				final int DimensionEnd=metaText.indexOf(";", Dimension);
				final String DimensionPre=metaText.substring(Dimension, DimensionEnd);
				
				final String DimensionX=DimensionPre.substring(0, DimensionPre.indexOf(","));
				final String DimensionY=DimensionPre.substring(DimensionPre.indexOf(",")+1);
				OldD=new Dimension(Integer.parseInt(DimensionX), Integer.parseInt(DimensionY));
				
				final int LabelDimension=metaText.indexOf("IdvDimension:")+13;
				final int LabelDimensionEnd=metaText.indexOf(";", LabelDimension);
				final String LabelDimensionPre=metaText.substring(LabelDimension, LabelDimensionEnd);
				
				final String LabelDimensionX=LabelDimensionPre.substring(0, LabelDimensionPre.indexOf(","));
				final String LabelDimensionY=LabelDimensionPre.substring(LabelDimensionPre.indexOf(",")+1);
				GameCore.InitDimension=new Dimension(Integer.parseInt(LabelDimensionX), Integer.parseInt(LabelDimensionY));
				
				final int BorderEnable=metaText.indexOf("border:")+7;
				final int BorderEnableEnd=metaText.indexOf(";", BorderEnable);
				borderEnabled=(Integer.parseInt(metaText.substring(BorderEnable, BorderEnableEnd))==0)?false:true;
			}
			else
			{
				Labels.RedIcon=null;
				Labels.BlueIcon=null;
				Labels.NeutralIcon=null;
				OldD=new Dimension(200, 200);
			}
		}
	};
	
	public static final Runnable RELAUNCH_SEQUENCE=new Runnable()
	{
		
		@Override
		public void run()
		{
			OldD=Engine.thisInstanceFrame.getSize();
			GameCore.ENDED=false;
			Engine.thisInstanceFrame.dispose();
			LAUNCH_SEQUENCE.run();
		}
	};
}
