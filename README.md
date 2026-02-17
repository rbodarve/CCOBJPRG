<div align="center">
  <h1>CCOBJPRG</h1>
  <h3>Object-Oriented Programming Exercises</h3>
  <p>A comprehensive collection of Java programming exercises demonstrating core OOP principles and concepts</p>
</div>

---

## Table of Contents

- [About The Project](#about-the-project)
- [Course Topics](#course-topics)
- [Weekly Exercises](#weekly-exercises)
- [Built With](#built-with)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Programs](#running-the-programs)
- [Project Structure](#project-structure)
- [Key Concepts Covered](#key-concepts-covered)
- [Contact](#contact)

---

## About The Project

This repository contains practical exercises and projects completed for the **CCOBJPRG (Object-Oriented Programming)** course. Each exercise demonstrates fundamental and advanced concepts of object-oriented programming using Java, including encapsulation, inheritance, polymorphism, abstraction, and GUI development.

The projects range from basic OOP implementations to complex GUI applications, showcasing progressive learning throughout the semester.

---

## Course Topics

This repository covers the following core OOP concepts:

- **Classes and Objects** - Fundamental building blocks of OOP
- **Encapsulation** - Data hiding and access control
- **Inheritance** - Code reusability through parent-child relationships
- **Polymorphism** - Method overriding and dynamic binding
- **Abstraction** - Abstract classes and interfaces
- **GUI Development** - Java Swing applications
- **Exception Handling** - Robust error management
- **Data Structures** - Arrays, ArrayLists, and collections

---

## Weekly Exercises

### Week 3: Public Transportation Fare Calculator
- **File:** `LRTMRT.java`
- **Description:** GUI application for calculating fares in Manila's LRT (Line 1 & 2) and MRT-3 transit systems
- **Concepts:** Java Swing, GUI components, Arrays, User input handling

### Week 4: Basic OOP Applications
- **Files:** `Bank.java`, `Calculator.java`
- **Description:** Fundamental OOP exercises
- **Concepts:** Classes, objects, methods, basic encapsulation

### Week 5: Inheritance Implementation
- **File:** `empInherit.java`
- **Description:** Employee management system demonstrating inheritance
- **Concepts:** Inheritance, superclass/subclass relationships, method overriding

### Week 6: Family Tree
- **File:** `familyTree.java`
- **Description:** Hierarchical relationship modeling
- **Concepts:** Object relationships, inheritance hierarchies

### Week 7: OOP Principles
- **Files:** `Abstraction.java`, `employeeCompany.java`
- **Description:** Comprehensive demonstration of core OOP principles
- **Concepts:** Encapsulation, polymorphism, abstraction, interfaces

### Week 14: Final Project
- **File:** `finalSwingLRT.java`
- **Description:** Enhanced LRT/MRT fare calculator with advanced features
- **Concepts:** Advanced GUI design, event handling, comprehensive OOP implementation

---

## Built With

- **Java** - Primary programming language
- **Java Swing** - GUI framework for desktop applications
- **OpenJDK 21.0.10** - Java Development Kit

---

## Getting Started

Follow these steps to get the project running on your local machine.

### Prerequisites

Ensure you have Java Development Kit (JDK) installed on your system:

```bash
# Check Java version
java -version
javac -version
```

If not installed, download from [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or install OpenJDK:

```bash
# For Ubuntu/Debian
sudo apt update
sudo apt install default-jdk

# For Fedora
sudo dnf install java-latest-openjdk-devel

# For macOS (using Homebrew)
brew install openjdk
```

### Installation

1. Clone the repository:
```bash
git clone https://github.com/rbodarve/CCOBJPRG.git
```

2. Navigate to the project directory:
```bash
cd CCOBJPRG
```

### Running the Programs

To compile and run any Java program:

```bash
# Navigate to the specific week folder
cd "Week 3"

# Compile the Java file
javac LRTMRT.java

# Run the program
java LRTMRT
```

For GUI applications (LRTMRT.java, finalSwingLRT.java), a window will appear upon execution.

---

## Project Structure

```
CCOBJPRG/
│
├── README.md
├── Week 3/
│   └── LRTMRT.java
├── Week 4/
│   ├── Bank.java
│   └── Calculator.java
├── Week 5/
│   └── empInherit.java
├── Week 6/
│   └── familyTree.java
├── Week 7/
│   ├── Abstraction.java
│   └── employeeCompany.java
└── Week 14/
    └── finalSwingLRT.java
```

---

## Key Concepts Covered

### Encapsulation
- Private fields with public getter/setter methods
- Data protection and controlled access

### Inheritance
- Parent-child class relationships
- Code reusability
- Method overriding

### Polymorphism
- Method overriding
- Dynamic method dispatch
- Runtime polymorphism

### Abstraction
- Abstract classes and methods
- Interface implementation
- Hiding implementation details

### GUI Programming
- Java Swing components
- Event handling
- User interaction design

---

## Contact

**Repository Owner:** rbodarve

**Project Link:** [https://github.com/rbodarve/CCOBJPRG](https://github.com/rbodarve/CCOBJPRG)

---

---

## Acknowledgments

README template inspired by [Best-README-Template](https://github.com/othneildrew/Best-README-Template) by [@othneildrew](https://github.com/othneildrew)

---

<div align="center">
  <p>If you find this repository helpful, please consider giving it a star!</p>
  <p>Made for learning Object-Oriented Programming</p>
</div>
