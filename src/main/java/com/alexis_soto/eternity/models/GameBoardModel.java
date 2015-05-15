package com.alexis_soto.eternity.models;

import java.awt.Dimension;

import com.alexis_soto.eternity.entities.Tile;

public class GameBoardModel {

	private Dimension tileNumberDimension = new Dimension(5, 5);
	private Tile[][] tiles;
	
	public GameBoardModel() {
		tiles = new Tile[getTileNumberX()][getTileNumberY()];
	}
	
	public Tile[][] getTiles() {
		return tiles;
	}
	
	public Tile getTile(int x, int y) {
		return tiles[x][y];
	}
	
	public int getTileNumberX() {
		return (int) tileNumberDimension.getWidth();
	}

	public int getTileNumberY() {
		return (int) tileNumberDimension.getHeight();
	}
	
	public int getTileCount() {
		return getTileNumberX() * getTileNumberY();
	}
}
