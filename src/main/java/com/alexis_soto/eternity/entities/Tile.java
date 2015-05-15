package com.alexis_soto.eternity.entities;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;

import javax.swing.SwingUtilities;

import com.alexis_soto.eternity.handlers.SwitchHandler;
import com.alexis_soto.eternity.models.TileModel;

/**
 * @author Alexis Soto
 * @date May 10, 2015
 */

public class Tile extends Entity implements MouseListener {

	private TileModel model;
	private final int radius = 3;
	private final int offset = 4;
	private TileState state = TileState.onStack;
	
	
	public Tile(int x, int y, int width, int height) {
		super(x, y, width, height);
		model = new TileModel();
		addMouseListener(this);
	}
	public Tile(int x, int y, int width, int height,TileModel model) {
		super(x, y, width, height);
		
		this.model = model;
		addMouseListener(this);
	}
	
	public TileModel getModel(){
		return model;
	}
	
	@Override
	public void paint(Graphics g) {
		
		int width = getWidth() - 1;
        int height = getHeight() - 1;
		
		g.setColor(Color.BLACK);
		g.fillRoundRect(getX(), getY(),
				getWidth(), getHeight(), radius, radius);
		
		g.setColor(getBackground());
		g.fillRoundRect(getXIn(), getYIn(),
						getWidthIn(), getHeightIn(), radius, radius);
		
		/*
		g.setColor(Color.BLACK);
		g.drawLine(0, 0, getWidth(), getHeight());
		*/
		
		g.setColor(model.getQuarterWest().getColor());
		int westTableX [] = {getXIn(),  getXIn() + getWidthIn()/2,  getXIn()};
		int westTableY [] = {getYIn() + getHeightIn(), getYIn() + getHeightIn()/2, getYIn()};
		g.fillPolygon(westTableX, westTableY, 3);
		
		g.setColor(model.getQuarterNorth().getColor());
		int northTableX [] = {getXIn(),  getXIn() + getWidthIn()/2,  getXIn() + getWidthIn()};
		int northTableY [] = {getYIn(), getYIn() + getHeightIn()/2, getYIn()};
		g.fillPolygon(northTableX, northTableY, 3);
		
		g.setColor(model.getQuarterEst().getColor());
		int estTableX [] = {getXIn() + getWidthIn(),  getXIn() + getWidthIn()/2,  getXIn() + getWidthIn()};
		int estTableY [] = {getYIn() + getHeightIn(), getYIn() + getHeightIn()/2, getYIn()};
		g.fillPolygon(estTableX, estTableY, 3);
		
		g.setColor(model.getQuarterSouth().getColor());
		int southTableX [] = {getXIn(),  getXIn() + getWidthIn()/2,  getXIn() + getWidthIn()};
		int southTableY [] = {getYIn() + getHeightIn(), getYIn() + getHeightIn()/2, getYIn() + getHeightIn()};
		g.fillPolygon(southTableX, southTableY, 3);

		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        g2.draw(new Line2D.Float(getX()+2, getY() + 2, getX() + getWidth() - 2, getY() + getHeight() - 2));
        g2.draw(new Line2D.Float(getX()+2, getY() + getHeight() - 2, getX() + getWidth() - 2, getY() + 2));
	}

	private int getXIn() { return getX() + offset/2; }
	private int getYIn() { return getY() + offset/2; }
	
	private int getWidthIn() { return getWidth() - offset; }
	private int getHeightIn() { return getHeight() - offset; }
	
	public TileState getState() {
		return state;
	}
	
	public void mouseClicked(MouseEvent e) {

		if (SwingUtilities.isLeftMouseButton(e)) {
			SwitchHandler.getInstance().setTile(this);
		} else if (SwingUtilities.isRightMouseButton(e)) {
			model.rotate();
		}
		this.getParent().repaint();
	}

	public void mousePressed(MouseEvent e) {
		state = TileState.flying;
	}

	public void mouseReleased(MouseEvent e) {
		state = TileState.onStack;
	}

	public void mouseEntered(MouseEvent e) {
		int elevation = 4;
		setLocation(getX() - elevation/2, getY() - elevation/2);
		setSize(getWidth() + elevation, getHeight() + elevation);
	}

	public void mouseExited(MouseEvent e) {
		int elevation = 4;
		setLocation(getX() + elevation/2, getY() + elevation/2);
		setSize(getWidth() - elevation, getHeight() - elevation);
	}
}