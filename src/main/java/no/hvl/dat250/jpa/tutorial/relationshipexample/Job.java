package no.hvl.dat250.jpa.tutorial.relationshipexample;


import jakarta.persistence.*;


@Entity
@Table(name ="Job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double salary;
    private String jobDescr;

    // getters and setters


}