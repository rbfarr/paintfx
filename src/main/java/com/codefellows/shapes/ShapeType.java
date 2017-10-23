package com.codefellows.shapes;

public enum ShapeType {
    RECTANGLE("this is a rectangle"),
    CIRCLE("this is a circle"),
    LINE("this is a line"),
    PEN("this is a pen");

    private String shapeName;

    ShapeType(String shapeName) {
        this.shapeName = shapeName;
    }

    public String getShapeName() {
        return shapeName;
    }
}
