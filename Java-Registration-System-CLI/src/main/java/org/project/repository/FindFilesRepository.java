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
           .sorted((file1, file2) -> {
                int f1 = Integer.parseInt(file1.getFileName().toString().split("-")[0]);
                int f2 = Integer.parseInt(file2.getFileName().toString().split("-")[0]);
                return Integer.compare(f1, f2);
            })
            .map(file -> file.getFileName().toString())
            .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
           return new ArrayList<>();
        }
        return fileNames;
    }
}
