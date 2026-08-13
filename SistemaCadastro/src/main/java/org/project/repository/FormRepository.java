package org.project.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
}
