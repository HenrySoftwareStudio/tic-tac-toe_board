package main.game.launcher.setting;

public enum ColorSelection 
{
	RED(),
	BLUE(),
	NEUTRAL();
	
	@Override
	public String toString()
	{
		return this.name();
	}
}
