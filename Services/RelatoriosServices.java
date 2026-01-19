package Services;

import entitites.RelatorioData;
import entitites.taxServiceContract;

import java.io.IOException;

public interface RelatoriosServices {
    void gerar(String dir, String fileName, taxServiceContract contract) throws IOException;
}
