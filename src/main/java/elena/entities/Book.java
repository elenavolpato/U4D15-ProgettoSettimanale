package elena.entities;

import elena.enumerated.BookGenre;
import jakarta.persistence.*;

@Entity
@Table(name="books")

public class Book extends LibraryItem{
    private String author;
    @Enumerated(EnumType.STRING)
    private BookGenre genre;

    public Book(){};

    public Book(String ISBN,String title,  int year, int pages, String author, BookGenre genre){
        super(ISBN, title, year,pages);
        this.author = author;
        this.genre = BookGenre.ROMANCE;
    }

    public BookGenre getGenre() {        return genre;    }
    public void setGenre(BookGenre genre) {        this.genre = genre;    }
    public String getAuthor() {        return author;    }
    public void setAuthor(String author) {        this.author = author;    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", genre=" + genre +
                '}';
    }
}
