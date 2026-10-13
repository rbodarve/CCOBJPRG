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
- [Review findings (2026-10-13)](#review-findings-2026-10-13)
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
- **File:** `FamilyTree.java`
- **Description:** Hierarchical relationship modeling
- **Concepts:** Object relationships, inheritance hierarchies

### Week 7: OOP Principles
- **Files:** `Abstraction.java`, `EmployeeCompany.java`
- **Description:** Comprehensive demonstration of core OOP principles
- **Concepts:** Encapsulation, polymorphism, abstraction, interfaces

### Week 14: Final Project
- **File:** `FinalSwingLRT.java`
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

For GUI applications (LRTMRT.java, FinalSwingLRT.java), a window will appear upon execution.

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
│   └── FamilyTree.java
├── Week 7/
│   ├── Abstraction.java
│   └── EmployeeCompany.java
└── Week 14/
    └── FinalSwingLRT.java
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

## Review findings (2026-10-13)

A review and scripted simulation of all programs. The dialogs were driven by a stub `JOptionPane`. The code in this repository is unchanged (graded coursework). The fixes below were tested in a copy only.

### Suggested fixes (verified in a copy)

**a. Week 14: wrong station after a transfer from LRT 1, and a crash**
- Where: `Week 14/FinalSwingLRT.java:200, 206`.
- Why: `lrt1` passes `0` as `transfer`. The next line then starts at the LRT 1 origin index, not at Taft or Recto. An origin index of 13 or more crashes LRT 2.
- Fix: pass `1` instead of `0` (as `lrt2` and `lrt3` already do).
- Baclaran → EDSA, change to MRT 3: starts at `North Ave` → starts at `Taft`.
- Abad Santos → D. Jose, change to LRT 2: `ArrayIndexOutOfBoundsException: Index 14 out of bounds for length 13` → starts at `Recto`, no exception.

**b. Week 14: LRT 1 fares read from the wrong rows**
- Where: `Week 14/FinalSwingLRT.java:153` (matrix at `:19-40`, stations at `:74-76`).
- Why: `LRT1Fares` rows run Roosevelt (FPJ) → Baclaran; `station1` runs Baclaran → Roosevelt.
- Fix: `LRT1Fares[19 - initial][19 - finale]`.
- Baclaran → EDSA: `Php 20.0` → `Php 15.0`. Roosevelt → Baclaran: `Php 35.0` → `Php 35.0` (unchanged, as expected).

**c. Week 7: crash when a dialog is cancelled**
- Where: `Week 7/EmployeeCompany.java:116-120, 150, 158`.
- Why: cancel leaves `null` slots in `employees`, and `totalSalary()` calls a method on them. Cancel at the salary dialog passes `null` to `Double.parseDouble`, which throws `NullPointerException` (only `NumberFormatException` is caught).
- Fix: treat a `null` salary input as cancel (same message and `return` as the name dialog); add `if (employee == null) continue;` in `totalSalary()` and `displayInfo()`.
- Cancel at the first name: `NullPointerException` → `Total Salary: $0.0`.
- Cancel at the salary: `NullPointerException` → `Operation cancelled.`, then `Total Salary: $0.0`.

**d. Week 14: money shown with floating-point noise**
- Where: `Week 14/FinalSwingLRT.java:88, 167, 290, 413`.
- Fix: `String.format("%.2f", payment)` and `String.format("%.2f", pricy)`.
- MRT 3 student Beep, two rides: `Php 11.049999999999999`, `Total Payment 22.099999999999998` → `Php 11.05`, `Total Payment 22.10`.
- MRT 3 regular Beep: `Php 11.700000000000001` → `Php 11.70`.

### Other findings (not fixed)

- `Week 3/LRTMRT.java:72-89`: cancel at a station dialog silently selects the first station (Baclaran fare charged; on LRT 2 the end becomes Recto and the transfer prompt appears).
- `Week 3/LRTMRT.java:54-61, 91`: cancel at the payment dialog adds no fare and shows no message.
- `Week 3/LRTMRT.java:46-62`: cancel at the terminal dialog still asks for payment, then shows "Error.".
- `Week 3/LRTMRT.java:90`: the same start and end station is charged the minimum fare (13.0).
- `Week 7/EmployeeCompany.java:120-121`: `NaN` and `1e309` salaries are accepted; the total becomes `$NaN`.
- `Week 7/EmployeeCompany.java:104`: the duplicate check uses the untrimmed name, so "A" and " A" both pass.
- `Week 5/empInherit.java:7, 13`: a blank name `" "` and `NaN` years are accepted; a `null` department prints "Department: null".
- `Week 4/Bank.java:18-24`: a negative opening balance and an `Infinity` deposit are accepted; `double` money gives 0.30000000000000004.
- `Week 7/Abstraction.java:9-12`: `new Person("", 200)` prints errors but still builds a person with name `null` and age 0.
- `Week 4/Calculator.java:96-97`: "NaN" input is accepted; overflow shows "Infinity".
- `Week 7/Abstraction.java:55, 64`: `brand` is set but never read.
- `Week 14/FinalSwingLRT.java:83`: a user cancel shows "Error! Exiting App..".
- `Week 14/FinalSwingLRT.java:15`: option label "3-PWD (20%)"; the prompt at `:492` says "PWD (20%)".
- `Week 3/LRTMRT.java:42, 224`: "Philippine Railways" vs "Philippines Railways".

### Open question

The fare matrices give a different fare per direction in these cells (`[row][col]` = value / mirrored value). Which value is correct is unknown.
- `LRT1Fares`: `[0][17]` 35/33, `[1][6]` 20/25, `[2][7]` 20/25, `[4][17]` `[4][18]` `[4][19]` 35/30.
- `LRT2Fares`: `[4][6]` 20/30 (J. Ruiz ↔ Betty Go-Belmonte). `MRT3Fares` is symmetric.

### README corrections

- Week 7 lists "interfaces", but no file uses `interface` or `implements`. Suggested: "Encapsulation, inheritance, polymorphism, abstract classes".
- Week 14 lists "event handling", but it uses only `JOptionPane` dialogs and no listeners. Suggested: "Swing dialogs (`JOptionPane`), 2D fare tables, multi-line transfers".

### Simplification ideas (not tried)

- `Week 14/FinalSwingLRT.java:95-462`: `lrt1`/`lrt2`/`lrt3` are copies; one method with per-line station, fare and transfer arrays (about -240 lines).
- `Week 3/LRTMRT.java:62-221`: the three `switch` cases are copies; index arrays by line (about -110 lines).
- `Week 3/LRTMRT.java:72-89`, `Week 14/FinalSwingLRT.java:113-118, 140-145`: station-index loops → `Arrays.asList(stations).indexOf(name)`.
- `Week 14/FinalSwingLRT.java:123-129`: end-station list loop → `Arrays.stream(...).filter(...).toArray(String[]::new)`.
- `Week 14/FinalSwingLRT.java:154-162`: discount `if` chain → `pricy *= new double[]{0.90, 0.85, 0.80}[status]` when the card is Beep.

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
