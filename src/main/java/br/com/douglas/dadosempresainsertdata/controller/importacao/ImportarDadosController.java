package br.com.douglas.dadosempresainsertdata.controller.importacao;

import br.com.douglas.dadosempresainsertdata.service.readfolder.IReadFilesInFolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/v1/importar")
public class ImportarDadosController {

    private final IReadFilesInFolder readFilesInFolder;

    public ImportarDadosController(IReadFilesInFolder iReadFilesInFolder) {
        this.readFilesInFolder = iReadFilesInFolder;
    }

    @GetMapping
    public ResponseEntity<Void> importarDadosEmpresa() throws IOException {
        readFilesInFolder.filesToRead();
        return ResponseEntity.noContent().build();
    }
}
