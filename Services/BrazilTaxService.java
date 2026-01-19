package Services;

public class BrazilTaxService implements TaxService{
    @Override
    public double calculateTax(double amount) {
        return amount * 0.02;
    }
    public double interest(double amount, double months){
        return amount * 0.01 * months;
    }
}
