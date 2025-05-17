# VehicFinder

VehicFinder is a Java-based application that helps users find cars matching their specific needs, such as budget, year, and seating capacity. It supports both local and server/client modes to display filtered car options, including common issues.

## Table Of Content
- [Problem](#Problem)
- [Solution](#Solution)
- [Usage](#Usage)
- [How To Download The Application](#how-to-download-the-application)
- [How to use the application](#how-to-use-the-application)
- [Test Unit](#Test-Unit)
- [Disclosure of the use of gen AI](#Disclosure-of-the-use-of-gen-AI)

## Problem

Many people find it hard to find an appropriatecar that fits their needs.
Many Specifications come to their mind like:

-What is budget?

-What is the year of production?

-How many people do it carry?

-What are the car issues?

## Solution

We planned to solve this problem by creating an app that takes the user specification. 
By entering his specification, the app will show him the cars found based on his choice 
and all the information needed including car common issues. This app will solve a major 
problem, and it includes local and global issues that everyone can get help using this 
app.

## Prerequisites
Java 11 or higher: Ensure you have Java installed on your system.

Maven: Used for dependency management and building the project.

Database: MySQL, or any other preffered database (You have to change the dependencies on the pom.xml file and then sync)

## Usage

### How To Download The Application
First you have to use git bash

Second choose the path for the project

Third write this command: git clone [https://github.com/TalalAlha/VehicFinder-CPIT305-Project.git](https://github.com/TalalAlha/VehicFinder-CPIT305-Project.git)

Finnaly open the project using your preferred Java IDE



### How to use the application
![Main Menu](https://github.com/TalalAlha/305-Project/blob/65191f1a3e286daf20ab4514b69cd8d76f18047a/Pictures/Menu.png)


You have two choices Server or Loacl.Choose local if you want to run the application locally and Server if you want to run the application using server/client.


![LocalInput](https://github.com/TalalAlha/305-Project/blob/65191f1a3e286daf20ab4514b69cd8d76f18047a/Pictures/LocalInput.png)

Lets choose local.
After you choose there are 3 inputs you have to put:

1- Car Year Model

2- Maximum price you will pay

3- Number of seats for the car

![LocalResult](https://github.com/TalalAlha/305-Project/blob/65191f1a3e286daf20ab4514b69cd8d76f18047a/Pictures/LocalResult.png)


After you put your choices, all cars that meet your specification will be shown.

![RunningServer](https://github.com/TalalAlha/305-Project/blob/65191f1a3e286daf20ab4514b69cd8d76f18047a/Pictures/RunningServer.png)

Now we will choose the second choice that will run the server on port 9000

![ClientInput](https://github.com/TalalAlha/305-Project/blob/65191f1a3e286daf20ab4514b69cd8d76f18047a/Pictures/ClientInput.png)

Now we will go to the client class and run it. After running the client class it will show us the same choices like the local choices, but this time it is running of server.

![ClientResult](https://github.com/TalalAlha/305-Project/blob/65191f1a3e286daf20ab4514b69cd8d76f18047a/Pictures/ClientResult.png)

After you put your choices, all cars that meet your specification will be shown.
## Test Unit

If we run the Test Unit it will work successfully as shown
![TestUnit](https://github.com/TalalAlha/VehicFinder-CPIT305-Project/blob/33cfeafa29e9c9eee1e95b6ba2d10696416fdf75/Pictures/TestUnit.png)

## Disclosure of the use of gen AI

We used chatGPT to create Test Unit for the project

