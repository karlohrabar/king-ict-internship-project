King ICT internship project

This small aplication written in Spring Boot utilizes a few GET endpoints to display data using another REST api called DummyJson. It features a list of products from various categories and our application fetches data from that list using different filtering techniques. Here are a few steps to help you get the app running locally so you can start using the endpoints.

This tutorial covers the Ubuntu operating system.

First, install the necessary packages to run the app.

Java Runtime Environment:

sudo apt install openjdk-21-jre

Maven:

sudo apt install maven

Now clone this repository and position yourself in it. Next, run this command:

mvn spring-boot:run

Alternatively, you can open the project using an IDE of choice (Intellij IDEA recommended) and run the project from it. 

And that's it! The app should be up and running.

These are all the available endpoints that you can access via web browser(make sure to start every URL with localhost:8080/api):

/hello -> prints out a Hello World! message
/products -> lists all products from the API
/product/{id} -> gives info about a specific product whose ID is the parameter
/product/random -> gives info about a random product
/product/{category}/{min}/{max} -> searches for products by category and price range
/product/search/{input} -> searches for products containing the input word as parameter

