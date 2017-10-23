package com.codefellows;

import com.codefellows.config.AppConfig;
import com.codefellows.config.IConfigProvider;
import com.codefellows.config.YamlConfigProvider;
import com.codefellows.shapes.ShapeType;
import javafx.scene.paint.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestYamlConfigProvider {
    @Test
    public void testAppConfig() {
        IConfigProvider configProvider = new YamlConfigProvider("src/test/resources/test-config.yml");

        AppConfig appConfig = (AppConfig)configProvider.provide(AppConfig.class);
        AppState appState = AppState.getInstance(appConfig);

        Assert.assertEquals(appState.getColor(), Color.BLUE);
        Assert.assertEquals(appState.getShapeType(), ShapeType.RECTANGLE);
        Assert.assertEquals(appState.isFilled(), true);
    }
}
