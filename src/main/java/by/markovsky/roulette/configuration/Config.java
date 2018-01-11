package by.markovsky.roulette.configuration;

import java.util.Properties;

/**
 * Created by Pavel Markovsky on 11.01.2018.
 */
public class Config {

    private static Properties properties = new Properties();
    static{
        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream("config/config.properties"));
        }
        catch(Exception exp){
            System.err.println("An error occured while opening config file!");
            exp.printStackTrace();
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
