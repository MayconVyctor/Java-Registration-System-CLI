package org.project;

import org.project.model.Person;
import org.project.repository.FindFilesRepository;
import org.project.repository.FormRepository;
import org.project.repository.PersonRepository;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        FormRepository form = new FormRepository();
        PersonRepository personRepository = new PersonRepository();
        FindFilesRepository findFilesRepository= new FindFilesRepository();

        List<String> questions = form.readForm( "Java-Registration-System-CLI/src/data/form.txt");

        Scanner input = new Scanner(System.in);
        Locale localeBrasil = new Locale("pt", "BR");
        input.useLocale(localeBrasil);

        System.out.println(questions.get(0));
        String userName = input.nextLine();
        System.out.println(questions.get(1));
        String userEmail = input.nextLine();
        System.out.println(questions.get(2));
        int userAge = input.nextInt();
        System.out.println(questions.get(3));
        double userHeight = input.nextDouble();

        Person person = new Person(userName, userEmail, userAge, userHeight);
        System.out.println(person);

        personRepository.savePerson(person);
        List<String> files = findFilesRepository.findFiles();

        System.out.println(files);

    }
}
