package br.com.douglas.dadosempresainsertdata.service.empresa;

import br.com.douglas.dadosempresainsertdata.entity.Empresa;
import br.com.douglas.dadosempresainsertdata.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> findAll(){
        return empresaRepository.findAll();
    }
}
