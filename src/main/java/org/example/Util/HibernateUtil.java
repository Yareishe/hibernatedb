package org.example.Util;

import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class HibernateUtil {

    public static void main(String[] args) throws SQLException, IOException {
        HibernateUtil hibernateUtil = new HibernateUtil();
        System.out.println(hibernateUtil.connection());
    }
    private static final HibernateUtil INSTANCE;
    private static SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtil();
    }
    private HibernateUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }
    public static HibernateUtil getInstance() {
        return INSTANCE;
    }
    public void close() {
        sessionFactory.close();
    }
    public static SessionFactory getConfiguration(){
        return sessionFactory;
    }

    public Connection connection() throws IOException, SQLException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("hibernate.properties");
        properties.load(fileInputStream);
        String dbUrl = properties.getProperty("jdbc:h2:tcp://localhost/~/init_db");
         String dbUsername = properties.getProperty("sa");
        String dbPassword = properties.getProperty("");
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        return connection;
    }
}