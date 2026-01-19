package Services;

public interface TaxService {
    double calculateTax(double amount);
    double interest(double amount, double months);
}
