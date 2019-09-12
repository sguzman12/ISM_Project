package controller;

import view.FX_Gui;

public class Control_Main
{
	Control_Main()
	{
		
	}
	
	public void begin() throws Exception 
	{
		FX_Gui gui = new FX_Gui();
		gui.initialize();
	}
}
