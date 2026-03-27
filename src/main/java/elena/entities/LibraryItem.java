package elena.entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="library_item")

@NamedQueries({
        @NamedQuery(name = "find_by_isbn", query = "SELECT i FROM LibraryItem i WHERE i.ISBN = :isbn"),
        @NamedQuery(name = "find_by_year", query = "SELECT i FROM LibraryItem i WHERE i.year = :year")
})

public abstract class LibraryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(unique = true, nullable = false)
    private String ISBN;

    @Column(name = "publication_year")
    private int year;

    @Column(name="num_pages")
    private int pages;

    public LibraryItem(){}

    public LibraryItem(String ISBN,String title, int year, int pages){
        this.ISBN = ISBN;
        this.title = title;
        this.year = year;
        this.pages = pages;
    }

    public Long getId() {        return id;    }

    public void setISBN(String ISBN) {        this.ISBN = ISBN;     }
    public String getISBN() {         return ISBN;    } // isbn doesn't change, it's unique, so it does not require/allow a setter.

    public String getTitle() {        return title;    }
    public void setTitle(String title) {        this.title = title;    }

    public int getYear() {        return year;    }
    public void setYear(int year) {        this.year = year;    }

    public int getPages() {        return pages;    }
    public void setPages(int pages) {        this.pages = pages;    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", ISBN='" + ISBN + '\'' +
                ", year=" + year +
                ", pages=" + pages +
                '}';
    }
}
