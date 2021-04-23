package main;

import java.awt.Color;
import javax.swing.JLabel;



public abstract class GameInterface
{
	public static final int LEFT=0;
	public static final int RIGTH=1;
	public static final int TOP=2;
	public static final int BOTTOM=3;
	public static final int TOPLEFT=4;
	public static final int TOPRIGHT=5;
	public static final int BOTTOMLEFT=6;
	public static final int BOTTOMRIGHT=7;;
	public abstract JLabel buildLT();
	public abstract JLabel buildCT();
	public abstract JLabel buildRT();
	public abstract JLabel buildLC();
	public abstract JLabel buildCC();
	public abstract JLabel buildRC();
	public abstract JLabel buildLB();
	public abstract JLabel buildCB();
	public abstract JLabel buildRB();
	public abstract void commonOnMouseClick();
	public abstract String yieldLabel();
	public abstract int[][] getMap(JLabel[][] Org);
	public abstract int stringNameToIntValue(String Name);
	public abstract Color getColorFromSide();
	public abstract int[][] getRedMap(int[][] publicMap);
	public abstract int[][] getBlueMap(int[][] publicMap);
}
