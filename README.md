# Java Registration System CLI

A command-line application developed in Java for registering and managing people.

## Features

- Register a new person
- List registered people
- Search people by name
- Search people by email
- Search people by age
- Add questions to the registration form
- Delete questions from the form
- Validate person data with custom exceptions
- Persist data using text files

## Technologies

- Java
- Java Collections
- File I/O
- Exception Handling
- Streams
- Object-Oriented Programming

## Project Structure

```text
src/
├── exception/
├── model/
├── repository/
├── service/
└── Menu.java
```

## How it works

The application uses a command-line menu to interact with the user.

Person registration follows the flow:

Menu → PersonService → PersonRepository → File

The `PersonService` is responsible for creating and validating `Person` objects, while the repository handles file persistence.
