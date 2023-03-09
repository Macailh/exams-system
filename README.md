# Exams System Backend

This is the backend component of the Exams System. It provides the necessary APIs for managing exams, questions, and users.

## Installation

Clone the repository:
`git clone https://github.com/Macailh/exams-system-backend.git`

Install the dependencies:
`mvn install`

The server will start on port 8080 by default.

## Usage

### Authentication

All APIs require authentication using a JSON Web Token (JWT). To authenticate, send a POST request to `/api/auth/login` with the following payload:

```json
{
  "username": "<username>",
  "password": "<password>"
}

The server will respond with a JWT, which you should include in the Authorization header of all subsequent requests.

### Exams
- GET /api/exams: Get a list of all exams
- POST /api/exams: Create a new exam
- GET /api/exams/{id} Get an exam by ID
- PUT /api/exams/{id} Update an exam by ID
- DELETE /api/exams/{id} Delete an exam by ID

### Questions
- GET /api/questions: Get a list of all questions
- POST /api/questions: Create a new question
- GET /api/questions/{id} Get a question by ID
- PUT /api/questions/{id} Update a question by ID
- DELETE /api/questions/{id} Delete a question by ID

### Users
- GET /api/users: Get a list of all users
- POST /api/users: Create a new user
- GET /api/users/{id} Get a user by ID
- PUT /api/users/{id} Update a user by ID
- DELETE /api/users/{id} Delete a user by ID

##Configuration
The following variables can be set to configure the server:
- PORT: The port on which the server should listen (default: 8080)
- DB_URL: The URL of the database (default: jdbc:mariadb://localhost:3306/exams_system_db)
- JWT_SECRET: The secret key used to sign JWTs (default: mysecretkey)

## License
This project is licensed under the MIT License. See the LICENSE file for details.
