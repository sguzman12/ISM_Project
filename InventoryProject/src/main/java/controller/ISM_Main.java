package controller;
import javafx.stage.*;
import view.FX_Gui;
import javafx.application.*;

//Author: Sigfredo Guzman
//Date: 9/11/2019


public class ISM_Main extends Application
{
	
	public static void main(String[] args)
	{
		
		launch(args);
		

	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		Control_Main con = new Control_Main();
		con.begin();
	}
	

}
