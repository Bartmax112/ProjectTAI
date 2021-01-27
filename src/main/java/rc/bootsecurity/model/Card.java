package rc.bootsecurity.model;

import javax.persistence.*;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String cardNumber;
    private String expDate;
    private String cvvCode;

    @ManyToOne
    private User user;

    public Card() {
    }

    public Card(String name, String cardNumber, String expDate, String cvvCode) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.cvvCode = cvvCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCvvCode() {
        return cvvCode;
    }

    public void setCvvCode(String cvvCode) {
        this.cvvCode = cvvCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return id != null ? id.equals(card.id) : card.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Card{" +
                ", name='" + name + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expDate='" + expDate + '\'' +
                ", cvvCode='" + cvvCode + '\'' +
                ", user=" + user +
                '}';
    }
}
