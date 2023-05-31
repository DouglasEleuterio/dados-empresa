package br.com.douglas.dadosempresainsertdata.service.readfolder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface IReadFilesInFolder {

    String getFolderURI();
    void readFilesInFolder(String folderURI) throws IOException;

    List<Path> filesToRead() throws IOException;
}
