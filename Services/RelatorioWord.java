package Services;

import entitites.Installments;
import entitites.taxServiceContract;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RelatorioWord implements RelatoriosServices {

    @Override
    public void gerar(String dir, String fileName, taxServiceContract contract) throws IOException {
        File file = new File(dir, fileName + ".txt");

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){

            bw.write("Numero, Valor, Vencimento" + " - Número do contrato: " + contract.getContractNumber() + "\n");
            bw.newLine();
            for(Installments i :contract.getInstallments()){
                bw.write(i.toString());
            }
        }
    }
}
