# SauceDemo QA Automation Framework

A Java + Playwright test automation framework built to demonstrate SDET
skills — UI test automation with the Page Object Model, CI/CD via GitHub
Actions, and a roadmap toward API testing, cloud tooling, and AI-assisted
test failure analysis.

## Current Features

- **UI automation** with [Playwright for Java](https://playwright.dev/java/), targeting [SauceDemo](https://www.saucedemo.com/)
- **API automation** with [RestAssured](https://rest-assured.io/), targeting [restful-booker](https://restful-booker.herokuapp.com/) — CRUD operations, cookie-based token authentication, and reusable request helpers
- **Page Object Model (POM)** architecture — page objects in `pages/`, tests in `ui/`
- **JUnit 5** as the test runner
- **Environment-aware config** — `ConfigReader` pulls from environment variables first, falling back to a local `config.properties` file (see Setup below)
- **Randomized test data** via [DataFaker](https://www.datafaker.net/) for checkout form fields
- **CI/CD** — GitHub Actions runs the full suite on every push/PR to `main`, headless in CI, with test results uploaded as build artifacts

## Tech Stack

Java 22 · Maven · Playwright · JUnit 5 · DataFaker · GitHub Actions

## Setup

1. Clone the repo
2. Copy the example config: cp src/test/resources/config.properties.example src/test/resources/config.properties

3. Run the suite: mvn test


## Test Coverage

- **Login** — valid and invalid credential flows
- **Checkout** — full end-to-end flow: add item to cart → cart → address form (randomized data) → order finalize → order confirmation
  
- **API (restful-booker)**
- **Health check** — API availability (`/ping`)
- **Read** — fetch a single booking and all booking IDs
- **Create** — create a new booking with randomized guest data
- **Auth** — generate a valid access token
- **Update / Delete** — authenticated operations using the generated token, with self-contained test data (each test creates its own booking rather than relying on shared seed data)
## Roadmap

- [ ] **API testing with RestAssured** — pairing SauceDemo's UI flows with a separate demo API (e.g. reqres.in / restful-booker) to demonstrate API-layer test coverage
- [ ] **Containerization** — running the suite in Docker for consistent local/CI execution
- [ ] **AWS integration** — S3 for storing test artifacts/screenshots, exploring additional AWS tooling for the pipeline
- [ ] **AI-assisted failure analysis** — a Python service that takes failure screenshots and returns a plain-language hypothesis of what broke, to speed up triage

## Author

Jacil Perez 