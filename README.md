#Flight API

## Overview

This project serves a microservice backend for providing available airlines that is operating within a certain route.

The project is using the [Java Dropwizard Framework](http://www.dropwizard.io/).

## Running the application


 * To test and package the application run.

		mvn package

* To run the server run.

        java -jar target/flightapi-1.0-SNAPSHOT.jar server example.yml


* To post data into the application.

  curl -H "Content-Type: application/xml" -X POST -d '&lt;root&gt;&lt;from&gt;Singapore&lt;/from>&lt;to&gt;Tokyo&lt;/to>&lt;/root>'  http://localhost:8080/route


## Settings

The project comes with a built in data of airline routes under csv format. To use an external data, set the "data" value on the example.yml

	data:
  		/Users/michael/Desktop/temp/routes.csv
