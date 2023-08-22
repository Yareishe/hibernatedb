package org.example.service;

import org.example.Util.HibernateUtil;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


public class TicketCrudService {
    private ClientCrudService clientCrudService;
    private PlanetCrudService planetCrudService;

    public static void main(String[] args) {
    }
    public void createTicket(Ticket ticket) {
        Session session = HibernateUtil.getConfiguration().openSession();
        Transaction transaction = session.beginTransaction();
            session.merge(ticket);
            transaction.commit();
            session.close();

    }

    public void deleteTicket(int id){
        Session session = HibernateUtil.getConfiguration().openSession();
        Transaction transaction = session.beginTransaction();
        Client client = session.get(Client.class, id);
        session.delete(client);
        transaction.commit();
        session.close();
    }
    public void updateTicket(Long id, String clientName, String toPlanetId, String fromPlanetId){
        Session session = HibernateUtil.getConfiguration().openSession();
        Transaction transaction = session.beginTransaction();
        Ticket ticket = session.get(Ticket.class , id);

        Client client = ticket.getClient();
        client.setName(clientName);

        Planet fromPlanet = ticket.getFromPlanet();
        fromPlanet.setName(fromPlanetId);

        Planet toPlanet = ticket.getToPlanet();
        toPlanet.setName(toPlanetId);

        ticket.setCreatedAt(new Timestamp(new Date().getTime()));
        session.persist(ticket);
        transaction.commit();
        session.close();
    }
    public List<Ticket> readTicket() {
        Session session = HibernateUtil.getConfiguration().openSession();
        return session.createQuery("FROM Ticket ", Ticket.class).list();
    }

    private void setClient(Client client, Planet planetTo, Planet planetFrom, Ticket ticket) {
        ticket.setClient(client);
        ticket.setToPlanet(planetTo);
        ticket.setFromPlanet(planetFrom);
        ticket.setCreatedAt(new Timestamp(new Date().getTime()));
    }
}
