package com.alexis_soto.eternity.api;

import java.awt.Color;

public class ColorManager {
	
	public static Color Purple() {
		return Purple(500);
	}
	
	public static Color Purple(int power) {
		switch (power) {
		case 500:
			return new Color(0x9C27B0);
		case 50:
			return new Color(0xF3E5F5);
		default:
			return Color.BLACK;
	}
	}
	
	public static Color Red() {
		return Red(500);
	}
	
	public static Color Red(int power) {
		switch (power) {
			case 500:
				return new Color(0xF44336);
			case 50:
				return new Color(0xFFEBEE);
			default:
				return Color.BLACK;
		}
	}
	
	public static Color Blue() {
		return Blue(500);
	}
	
	public static Color Blue(int power) {
		return new Color(0x2196F3);
	}
}