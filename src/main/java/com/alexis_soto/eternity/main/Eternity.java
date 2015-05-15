package com.alexis_soto.eternity.main;

import com.alexis_soto.eternity.handlers.GameOption;


/**
 * @author Alexis Soto
 * @date May 7, 2015
 *
 * @TODO Le moins de code possible dans cette classe !
 */

public class Eternity {
	
	//Taille de l'ecran; On utilise les dimensions d'un ecran d'iPhone 6
	static int screenWidth = GameOption.getInstance().getWindowDimension().width;
	static int screenHeight = GameOption.getInstance().getWindowDimension().height;
	private static EternityWindow gameWindow;
	
	public static void main(String[] args) {
		gameWindow = new EternityWindow(screenWidth, screenHeight);
		gameWindow.setVisible(true);
	}
}
