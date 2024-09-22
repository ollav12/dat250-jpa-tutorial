package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

@Entity
@Table(name ="Pincode")
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pin;
    private Integer count;

    public Long getId() {
        return id;
    }

    public String getCode() {
        return pin;
    }

    public Integer getCount() {
        return count;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
