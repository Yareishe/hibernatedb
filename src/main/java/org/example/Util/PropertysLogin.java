package org.example.Util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;

public class PropertysLogin {

    private static final String PROPERTIES_FILE = "hibernate.properties";

    public static Properties getCredentials() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = PropertysLogin.class
                .getClassLoader().getResourceAsStream(PROPERTIES_FILE);

                properties.load(inputStream);

        return properties;
    }

    public static String getDatabaseUrl() throws IOException {
        return getCredentials().getProperty(URL);
    }

    public static String getDatabaseUsername() throws IOException {
        return getCredentials().getProperty(USER);
    }

    public static String getDatabasePassword() throws IOException {
        return getCredentials().getProperty(PASS);
    }
    private PropertysLogin(){

    }
}
