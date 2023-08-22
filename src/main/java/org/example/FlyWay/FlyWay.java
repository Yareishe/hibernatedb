package org.example.FlyWay;

import org.flywaydb.core.Flyway;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FlyWay {



    public void migracia()  {



        Flyway flyway = Flyway.configure().dataSource("jdbc:h2:tcp://localhost/~/init_db", "sa",null).load();

        flyway.migrate();
    }
}
