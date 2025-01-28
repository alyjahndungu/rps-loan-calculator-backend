# rps-loan-calculator-backend

## Introduction

This project is a Spring Boot application that provides Loan Calculator Operations. Follow the steps below to run the project and understand the available endpoints.

## How to Run the Project

1. **Prerequisites**:
    - JDK 17 or higher installed
    - Maven or Gradle installed
    - An IDE (e.g., IntelliJ, VS Code) for running the project

2. **Clone the Repository**:
    ```bash
    git clone https://github.com/alyjahndungu/rps-loan-calculator-backend.git
    cd rps-loan-calculator-backend
    ```

3. **Build the Project**:
    - Using Maven:
    ```bash
    mvn clean install
    ```

4. **Run the Project**:
    - Using Maven:
    ```bash
    mvn spring-boot:run
    ```

5. **Access the Application**:
    - The application will be running on port `8085`.
    - Open your API testing tool and navigate to  `http://localhost:8085` (Development) and `https://rps-loan-calculator-backend.onrender.com` (Production)
    - 

## Authentication API Endpoints

### 1. Login

- **Endpoint**: `/api/v1/auth/login`
- **Method**: `POST`
- **Description**: Authenticates a user with a username and password.
- **Request Body**:
    ```json
    {
        "username": "johndoe@example.com",
        "password": "password"
    }
    ```
- **Curl Command**:
    ```bash
    curl --location 'http://localhost:8085/api/v1/auth/login' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "username": "johndoe@example.com",
        "password": "password"
    }'
    ```

#### Successful Response
- **Status Code**: `200 OK`
- **Response Body**:
    ```json
  {
    "accessToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huZG9lQGV4YW1wbGUuY29tIiwiaWF0IjoxNzM3OTczNzgwLCJleHAiOjE3Mzc5NzczODB9.EoZnUPAqkAua15nWu1cSWt_KJkogHXL9TT5NAksKhbc",
    "expiresIn": 3600000
}
    ```

#### Error Response
- **Status Code**: `401 Unauthorized`
- **Response Body**:
    ```json
    {
        "error": "Invalid username or password"
    }
    ```


## Loan Calculation API Endpoint

### 1. Calculate Loan

- **Endpoint**: `/api/v1/loan/calculator`
- **Method**: `POST`
- **Description**: Calculates loan details based on the originated amount, interest rate, and loan term.
- **Request Body**:
    ```json
    {
        "originatedAmount": 3000000,
        "interestRate": 19.5,
        "loanTermMonths": 2
    }
    ```
- **Curl Command**:
    ```bash
    curl --location 'http://localhost:8085/api/v1/loan/calculator' \
    --header 'Content-Type: application/json' \
    --data '{
        "originatedAmount": 3000000,
        "interestRate": 19.5,
        "loanTermMonths": 2
    }'
    ```

#### Successful Response
- **Status Code**: `200 OK`
- **Response Body**:
    ```json
    {
        "loan": {
            "originatedAmount": 3000000,
            "interestRate": 19.5,
            "loanTermMonths": 2,
            "totalInterest": 96000.00,
            "outstandingLoanAmount": 3096000.00,
            "startDate": "2025-01-27",
            "endDate": "2025-03-28",
            "installments": [
                {
                    "installmentNumber": 1,
                    "principalAmount": 1500000.00,
                    "totalInstallmentInterest": 309600.00,
                    "outstandingAmount": 1548000.00,
                    "dueDate": "2025-02-27"
                },
                {
                    "installmentNumber": 2,
                    "principalAmount": 1500000.00,
                    "totalInstallmentInterest": 309600.00,
                    "outstandingAmount": 1548000.00,
                    "dueDate": "2025-03-27"
                }
            ]
        }
    }
    ```
---

Feel free to contribute to this project by opening issues or submitting pull requests. Happy coding! 🚀
