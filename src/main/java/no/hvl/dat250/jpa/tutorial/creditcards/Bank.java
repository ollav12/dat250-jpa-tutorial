package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name ="Bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    private Set<CreditCard> cards;

    public Long getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public Set<CreditCard> getOwnedCards() {
        return cards;
    }

    public void setOwnedCards(Set<CreditCard> creditCards) {
        this.cards = creditCards;
    }

    public void setName(String name) {
        this.name = name;
    }
}
