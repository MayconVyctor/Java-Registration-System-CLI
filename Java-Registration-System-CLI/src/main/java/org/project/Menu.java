package org.project;

import org.project.model.Person;
import org.project.repository.FormRepository;
import org.project.repository.PersonRepository;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Menu {
    FormRepository form = new FormRepository();
    PersonRepository personRepository = new PersonRepository();

    public static void menu() {
        Menu menu = new Menu();

        List<String> questions = menu.form.readForm( "Java-Registration-System-CLI/src/data/form.txt");

        Scanner input = new Scanner(System.in);
        Locale localeBrasil = new Locale("pt", "BR");
        input.useLocale(localeBrasil);

        int option = -1;

        while (option != 0) {
            System.out.println("\nWelcome to the Registration System!");
            System.out.println("Please select an option:");
            System.out.println("1. Register a new person");
            System.out.println("2. List all registered persons");
            System.out.println("3. Register a new question in the form");
            System.out.println("4. Delete a question from the form");
            System.out.println("5. Search for a person by name or age or email");
            System.out.println("0. Exit the program");

            option = input.nextInt();
            switch (option) {
                case 1:
                    input.nextLine(); // Consume the newline character
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

                    menu.personRepository.savePerson(person);
                    break;
                case 2:
                    List<String> registeredPersons = menu.personRepository.findAll();
                    System.out.println("\nRegistered persons:");
                    for (int i = 0; i < registeredPersons.size(); i++) {
                        System.out.println((i + 1) + "- " + registeredPersons.get(i));
                    }
                    break;
                case 3:
                    // Code for registering a new question in the form
                    break;
                case 4:
                    // Code for deleting a question from the form
                    break;
                case 5:
                    // Code for searching for a person by name or age or email
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
