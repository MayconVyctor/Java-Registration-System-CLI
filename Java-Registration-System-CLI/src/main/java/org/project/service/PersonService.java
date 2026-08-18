package org.project.service;

import org.project.InvalidPersonException;
import org.project.model.Person;
import org.project.repository.PersonRepository;

import java.util.HashMap;
import java.util.Map;

public class PersonService {
    private final PersonRepository personRepository = new PersonRepository();

    public Person createPerson( Map<String, String> answers){

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

        validatePerson(userName,userEmail,userAge,userHeight);
        return new Person(userName, userEmail, userAge, userHeight,additionalAnswers);
    }
    public Person registerPerson(Map<String, String> answers){
        Person person = createPerson(answers);
        personRepository.savePerson(person);
        return person;
    }

    private void validatePerson(String userName,String userEmail, int userAge,double userHeight){
        if (userAge <=0){
            throw new InvalidPersonException("Age cannot be 0 or negative");
        }

        if (userName == null){
            throw new InvalidPersonException("The name cannot be empty.");

        } else {
            String userNameConverted = userName.strip();
            if (userNameConverted.isEmpty()) {
                throw new InvalidPersonException("The name cannot be empty.");
            }
        }

        if (userEmail == null){
            throw new InvalidPersonException("The email cannot be empty.");
        }else {
            String userEmailConverted = userEmail.strip();
            if (userEmailConverted.isEmpty()) {
                throw new InvalidPersonException("The email  cannot be empty.");
            }
        }

        if (userHeight <= 0){
            throw new InvalidPersonException("Height cannot be 0 or negative");
        }
    }
}
