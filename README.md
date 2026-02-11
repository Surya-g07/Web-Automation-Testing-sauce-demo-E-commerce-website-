# Web-Automation-Testing-sauce-demo-E-commerce-website-
Automated functional testing of the "SauceDemo" e-commerce site used Selenium WebDriver (Java) and TestNG. We ran end-to-end scenarios, created reusable base utilities, managed login validation, captured failure screenshots, and produced execution reports.


/*
Project Overview

This project is an end-to-end Selenium automation framework built using Java + TestNG for testing the SauceDemo web application.

The framework follows a clean TestNG lifecycle, uses a single browser session, and executes tests sequentially and visibly without flaky behavior.


Tech Stack:

Language: Java

Automation Tool: Selenium WebDriver

Test Framework: TestNG

Browser: Google Chrome

IDE: VS Code


All required dependencies are downloaded manually and included in lib/.

Also use maven for dependency management.
*/

Note: To handle the data breach alert in the SauceDemo website, please use the following credentials:

1. Before Login: We need to disable some chrome features.... 

    ChromeOptions opt = new ChromeOptions(); 
        /*Map<String, Object> prefs = new HashMap<>(); 
        prefs.put("-credential_enable_service", false); 
        prefs.put("profile.password_manager_enabled", false);
        opt.setExperimentalOption("prefs", prefs);
        opt.addArguments("--disable-blink-features=AutomationControlled"); 
        opt.addArguments("--disable-save-password-bubble"); 
        opt.addArguments("--incognito");
        ch = new ChromeDriver(opt);*/

        For more details please refer the Base.java file for more details....

2. After this we will handle the test case by default.

3. Test cases are executed in each section. Whenever the test case fails apart from the test logic just run single class at one by one to execute the correct result.

4. Please look through the "NOTE:", mentioned in the testng.xml

5. The defect will be logged in the TestNG report and the screenshot have been taken.

6. The Junit Folder will show the status of the test cases.
