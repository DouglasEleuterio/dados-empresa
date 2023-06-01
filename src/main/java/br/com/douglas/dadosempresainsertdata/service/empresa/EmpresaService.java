package br.com.douglas.dadosempresainsertdata.service.empresa;

import br.com.douglas.dadosempresainsertdata.entity.Empresa;
import br.com.douglas.dadosempresainsertdata.repository.EmpresaRepository;
import br.com.douglas.dadosempresainsertdata.service.readfile.IReadFile;
import br.com.douglas.dadosempresainsertdata.service.readfolder.IReadFilesInFolder;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final IReadFile<Empresa> iReadFile;
    private final IReadFilesInFolder readFilesInFolder;

    public EmpresaService(EmpresaRepository empresaRepository, IReadFile<Empresa> iReadFile, IReadFilesInFolder readFilesInFolder) {
        this.empresaRepository = empresaRepository;
        this.iReadFile = iReadFile;
        this.readFilesInFolder = readFilesInFolder;
    }

    public List<Empresa> findAll(){
        return empresaRepository.findAll();
    }

    public boolean saveEmpresas() throws IOException, CsvValidationException {
        var files = readFilesInFolder.filesToRead();
        var empresas = iReadFile.getListBean(files.get(0), ';');
        empresaRepository.saveAll(empresas);
        return true;
    }
}
