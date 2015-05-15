package com.alexis_soto.eternity.models;

import com.alexis_soto.eternity.entities.QuarterStyle;

public class TileModel {

	private QuarterModel westQuarter;
	private QuarterModel northQuarter;
	private QuarterModel estQuarter;
	private QuarterModel southQuarter;
	
	public TileModel() {
		westQuarter = new QuarterModel();
		northQuarter = new QuarterModel();
		estQuarter = new QuarterModel();
		southQuarter = new QuarterModel();
	}
	
	public TileModel(QuarterModel west, QuarterModel north, QuarterModel est, QuarterModel south) {
		westQuarter = west;
		northQuarter = north;
		estQuarter = est;
		southQuarter = south;
	}
	public TileModel(QuarterStyle west, QuarterStyle north, QuarterStyle est, QuarterStyle south) {
		westQuarter = new QuarterModel(west);
		northQuarter = new QuarterModel(north);
		estQuarter = new QuarterModel(est);
		southQuarter = new QuarterModel(south);
	}
	public TileModel(String west, String north, String est, String south) {
		westQuarter = new QuarterModel(west);
		northQuarter = new QuarterModel(north);
		estQuarter = new QuarterModel(est);
		southQuarter = new QuarterModel(south);
	}
	public void rotate() {
		QuarterModel temp = westQuarter;
		westQuarter = southQuarter;
		southQuarter = estQuarter;
		estQuarter = northQuarter;
		northQuarter = temp;
	}

	public QuarterModel getQuarterWest() { return westQuarter; }
	public QuarterModel getQuarterNorth() { return northQuarter; }
	public QuarterModel getQuarterEst() { return estQuarter; }
	public QuarterModel getQuarterSouth() { return southQuarter; }
}
