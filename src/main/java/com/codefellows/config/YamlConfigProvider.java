package com.codefellows.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

public class YamlConfigProvider implements IConfigProvider {
    private static final String DEFAULT_CONFIG_FILE = "src/main/resources/config.yml";

    private static final Logger log = LoggerFactory.getLogger(YamlConfigProvider.class);

    private final String configFile;
    private Object configObj;

    public YamlConfigProvider() {
        this(DEFAULT_CONFIG_FILE);
    }

    public YamlConfigProvider(String configFile) {
        this.configFile = configFile;
    }

    public Config provide(Class className) {
        if (configObj == null) {
            try (InputStream inputStream = new FileInputStream(configFile)) {
                configObj = (new Yaml()).loadAs(inputStream, className);
            } catch (IOException ex) {
                log.error("Unable to read YAML config file: {}", configFile, ex);
                System.exit(1);
            }
        }

        return (Config)configObj;
    }
}
