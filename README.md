# Rock-Paper-Scissors
An implementation of the Rock-Paper-Scissors game including variants as a RESTful service using spring.

## Build and Run
The application was built using Java 8.
Build the application using the gradle wrapper provided in the repository. Run
`./gradlew build` or
`./gradlew.bat build` for Windows.

To run the application after the build is done run `java -jar build/libs/gs-rest-service-0.1.0.jar`

## Endpoints
GET `/variants` gives you a list of the available variants including the rule sets
(check out the code for more information on how the rule sets work).

POST `/{variant}` in non-capital letters lets you play the variant, i.e `/standard`.
The request body should be formatted as follows:
`{"choice":"{CHOICE}"}` i.e `{"choice":"ROCK"}`.

Example curl command:
`curl -H "Content-Type: application/json" -d '{"choice":"ROCK"}' http://localhost:8080/standard`
