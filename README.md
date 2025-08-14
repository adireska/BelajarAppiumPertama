# BelajarAppiumPertama

This project is a collection of Appium tests written in Java using Maven. It focuses on automating mobile application testing.

This project includes tests for login functionality, inventory management, and viewing item details.

## Features

This project includes automated tests for the following functionalities:
*   **Login:** Verifies the user login process.
*   **Inventory Management:** Tests functionalities related to managing inventory items.
*   **Detail Inventory:** Tests the display and interaction zoom in.

## Clone Repository

To get a local copy of the project, clone the repository using Git:

```bash
git clone https://github.com/adireska/BelajarAppiumPertama.git
```

## Prerequisites

*   Java Development Kit (JDK) installed.
*   Apache Maven installed.

## Build

To build the project, navigate to the project's root directory in your terminal and run the following Maven command:

```bash
mvn clean install
```

This command will compile the source code, run tests, and package the project.

## Run Tests

To run the tests, use the following Maven command:

```bash
mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testng.xml  
```

This command will execute all the tests defined in the project.
