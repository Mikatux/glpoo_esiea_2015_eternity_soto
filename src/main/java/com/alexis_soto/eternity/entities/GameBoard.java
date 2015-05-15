package com.alexis_soto.eternity.entities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import com.alexis_soto.eternity.models.GameBoardModel;

/**
 * @author Alexis Soto
 * @date May 10, 2015
 */

@SuppressWarnings("serial")
public class GameBoard extends Entity {

	private final int radius = 6;
	private final int offSetOut = 4;
	private final int offSetIn = 2;
	
	private GameBoardModel model = new GameBoardModel();
	private BoardTile[][] boardTiles;
	private Dimension tileSize;
	
	public GameBoard(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		tileSize = new Dimension(
				(width  - (offSetOut*2 + (model.getTileNumberX() - 1) * offSetIn))/model.getTileNumberX(), 
				(height - (offSetOut*2 + (model.getTileNumberY() - 1) * offSetIn))/model.getTileNumberY());
		
		initializeTile();
	}
	
	private void initializeTile() {
		boardTiles = new BoardTile[model.getTileNumberX()][model.getTileNumberY()];
		setLayout(null);
		
		for (int i = 0; i < model.getTileNumberX(); i++) {
        	for (int j = 0; j < model.getTileNumberY(); j++) {
        		boardTiles[i][j] = new BoardTile(
        				(int)(this.getX() + + offSetOut + i * (tileSize.getWidth() + offSetIn)),
        				(int)(this.getY() + + offSetOut + j * (tileSize.getHeight() + offSetIn)),
        				(int)tileSize.getWidth(), (int)tileSize.getHeight(), radius/2);
        		boardTiles[i][j].setBackground(new Color(0.25f, 0.25f, 0.25f));
        		boardTiles[i][j].setForeground(new Color(0.65f, 0.55f, 0.55f));
        		add(boardTiles[i][j]);
        	}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(getBackground());
		g.fillRoundRect(this.getX(), this.getY(), this.getWidth(), this.getHeight(), radius, radius);
		
		for (int i = 0; i < model.getTileNumberX(); i++) {
        	for (int j = 0; j < model.getTileNumberY(); j++) {
        		if (boardTiles[i][j] != null)
        			boardTiles[i][j].paint(g);
        		/*
        		if (model.getTile(i, j) == null) {
        			g.setColor(getForeground());
        			g.fillRoundRect(
        				(int)(this.getX() + + offSetOut + i * (tileSize.getWidth() + offSetIn)),
        				(int)(this.getY() + + offSetOut + j * (tileSize.getHeight() + offSetIn)),
        				(int)tileSize.getWidth(), (int)tileSize.getHeight(), radius/2, radius/2);
        		} else {
        			
        		}
        		//*/
        	}
        }
	}
	
	public GameBoardModel getModel() { return model; }
}
