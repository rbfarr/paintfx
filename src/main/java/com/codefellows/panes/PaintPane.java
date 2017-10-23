package com.codefellows.panes;

import com.codefellows.AppState;
import com.codefellows.shapes.Circle;
import com.codefellows.shapes.Line;
import com.codefellows.shapes.Rectangle;
import com.codefellows.shapes.Shape;
import com.codefellows.shapes.ShapeType;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PaintPane extends Pane {
    private List<Shape> shapes = new ArrayList<>();
    private Point2D p0;
    private Canvas canvas;
    private final AppState appState;

    public PaintPane(AppState appState) {
        this.appState = appState;

        BackgroundFill bf = new BackgroundFill(Color.gray(1.0),
                CornerRadii.EMPTY, Insets.EMPTY);

        setBackground(new Background(bf));

        setOnMousePressed(e -> {
            p0 = new Point2D(e.getX(), e.getY());
            addShape(p0);
        });

        setOnMouseDragged(e -> {
            Point2D finalPoint = new Point2D(e.getX(), e.getY());

            boolean isPen = appState.getShapeType() == ShapeType.PEN;

            if (shapes.size() > 0 && !isPen) {
                shapes.remove(shapes.size()-1);
            }

            addShape(finalPoint);
            redraw();

            if (isPen) {
                p0 = finalPoint;
            }
        });

        canvas = new Canvas(750, 500);
        getChildren().add(canvas);
    }

    private void addShape(Point2D p1) {
        Shape shape = null;

        double width = Math.abs(p0.getX()-p1.getX()+1);
        double height = Math.abs(p0.getY()-p1.getY()+1);

        double x = Math.min(p0.getX(), p1.getX());
        double y = Math.min(p0.getY(), p1.getY());

        double radius = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));

        switch (appState.getShapeType()) {
            case RECTANGLE:
                shape = new Rectangle(new Point2D(x, y), width, height);
                break;
            case CIRCLE:
                shape = new Circle(p0, radius);
                break;
            default:
                shape = new Line(p0, p1);
        }

        shape.setColor(appState.getColor());
        shape.setIsFilled(appState.isFilled());

        shapes.add(shape);
    }

    public void clear() {
        shapes.clear();
        redraw();
    }

    private void redraw() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (Shape s : shapes) {
            s.draw(canvas.getGraphicsContext2D());
        }
    }
}
