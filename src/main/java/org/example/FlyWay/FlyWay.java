package org.example.FlyWay;

import org.example.Util.PropertysLogin;
import org.flywaydb.core.Flyway;

import java.io.IOException;

public class FlyWay {



    public FlyWay() throws IOException {
    }

    public void migracia() throws IOException {

         final String url = PropertysLogin.getDatabaseUrl();
         final String username = PropertysLogin.getDatabaseUsername();
        final String password = PropertysLogin.getDatabasePassword();

        Flyway flyway = Flyway.configure().dataSource(url, username,null).load();

        flyway.migrate();
    }
}
