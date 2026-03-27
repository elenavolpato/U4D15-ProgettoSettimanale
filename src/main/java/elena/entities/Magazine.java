package elena.entities;

import elena.enumerated.Periodicity;
import jakarta.persistence.*;

@Entity
@Table(name="magazine")

public class Magazine extends LibraryItem{

    private Periodicity periodicity;

    public Magazine(){};

    public Magazine(String ISBN, int year, int pages, Periodicity periodicity){
        super(ISBN, year,pages);
        this.periodicity = Periodicity.WEEKLY;
    }

    public Periodicity getPeriodicity() {        return periodicity;    }

    public void setPeriodicity(Periodicity periodicity) {        this.periodicity = periodicity;    }

    @Override
    public String toString() {
        return "Magazine{" +
                "periodicity=" + periodicity +
                '}';
    }
}
