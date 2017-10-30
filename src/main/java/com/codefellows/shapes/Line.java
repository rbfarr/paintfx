package com.codefellows.shapes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Line extends Shape {
    private transient Point2D p1;

    public Line(Point2D p0, Point2D p1) {
        super(p0);
        this.p1 = p1;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(color);
        gc.strokeLine(p0.getX(), p0.getY(), p1.getX(), p1.getY());
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.writeObject(new double[] {p1.getX(), p1.getY()});
    }

    private void readObject(ObjectInputStream ois) throws IOException,ClassNotFoundException {
        double[] xy = (double[])ois.readObject();
        p1 = new Point2D(xy[0], xy[1]);
    }
}
