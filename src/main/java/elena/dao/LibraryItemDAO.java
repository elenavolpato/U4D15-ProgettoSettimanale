package elena.dao;
//The archive must allow the following operations:
//    Search for items currently on loan given a user's membership card number
//    Search for all overdue loans (loans that have expired and have not yet been returned)

import elena.entities.Book;
import elena.entities.LibraryItem;
import elena.exceptions.NotFoundException;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    public LibraryItem findByIsbn(String isbn) {
        LibraryItem foundItem = em.createNamedQuery("find_by_isbn", LibraryItem.class).setParameter("isbn", isbn).getSingleResult();
        System.out.println("Item isbn:" + isbn + foundItem);
        if (foundItem == null) throw new NotFoundException(isbn);
        return foundItem;
    }

    public void deleteByIsbn(String isbn){
        try {
            EntityTransaction t = this.em.getTransaction();
            t.begin();
            LibraryItem foundItem = findByIsbn(isbn);

            em.remove(foundItem);
            t.commit();
            System.out.println("The item '" + foundItem.getTitle() + "' (ISBN: " + isbn + ") was successfully removed.");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Book> findByAuthor(String authorName) {
        try {
            TypedQuery<Book> query = em.createNamedQuery("find_books_by_author", Book.class);
            query.setParameter("author", authorName);
            System.out.println("Items with "+ authorName + "found:" + query.getResultList());
            return query.getResultList();

        } catch (Exception e) {
            System.err.println("Error searching by author: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<LibraryItem> findByYear(int year) {
         try {
            TypedQuery<LibraryItem> query = em.createNamedQuery("find_by_year", LibraryItem.class);
            query.setParameter("year", year);
             System.out.println("Items with "+ year + "found:" + query.getResultList());
            return query.getResultList();

        } catch (Exception e) {
            System.err.println("Error searching by author: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<LibraryItem> findByTitle(String term){
        try{
            TypedQuery<LibraryItem> query = em.createQuery("SELECT t FROM LibraryItem t WHERE LOWER(t.title) LIKE LOWER(:term)", LibraryItem.class);
            query.setParameter("term", "%" + term + "%");
            System.out.println(query.getResultList());
            return query.getResultList();

        }catch(Exception e) {
            System.err.println("Error searching by term: " + e.getMessage());
            return new ArrayList<>();
        }
    }

}
