package com.alexis_soto.eternity.main;

/**
 * @author Alexis Soto
 * @date May 7, 2015
 */

import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import com.alexis_soto.eternity.api.ScreenManager;
import com.alexis_soto.eternity.handlers.GameOption;

@SuppressWarnings("serial")
public class EternityWindow extends JFrame implements WindowListener {
	EternityGame gamePanel;
	public EternityWindow(int width, int height) {
		GameOption.openJsonFile("res/level.json");
		this.setTitle("Eternity");
		//On va intercepter l'event pour supprimer des choses avant la fermeture de la fenetre
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		
		this.addWindowListener(this);
		
		 gamePanel = new EternityGame(width, height);
		this.add(gamePanel);
		
		this.setSize(width, height);
		this.setInCenter();
	}
	
	//Centre la fenetre dans l'écran
	private void setInCenter() {
		Point center = ScreenManager.getScreenCenter();
		this.setLocation(center.x - (this.getWidth()/2), center.y - (this.getHeight()/2));
	}
	
	public void windowOpened(WindowEvent e) {}
	public void windowClosing(WindowEvent e) {
		System.out.println("Save");
		System.out.println(gamePanel.checkTile());
		System.exit(0);
	}
	public void windowClosed(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
}
