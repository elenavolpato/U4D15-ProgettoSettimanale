package elena.dao;
//The archive must allow the following operations:
//    Add a catalog item
//    Remove a catalog item given an ISBN code
//    Search by ISBN
//    Search by publication year
//    Search by author
//    Search by title (or part of it)
//    Search for items currently on loan given a user's membership card number
//    Search for all overdue loans (loans that have expired and have not yet been returned)

import elena.entities.LibraryItem;
import jakarta.persistence.*;

public class LibraryItemDAO {
    private EntityManager em;
    public LibraryItemDAO (EntityManager em){this.em = em;}

    public void save(LibraryItem item){
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(item);
            t.commit();
            System.out.println("Item " + item.getTitle() + " added to the library");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
