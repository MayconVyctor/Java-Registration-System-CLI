package org.project.repository;

import org.project.model.Person;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


public class PersonRepository {
    public void savePerson(Person person) {

        String fileName = person.getName();
        String customFileName = fileName.toUpperCase();
        customFileName = customFileName.replace(" ", "");

        FindFilesRepository findFilesRepository= new FindFilesRepository();
        List<String> files = findFilesRepository.findFiles();
        Optional<Integer> largestFileNumber= files.stream()
                .map(file -> file.split("-"))
                .map(file -> file[0] )
                .map(file -> Integer.parseInt(file))
                .max(Integer::compareTo);

        int largestNumber = largestFileNumber.orElse(0);
        int fileNumber = largestNumber + 1;


        File filePath = new File("Java-Registration-System-CLI/src/data/users/" +fileNumber+ "-" +customFileName+ ".txt");

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(person.getName()+ "\n"+
                             person.getEmail()+ "\n"+
                             person.getAge()+ "\n"+
                             person.getHeight());
        } catch (IOException erro) {
            System.out.println("Ocorreu um erro ao gravar o arquivo: ");
            erro.printStackTrace();
        }
    }
}