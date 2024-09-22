## Running the Tests

1. Clone this repository.
2. Navigate to the project root directory.
3. Run the following command to execute the tests:

bash
mvn verify

Explanation of the Tests

1. **Test 1: Homepage Title**:
   - Verifies that the homepage title contains "Entrata."

2. **Test 2: verify link Schedule Your Demo**:
   - verify link Schedule Your Demo is working 

3. **Test 3: Dynamic Content on Homepage**:
   - Checks if a dynamic element (e.g., a banner) is displayed on the homepage.

4. **Test 4: Search Form Interaction**:
   - Enters text into the search input field, verifies the input, and ensures that it can be cleared without submitting the form.

### Key Features:
- **Page Object Model (POM)**: Separates page functionalities from test logic.
- **Constants**: Avoids hardcoded strings and numbers using the `Constants` class.
- **Reusability**: Methods in `BaseTest` provide reusable setup and teardown operations.
