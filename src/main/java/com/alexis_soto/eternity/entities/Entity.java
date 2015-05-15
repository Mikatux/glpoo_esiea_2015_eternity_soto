/**
 * 
 */
package com.alexis_soto.eternity.entities;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * @author Alexis Soto
 * @date May 15, 2015
 */
@SuppressWarnings("serial")
public class Entity extends JPanel {

	private Dimension size;
	
	public Entity(int x, int y, int width, int height) {
		setLocation(x, y);
		setSize(width, height);
		
		size = new Dimension(width, height);
	}
	
	public void paint(Graphics g) {
		g.setColor(this.getBackground());
		g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());	
	}
	
	@Override
    public Dimension getPreferredSize() {
        return size;
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    @Override
    public Dimension getMaximumSize() {
    	return getPreferredSize();
    }
}
