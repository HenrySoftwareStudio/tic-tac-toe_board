package main.commom;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import main.engine.resources.Labels;
import main.game.GameCore;
import main.game.launcher.setting.ColorSelection;

public class Assister
{
	public static void writeFileToMeta(final String path,final ColorSelection s) throws IOException
	{
		Scanner metaDataFile=new Scanner("");
		try
		{
			metaDataFile = new Scanner(new File("Meta.metadata"));
		}
		catch (FileNotFoundException e0)
		{
			e0.printStackTrace();
		}
		String metaText[]=new String[5];
		FileWriter wtritTo=new FileWriter(new File("Meta.metadata"));
		String finalMessage="";
		try
		{
			switch (s)
			{
			case BLUE:
			{
				try
				{
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
						if(metaText[i].contains("Blue"))
						{
							metaText[i]="Blue:"+path+";";
						}
					}
					metaDataFile.close();
					try
					{
						
						for (int i = 0; i < metaText.length; i++)
						{
							finalMessage+=metaText[i]+"\n";
						}
						wtritTo.write(finalMessage);
						wtritTo.flush();
					}
					catch (IOException e2)
					{
						e2.printStackTrace();
					}
				}
				catch (Exception e0) 
				{
					System.err.println(Assister.class.getClass().getEnclosingMethod().toGenericString());
					e0.printStackTrace();
				}
				break;
			}
			case NEUTRAL:
			{
				try
				{
					for (int i = 0; i < metaText.length; i++)
					{
						metaText[i]=(metaDataFile.hasNextLine())? metaDataFile.nextLine():"";
					}
					for (int i = 0; i < metaText.length; i++)
					{
						if(metaText[i].contains("Neutral"))
						{
							metaText[i]="Neutral:"+path+";";
						}
					}
					for (int i = 0; i < metaText.length; i++)
					{
						finalMessage+=metaText[i]+"\n";
					}
					wtritTo.write(finalMessage);
					wtritTo.flush();
	
				}
				catch (Exception e0) 
				{
					System.err.println(Assister.class.getEnclosingMethod().toGenericString());
					e0.printStackTrace();
				}
				break;
			}
			case RED:
			{
				try
				{
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
						if(metaText[i].contains("Red"))
						{
							metaText[i]="Red:"+path+";";
						}
					}
					metaDataFile.close();
					try
					{
						for (int i = 0; i < metaText.length; i++)
						{
							finalMessage+=metaText[i]+"\n";
						}
						wtritTo.write(finalMessage);
						wtritTo.flush();
					}
					catch (IOException e2)
					{
						e2.printStackTrace();
					}
				}
				catch (Exception e0) 
				{
					System.err.println(Assister.class.getClass().getEnclosingMethod().toGenericString());
					e0.printStackTrace();
				}
				break;
			}
			default:
				metaDataFile.close();
				throw new IllegalArgumentException("Unexpected value: " + s);
			}
		}
		catch (Exception e) 
		{
			System.err.println(Assister.class.getClass().getEnclosingMethod().toGenericString());
			e.printStackTrace();
		}
	}
	
	public static String getExceptionWholeMessage(final Throwable e)
	{
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
	}
	
	public static ImageIcon iconMaker(final Image image, final Dimension dimensionOfRef)
	{
		try
		{
			return new ImageIcon(ResizeIcon(image, dimensionOfRef));
		}
		catch (Exception e)
		{
			JOptionPane.showInternalMessageDialog(null, "Error: this has happened:\n"+getExceptionWholeMessage(e),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		return (ImageIcon)null;
	}

	
	public static boolean CheckExist(String path,boolean needMessage)
	{
		boolean toReturn=false;
		try
		{
			FileInputStream test=new FileInputStream(new File(path));
			toReturn=true;
			test.close();
		}
		catch (Exception e) 
		{
			toReturn=false;
			if(needMessage && e.getClass()==FileNotFoundException.class)
			{
				JOptionPane.showInternalMessageDialog(null, "file "+path+"does not exist", "File Does Not Exist", JOptionPane.ERROR_MESSAGE);
			}
		}
		return toReturn;
	}
	
	public static Image ResizeIcon(final Image image, final Dimension dimensionOfRef)
	{
		Dimension d=dimensionOfRef;
		if(dimensionOfRef.height==0 | dimensionOfRef.width==0)
		{
			d.height=image.getHeight(null);
			d.width=image.getWidth(null);
		}
		return image.getScaledInstance(d.width, d.height, Image.SCALE_DEFAULT);
	}
	
	public static void ErrorReport(final Thread t, final Throwable e)
	{
		JOptionPane.showInternalMessageDialog(null,t.toString()+
				", had an exception,this may be fatal,\ndetails:\n"+Assister.getExceptionWholeMessage(e),"ERROR",JOptionPane.ERROR_MESSAGE);
		if(FatalExceptionList.isFatalException(e))
		{
			System.exit(e.hashCode());
		}
	}
	
	public static ImageIcon AutoIconOnBuild(final int PosX, final int PosY)
	{
		Image img;
		switch (GameCore.map[PosX+PosY*3])
		{
		case Labels.BLUE_ID:
		{
			img=Labels.BlueIcon;
			break;
		}
		case Labels.NEUTRAL_ID:
		{
			img=Labels.NeutralIcon;
			break;
		}
		case Labels.RED_ID:
		{
			img=Labels.RedIcon;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + GameCore.map[PosX+PosY*3]);
		}
		return iconMaker(img, GameCore.InitDimension);
	}
	
	public static String AutoStringOnBuild(final int PosX, final int PosY)
	{
		String name;
		switch (GameCore.map[PosX+PosY*3])
		{
		case Labels.BLUE_ID:
		{
			name=Labels.BLUE;
			break;
		}
		case Labels.NEUTRAL_ID:
		{
			name=Labels.NEUTRAL;
			break;
		}
		case Labels.RED_ID:
		{
			name=Labels.RED;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + GameCore.map[PosX+PosY*3]);
		}
		return name;
	}
}
