package com.alexis_soto.eternity.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.alexis_soto.eternity.handlers.SwitchHandler;

public class BoardTile extends Entity implements MouseListener {

	private int radius = 3;
	private Tile tile;
	private Color actualColor;
	
	public BoardTile(int x, int y, int width, int height, int radius) {
		super(x, y, width, height);
		this.radius = radius;
		
		addMouseListener(this);
	}
	
	@Override
	public void setBackground(Color bg) {
		super.setBackground(bg);
		actualColor = bg;
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(actualColor);
		g.fillRoundRect(getX(), getY(),
				getWidth(), getHeight(), radius, radius);
	}

	public void mouseClicked(MouseEvent e) {
		SwitchHandler.getInstance().setBoardTile(this);
		SwitchHandler.getInstance().switchTile();
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {
		actualColor = getForeground();
		this.getParent().getParent().repaint();
	}
	public void mouseExited(MouseEvent e) {
		actualColor = getBackground();
		this.getParent().getParent().repaint();
	}
}
