package com.alexis_soto.eternity.entities;

import java.awt.Graphics;

@SuppressWarnings("serial")
public class GameStack extends Entity {

	private final int radius = 10;
	
	public GameStack(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(getBackground());
		g.fillRoundRect(getX(), getY(), getWidth(), getHeight(), radius, radius);
	}
}
