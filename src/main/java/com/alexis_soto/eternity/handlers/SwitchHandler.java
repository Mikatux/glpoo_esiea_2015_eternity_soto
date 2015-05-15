package com.alexis_soto.eternity.handlers;

import com.alexis_soto.eternity.entities.BoardTile;
import com.alexis_soto.eternity.entities.Tile;

public class SwitchHandler {

	private static SwitchHandler instance = new SwitchHandler();
	
	private Tile tile;
	private BoardTile boardTile;
	
	public SwitchHandler() {
		
	}
	
	public void setBoardTile(BoardTile boardTile) {
		this.boardTile = boardTile;
	}
	
	public void setTile(Tile tile) {
		this.tile = tile;
	}
	
	public boolean switchTile() {
		if (tile != null && boardTile != null) {
			tile.setLocation(boardTile.getLocation());
			tile.setSize(boardTile.getSize());
			tile = null;
			boardTile = null;
			return true;
		} else {
			return false;
		}
	}
	
	public static SwitchHandler getInstance() {
		return instance;
	}

}
