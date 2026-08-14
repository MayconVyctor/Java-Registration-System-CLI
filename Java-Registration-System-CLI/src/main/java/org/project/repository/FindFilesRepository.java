package org.project.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FindFilesRepository {
    public List<String> findFiles(){
        List<String> fileNames = new ArrayList<>();

        Path path = Paths.get("src/data/users");
        try (Stream<Path> fluxo = Files.list(path)) {
            fluxo.forEach(arquivo -> System.out.println(arquivo.getFileName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileNames;
    }
}
