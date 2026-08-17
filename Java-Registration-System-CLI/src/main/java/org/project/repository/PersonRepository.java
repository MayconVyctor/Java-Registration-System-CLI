package org.project.repository;

import org.project.model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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

    public List<String> findAll(){

        List<String> personNames = new ArrayList<>();
        FindFilesRepository findFilesRepository = new FindFilesRepository();
        List<String> files = findFilesRepository.findFiles();

        for (int i = 0; i < files.size(); i++) {
            try (BufferedReader reader = new BufferedReader(new FileReader("Java-Registration-System-CLI/src/data/users/" + files.get(i)))) {
                String personName = reader.readLine();

                personNames.add(personName);
            } catch (IOException erro) {
                System.out.println("Ocorreu um erro ao ler o arquivo: ");
                erro.printStackTrace();
            }
        }
        return personNames;
    }

    public List<String> findUserByName(String name){
        FindFilesRepository findFilesRepository = new FindFilesRepository();
        List<String> userNames = new ArrayList<>();
        List<String> files = findFilesRepository.findFiles();
        for (int i = 0; i < files.size(); i++) {
            try (BufferedReader reader = new BufferedReader(new FileReader("Java-Registration-System-CLI/src/data/users/" + files.get(i)))) {
                String personName = reader.readLine();
                if (personName.equalsIgnoreCase(name))
                    userNames.add(personName);
            } catch (IOException erro) {
                System.out.println("Ocorreu um erro ao ler o arquivo: ");
                erro.printStackTrace();
            }
        }
        return userNames;
    }

    public List<String> findUserByEmail(String email){

        FindFilesRepository findFilesRepository = new FindFilesRepository();

        List<String> userByEmails = new ArrayList<>();
        List<String> files = findFilesRepository.findFiles();

        for (int i = 0; i < files.size(); i++) {
            try (BufferedReader reader = new BufferedReader(new FileReader("Java-Registration-System-CLI/src/data/users/" + files.get(i)))) {
                String personName = reader.readLine();
                String personEmail = reader.readLine();
                if (personEmail.equalsIgnoreCase(email))
                    userByEmails.add(personName);
            } catch (IOException erro) {
                System.out.println("Ocorreu um erro ao ler o arquivo: ");
                erro.printStackTrace();
            }
        }
        return userByEmails;
    }

    public List<String> findUserByAge(int age){
        List<String> userByAge = new ArrayList<>();

        FindFilesRepository findFilesRepository = new FindFilesRepository();
        List<String> files = findFilesRepository.findFiles();

        for (int i = 0; i < files.size(); i++) {
            try (BufferedReader reader = new BufferedReader(new FileReader("Java-Registration-System-CLI/src/data/users/" + files.get(i)))) {
                String personName = reader.readLine();
                String personEmail = reader.readLine();
                int personAge = Integer.parseInt(reader.readLine());
                if (personAge == (age))
                    userByAge.add(personName);
            } catch (IOException erro) {
                System.out.println("Ocorreu um erro ao ler o arquivo: ");
                erro.printStackTrace();
            }
        }

        return userByAge;
    }
}