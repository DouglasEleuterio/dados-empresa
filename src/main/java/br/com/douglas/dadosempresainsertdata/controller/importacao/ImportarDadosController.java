package br.com.douglas.dadosempresainsertdata.controller.importacao;

import br.com.douglas.dadosempresainsertdata.service.empresa.EmpresaService;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/v1/importar")
public class ImportarDadosController {


    private final EmpresaService empresaService;

    public ImportarDadosController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("preparar-lista-de-dados")
    public ResponseEntity<List<Path>> importarDadosEmpresa() throws IOException, CsvValidationException {
        empresaService.saveEmpresas();
        return ResponseEntity.accepted().body(null);
    }
}
