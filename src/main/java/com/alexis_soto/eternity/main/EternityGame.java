package com.alexis_soto.eternity.main;

/**
 * @author Alexis Soto
 * @date May 7, 2015
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.alexis_soto.eternity.entities.GameBoard;
import com.alexis_soto.eternity.entities.GameStack;
import com.alexis_soto.eternity.entities.Tile;
import com.alexis_soto.eternity.entities.TileState;

@SuppressWarnings("serial")
public class EternityGame extends JPanel {

	private GameBoard board;
	private GameStack stack;

	private ArrayList<Tile> tiles = new ArrayList<Tile>();

	public EternityGame(int width, int height) {
		this.setLocation(0, 0);
		this.setSize(width, height);
		setBackground(new Color(0.98f, 0.98f, 0.98f));

		setLayout(null);

		board = new GameBoard(32, 202, 512, 512);
		board.setBackground(new Color(0.4f, 0.4f, 0.4f));
		// board.setForeground(new Color(0.25f, 0.25f, 0.25f));
		add(board);

		stack = new GameStack(512 + 32 * 2, 458, 416, 256);
		stack.setBackground(new Color(0.4f, 0.4f, 0.4f));
		add(stack);

		initializeTiles();
	}

	private void initializeTiles() {
		int tileSize = (int) (Math.sqrt(stack.getWidth() * stack.getHeight()
				/ board.getModel().getTileCount()) * 0.9f) - 4;
		System.out.println("Tile Size : " + tileSize);

		int x = 0;
		int y = 0;

		for (int i = 0; i < board.getModel().getTileCount(); i++) {
			if (stack.getX() + (tileSize + 4) * (x + 1) + 2 > stack.getX()
					+ stack.getWidth()) {
				x = 0;
				y++;
			}

			Tile tile = new Tile(stack.getX() + (tileSize + 4) * x + 4,
					stack.getY() + (tileSize + 4) * y + 4, tileSize, tileSize);
			tile.setBackground(new Color(0.7f, 0.7f, 0.7f));
			tiles.add(tile);
			x++;

			add(tile);
		}
		
		System.out.println("Same = " +checkTile()+"");
	}

	public int checkTile() {
		int correctFace = 0;
		for (int x = 0; x < board.getModel().getTileNumberX(); x++) {
			for (int y = 0; y < board.getModel().getTileNumberY(); y++) {
				Tile currentTile = board.getModel().getTile(x, y);
				if ( currentTile != null && currentTile.getState() == TileState.onBoard) {
					if (x > 0) {
						if (currentTile.getModel().getQuarterEst() == board
								.getModel().getTile(x - 1, y).getModel()
								.getQuarterWest()) {
							correctFace++;

						}
					}
					if (y > 0) {
						if (currentTile.getModel().getQuarterNorth() == board
								.getModel().getTile(x, y-1).getModel()
								.getQuarterSouth()) {
							correctFace++;

						}
					}

				}
			}
		}
		return correctFace;
	}

	public void paint(Graphics g) {
		g.setColor(getBackground());
		g.fillRect(getX(), getY(), getWidth(), getHeight());

		if (board != null)
			board.paint(g);
		if (stack != null)
			stack.paint(g);

		for (int i = 0; i < tiles.size(); i++) {
			tiles.get(i).paint(g);
		}
	}
}