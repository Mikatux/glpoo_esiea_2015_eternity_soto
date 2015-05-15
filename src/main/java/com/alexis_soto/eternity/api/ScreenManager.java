//Alexis Soto
//7 May 2015

//ScreenManager.java Main class
//API permettant de recuperer des informations sur l'ecran

package com.alexis_soto.eternity.api;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

public class ScreenManager {
	
	//Permet de recuperer la taille de l'ecran actif
	public static Dimension getScreenDimension()
	{
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int screenWidth = gd.getDisplayMode().getWidth();
		int screenHeight = gd.getDisplayMode().getHeight();
		
		return new Dimension(screenWidth, screenHeight);
	}
	
	//Permet de recuperer point central de l'ecran actif
	public static Point getScreenCenter() {
		Dimension screenSize = getScreenDimension();
		int x = (int) screenSize.width / 2;
		int y = (int) screenSize.height / 2;
		return new Point(x, y);
	}
}
