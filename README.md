# Package Sorting Application

This project is designed to help a robotic automation system determine the correct stack for packages based on their dimensions and weight. The packages are sorted into three categories: `STANDARD`, `SPECIAL`, and `REJECTED`.

## Features

- **STANDARD**: Packages that are neither bulky nor heavy.
- **SPECIAL**: Packages that are either bulky or heavy.
- **REJECTED**: Packages that are both bulky and heavy.

## Installation
Running the Main Application
### Prerequisites

Ensure you have the following installed on your machine:

- **Java Development Kit (JDK)** version 8 or later.
- A Java-compatible IDE (like IntelliJ IDEA, Eclipse) or a text editor with command-line support.
- A terminal or command prompt to run the Java files.

### Clone the Repository

Clone this repository to your local machine using the following command:

```bash
git clone https://github.com/your-username/package-sorting.git
cd package-sorting
cd src
javac model/*.java sorter/*.java Main.java
java Main
```

### Input the package dimensions and mass when prompted:

Enter the package width (cm): 150

Enter the package height (cm): 100

Enter the package length (cm): 50

Enter the package mass (kg): 25

The package should go to: SPECIAL

## Testing
The PackageSorterTest.java file contains a set of predefined test cases that validate the sorting logic.

### Running the Tests
```
cd src
javac model/*.java sorter/*.java PackageSorterTest.java
java PackageSorterTest
```

### Observe the output
If all tests pass, you will see:

#### All manual tests passed.



