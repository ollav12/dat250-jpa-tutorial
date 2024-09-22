package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {

    // Create customer
    Customer customer = new Customer();
    customer.setName("Max Mustermann");

    // Create address
    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);

    // Create addresses list and set customer address
    Set<Address> addresses = new HashSet<>();
    addresses.add(address);
    customer.setAddresses(addresses);

    // Create owners list
    Set<Customer> owners = new HashSet<>();
    owners.add(customer);
    address.setOwners(owners);

    // Create pincode and initialize
    Pincode pincode = new Pincode();
    pincode.setPin("123");
    pincode.setCount(1);

    // Create credit card and initialize
    CreditCard creditCard1 = new CreditCard();
    creditCard1.setNumber(12345);
    creditCard1.setBalance(-5000);
    creditCard1.setCreditLimit(-10000);

    // Create second credit card
    CreditCard creditCard2 = new CreditCard();
    creditCard2.setNumber(123);
    creditCard2.setBalance(1);
    creditCard2.setCreditLimit(2000);

    // Create creditcards list
    Set<CreditCard> creditCards = new HashSet<>();

    // Add pincodee to creditcards
    creditCard1.setPincode(pincode);
    creditCard2.setPincode(pincode);

    // Create bank and set name
    Bank bank = new Bank();
    bank.setName("Pengebank");

    // Set creditcard owning bank
    creditCard1.setOwningBank(bank);
    creditCard2.setOwningBank(bank);

    // Set bank credit cards owned
    bank.setOwnedCards(creditCards);

    // Add creditcards to list
    creditCards.add(creditCard1);
    creditCards.add(creditCard2);

    // Set creditcards to customer
    customer.setCreditCards(creditCards);

    // Presist objects
    em.persist(customer);
    em.persist(address);
    em.persist(bank);
    em.persist(creditCard1);
    em.persist(creditCard2);
    em.persist(pincode);
  }
}
