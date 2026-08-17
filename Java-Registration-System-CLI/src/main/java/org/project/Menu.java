package org.project;

import org.project.model.Person;
import org.project.repository.FormRepository;
import org.project.repository.PersonRepository;

import java.util.*;

public class Menu {
    FormRepository form = new FormRepository();
    PersonRepository personRepository = new PersonRepository();
    String formPath = "Java-Registration-System-CLI/src/data/form.txt";

    public static void menu() {
        Menu menu = new Menu();

        List<String> questions = menu.form.readForm(menu.formPath);

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
                    input.nextLine();
                    Map<String, String> answers = new HashMap<>();
                    for (String question : questions) {
                        System.out.println(question);
                        String answer = input.nextLine();

                        answers.put(question, answer);
                    }

                    String userName = answers.get("1 - What is your full name?");
                    String userEmail = answers.get("2 - What is your contact email?");
                    int userAge = Integer.parseInt(answers.get("3 - What is your age?"));
                    String userHeightStr = answers.get("4 - What is your height?");
                    userHeightStr = userHeightStr.replace(",", ".");
                    double userHeight = Double.parseDouble(userHeightStr);

                    Map<String, String> additionalAnswers = new HashMap<>();
                    for (Map.Entry<String, String> entry : answers.entrySet()){
                        String question = entry.getKey();
                        String answer =  entry.getValue();
                        if(!question.equals("1 - What is your full name?") && !question.equals("2 - What is your contact email?") &&
                                !question.equals("3 - What is your age?") && !question.equals("4 - What is your height?")){
                            additionalAnswers.put(question, answer);
                        }
                    }

                    Person user = new Person(userName, userEmail, userAge, userHeight, additionalAnswers);
                    menu.personRepository.savePerson(user);

                    System.out.println("Person registered successfully!");
                    System.out.println(user);
                    break;
                case 2:
                    List<String> registeredPersons = menu.personRepository.findAll();
                    System.out.println("\nRegistered persons:");
                    for (int i = 0; i < registeredPersons.size(); i++) {
                        System.out.println((i + 1) + "- " + registeredPersons.get(i));
                    }
                    break;
                case 3:
                    System.out.printf("Enter the new question to add to the form: ");
                    input.nextLine();
                    String newQuestion = input.nextLine();
                    menu.form.addQuestion(newQuestion, menu.formPath);
                    System.out.println("Question added successfully!");
                    questions = menu.form.readForm(menu.formPath);
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
