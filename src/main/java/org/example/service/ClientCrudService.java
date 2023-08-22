package org.example.service;

import org.example.entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.example.Util.HibernateUtil;

import java.util.List;


public class ClientCrudService {
    public static void main(String[] args) {
        ClientCrudService clientCrudService = new ClientCrudService();
        clientCrudService.createClient(new Client("fff"));
    }


    public void createClient(Client client){
        Session session = HibernateUtil.getConfiguration().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(client);
        transaction.commit();
        session.close();
    }

    public void deleteClient(int id){
        Transaction transaction = null;
        Session session = HibernateUtil.getConfiguration().openSession();
            transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            session.delete(client);
            transaction.commit();
            session.close();
    }


    public void updateClient(String name,int id){
        Session session = HibernateUtil.getConfiguration().openSession();
        Transaction transaction = session.beginTransaction();
        Client client = session.get(Client.class , id);
        client.setName(name);
        session.persist(client);
        transaction.commit();
        session.close();
    }



    public List<Client> readClient() {
        Session session = HibernateUtil.getConfiguration().openSession();
            return session.createQuery("FROM Client", Client.class).list();
    }
}
