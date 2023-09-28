package com.bts.app.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties properties = new Properties();

    public Properties readFromConfigFile() {

        try {
            FileInputStream fileInputStream = new FileInputStream("./src/test/Resources/Config/Config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
