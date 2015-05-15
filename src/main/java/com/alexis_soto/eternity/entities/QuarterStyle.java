package com.alexis_soto.eternity.entities;

public enum QuarterStyle {
	black ("Black"),
	blue ("Blue"),
	red ("Red"),
	green ("Green"),
	yellow ("Yellow");
	
	private String name;
	
	 QuarterStyle(String color){
		this.name = color;
	}
	
	public static QuarterStyle random() {
		int result = (int) (Math.random()*QuarterStyle.count());
		
		switch (result) {
		case 0:
			return QuarterStyle.black;
		case 1:
			return QuarterStyle.blue;
		case 2:
			return QuarterStyle.red;
		case 3:
			return QuarterStyle.green;
		case 4:
			return QuarterStyle.yellow;
		case 5:
			return QuarterStyle.black;
		case 6:
			return QuarterStyle.black;
		default:
			return QuarterStyle.black;
		}
	}
	
	public static int count() {
		return 5;
	}
}
