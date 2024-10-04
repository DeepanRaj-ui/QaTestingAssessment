
# OrangeHRM Test Automation Framework

This project is a test automation framework for testing the [OrangeHRM](https://www.orangehrm.com/) application. The framework is built using **Selenium WebDriver**, **Cucumber**, **Java**, and the **Page Object Model (POM)** design pattern. It includes test scenarios for verifying the login functionality and can be extended for other features of OrangeHRM.

## Table of Contents

- [Test Case Design](#test-case-design)
- [Code Structure](#code-structure)
- [Setup and Installation](#setup-and-installation)
- [Running Tests](#running-tests)
- [Test Data](#test-data)
- [Reporting](#reporting)
- [Contributing](#contributing)

---

## Test Case Design

The test cases are designed using **Cucumber** in the form of feature files written in Gherkin syntax. Each feature file contains scenarios that represent different test cases. The framework uses the **Page Object Model (POM)** design pattern to separate the test logic from the web element locators and page-specific methods, making the test cases more maintainable and scalable.

### Example Test Case: Login to OrangeHRM

Feature: Login to OrangeHRM  
  - **Scenario**: Login with valid credentials  
    - **Given**: I am on the OrangeHRM login page  
    - **When**: I enter valid username and password  
    - **And**: I click the login button  
    - **Then**: I should see the dashboard page  

## Code Structure

```
src/
└── test/
    └── java/
        └── org.example/
            ├── pageObjects/          # Contains the Page Object classes
            │   └── LoginPage.java    # Page Object for login page
            ├── stepdefinitions/      # Contains Cucumber step definitions
            │   └── LoginSteps.java   # Step definitions for login scenarios
            ├── utilities/            # Utility classes for reading data and configurations
            │   ├── ExcelReader.java  # Utility to read data from Excel files
            │   └── configReader.java # Utility to read configuration data
            ├── runners/              # Test runner classes
            │   └── TestRunner.java   # JUnit runner for Cucumber tests
    └── resources/
        ├── features/                 # Cucumber feature files
        │   └── Login.feature         # Feature file for login tests
        └── testdata/                 # External test data files
            └── LoginData.xlsx        # Excel file containing login test data
pom.xml                               # Maven project file with dependencies
```

### Key Components

- **Page Objects**: Contains the classes for each page of the OrangeHRM application. Each page object class contains locators and actions specific to that page.
- **Step Definitions**: Maps the Gherkin steps from the feature files to Java methods. Here, the interaction between tests and page objects happens.
- **Runners**: Contains the JUnit runner class (`TestRunner.java`) to execute the Cucumber tests.
- **Utilities**: Contains helper classes like `ExcelReader` for reading external data files and `configReader` for reading configuration properties.
- **Feature Files**: Cucumber feature files written in Gherkin syntax that define the test scenarios.

## Setup and Installation

### Prerequisites

1. **Java**: Ensure that you have JDK 17 or higher installed.
2. **Maven**: Ensure Maven is installed and available in your system's PATH.
3. **Chrome WebDriver**: The framework is configured to run tests on Chrome. Ensure you have the Chrome browser installed and that the matching ChromeDriver version is available.

### Installation Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/orangehrm-automation.git
   cd orangehrm-automation
   ```

2. Install Maven dependencies:
   ```bash
   mvn clean install
   ```

## Running Tests

To execute the tests, you can use the following commands:

### Run All Tests
```bash
mvn clean test
```

This command will compile the project and execute all the scenarios defined in the feature files using the `TestRunner`.

### Run Specific Tests
If you want to run a specific feature or scenario, you can specify it in the command:
```bash
mvn -Dcucumber.options="src/test/resources/features/Login.feature" test
```

### Test Data

Test data is stored in an external Excel file (`LoginData.xlsx`) located in the `src/test/resources/testdata/` folder. The framework reads login credentials and other test data from this file using the `ExcelReader` utility class.

### Configuration

- **Base URL**: The base URL for the application is stored in the `config.properties` file. The `configReader` utility is responsible for loading this configuration during the tests.

## Reporting

After running the tests, a Cucumber report will be generated in the `target/cucumber-reports/` folder. It includes both HTML and JSON reports that provide a detailed summary of test results.

- To view the report, open the following file in your browser:
  ```bash
  target/cucumber-reports/cucumber-reports.html
  ```

## Contributing

If you would like to contribute to this project, feel free to fork the repository and submit a pull request. We welcome contributions for additional test scenarios, bug fixes, and improvements to the framework.

---

