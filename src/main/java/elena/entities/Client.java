package elena.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="client")
@NamedQuery(name = "find_client_by_membership",
        query = "SELECT c FROM Client c WHERE c.membershipNum = :num")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="date_birth")
    private LocalDate dateBirth;

    @Column(name="membership_num", unique = true, nullable = false)
    private long membershipNum;

    @OneToMany(mappedBy = "client")
    private List<Loan> loans = new ArrayList<>();

    public Client(){   };
    public Client(String firstName, String lastName, LocalDate dateBirth, List<Loan> loans){
        this.firstName=firstName;
        this.lastName = lastName;
        this.dateBirth = dateBirth;
        //generates random num for membershipNum
        this.membershipNum = System.currentTimeMillis();

    }

    public Long getId() {        return id;    }

    public String getFirstName() {        return firstName;    }
    public void setFirstName(String firstName) {        this.firstName = firstName;    }

    public String getLastName() {        return lastName;    }
    public void setLastName(String lastName) {        this.lastName = lastName;    }

    public LocalDate getDateBirth() {        return dateBirth;    }
    public void setDateBirth(LocalDate dateBirth) {        this.dateBirth = dateBirth;    }

    public long getMembershipNum() {        return membershipNum;    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateBirth=" + dateBirth +
                ", membershipNum=" + membershipNum +
                '}';
    }
}
