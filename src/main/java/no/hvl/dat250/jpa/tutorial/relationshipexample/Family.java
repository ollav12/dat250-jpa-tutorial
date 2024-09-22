package no.hvl.dat250.jpa.tutorial.relationshipexample;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name ="Family")
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @OneToMany(mappedBy = "family")
    private final List<Person> members = new ArrayList<>();

    // getters and setters

    public List<Person> getMembers() {
        return members;
    }

    public void setDescription(String description) {
//        this.description = description;
    }
}