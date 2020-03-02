package ru.pupkov.stas.base;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Configuration {

    private Map<String,Map<String, Map<String, Map<String, Object>>>> map = new HashMap<>();

    private static volatile Configuration myInstance;
    private Configuration() {
        Yaml yaml = new Yaml();
        try {
            InputStream resourceAsStream =
                    Main.class.getClassLoader().getResourceAsStream("addresses-configuration.yml");
            map = yaml.load(resourceAsStream);
        }
        catch (Exception ignore) {
        }
    }
    public static Configuration getInstance() {
        if (myInstance == null) {
            synchronized (Configuration.class) {
                if (myInstance == null) {
                    myInstance = new Configuration();
                }
            }
        }
        return myInstance;
    }

    public Object getSelenoidHost() {return map.get("url").get("selenoidHost");}
    public Object getSelenoidPort() {return map.get("url").get("selenoidPort");}
    public Object getHost() {return map.get("url").get("host");}
    public Object getBrowserName() {return map.get("browser").get("name");}
    public Object getBrowserVersion() {return map.get("browser").get("version");}
}
