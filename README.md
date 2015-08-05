#Flight API

## Overview

This project serves a microservice backend for providing available airlines that is operating within a certain route.

The project is using the [Java Dropwizard Framework](http://www.dropwizard.io/).

## Running the application


 * To test and package the application run.

		mvn package

 * To run database migration.

        java -jar target/flightapi-1.0-SNAPSHOT.jar db migrate example.mysql.yml

 * To run the server run.

        java -jar target/flightapi-1.0-SNAPSHOT.jar server example.mysql.yml


* To post data into the application.

  curl -H "Content-Type: application/xml" -X POST -d '&lt;root&gt;&lt;from&gt;Singapore&lt;/from>&lt;to&gt;Tokyo&lt;/to>&lt;/root>'  http://localhost:8080/route


## Settings

The project connects to a database.

	database:
      driverClass: com.mysql.jdbc.Driver
      user: someuser
      password: somepassword
      url: jdbc:mysql://localhost:3307/flightfinder
