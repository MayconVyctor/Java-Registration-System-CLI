package org.project;

import org.project.model.Person;
import org.project.repository.FormRepository;
import org.project.repository.PersonRepository;
import org.project.service.PersonService;

import java.util.*;

public class Menu {
    FormRepository form = new FormRepository();
    PersonRepository personRepository = new PersonRepository();
    PersonService personService = new PersonService();
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
                    try {
                        input.nextLine();
                        Map<String, String> answers = new HashMap<>();
                        for (String question : questions) {
                            System.out.println(question);
                            String answer = input.nextLine();

                            answers.put(question, answer);
                        }

                        Person person = menu.personService.registerPerson(answers);

                        System.out.println("Person registered successfully!");
                        System.out.println(person);
                    }catch (InvalidPersonException exception){
                        System.out.println("It was not possible to complete the registration " + exception.getMessage());
                    } catch (NumberFormatException exception) {
                        System.out.printf("Please enter a valid number");
                    }
                    break;
                case 2:
                    List<String> registeredPersons = menu.personRepository.findAll();
                    System.out.println("\nRegistered persons:");
                    for (int i = 0; i < registeredPersons.size(); i++) {
                        System.out.println((i + 1) + "- " + registeredPersons.get(i));
                    }
                    break;
                case 3:
                    System.out.println("Enter the new question to add to the form: ");
                    input.nextLine();
                    String newQuestion = input.nextLine();
                    menu.form.addQuestion(newQuestion, menu.formPath);
                    System.out.println("Question added successfully!");
                    questions = menu.form.readForm(menu.formPath);
                    break;
                case 4:
                    System.out.println("Which question do you want to delete?");
                    questions = menu.form.readForm(menu.formPath);
                    for (int i = 0; i <questions.size(); i++) {
                        System.out.println(questions.get(i));
                    }
                    int questionNumber = input.nextInt();
                    boolean deleteQuestion = menu.form.deleteQuestion(questionNumber, menu.formPath);
                    if (deleteQuestion == true){
                        System.out.println("Question successfully deleted.");
                    }else {
                        System.out.println("This question cannot be excluded.");
                    }

                    break;
                case 5:
                    System.out.println("1- Search by name");
                    System.out.println("2- Search by email");
                    System.out.println("3- Search by age");
                    int search = input.nextInt();
                    if(search == 1){
                        input.nextLine();
                        System.out.println("Whats the person name?");
                        String name = input.nextLine();
                        List<String> nameSearch = menu.personRepository.findUserByName(name);
                        System.out.println("\n People found:");
                        for (int i = 0; i <nameSearch.size(); i++) {
                            System.out.println((i + 1) + "- " + nameSearch.get(i));
                        }
                    }
                    if (search == 2){
                        input.nextLine();
                        System.out.println("Whats the person email?");
                        String email = input.nextLine();
                        List<String> emailSearch = menu.personRepository.findUserByEmail(email);
                        System.out.println("\n People found:");
                        for (int i = 0; i <emailSearch.size(); i++) {
                            System.out.println((i + 1) + "- " + emailSearch.get(i));
                        }
                    }
                    if (search == 3){
                        input.nextLine();
                        System.out.println("Whats the person age?");
                        int age = input.nextInt();
                        List<String> ageSearch = menu.personRepository.findUserByAge(age);
                        System.out.println("\n People found:");
                        for (int i = 0; i <ageSearch.size(); i++) {
                            System.out.println((i + 1) + "- " + ageSearch.get(i));
                        }
                    }

                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye");
                    break;
                default:
                    System.out.println("Invalid option, Please try again");
                    break;
            }
        }
    }
}
