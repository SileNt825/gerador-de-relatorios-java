package entitites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class taxServiceContract {
    private String contractNumber;
    private LocalDate date;
    private double totalValue;

    private final List<Installments> installments = new ArrayList<>();

    public taxServiceContract(String contractNumber, LocalDate date, double totalValue) {
        this.contractNumber = contractNumber;
        this.date = date;
        this.totalValue = totalValue;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public List<Installments> getInstallments() {
        return installments;
    }
}
