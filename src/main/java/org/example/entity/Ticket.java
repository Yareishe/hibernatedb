package org.example.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;


@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "id",nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_planet_id", referencedColumnName = "id",nullable = false)
    private Planet fromPlanet;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "to_planet_id",referencedColumnName = "id",nullable = false)
    private Planet toPlanet;

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Planet getFromPlanet() {
        return fromPlanet;
    }

    public void setFromPlanet(Planet fromPlanet) {
        this.fromPlanet = fromPlanet;
    }

    public Planet getToPlanet() {
        return toPlanet;
    }

    public void setToPlanet(Planet toPlanet) {
        this.toPlanet = toPlanet;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", client=" + client +
                ", fromPlanet=" + fromPlanet +
                ", toPlanet=" + toPlanet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && Objects.equals(client, ticket.client) && Objects.equals(fromPlanet, ticket.fromPlanet) && Objects.equals(toPlanet, ticket.toPlanet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, fromPlanet, toPlanet);
    }
}
