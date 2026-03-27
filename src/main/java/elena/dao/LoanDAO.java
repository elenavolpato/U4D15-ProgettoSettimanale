package elena.dao;

import elena.entities.Loan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
import java.util.List;

public class LoanDAO {
    private EntityManager em;
    public LoanDAO (EntityManager em){this.em = em;}

    public void save(Loan loan){
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(loan);
            t.commit();
            System.out.println("Loan " + loan.getBorrowedItem() + " to client " + loan.getClient());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //    Search for items currently on loan given a user's membership card number
   public List<Loan> findLoanedItemByClientNum(long membershipNum){
      List<Loan> found = em.createQuery("SELECT l FROM Loan l " +
                      "WHERE l.client.membershipNum = :membershipNum " +
                      "AND l.actualReturnDate IS NULL", Loan.class)
              .setParameter("membershipNum", membershipNum)
              .getResultList();
        System.out.println("Item loaned by client membership number" +membershipNum+ " :"  + found);
        return found;
    }

    public List<Loan> findOverdueLoans() {
        List<Loan> found = em.createQuery(
                        "SELECT l FROM Loan l  WHERE l.expectedReturnDate < :today AND l.actualReturnDate IS NULL",
                        Loan.class)
                .setParameter("today", LocalDate.now())
                .getResultList();
        System.out.println("Overdue loans: " + found);
        return found;
    }





}
