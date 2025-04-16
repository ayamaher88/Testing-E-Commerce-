# Testing-E-Commerce-

# Demoblaze Automated Testing Framework

## Project Title: Automated Testing Framework for Demoblaze Web Application
  
### Duration: 4 Weeks

## Objective:
To develop and execute a comprehensive automated testing framework for the Demoblaze e-commerce website, covering UI, API, and performance testing, ensuring all core functionalities perform as expected.

---

## Project Summary

| Phase      | Key Activities                           | Tools/Tech Used                  | Deliverables                                          |
|------------|------------------------------------------|----------------------------------|------------------------------------------------------|
| **Week 1** | Test Environment Setup, Initial UI + API Test Cases | Selenium, Postman, Jira         | Folder structure, Sample UI & API test cases         |
| **Week 2** | Functional Test Automation, Reporting Integration | TestNG, Postman                 | Automated test scripts, Test reports                 |
| **Week 3** | UI & Performance Testing, Bug Reporting | JMeter, Jira                     | Cross-browser UI test cases, Performance metrics, Bug tracking |
| **Week 4** | Final Test Execution, Framework Optimization, Documentation | Jenkins (CI/CD Ready), JUnit    | Final reports, Framework deployment-ready, Usage guide |

---

## Key Functional Areas Tested

- **UI Testing:**  
  Navigation, product display, buttons (e.g., "Cart", "View More Products"), modal dialogs, forms.

- **Functional Testing:**  
  Add to Cart, Remove from Cart, Login/Logout, Place Order, User Signup.

- **API Testing (Postman):**  
  Validated response codes and payloads for cart actions, login, and product listings.

- **Performance Testing (JMeter):**  
  Stress and load testing on product page and login endpoint.

---

## Sample Bugs Reported

| Bug Title                              | Actual Result                                                            | Expected Result                                                      | Status |
|----------------------------------------|---------------------------------------------------------------------------|----------------------------------------------------------------------|--------|
| Cart button not updating on some pages | Item count updates only on product detail/cart page, not on homepage/category pages unless a second item is added | Item count should update immediately on all pages                      | Open   |
| View More button text invisible        | Black text on black background; visible only on hover                     | Text should be clearly visible without hover                          | Fixed  |
| Cart button unresponsive on homepage   | Click does not navigate to cart; no visual response                       | Clicking should open the cart                                        | Fixed  |

---

## Performance Metrics

| Scenario                          | Response Time | Status  |
|-----------------------------------|----------------|---------|
| Homepage load with 50 users      | < 2 sec        | Pass    |
| Product page load with 100 users | ~3.2 sec       | Warning |
| Login API                         | 1.1 sec        | Pass    |

---

## Documentation & Delivery

- Test cases, bug reports, and performance results documented and stored in Google Sheets and Jira.
- Final framework optimized using the **Page Object Model (POM)**.
- The project is **CI/CD ready** and can be extended for regression testing.

---

## Conclusion

The automated testing framework for Demoblaze has successfully identified and helped resolve several bugs, validated major user workflows, and confirmed system performance under load. This framework ensures **quality, reliability, and scalability** for future releases.

---

## How to Use This Framework

1. **Clone the repository:**

    ```bash
    git clone https://github.com/yourusername/demoblaze-testing.git
    ```

2. **Setup Environment:**
    - Install necessary tools: **Selenium**, **TestNG**, **Postman**, **JMeter**.
    - Configure the testing environment.
    - Follow the instructions in the **Installation** section of the repository.

3. **Run Tests:**
    - Use the instructions to run automated tests using **TestNG** and **Jenkins** for continuous integration.

---

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
