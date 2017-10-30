package com.codefellows.panes;

import com.codefellows.AppState;
import com.codefellows.config.AppConfig;
import com.codefellows.shapes.ShapeType;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControlPane extends VBox {
    private static final Logger log = LoggerFactory.getLogger(ControlPane.class);

    private final List<Button> shapeButtons = new ArrayList<>();

    private final CheckBox filledBox;
    private final ColorPicker colorPicker;
    private final Button clearButton;
    private final Button quitButton;

    private final AppState appState;

    public ControlPane(AppState appState, PaintPane paintPane) {
        this.appState = appState;

        shapeButtons.add(new Button("Rectangle"));
        shapeButtons.add(new Button("Circle"));
        shapeButtons.add(new Button("Line"));
        shapeButtons.add(new Button("Pen"));
        
        AppConfig appConfig = appState.getAppConfig();

        filledBox = new CheckBox(appConfig.getFilledBoxText());
        colorPicker = new ColorPicker(appConfig.getInitialColor());
        clearButton = new Button(appConfig.getClearButtonText());
        quitButton = new Button(appConfig.getQuitButtonText());

        filledBox.setSelected(appConfig.getInitialFill());

        for (Button b : shapeButtons) {
            getChildren().add(b);

            b.setOnAction(e -> {
                String buttonText = b.getText().toUpperCase();
                appState.setShapeType(ShapeType.valueOf(buttonText));

                log.debug(appState.getShapeType().getShapeName());
            });
        }

        filledBox.setOnAction(e -> appState.setFilled(filledBox.isSelected()));
        colorPicker.setOnAction(e -> appState.setColor(colorPicker.getValue()));
        clearButton.setOnAction(e -> paintPane.clear());

        quitButton.setOnAction(e -> {
            paintPane.saveShapes();
            Platform.exit();
            System.exit(0);
        });

        getChildren().add(filledBox);
        getChildren().add(colorPicker);
        getChildren().add(clearButton);
        getChildren().add(quitButton);

        setSpacing(10.0);
        setPadding(new Insets(10.0));
    }
}
