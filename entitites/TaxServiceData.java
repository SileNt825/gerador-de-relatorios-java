package entitites;

import Services.TaxService;

import java.time.LocalDate;

public class TaxServiceData {
    public static TaxService service;

    public TaxServiceData(TaxService service) {
        TaxServiceData.service = service;
    }

    public static TaxService getService() {
        return service;
    }

    public static void setService(TaxService service) {
        TaxServiceData.service = service;
    }

    public void generateTotalTax(taxServiceContract contract, int months){
        double calculateQuotaPerMonths = contract.getTotalValue() / months;

        for(int i = 1; i<= months; i++){
            LocalDate dueDate = contract.getDate().plusMonths(i);

            double interest = service.interest(calculateQuotaPerMonths, i);
            double calculateTax = service.calculateTax(calculateQuotaPerMonths + interest);
            double totalQuota = calculateQuotaPerMonths + interest + calculateTax;

            contract.getInstallments().add(new Installments(dueDate,totalQuota));

        }

    }
}
