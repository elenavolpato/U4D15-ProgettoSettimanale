package elena;
import jakarta.persistence.*;


//English Translation:
//Create a Java project that implements persistence management based on JPA and a PostgreSQL database for a bibliographic catalog with loan management.
//The repository must contain an attached ER diagram (created via drawsql.app), which should be appropriately commented on in the README to justify your design choices, as well as a screenshot of the same ERD from pgAdmin.
//Detailed instructions follow in the subsequent slides.
//Create the classes necessary to manage a library catalog. The catalog consists of items that can be either Books or Magazines. Both Books and Magazines have the following attributes:
//    ISBN Code (unique code, but not the Primary Key)
//    Title
//    Publication Year
//    Number of Pages
//Books additionally have:
//    Author
//    Genre
//Magazines have:
//    Periodicity [WEEKLY, MONTHLY, SEMI-ANNUAL]
//
// Additionally, create the classes necessary for loan management:
//      A User is characterized by the following attributes:
//    First Name
//    Last Name
//    Date of Birth
//    Membership Card Number (unique code, but not the Primary Key)
//
//A Loan is characterized by:
//    User
//    Borrowed Item (can be a book or a magazine)
//    Loan Start Date
//    Expected Return Date (calculated automatically as 30 days from the loan start date)
//    Actual Return Date

//The archive must allow the following operations:
//    Add a catalog item
//    Remove a catalog item given an ISBN code
//    Search by ISBN
//    Search by publication year
//    Search by author
//    Search by title (or part of it)
//    Search for items currently on loan given a user's membership card number
//    Search for all overdue loans (loans that have expired and have not yet been returned)

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("U4D15");

    public static void main(String[] args) {
        System.out.println("works");
    }
}
