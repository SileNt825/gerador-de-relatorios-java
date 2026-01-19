package Services;

import entitites.Installments;
import entitites.taxServiceContract;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class RelatorioExcel implements RelatoriosServices {

    @Override
    public void gerar(String directory, String fileName, taxServiceContract contract) {
        File file = new File(directory, fileName + ".csv");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

            bw.write("Numero, Valor, Vencimento" + " - Número do contrato: " + contract.getContractNumber() + "\n");
            bw.newLine();
            for (Installments i : contract.getInstallments()){
                bw.write(i.toString());
                bw.newLine();
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

