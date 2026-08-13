package org.project;

import org.project.model.Person;
import org.project.repository.FormRepository;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FormRepository form = new FormRepository();
        List<String> questions = form.readForm( "src/data/form.txt");

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

        Person person1 = new Person(userName, userEmail, userAge, userHeight);
        System.out.println(person1);
    }
}
