package org.project.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindFilesRepository {
    public List<String> findFiles(){

        List<String> fileNames = new ArrayList<>();

        Path path = Paths.get("Java-Registration-System-CLI/src/data/users");
        try (Stream<Path> flow = Files.list(path)) {
            fileNames = flow
            .map(file -> file.getFileName().toString())
            .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
           return new ArrayList<>();
        }
        return fileNames;
    }
}
