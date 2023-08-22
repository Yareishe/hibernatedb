package org.example;

import org.example.entity.Client;
import org.example.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.example.HibernateUtil;

import java.util.List;
import java.util.Objects;


public class ClientCrudService {
    public static void main(String[] args) {
        ClientCrudService clientCrudService = new ClientCrudService();
        clientCrudService.createClient(new Client("ff"));

        System.out.println(clientCrudService.readClient());
    }

    public void createClient(Client client){
        Session session = HibernateUtil.getConfiguration().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(client);
        transaction.commit();
    }

    public void deleteClient(int id){
        Transaction transaction = null;
        Session session = HibernateUtil.getConfiguration().openSession();
            transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            session.delete(client);
            transaction.commit();
    }


    public void updateClient(String name,int id){
        Session session = HibernateUtil.getConfiguration().openSession();
        Transaction transaction = session.beginTransaction();
        Client client = session.get(Client.class , id);
        client.setName(name);
        session.persist(client);
        transaction.commit();
    }



    public List<Client> readClient() {
        Session session = HibernateUtil.getConfiguration().openSession();
            return session.createQuery("FROM Client", Client.class).list();
    }
}
