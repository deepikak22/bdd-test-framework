package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    static Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream("src//test//resources//config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readPropertyValue(String propertyName) {
        return properties.getProperty(propertyName);
    }
}
