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

    Customer customer = new Customer();
    customer.setName("Max Mustermann");

    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);

    Set<Address> addresses = new HashSet<>();
    addresses.add(address);
    customer.setAddresses(addresses);

    Set<Customer> owners = new HashSet<>();
    owners.add(customer);
    address.setOwners(owners);


    CreditCard creditCard = new CreditCard();
    creditCard.setNumber(12345);
    creditCard.setBalance(-5000);
    creditCard.setCreditLimit(-10000);


    CreditCard creditCard2 = new CreditCard();
    creditCard2.setNumber(123);
    creditCard2.setBalance(1);
    creditCard2.setCreditLimit(2000);

    Set<CreditCard> creditCards = new HashSet<>();


    Pincode pincode = new Pincode();
    pincode.setPin("123");
    pincode.setCount(1);

    creditCard.setPincode(pincode);
    creditCard2.setPincode(pincode);

    Bank bank = new Bank();
    bank.setName("Pengebank");

    creditCard.setOwningBank(bank);
    creditCard2.setOwningBank(bank);


    bank.setOwnedCards(creditCards);

    creditCards.add(creditCard);
    creditCards.add(creditCard2);

    customer.setCreditCards(creditCards);



    em.persist(customer);
    em.persist(address);
    em.persist(bank);
    em.persist(creditCard);
    em.persist(creditCard2);
    em.persist(pincode);

  }
}
