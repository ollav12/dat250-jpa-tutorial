package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name ="Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    private Set<Address> addresses;
    @ManyToMany
    private Set<CreditCard> creditCards;

    public String getName() {
        return name;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public Set<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public void setCreditCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
}
