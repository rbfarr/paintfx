package com.codefellows.config;

import com.codefellows.shapes.ShapeType;
import javafx.scene.paint.Color;

public class AppConfig extends Config {
    public String initialColor;
    public String initialShape;
    public boolean initialFill;

    public String filledBoxText;
    public String clearButtonText;
    public String quitButtonText;

    public String getFilledBoxText() {
        if (filledBoxText == null) {
            return "Filled";
        }

        return filledBoxText;
    }

    public String getClearButtonText() {
        if (clearButtonText == null) {
            return "Clear";
        }

        return clearButtonText;
    }

    public String getQuitButtonText() {
        if (quitButtonText == null) {
            return "Quit";
        }

        return quitButtonText;
    }

    public boolean getInitialFill() {
        return initialFill;
    }

    public Color getInitialColor() {
        return Color.valueOf(initialColor.toUpperCase());
    }

    public ShapeType getInitialShape() {
        return ShapeType.valueOf(initialShape.toUpperCase());
    }
}
