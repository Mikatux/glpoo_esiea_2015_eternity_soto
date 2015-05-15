package com.alexis_soto.eternity.models;

import java.awt.Color;

import com.alexis_soto.eternity.entities.QuarterStyle;

public class QuarterModel {

	private Color color;
	private QuarterStyle style;

	public QuarterModel() {
		style = QuarterStyle.random();
		setColor(style);
		// color = new Color((float)Math.random(), (float)Math.random(),
		// (float)Math.random());
	}

	public QuarterModel(QuarterStyle style) {
		this.style = style;
		setColor(style);

	}

	public QuarterModel(String color) {
		setColor(color);

	}

	public Color getColor() {
		return color;
	}

	public void setColor(String newColor) {
		switch (newColor) {
		case "Black":
			this.color = Color.BLACK;
			this.style = QuarterStyle.black;
			break;
		case "Blue":
			color = Color.BLUE;
			this.style = QuarterStyle.blue;
			break;
		case "Red":
			color = Color.RED;
			this.style = QuarterStyle.red;
			break;
		case "Green":
			color = Color.GREEN;
			this.style = QuarterStyle.green;
			break;
		case "Yellow":
			color = Color.YELLOW;
			this.style = QuarterStyle.yellow;
			break;
		default:
			color = Color.BLACK;
			this.style = QuarterStyle.black;
			break;
		}
	}

	public void setColor(QuarterStyle style) {
		switch (style) {
		case black:
			color = Color.BLACK;
			break;
		case blue:
			color = Color.BLUE;
			break;
		case red:
			color = Color.RED;
			break;
		case green:
			color = Color.GREEN;
			break;
		case yellow:
			color = Color.YELLOW;
			break;
		default:
			color = Color.BLACK;
			break;
		}
	}
	

@Override
public boolean equals(Object obj) {
	QuarterModel object = (QuarterModel) obj;
    if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }
    if ((this.color == null) ? (object.color != null) : !this.color.equals(object.color)) {
        return false;
    }
    if (this.style != object.style) {
        return false;
    }
    return true;
}

	

}
