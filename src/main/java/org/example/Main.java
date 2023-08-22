package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.FlyWay.FlyWay;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.example.service.TicketCrudService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.security.Timestamp;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        FlyWay main = new FlyWay();
        main.migracia();
    }


}