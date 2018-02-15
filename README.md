# Automation task for Web application auto1.com

**Automated scenario**
1. Open https://auto1.com/en/our-cars
 2. Filter by manufacturer by clicking checkbox(BMW)
 3. Verify filter was selected
 4. Verify all cars are BMW’s on the page
 5. Verify each car has picture
 6. Verify each car has complete information (Mileage, Registration is not empty etc.)

**Prerequisites**
- JDK 8
- Maven 3.3.9
- Chrome browser v62-64

**Running the tests**
- clone current project
- go to **auto1-our-cars** folder (*cd auto1-our-cars*)
- run *mvn test* command

**Infrastructure**
- Java language
- Selenium Webdriver Java client
- TestNG testing framework
- Log4j2 for logging
