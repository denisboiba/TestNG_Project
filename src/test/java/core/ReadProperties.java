package core;

import java.io.IOException;
import java.util.Properties;

public final class ReadProperties {
    private static ReadProperties instance;
    static Properties properties;


    public ReadProperties() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ReadProperties getInstance() {
        if (instance == null) {
            instance = new ReadProperties();
        }
        return instance;
    }

    public String getApiURL() {
        return properties.getProperty("base_url");
    }
}


