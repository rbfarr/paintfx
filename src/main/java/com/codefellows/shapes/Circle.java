package com.codefellows.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Circle extends Shape {
    private double radius;

    public Circle(Point2D p0, double radius) {
        super(p0);
        this.radius = radius;
    }

    @Override
    public void draw(GraphicsContext gc) {
        if (isFilled) {
            gc.setFill(color);
            gc.fillOval(p0.getX()-radius, p0.getY()-radius, radius*2, radius*2);
        } else {
            gc.setStroke(color);
            gc.strokeOval(p0.getX()-radius, p0.getY()-radius, radius*2, radius*2);
        }
    }
}
