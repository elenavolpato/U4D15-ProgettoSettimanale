package elena.entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="library_item")

public abstract class LibraryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String ISBN;
    @Column(name = "publication_year")
    private int year;
    @Column(name="num_pages")
    private int pages;

    public LibraryItem(){}

    public LibraryItem(String ISBN, int year, int pages){
        this.ISBN = ISBN;
        this.year = year;
        this.pages = pages;
    }

    public long getId() {        return id;    }
    public String getISBN() {         return ISBN;    } // isbn doesn't change, it's unique, so it does not require/allow a setter.

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
