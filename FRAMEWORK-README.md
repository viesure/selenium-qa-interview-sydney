# Framework Details

## Tools used

* **Java**
* **Maven**
* **Cucumber**
* **Cucumber Report**
* **Rest assured** (for API testing)

## Prerequisites

Install java. To check what java version is installed use `java --version`
Install a preferred IDE like IntelliJ, Visual Studio Code, Eclipse etc

The Framework is structured as follows: <br>

```
.
├── api
│   └── src
│       ├── main
│       └── test
│           ├── java                    (Cucumber test runner for api project)
│           │   └── step
│           │       └── definitions     (Step definitions)
│           └── resources
│               └── featureFiles        (Feature files)
│
├── reports                            (Cucumber reports)
├── resources
└── web
    └── src
        ├── main
        └── test
            ├── java                    (Cucumber test runner for web project)
            │   └── org
            │       └── weather
            │           └── app
            │               ├── pages
            │               └── step
            │                   └── definitions       (Step definitions)
            └── resources
                └── featureFiles        (Feature files)
```

The Framework is split in two parts. It has a super POM file and two child POM files for each sub-module:
* api
* web

Please refer to the above folder tree with description for most important folders

## Running the tests
Tests can be run using the 'mvn' command. Both api and web sub-modules can be run together or separately:
* `mvn clean test`
* `mvn clean test -pl api`
* `mvn clean test -pl web`

## Test execution Reports

Reports are located in `reports` folder (see the above folder structure) and are codenamed as `api` and `web`. 
The reports are generated in html format and can be opened in any browser. 
At the moment reports are overwritten at each test run. 
This is convenient for test creation as the reports can be automatically or manually refreshed to see the results.

## Current issues
As it is visible in the [API report](reports/cucumber_api.html) several tests are failing due to bugs.
[Web report](reports/cucumber_web.html) shows that website works fine.