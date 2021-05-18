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
}
