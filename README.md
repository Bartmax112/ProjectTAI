# ProjectTAI

ProjectTAI was created for a laboratory class assignment. TAI stands for Web Application Development(PL: "Tworzenie aplikacji internetowych").

### Getting Started

To run application, press "Run 'BootSecurityApplication.java'". Spring Boot will take care of configuring project and specified
ports on which the project will run. After short while open browser and type "https://localhost:8888" or "http://localhost:8080".
In the second option you will be redirected to secured connection. Navigate throughout implemented options 
from menu in upper parts of site("Home", "Form", "Login"/"Logout"). To log in type one of the users specified in 
"DbInit.java" class in method "run(String... args)" (eg. login="bart" password="bart123").

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Thymeleaf](https://www.thymeleaf.org) - Server-side Java template engine for HTML files
* [Hibernate](https://hibernate.org) - Object Relational Mapping for H2 database
* [H2 Database](https://www.h2database.com) - Embedded open source database project usage
* [Spring Framework](http://www.dropwizard.io/1.0.2/docs/) - The backend web framework
* [Spring Security](https://spring.io/projects/spring-security) - User authentication and access-control framework
* [Spring Boot](https://spring.io/projects/spring-boot) - Project configuration
* My own Digital signature (file - "bootsecurity.p12")

## Authors

**Bartłomiej Giza** - *Initial work* - [Bartmax112](https://github.com/Bartmax112)