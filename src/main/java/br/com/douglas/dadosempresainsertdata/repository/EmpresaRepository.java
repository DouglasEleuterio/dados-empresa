package br.com.douglas.dadosempresainsertdata.repository;

import br.com.douglas.dadosempresainsertdata.entity.Empresa;
import br.com.douglas.dadosempresainsertdata.service.empresa.EmpresaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
