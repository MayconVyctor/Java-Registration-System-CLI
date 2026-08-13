package org.project.repository;

import org.project.model.Person;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PersonRepository {
    public void savePerson(Person person){
        String caminhoArquivo = "src/data/users/testUser.txt";

        try( BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
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
