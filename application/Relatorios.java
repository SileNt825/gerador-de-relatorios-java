import Exceptions.ExtentionTypeException;
import Services.BrazilTaxService;
import entitites.*;
import Services.RelatoriosServices;

static void main() {
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    Scanner sc = new Scanner(System.in);
    System.out.println("Qual o valor do pagamento?");
    double amount = sc.nextDouble();
    System.out.println("Qual a data inicio do pagamento?");
    LocalDate date = LocalDate.parse(sc.next(), fmt);
    sc.nextLine();
    System.out.println("Qual o número do contrato: ");
    String contractNumber = sc.nextLine();
    taxServiceContract contract = new taxServiceContract(contractNumber, date, amount);

    System.out.println("Qual a quantidade de parcelas que voce quer pagar? (max: 12)");
    int installments = sc.nextInt();
    TaxServiceData taxData = new TaxServiceData(new BrazilTaxService());
    taxData.generateTotalTax(contract, installments);

    for(Installments i : contract.getInstallments()){
        System.out.println(i);
    }

    try {
        String directory = "C:\\Users\\username\\Documents\\reports";

        System.out.println("Nome do arquivo(Sem extensão)");
        String fileName = "RelatórioParcelas";
        System.out.println("""
                Escolha a extensão:
                1 - CSV
                2 - TXT
                """);
        int option = sc.nextInt();

        RelatoriosServices services = GenerateReports.create(option);
        RelatorioData data = new RelatorioData(services);
        data.create(directory, fileName, contract);

    } catch (ExtentionTypeException e) {
        System.out.println("Errow wrinting file" + e.getMessage());
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
}
