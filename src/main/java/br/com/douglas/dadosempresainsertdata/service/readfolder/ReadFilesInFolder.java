package br.com.douglas.dadosempresainsertdata.service.readfolder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
@Slf4j
public class ReadFilesInFolder implements IReadFilesInFolder{

    @Value("${application.csv-folder}")
    private String csvFolder;

    private List<Path> files;

    private final ResourceLoader resourceLoader;

    public ReadFilesInFolder(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        this.files = new ArrayList<Path>();
    }

    @Override
    public String getFolderURI() {
        return csvFolder;
    }

    @Override
    public void readFilesInFolder(String folderURI) throws IOException {
        this.csvFolder = getAbsolutPath();
        try(Stream<Path> paths = Files.walk(Paths.get(getFolderURI()))) {
            paths.filter(Files::isRegularFile).forEach(path -> files.add(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Path> filesToRead() throws IOException {
        this.readFilesInFolder(csvFolder);
        files.forEach(System.out::println);
        return this.files;
    }

    private String getAbsolutPath() throws IllegalAccessError {
        try {
            return ResourceUtils.getFile(this.getResource().getURL()).getAbsolutePath();
        }catch (Exception e){
            log.error("Erro ao acessar os arquivos da pasta: {}", csvFolder);
            log.info("Certifique-se que a pasta não esteja vazia");
            throw new IllegalAccessError("Erro ao acessar os arquivos da pasta: " + csvFolder);
        }
    }

    private Resource getResource(){
        return resourceLoader.getResource("classpath:".concat(csvFolder));
    }
}
