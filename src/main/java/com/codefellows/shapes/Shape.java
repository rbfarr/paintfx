package com.codefellows.shapes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape implements Serializable {
    protected transient Point2D p0;

    protected boolean isFilled;
    protected transient Color color;

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

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(new double[] {p0.getX(), p0.getY()});
        oos.writeObject(color.toString());
    }

    private void readObject(ObjectInputStream ois) throws IOException,ClassNotFoundException {
         ois.defaultReadObject();
         double[] xy = (double[])ois.readObject();
         p0 = new Point2D(xy[0], xy[1]);
         String colorStr = (String)ois.readObject();
         color = Color.valueOf(colorStr);
    }
}
