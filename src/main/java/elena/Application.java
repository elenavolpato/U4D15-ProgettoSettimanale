package elena;
import elena.dao.ClientDAO;
import elena.dao.LibraryItemDAO;
import elena.dao.LoanDAO;
import elena.entities.*;
import elena.enumerated.BookGenre;
import elena.enumerated.Periodicity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;


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
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4D15");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        LibraryItemDAO libraryDAO = new LibraryItemDAO(em);
        ClientDAO clientDAO = new ClientDAO(em);
        LoanDAO loanDAO = new LoanDAO(em);

        //    Add a catalog item
        Book cegueira = new Book("123456", "Ensaio sobre a cegueira", 1960, 259, "José Saramago", BookGenre.THRILLER);
        Book memorias = new Book("9788572325424", "Memórias Póstumas de Brás Cubas", 1881, 224, "Machado de Assis", BookGenre.ROMANCE);
        Book horaDaEstrela = new Book("9788570221350", "A Hora da Estrela", 1977, 96, "Clarice Lispector", BookGenre.ROMANCE);
        Book capitaesDaAreia = new Book("9788535911695", "Capitães da Areia", 1937, 280, "Jorge Amado", BookGenre.FANTASY);
        Book alquimista = new Book("9788575427583", "O Alquimista", 1988, 208, "Paulo Coelho", BookGenre.HISTORICAL_FICTION);

        //libraryDAO.save(alquimista);
//      libraryDAO.save(memorias);
//      libraryDAO.save(horaDaEstrela);
//      libraryDAO.save(capitaesDaAreia);

        Magazine superBike = new Magazine("44587996321","La nuova BMW XR1200", 2025, 62, Periodicity.MONTHLY);
        Magazine focus = new Magazine("9771120515003", "Focus: Il Futuro dell'IA", 2026, 120, Periodicity.MONTHLY);
        Magazine cucina = new Magazine("9771121356001", "La Cucina Italiana: Speciale Pasqua", 2026, 85, Periodicity.SEMI_ANNUAL);
        Magazine limes = new Magazine("9788883719924", "Limes: Il mondo nel 2026", 2026, 250, Periodicity.MONTHLY);
        Magazine natGeo = new Magazine("9771128561002", "National Geographic Italia", 2026, 114, Periodicity.MONTHLY);

     //libraryDAO.findByIsbn("9788575427583");
//      libraryDAO.save(focus);
//      libraryDAO.save(cucina);
//      libraryDAO.save(limes);

        //libraryDAO.findByAuthor("Paulo Coelho");
        //libraryDAO.findByYear(2026);

        //libraryDAO.findByTitle("La");
        //    libraryDAO.deleteByIsbn("9788575427583");



        Client c1 = new Client("Machado", "de Assis", LocalDate.of(1839, 6, 21), new ArrayList<>());
        Client c2 = new Client("Clarice", "Lispector", LocalDate.of(1920, 12, 10), new ArrayList<>());
        Client c3 = new Client("Jorge", "Amado", LocalDate.of(1912, 8, 10), new ArrayList<>());

        //clientDAO.save(c2);
        LibraryItem book1 = libraryDAO.findByIsbn("9788572325424");
        // LibraryItem book2 = libraryDAO.findByIsbn("9788572325424");
        //LibraryItem book3 = libraryDAO.findByIsbn("9771121356001");

        Client client1fromDB = clientDAO.findByMembershipNum(1774622523653L);

        Loan loan2 = new Loan(client1fromDB, book1, LocalDate.now().minusDays(50), null);

        loanDAO.save(loan2);

        loanDAO.findLoanedItemByClientNum(1774622523653L);

        loanDAO.findOverdueLoans();


        em.close();
        emf.close();
    }

}

