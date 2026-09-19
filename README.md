# Java Registration System CLI

Sistema de cadastro desenvolvido em Java para praticar conceitos fundamentais da linguagem, Programação Orientada a Objetos, Collections, Streams, tratamento de exceções e persistência de dados em arquivos.

O projeto possui uma interface de linha de comando (CLI) que permite cadastrar, listar e pesquisar pessoas, além de possibilitar a criação e remoção de perguntas do formulário de cadastro.

## Funcionalidades

- Cadastrar uma nova pessoa
- Listar pessoas cadastradas
- Pesquisar pessoas por nome
- Pesquisar pessoas por e-mail
- Pesquisar pessoas por idade
- Adicionar novas perguntas ao formulário de cadastro
- Remover perguntas do formulário
- Validar dados utilizando exceções personalizadas
- Persistir os dados em arquivos `.txt`
- Gerar automaticamente a numeração dos arquivos de cadastro

## Tecnologias e conceitos

- **Java**
- **Programação Orientada a Objetos (POO)**
- **Java Collections**
  - `List`
  - `Map`
  - `HashMap`
- **Streams e Optional**
- **File I/O**
  - `FileReader`
  - `FileWriter`
  - `BufferedReader`
  - `BufferedWriter`
  - `Path` e `Files`
- **Tratamento de exceções**
- **Exceções personalizadas**
- **Lambda expressions**
- **Scanner**
- **Git e GitHub**

## Estrutura do projeto

```text
src/
├── exception/
│   └── InvalidPersonException.java
├── model/
│   └── Person.java
├── repository/
│   ├── FindFilesRepository.java
│   ├── FormRepository.java
│   └── PersonRepository.java
├── service/
│   └── PersonService.java
└── Menu.java
