package com.codefellows;

import com.codefellows.config.AppConfig;
import com.codefellows.config.IConfigProvider;
import com.codefellows.config.YamlConfigProvider;
import com.codefellows.panes.ControlPane;
import com.codefellows.panes.PaintPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PaintingWithATwist extends Application {
    public static void main( String[] args ) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Painting, With A Twist!");

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);

        IConfigProvider configProvider = new YamlConfigProvider();

        AppConfig appConfig = (AppConfig)configProvider.provide(AppConfig.class);
        AppState appState = AppState.getInstance(appConfig);

        PaintPane paintPane = new PaintPane(appState);
        ControlPane controlPane = new ControlPane(appState, paintPane);

        root.setRight(paintPane);
        root.setLeft(controlPane);

        stage.setScene(scene);
        stage.show();
    }
}
