package main.game;

import java.awt.Color;
import javax.swing.JLabel;



public abstract class GameInterface
{
	public static final int BOTTOM=3;
	public static final int BOTTOMLEFT=6;
	public static final int BOTTOMRIGHT=7;
	public static final int LEFT=0;
	public static final int RIGTH=1;
	public static final int TOP=2;
	public static final int TOPLEFT=4;
	public static final int TOPRIGHT=5;;
	public abstract JLabel buildCB();
	public abstract JLabel buildCC();
	public abstract JLabel buildCT();
	public abstract JLabel buildLB();
	public abstract JLabel buildLC();
	public abstract JLabel buildLT();
	public abstract JLabel buildRB();
	public abstract JLabel buildRC();
	public abstract JLabel buildRT();
	public abstract void commonOnMouseClick();
	public abstract int[][] getBlueMap(int[][] publicMap);
	public abstract Color getColorFromSide();
	public abstract int[][] getMap(JLabel[][] Org);
	public abstract int[][] getRedMap(int[][] publicMap);
	public abstract int stringNameToIntValue(String Name);
	public abstract String yieldLabel();
}
