package org.example.entity;


import jakarta.persistence.*;

@Table(name = "planet")
@Entity
public class Planet {
    @Id
    private String id;
    private String name;

    public Planet(String name) {
        this.name = name;
    }

    public Planet() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}' + "\n";
    }
}