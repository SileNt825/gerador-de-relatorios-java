package entitites;

import Exceptions.ExtentionTypeException;
import Services.RelatorioExcel;
import Services.RelatorioWord;
import Services.RelatoriosServices;

public class GenerateReports {

    public static RelatoriosServices create(int option) throws ExtentionTypeException {
        return switch (option) {
            case 1 -> new RelatorioExcel();
            case 2 -> new RelatorioWord();
            default -> throw new IllegalArgumentException("Opção inválida");
        };
    }
}