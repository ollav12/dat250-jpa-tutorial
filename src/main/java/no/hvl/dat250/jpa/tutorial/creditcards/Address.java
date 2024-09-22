package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name ="Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Integer number;
    @ManyToMany
    private Set<Customer> owners;

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public Set<Customer> getOwners() {
        return owners;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setOwners(Set<Customer> owners) {
        this.owners = owners;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
