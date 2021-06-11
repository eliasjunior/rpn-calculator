[![Java CI with Maven](https://github.com/eliasjunior/rpn-calculator/actions/workflows/build.yml/badge.svg)](https://github.com/eliasjunior/rpn-calculator/actions/workflows/build.yml)

# RPN Calculator

The project is splited into modules to make parts decoubled as the future of
RPN-Calculator in the company is to have an UI, I've built a very simple CLI to demostration usage,
but the main module is tested and easy to maintain or extent, always in mind using main SOLID principles as SRP and OCP


## Getting Started

### Prerequisites

* Java 11

* Maven Version 3.6.3

### Installation

1. Clone the rpn calculator
   ```sh
   git clone https://github.com/eliasjunior/rpn-calculator.git
   ```
2. Install Maven dependencies packages, run the command bellow.
   ```sh
   mvn clean package
   ```

### Usage
- run cli:
```bash
java -jar rpn-cli/target/rpn-cli-1.0-SNAPSHOT.jar
```
- test:
```bash
mvn clean test
```


## File Structure

The goal of the file structure here is to be easy to navigate

<a href="https://github.com/eliasjunior/rpn-calculator/blob/main/images/files-structure.png">
   <img src="img/files-structure.png" alt="Logo"  width="506px" height="895px">
</a>

## Technical Overview 

### CI

There is a basic CI with Git Actions that build, and test the project once changes pushed to master.

### rpn module 

Here is the heart to the app, the dependencies are injected to allow easy maintainability and testability

### cli module 

Simple cli for demonstration

## Observation

There are some comments on why how and why I've chosen some implementations

Happy Reviewing :)



