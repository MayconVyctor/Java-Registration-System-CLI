package org.project.repository;

import org.project.model.Person;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PersonRepository {
    public void savePerson(Person person) {

        String fileName = person.getName();
        String customFileName = fileName.toUpperCase();
        customFileName = customFileName.replace(" ", "");
        File filePath = new File("Java-Registration-System-CLI/src/data/users/" +customFileName+ ".txt");

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