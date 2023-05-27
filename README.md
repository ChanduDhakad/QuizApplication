# QuizApplication
This project is a REST API for a Quiz Application. The API allows users to create and participate in timed quizzes. Users can create quizzes, retrieve active quizzes, retrieve quiz results, and retrieve all quizzes.

- Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger UI
- Maven

# Endpoints
- POST /quizzes: Create a new quiz by sending a POST request to this endpoint. The request body should include the question, options, rightAnswer, startDate, and endDate.

- GET /quizzes/active: Retrieve the active quiz (the quiz that is currently within its start and end time) by sending a GET request to this endpoint.

- GET /quizzes/{id}/result: Retrieve the result of a quiz by its ID. This endpoint requires the quiz ID as a path parameter.

- GET /quizzes/all: Retrieve all quizzes by sending a GET request to this endpoint.

# Validation
- This project uses validation annotations to ensure that user input is in the correct format. The following validations are implemented:

- Question: Must not be empty or exceed a certain character limit.

- Options: Must be a non-empty array with at least two options.

- Right Answer: Must be a valid index within the options array.

- Start Date: Must be a valid date and time in the future.

- End Date: Must be a valid date and time after the start date.

# Exception Handling
- Custom exceptions are used for handling errors in the application.
- A global exception handler is used to handle exceptions globally.
# Authentication
- This project does not implement authentication as it focuses on the functionality of the Quiz Application. However, you can incorporate authentication mechanisms according to your specific requirements.
# Installation & Run
- Before running the API server, you should update the database config inside the application.properties file.
Update the port number, username, password, and database URL as per your local database configuration.
arduino
Copy code
server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/quizdb
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root
