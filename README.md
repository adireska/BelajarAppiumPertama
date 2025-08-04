# BelajarAppiumPertama

This project demonstrates mobile automation using Appium with Java and TestNG. It includes test cases for login functionality and inventory management on a mobile application.

## Features

*   Automated login tests.
*   Automated inventory screen interactions.
*   Utilizes Appium for mobile device automation.
*   Organized with Maven for dependency management.
*   Test execution managed by TestNG.

## Prerequisites

*   Java Development Kit (JDK)
*   Apache Maven
*   Appium Server
*   Android SDK and an Android Emulator or physical device

## Setup

1.  Clone the repository:
    ```bash
    git clone https://github.com/adireska/BelajarAppiumPertama.git
    cd BelajarAppiumPertama
    ```
2.  Ensure Appium Server is running.
3.  Ensure an Android Emulator or device is connected and recognized by ADB.

## Running Tests

1.  Build the project using Maven:
    ```bash
    mvn clean install
    ```
2.  Run the tests using TestNG. You can execute tests directly from your IDE or via Maven:
    ```bash
    mvn test
    ```
    Alternatively, you can run tests specified in `src/test/resources/testng.xml`.

## Project Structure

```
.
├── login_test_cases.csv
├── pom.xml
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── zonakode
│   │               └── appium
│   │                   ├── components
│   │                   │   └── HeaderComponent.java
│   │                   ├── screens
│   │                   │   ├── InventoryScreen.java
│   │                   │   └── LoginScreen.java
│   │                   └── utils
│   │                       ├── DragPositionUtil.java
│   │                       └── DriverUtil.java
│   └── test
│       ├── java
│       │   └── com
│       │       └── zonakode
│       │           └── appium
│       │               ├── InventoryTest.java
│       │               └── LoginTest.java
│       └── resources
│           └── testng.xml
└── target
    └── ... (compiled classes and test reports)
```

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License.
