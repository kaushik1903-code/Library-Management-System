# Library Management System

A Java-based Library Management System developed to simplify library operations such as book management, member registration, book issuing, returning, fine calculation and borrowing history.

## Project Overview

The Library Management System is a console-based application developed using Java and Object-Oriented Programming principles. It provides an organized way to manage library records and automate common library activities.

The application uses Java collections for efficient data handling and serialization for persistent storage of library records.

## Features

- **Book Management:** Add, search and display books.
- **Member Management:** Register students and faculty members.
- **Book Issuing:** Issue books to registered members.
- **Book Returns:** Process returned books and update availability.
- **Fine Calculation:** Calculate overdue fines based on member category.
- **Borrowing History:** Maintain and display borrowing records.
- **Data Persistence:** Save and retrieve library records using Java serialization.
- **Input Validation:** Handle invalid inputs and prevent duplicate member IDs.

## Technologies Used

- Programming Language: Java
- IDE: Visual Studio Code
- Data Structures: HashMap and Java Collections
- Storage: Java Serialization
- Version Control: Git and GitHub

## Project Structure

```text
LibraryManagementSystem/
│
├── Main.java
├── Book.java
├── Member.java
├── Student.java
├── Faculty.java
├── FineCalculator.java
├── Library.java
├── BorrowRecord.java
├── README.md
└── library.dat (generated during execution)
```

## Borrowing Policy

| Member Type | Maximum Books | Borrowing Period | Fine per Day |
|---|---:|---:|---:|
| Student | 3 | 14 days | ₹5 |
| Faculty | 5 | 30 days | ₹2 |

*These are the borrowing rules configured for this project.*

## Requirements

- Java Development Kit (JDK)
- Visual Studio Code or any Java-supported IDE
- Git (optional, for cloning the repository)

## Installation and Execution

### 1. Clone the repository

```bash
git clone https://github.com/kaushik1903-code/Library-Management-System.git
```

### 2. Open the project folder

```bash
cd Library-Management-System
```

### 3. Compile the Java files

```bash
javac *.java
```

### 4. Run the application

```bash
java Main
```

## Data Storage

The application uses Java serialization to save library information. The `library.dat` file is generated during execution and is used to restore saved records when the application is restarted.

## Object-Oriented Programming Concepts

The project demonstrates:

- Encapsulation
- Inheritance
- Polymorphism
- Abstraction
- Classes and Objects

## Project Team

| Name | Roll Number |
|---|---|
| S Krishna Kaushik | AP25110010956 |
| T Kulaya Swamy | AP25110010714 |
| P Bhaskar Sai Venkatesh | AP25110010227 |
| K Santosh | AP25110010833 |
| A Emmanuel | AP25110010810 |
| C Charitesh | AP25110010811 |

## GitHub Repository

[Library Management System – GitHub](https://github.com/kaushik1903-code/Library-Management-System)

---

**Developed as an academic project for the Department of Computer Science and Engineering, SRM University-AP.**