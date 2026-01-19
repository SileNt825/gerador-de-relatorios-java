package entitites;

import Services.RelatoriosServices;

import java.io.IOException;

public class RelatorioData {
    public static RelatoriosServices services;

    public RelatorioData(RelatoriosServices services) {
        RelatorioData.services = services;
    }
    public void create(String dir, String fileName, taxServiceContract contract) throws IOException {
        services.gerar(dir,fileName, contract);
    }
}
