package br.com.douglas.dadosempresainsertdata.controller.empresa;

import br.com.douglas.dadosempresainsertdata.entity.Empresa;
import br.com.douglas.dadosempresainsertdata.service.empresa.EmpresaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public List<Empresa> findAll(){
        return empresaService.findAll();
    }
}
