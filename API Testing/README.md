# Postman API Tests for Demoblaze

[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://god.gw.postman.com/run-collection/43742582-f64259a9-2305-4283-ad03-4904e6cc132b?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D43742582-f64259a9-2305-4283-ad03-4904e6cc132b%26entityType%3Dcollection%26workspaceId%3D3240b3df-fcce-48ba-b621-1ca9db45a36a)

## I. Test Suite Overview:
- **Project**: Demoblaze API Testing
- **Tester**: Asmaa Said, Aya Maher
- **Date Created/Last Updated**: [14/4/2025]
- **Purpose**: This document outlines the API tests created for the Demoblaze application, covering the homepage, cart page, about page, login, signup, and contact functionalities. These tests aim to verify the correctness, reliability, and basic functionality of the underlying APIs that drive these pages.
- **Tools Used**: Postman
- **Environment**: [environment Demoblaze]

## II. Test Cases Documentation:

### A. Homepage:
**Test Folder/Collection Name in Postman**: Demoblaze API Tests / HomePage

#### Test Cases:

1. **Test Case Name**: [Login - Valid Credentials (POST)]  
   - **Request Method**: POST  
   - **Request URL**: [{{baseUrl}}/login]  
   - **Pre-requisites**: A global variable `baseUrl` is set to `https://api.demoblaze.com`.  
   - **Environment Variables**: `validUsername` and `validPassword` are set with valid user credentials.  
   - **Request Body**:  
     ```json
     { 
       "username": "{{validUsername}}", 
       "password": "{{validPassword}}"
     }
     ```  
   - **Test Steps**:
     1. Send a POST request to `{{baseUrl}}/login` with the username and password from the environment variables in the request body.  
   - **Expected Outcome**:
     - Status code: 200 OK
     - Response body is not empty
     - Response body is a string
     - Store the authentication token in an environment variable
   - **Pass/Fail Criteria**: All expected outcomes are met.

2. **Test Case Name**: [Navigate to Phone Category (POST)]  
   - **Request Method**: POST  
   - **Request URL**: [{{baseUrl}}/bycat]  
   - **Pre-requisites**: A global variable `baseUrl` is set to `https://api.demoblaze.com`.  
   - **Request Body**:  
     ```json
     { 
       "cat": "phone"
     }
     ```  
   - **Test Steps**:
     1. Send a POST request to `{{baseUrl}}/bycat` with the category "phone" in the request body.  
   - **Expected Outcome**:
     - Status code: 200 OK
     - Response body contains an 'Items' array
     - Response body contains at least one phone in 'Items'
     - Response body in 'Items' contains Samsung Galaxy S6
   - **Pass/Fail Criteria**: All expected outcomes are met.

3. **Test Case Name**: [Navigate to Laptops Category (POST)]  
   - **Request Method**: POST  
   - **Request URL**: [{{baseUrl}}/bycat?=]  
   - **Pre-requisites**: A global variable `baseUrl` is set to `https://api.demoblaze.com`.  
   - **Request Body**:  
     ```json
     { 
       "cat": "notebook"
     }
     ```  
   - **Test Steps**:
     1. Send a POST request to `{{baseUrl}}/bycat?=` with the category "Laptops" in the request body.  
   - **Expected Outcome**:
     - Status code: 200 OK
     - Response body contains an 'Items' array
     - Response body contains at least one laptop
     - Response body in 'Items' contains Sony Vaio i5
   - **Pass/Fail Criteria**: All expected outcomes are met.

4. **Test Case Name**: [Navigate to Monitors Category (POST)]  
   - **Request Method**: POST  
   - **Request URL**: [{{baseUrl}}/bycat]  
   - **Pre-requisites**: A global variable `baseUrl` is set to `https://api.demoblaze.com`.  
   - **Request Body**:  
     ```json
     { 
       "cat": "monitor"
     }
     ```  
   - **Test Steps**:
     1. Send a POST request to `{{baseUrl}}/bycat` with the category "Monitors" in the request body.  
   - **Expected Outcome**:
     - Status code: 200 OK
     - Response body contains an 'Items' array
     - Response body contains at least one monitor
     - Response body in 'Items' contains Apple monitor 24
   - **Pass/Fail Criteria**: All expected outcomes are met.

5. **Test Case Name**: [Get Phones Category Product Details (POST)]  
   - **Request Method**: POST  
   - **Request URL**: [{{baseUrl}}/view]  
   - **Pre-requisites**: A global variable `baseUrl` is set to `https://api.demoblaze.com`.  
   - **Environment Variable**: `phoneProductId` is set with value = 1.  
   - **Request Body**:  
     ```json
     { 
       "id": "{{phoneProductId}}"
     }
     ```  
   - **Test Steps**:
     1. Send a POST request to `{{baseUrl}}/view` with the id of the phone product from the `phoneProductId` environment variable in the request body.  
   - **Expected Outcome**:
     - Status code: 200 OK
     - Response body is a JSON object
     - Response body has product details
   - **Pass/Fail Criteria**: All expected outcomes are met.

### B. About Page:
**Test Folder/Collection Name in Postman**: Demoblaze API Tests / About Page  
**Description**: Tests related to elements and links within the "About Us" page.

#### Test Case:

6. **Test Case Name**: About us link - Retrieve Image (GET)  
   - **Request Method**: GET  
   - **Request URL**: {{baseUrl}}/imgs/front.jpg  
   - **Pre-requisites**: A global variable `baseUrl` is set to `https://api.demoblaze.com`.  
   - **Test Steps**:
     1. Send a GET request to `{{baseUrl}}/imgs/front.jpg`.  
   - **Expected Outcome**:
     - Response status code is 404 (Not Found)
     - Response body is a valid JPEG image  
     - Response indicates 'Not Found' content type (may vary)
   - **Pass/Fail Criteria**: All expected outcomes are met.

### C. Cart Page:
**Test Folder/Collection Name in Postman**: Demoblaze API Tests / Cart Page  
**Description**: Tests related to adding items to the user's shopping cart.

#### Test Cases:

7. **Test Case Name**: Add to Cart (POST)  
   - **Request Method**: POST  
   - **Request URL**: {{baseUrl}}/addtocart  
   - **Pre-requisites**: A global variable `baseUrl` is set to `https://api.demoblaze.com`.  
   - **Environment Variable**: `id` (representing the `productId` to add) is set to 1.  
   - **Request Body**:  
     ```json
     { 
       "id": "2d397d2e-2bba-f3f5-2d72-1c452cc28368", 
       "cookie": "dHJpcGxlX2ExNzQ1MTE1", 
       "prod_id": "{{phoneProductId}}", 
       "flag": true
     }
     ```  
   - **Test Steps**:
     1. Send a POST request to `{{baseUrl}}/addtocart` with the id from the environment variables in the request body.  
   - **Expected Outcome**:
     - Status code: 200 OK
     - Cart cookie might have been updated

8. **Test Case Name:** Go to Cart page (POST)  
   - **Request Method:** POST  
   - **Request URL:** {{baseUrl}}/cart  
   - **Pre-requisites:**  
     - A global variable `baseUrl` is set to `https://api.demoblaze.com`.
     - An environment variable `cartId` is set with a valid cart identifier.
   - **Request Body:**
     ```json
     {
       "cartId": "{{cartId}}"
     }
     ```
   - **Test Steps:**  
     1. Send a POST request to `{{baseUrl}}/cart` with the `cartId` in the request body.
   - **Expected Outcome:**  
     - Status code 200 OK.  
     - Response body contains cart details.
   - **Pass/Fail Criteria:**  
     All expected outcomes are met. The status code is 200, and the response body contains valid cart details.

---

**D. Login and Signup Pages:**  
Test Folder/Collection Name in Postman: Demoblaze API Tests / Login & Signup  
Description: Tests related to login, signup, and session management.

**Test Cases:**

9. **Test Case Name:** User Login (POST)  
   - **Request Method:** POST  
   - **Request URL:** {{baseUrl}}/login  
   - **Pre-requisites:**  
     - A global variable `baseUrl` is set to `https://api.demoblaze.com`.
     - Environment variables `validUsername` and `validPassword` are set with valid credentials.
   - **Request Body:**
     ```json
     {
       "username": "{{validUsername}}",
       "password": "{{validPassword}}"
     }
     ```
   - **Test Steps:**  
     1. Send a POST request to `{{baseUrl}}/login` with the username and password.
   - **Expected Outcome:**  
     - Status code 200 OK.  
     - Response body contains authentication token.
   - **Pass/Fail Criteria:**  
     All expected outcomes are met. Status code is 200, and the response contains the authentication token.

10. **Test Case Name:** User Signup (POST)  
   - **Request Method:** POST  
   - **Request URL:** {{baseUrl}}/signup  
   - **Pre-requisites:**  
     - A global variable `baseUrl` is set to `https://api.demoblaze.com`.
     - Environment variables `newUsername`, `newPassword`, and `newEmail` are set with valid signup details.
   - **Request Body:**
     ```json
     {
       "username": "{{newUsername}}",
       "password": "{{newPassword}}",
       "email": "{{newEmail}}"
     }
     ```
   - **Test Steps:**  
     1. Send a POST request to `{{baseUrl}}/signup` with the provided details in the request body.
   - **Expected Outcome:**  
     - Status code 200 OK.  
     - Response body indicates successful account creation.
   - **Pass/Fail Criteria:**  
     All expected outcomes are met. The status code is 200, and the response indicates successful signup.

---

**E. Contact Page:**  
Test Folder/Collection Name in Postman: Demoblaze API Tests / Contact Page  
Description: Tests related to the contact form submission.

**Test Cases:**

11. **Test Case Name:** Submit Contact Form (POST)  
   - **Request Method:** POST  
   - **Request URL:** {{baseUrl}}/contact  
   - **Pre-requisites:**  
     - A global variable `baseUrl` is set to `https://api.demoblaze.com`.
     - Environment variables `userName`, `userEmail`, and `userMessage` are set with valid contact details.
   - **Request Body:**
     ```json
     {
       "name": "{{userName}}",
       "email": "{{userEmail}}",
       "message": "{{userMessage}}"
     }
     ```
   - **Test Steps:**  
     1. Send a POST request to `{{baseUrl}}/contact` with the provided contact information.
   - **Expected Outcome:**  
     - Status code 200 OK.  
     - Response body indicates successful submission.
   - **Pass/Fail Criteria:**  
     All expected outcomes are met. The status code is 200, and the response indicates the form was successfully submitted.

---

### III. Summary  
The tests described in this document verify the functionality of key features of the Demoblaze application, including login, product browsing by category, adding to cart, and contacting support. All tests ensure that the API endpoints behave as expected, returning the correct responses with the appropriate status codes.

### IV. Tools Used  
- **Postman** was used to create, manage, and run the API tests.  
- **Environment Variables** were used for sensitive information like user credentials and product IDs.

### V. Next Steps  
- Continue to expand the API tests for other pages and functionalities.  
- Test for edge cases and error handling (e.g., invalid input, unauthorized access).  
- Automate the tests with CI/CD pipelines to integrate them into the development workflow.

---

### VI. Conclusion  
This test suite ensures the proper functionality of the Demoblaze API, covering critical aspects of user interaction with the platform. By verifying the responses from the API, the tests ensure that the API can support key application features, providing a stable foundation for the application's functionality.


