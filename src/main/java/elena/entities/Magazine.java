package elena.entities;

import elena.enumerated.Periodicity;
import jakarta.persistence.*;

@Entity
@Table(name="magazine")

public class Magazine extends LibraryItem{
    @Enumerated(EnumType.STRING)
    private Periodicity periodicity;

    public Magazine(){};

    public Magazine(String ISBN,String title, int year, int pages, Periodicity periodicity){
        super(ISBN,title, year,pages);
        this.periodicity = Periodicity.WEEKLY;
    }

    public Periodicity getPeriodicity() {        return periodicity;    }

    public void setPeriodicity(Periodicity periodicity) {        this.periodicity = periodicity;    }

    @Override
    public String toString() {
        return "Magazine{" +
                "id=" + getId() +
                ", ISBN='" + getISBN() +
                ", title='" + getTitle() +
                "periodicity=" + periodicity +
                '}';
    }
}
