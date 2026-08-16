package org.project.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FormRepository {
    public List<String> readForm(String formPath) {
        List<String> formQuestions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(formPath))) {
            String questions = reader.readLine();
            while (questions != null) {
                formQuestions.add(questions);
                questions = reader.readLine();
            }
        } catch (IOException erro) {
            System.out.println("Ocorreu um erro ao ler o arquivo: ");
            erro.printStackTrace();
        }
        return formQuestions;
    }

    public void addQuestion(String question, String formPath) {

        FormRepository formRepository = new FormRepository();
        List<String> questions = formRepository.readForm(formPath);
        int numberQuestion = questions.size() + 1;

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(formPath, true))) {
            writer.newLine();
            writer.write(numberQuestion + "-" + question);

        } catch (IOException erro) {
            System.out.println("Ocorreu um erro ao gravar o arquivo: ");
            erro.printStackTrace();
        }
    }
}
