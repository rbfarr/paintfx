package com.codefellows;

import com.codefellows.config.AppConfig;
import com.codefellows.shapes.ShapeType;
import javafx.scene.paint.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppState {
    private ShapeType shapeType;
    private Color color;

    private boolean filled;

    private static AppState instance;
    private final AppConfig appConfig;

    private static final Logger log = LoggerFactory.getLogger(AppState.class);

    private AppState(AppConfig appConfig) {
        this.appConfig = appConfig;

        shapeType = appConfig.getInitialShape();
        color = appConfig.getInitialColor();
        filled = appConfig.getInitialFill();
    }

    public static AppState getInstance() {
        if (instance == null) {
            log.error("AppState not initialized with AppConfig!");
            System.exit(1);
        }

        return instance;
    }

    public static AppState getInstance(AppConfig appConfig) {
        if (instance == null) {
            instance = new AppState(appConfig);
        }

        return instance;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public AppConfig getAppConfig() {
        return appConfig;
    }
}
