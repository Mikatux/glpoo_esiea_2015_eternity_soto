package com.alexis_soto.eternity.handlers;

import java.awt.Dimension;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.alexis_soto.eternity.api.ScreenManager;
import com.alexis_soto.eternity.entities.QuarterStyle;
import com.alexis_soto.eternity.entities.Tile;
import com.alexis_soto.eternity.models.GameBoardModel;
import com.alexis_soto.eternity.models.TileModel;

/**
 * @author Alexis Soto
 * @date May 14, 2015
 */

public class GameOption {

	private static GameOption instance = new GameOption();

	private Dimension windowDimension;

	private final float scale = 1f;

	protected GameOption() {
		setWindowDimension(new Dimension((int) (1024 / scale),
				(int) (768 / scale)));
	}

	public void setWindowDimension(Dimension windowDimension) {
		// Si la fenetre ne tient pas dans l'écran
		if (windowDimension.width > ScreenManager.getScreenDimension()
				.getWidth()
				|| windowDimension.height > ScreenManager.getScreenDimension()
						.getHeight()) {
			// TODO faire quelque chose
			System.out.println("Résolution d'écran trop basse...");
			return;
		}

		this.windowDimension = windowDimension;
	}

	// Retourne les dimensions de la fenetre
	public Dimension getWindowDimension() {
		return this.windowDimension;
	}

	public static GameOption getInstance() {
		return instance;
	}

	public static void openJsonFile(String path) {
		JSONParser parser = new JSONParser();

		try {
			JSONArray obj = (JSONArray) parser.parse(new FileReader(path));

			JSONObject jsonObject = (JSONObject) obj.get(0);
			System.out.println(jsonObject.toString() + "");

			int width = (int) Integer.parseInt(jsonObject.get("width")
					.toString());
			System.out.println(width + "");
			int height = (int) Integer.parseInt(jsonObject.get("height")
					.toString());
			System.out.println(height + "");

			// loop array
			JSONArray tiles = (JSONArray) jsonObject.get("tiles");
			ArrayList<Tile> tileList = new ArrayList<Tile>();
			int currentWidth = 0;
			int currentHeight = 0;

			for (int i = 0; i < tiles.size(); i++) {
				JSONObject Jsontile = (JSONObject) tiles.get(i);
				String westColor = (String) Jsontile.get("west");
				String northColor = (String) Jsontile.get("north");
				String estColor = (String) Jsontile.get("est");
				String southColor = (String) Jsontile.get("south");
				Tile tile = new Tile(currentWidth * 8, currentHeight * 8, 8, 8,
						new TileModel(westColor, northColor, estColor,
								southColor));
				tileList.add(tile);
				System.out.println(tile.getModel().getQuarterWest().getColor());

				currentWidth++;
				if (currentWidth == width) {
					currentHeight++;
					currentWidth = 0;
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
