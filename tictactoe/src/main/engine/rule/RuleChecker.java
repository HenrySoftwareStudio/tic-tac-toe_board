package main.engine.rule;

public class RuleChecker extends AbstractRuleChecker
{
	@Override
	public int chkWinner(final int[][] General)
	{
		//prep
		int[] OneDGeneral=new int[9];
        for(int i = 0;i<General.length;i++) 
        {
            for(int j = 0;j<General[i].length;j++)
            {
                OneDGeneral[i*3+j] = General[i][j];
            }
        }
        //diagonal left
        if((OneDGeneral[0]!=0 & OneDGeneral[4]!=0 & OneDGeneral[8]!=0)&&
        		(OneDGeneral[0]==OneDGeneral[4]) & (OneDGeneral[8]==OneDGeneral[4]))
        {
        	return OneDGeneral[0];
        }
        //diagonal Right
        if((OneDGeneral[2]!=0 & OneDGeneral[4]!=0 & OneDGeneral[6]!=0)&&
        		(OneDGeneral[2]==OneDGeneral[4]) & (OneDGeneral[6]==OneDGeneral[4]))
        {
        	return OneDGeneral[2];
        }
        //Horizontal
        for (int i = 0; i < General.length; i++)
		{
			int[] j = General[i];
			if((j[0]!=0 & j[1]!=0 & j[2]!=0) && ((j[0]==j[1]) & (j[1]==j[2])))
			{
				return j[0];
			}
			
		}
        //vertical
        for(int i=0; i < 3; i++)
        {
			if((General[0][i]!=0 & General[1][i]!=0 & General[2][i]!=0)&&(General[0][i]==General[1][i] & General[2][i]==General[1][i]))
			{
				return General[0][i];
			}
        }
        return 0;
	}
}
