package org.example;

import org.example.entity.Planet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetCrudService {

    public static void main(String[] args) {
        PlanetCrudService planetCrudService =  new PlanetCrudService();
        System.out.println(planetCrudService.readClient());
    }
    public void deleteClient(int id){
        Transaction transaction = null;
        Session session = HibernateUtil.getConfiguration().openSession();
        transaction = session.beginTransaction();
        Planet planet = session.get(Planet.class, id);
        session.delete(planet);
        transaction.commit();
    }
    public void createClient(Planet planet){
        Session session = HibernateUtil.getConfiguration().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(planet);
        transaction.commit();
    }

    public void updateClient(String name,int id){
        Session session = HibernateUtil.getConfiguration().openSession();
        Transaction transaction = session.beginTransaction();
        Planet planet = session.get(Planet.class , id);
        planet.setName(name);
        session.persist(planet);
        transaction.commit();
    }



    public List<Planet> readClient() {
        Session session = HibernateUtil.getConfiguration().openSession();
        return session.createQuery("FROM Planet", Planet.class).list();
    }
}
