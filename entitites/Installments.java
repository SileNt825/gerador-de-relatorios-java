package entitites;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installments{

    private LocalDate date;
    private double amount;

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Installments(LocalDate date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString(){
        return
                date.format(fmt) + " - " + String.format("%.2f\n", amount);
    }
}
