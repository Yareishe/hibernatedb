package org.example.service;

import org.example.Util.HibernateUtil;
import org.example.entity.Planet;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

public class PlanetCrudService {
    public static void main(String[] args) {
        PlanetCrudService planetCrudService = new PlanetCrudService();

        Planet planet = new Planet();
        planetCrudService.createPlanet("ssddfgs","hhh");
    }

    public void deletePlanet(int id){
        Transaction transaction = null;
        Session session = HibernateUtil.getConfiguration().openSession();
        transaction = session.beginTransaction();
        Planet planet = session.get(Planet.class, id);
        session.delete(planet);
        transaction.commit();
        session.close();
    }
    public void createPlanet(String id,String name){
        Session session = HibernateUtil.getConfiguration().openSession();
        Transaction transaction = session.beginTransaction();
        Planet planet = new Planet();
        planet.setName(name);
        planet.setId(id);
        session.persist(planet);
        transaction.commit();
        session.close();
    }

    public void updatePlanet(String name,int id){
        Session session = HibernateUtil.getConfiguration().openSession();
        Transaction transaction = session.beginTransaction();
        Planet planet = session.get(Planet.class , id);
        planet.setName(name);
        session.persist(planet);
        transaction.commit();
        session.close();
    }



    public List<Planet> readPlanet() {
        Session session = HibernateUtil.getConfiguration().openSession();
        return session.createQuery("FROM Planet", Planet.class).list();

    }
}
