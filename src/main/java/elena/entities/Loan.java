package elena.entities;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id") // This creates the FK column in the DB
    private Client client;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private LibraryItem borrowedItem;

    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name="expected_return_date")
    private LocalDate expectedReturnDate;

    @Column(name="actual_return_date")
    private LocalDate actualReturnDate;


    public Loan(){}

    public Loan(Client client, LibraryItem borrowedItem, LocalDate startDate, LocalDate actualReturnDate ){
        this.client = client;
        this.borrowedItem = borrowedItem;
        this.startDate = startDate;
        this.actualReturnDate = actualReturnDate;
        setExpectedReturnDate(startDate);
    }

    public Long getId() {        return id;    }

    public Client getClient() {        return client;    }
    public void setClient(Client client) { this.client = client; }

    public LibraryItem getBorrowedItem() {        return borrowedItem;    }
    public void setBorrowedItem(LibraryItem borrowedItem) {        this.borrowedItem = borrowedItem;    }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) {this.startDate =startDate;}

    public LocalDate getExpectedReturnDate() {return expectedReturnDate;}
    public void setExpectedReturnDate(LocalDate startDate) {
        this.expectedReturnDate = startDate.plusDays(30);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", client=" + client +
                ", borrowedItem=" + borrowedItem +
                ", startDate=" + startDate +
                ", expectedReturnDate=" + expectedReturnDate +
                ", actualReturnDate=" + actualReturnDate +
                '}';
    }
}
