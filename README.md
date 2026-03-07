# Ndosi Cellular Online - Test Automation

Welcome to the Ndosi Cellular Online test automation project. This project contains automated test cases for the Ndosi Cellular Online learning platform using Selenium WebDriver and TestNG.

## 📋 Project Overview

**Ndosi Cellular Online** is a test automation framework designed to validate the functionality of the Ndosi Cellular Online platform. The project focuses on login flows and course navigation workflows using the Selenium WebDriver library with TestNG as the testing framework.

**Platform Under Test:** https://ndosisimplifiedautomation.vercel.app/

## 🛠️ Tech Stack

- **Language:** Java 21
- **Testing Framework:** TestNG 7.12.0
- **Web Automation:** Selenium WebDriver 4.40.0
- **Build Tool:** Maven
- **IDE:** IntelliJ IDEA

## 📦 Prerequisites

Before running this project, ensure you have the following installed:

- **Java Development Kit (JDK) 21** or higher
- **Maven 3.6.0** or higher
- **Google Chrome** (latest version)
- **ChromeDriver** (compatible with your Chrome version)

### Installation Steps

1. **Install Java 21:**
   - Download from [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or use [OpenJDK](https://adoptopenjdk.net/)
   - Verify installation: `java -version`

2. **Install Maven:**
   - Download from [Apache Maven](https://maven.apache.org/download.cgi)
   - Verify installation: `mvn -version`

3. **Download ChromeDriver:**
   - Download from [ChromeDriver](https://chromedriver.chromium.org/)
   - Ensure it's compatible with your Chrome browser version
   - Place it in your system PATH or in the project root

## 🚀 Getting Started

### Clone the Repository

```bash
git clone https://github.com/your-org/NdosiCellularOnline.git
cd NdosiCellularOnline
```

### Build the Project

```bash
mvn clean install
```

This command will:
- Clean any previous build artifacts
- Download all dependencies from `pom.xml`
- Compile the source code
- Run all tests

### Run Tests

Run all tests:
```bash
mvn test
```

Run a specific test class:
```bash
mvn test -Dtest=loginToNdosiCellularOnline
```

Run a specific test method:
```bash
mvn test -Dtest=loginToNdosiCellularOnline#loginWithValidCredentials
```

## 📂 Project Structure

```
NdosiCellularOnline/
├── src/
│   ├── main/
│   │   ├── java/          # Main application code (if any)
│   │   └── resources/     # Configuration files
│   └── test/
│       └── java/
│           └── loginToNdosiCellularOnline.java   # Test classes
├── target/                # Build output directory
├── pom.xml               # Maven project configuration
└── README.md             # This file
```

## 🧪 Test Cases

### Current Tests

#### 1. Login with Valid Credentials
- **Test Class:** `loginToNdosiCellularOnline`
- **Test Method:** `loginWithValidCredentials()`
- **Description:** Validates successful login to the Ndosi Cellular Online platform with valid email and password credentials
- **Test Steps:**
  1. Navigate to the Ndosi Cellular Online application
  2. Click the login button
  3. Enter valid email credentials
  4. Enter valid password
  5. Submit login form
  6. Verify "My Courses" section is displayed
  7. Verify welcome message is correct
  8. Navigate to Learning Materials
  9. Select "Web Automation Advance" course
  10. Interact with device type, brand, and storage dropdowns

**Test Credentials:**
- Email: `kimoslice@gmail.com`
- Password: `Qwerty1!`

## ⚙️ Dependencies

All dependencies are managed through Maven. See `pom.xml` for the complete list:

| Dependency | Version | Scope |
|-----------|---------|-------|
| Selenium Java | 4.40.0 | compile |
| TestNG | 7.12.0 | test |

## 🔧 Configuration

### Java Compiler Settings
- Source Version: Java 21
- Target Version: Java 21
- Encoding: UTF-8

### Selenium WebDriver Configuration

The project uses ChromeDriver for browser automation. Ensure ChromeDriver is available in your system PATH or adjust the initialization in your test code.

## 📝 Development Notes

### Current Implementation Notes

- **Hardcoded Credentials:** Test credentials are currently hardcoded in the test. Consider moving these to a configuration file or environment variables for better security.
- **XPath Usage:** The project uses both standard XPath selectors and text-based selectors. Consider standardizing locator strategies for maintainability.
- **Hardcoded Welcome Message:** The welcome message verification is hardcoded for user "Kimo". This should be parameterized to support multiple users.
- **Dropdown Handling:** The project uses both `Select` class for standard HTML `<select>` elements and `WebDriverWait` for custom dropdowns.
- **Assertion Improvements Needed:** Some assertions rely on element position and should be updated to use more reliable selectors.

### Best Practices to Implement

1. **Move credentials to external configuration** (environment variables or config files)
2. **Standardize locator strategies** (use Page Object Model pattern)
3. **Add parameterized tests** for multiple user scenarios
4. **Improve assertion reliability** by avoiding position-based XPaths
5. **Add test reporting** (HTML reports, logs)
6. **Implement proper error handling and logging**
7. **Add screenshots on test failures**

## 🔍 Troubleshooting

### Common Issues

1. **ChromeDriver version mismatch:**
   - Ensure ChromeDriver version matches your Chrome browser version
   - Download the correct version from [ChromeDriver](https://chromedriver.chromium.org/)

2. **Maven build fails:**
   ```bash
   mvn clean install -DskipTests
   ```

3. **Tests timeout:**
   - Increase WebDriverWait timeout duration if your network is slow
   - Check if the application URL is accessible

4. **Element not found errors:**
   - Verify the application is loaded completely
   - Check if element selectors have changed in the application
   - Use explicit waits instead of implicit waits

## 📚 Resources

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/)
- [Maven Documentation](https://maven.apache.org/guides/)
- [Java 21 Documentation](https://docs.oracle.com/en/java/javase/21/)

## 👥 Contributing

When contributing to this project:

1. Follow Java naming conventions
2. Use meaningful variable and method names
3. Add comments for complex logic
4. Test your changes before submitting
5. Update this README if you add new features

## 📄 License

This project is part of the Ndosi test automation suite. Please refer to your organization's license policy.

## ❓ Support

For issues, questions, or contributions, please contact the test automation team or create an issue in the project repository.

