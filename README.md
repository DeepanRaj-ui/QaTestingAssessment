
# Test Automation Framework

This project is a test automation framework for testing the Test application. The framework is built using **Selenium WebDriver**, **Cucumber**, **Java**, and the **Page Object Model (POM)** design pattern.

## Table of Contents

- [Test Case Design](#test-case-design)
- [Setup and Installation](#setup-and-installation)
- [Running Tests](#running-tests)
- [Test Data](#test-data)
- [Reporting](#reporting)

---

## Test Case Design

The test cases are designed using **Cucumber** in the form of feature files written in Gherkin syntax. Each feature file contains scenarios that represent different test cases. The framework uses the **Page Object Model (POM)** design pattern to separate the test logic from the web element locators and page-specific methods, making the test cases more maintainable and scalable.
  
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
   git clone https://github.com/DeepanRaj-ui/QaTestingAssessment.git
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
---

