package no.hvl.dat250.jpa.tutorial.relationshipexample;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name ="Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToOne
    private Family family;

    @Transient
    private String nonsenseField = "";

    @OneToMany
    private List<Job> jobList = new ArrayList<>();

    // getters and setters

    public void setFamily(Family family) {
        this.family = family;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}