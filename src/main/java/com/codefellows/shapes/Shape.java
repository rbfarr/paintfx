package com.codefellows.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {
    protected Point2D p0;

    protected boolean isFilled;
    protected Color color;

    public Shape(Point2D p0) {
        this.p0 = p0;
    }

    public void setIsFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw(GraphicsContext gc);
}
