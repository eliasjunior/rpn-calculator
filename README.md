# RPN Calculator

<br />
<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#technical-overview">Technical overview</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->

## About The Project

RPN calculator using a stack

</br>

## Getting Started

### Prerequisites

* Java 11

* Maven Version 3.6.3

### Installation

1. Clone the Weekly-menu-react App
   ```sh
   git clone 
   ```
2. Install Maven dependencies packages, run the command bellow.
   ```sh
   mvn package
   ```

## Technical Overview

### Frameworks and Libs

React

* Positive personal experience.
* Instability
* It embraces reusability, testability and Javascript native features instead of adding a api layer.

CSS

* React Material


### Code Structure

Organized by features

root
- features
    - components(returns a html/jsx or actions(functions from the component))
    - presenter (layer between view and the access-data)
    - data-access (access external API)
    - helpers


