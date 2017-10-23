package com.codefellows.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Line extends Shape {
    private Point2D p1;

    public Line(Point2D p0, Point2D p1) {
        super(p0);
        this.p1 = p1;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(color);
        gc.strokeLine(p0.getX(), p0.getY(), p1.getX(), p1.getY());
    }
}
