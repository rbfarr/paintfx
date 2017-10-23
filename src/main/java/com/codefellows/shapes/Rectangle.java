package com.codefellows.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Rectangle extends Shape {
    private double width, height;

    public Rectangle(Point2D p0, double width, double height) {
        super(p0);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(GraphicsContext gc) {
        if (isFilled) {
            gc.setFill(color);
            gc.fillRect(p0.getX(), p0.getY(), width, height);
        } else {
            gc.setStroke(color);
            gc.strokeRect(p0.getX(), p0.getY(), width, height);
        }
    }
}
