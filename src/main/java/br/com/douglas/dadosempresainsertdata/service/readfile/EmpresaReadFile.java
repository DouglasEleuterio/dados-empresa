package br.com.douglas.dadosempresainsertdata.service.readfile;

import br.com.douglas.dadosempresainsertdata.entity.Empresa;
import br.com.douglas.dadosempresainsertdata.enums.EnumPorteEmpresa;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmpresaReadFile implements IReadFile<Empresa> {

    private final List<Empresa> empresaList;
    private FileReader filereader;

    public EmpresaReadFile() {
        this.empresaList = new ArrayList<>();
    }

    private Optional<CSVReader> getCSVReader(Path filePath, char separator) {
        CSVParser parser = new CSVParserBuilder().withSeparator(separator).build();
        try  {
            filereader = new FileReader(filePath.toFile());
            return Optional.of(new CSVReaderBuilder(filereader)
                    .withCSVParser(parser).build());
        } catch (Exception e) {
            log.error(e.getMessage());
            return Optional.empty();
        }
    }


    private void readDataFromReader(CSVReader reader) throws CsvValidationException, IOException {
        while (reader.iterator().hasNext() && reader.getLinesRead() < 1000) {
            var data = reader.readNext();
            empresaList.add(
                    Empresa.builder()
                            .cnpjBase(data[0].replace("\"", ""))
                            .razaoSocial(data[1].replace("\"", ""))
                            .naturezaJuridica(data[2].replace("\"", ""))
                            .qualificacaoResponsavel(data[3].replace("\"", ""))
                            .capitalSocial(Double.valueOf(data[4].replace(",", ".")))
                            .porteEmpresa(EnumPorteEmpresa.fromCodigo(data[5].replace("\"", "")))
                            .enteFederativo(data[6].replace("\"", ""))
                            .build());
        }
        reader.close();
    }

    public List<Empresa> getListBean(Path filePath, char separator) throws CsvValidationException, IOException {
        var csvReader = getCSVReader(filePath, separator);
        if(csvReader.isPresent())
            readDataFromReader(csvReader.get());
        filereader.close();
        return empresaList;
    }
}
