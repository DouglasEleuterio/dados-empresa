package br.com.douglas.dadosempresainsertdata.service.readfile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface IReadFile<T> {

    List<T> getListBean(Path filePath, char separator) throws CsvValidationException, IOException;

}
