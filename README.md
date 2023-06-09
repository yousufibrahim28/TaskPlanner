# TaskPlanner
A Task Planner application for managing your tasks both official and personal


Build your first Web application with Spring Boot

Todo web application

In spring initializer create the project and add dependencies

- Spring Web - should be added for any web application
- Spring Boot DevTools - will make the application restart faster and view changes in an instance
- Download the generated folder
- Open the folder in IntelliJ
- Import as Maven project
- Go to the git tab in IntelliJ and click Create repository
- Now go to Git and create the same repository with the same name
- Click the code button and copy the SSH URL
- Execute the below command
    - git remote add origin git@github.com:yousufibrahim28/TaskPlanner.git
- Make settings in IntelliJ for the auto restart of the application when changes are made
    - IntelliJ IDEA -> Setting -> Build - > Select “Reload Projects after changes in the build script”
    - Also, Select any changes radio button
    - Click Apply, and OK

- ‘YourWebAPP’Application.java is the entry point for your application you can start your application by clicking the play button near the main method.

- application.properties file is important - this is where you can configure your application’s properties.
    - You can configure on which port your webApp should run by mentioning this property and value. 
        - server.port=8080 , there are many such properties, please explore and tailor it based on your needs

- pom.xml is an important file where you can declare your dependencies and spring boot will automatically fetch it for you.
- You need to be careful with adding tomcat-embed-jasper dependency. Configuration is different for different IDEs.
- 
- 1: ECLIPSE
    * 		<dependency>
    * 		<groupId>org.apache.tomcat.embed</groupId>
    * 		<artifactId>tomcat-embed-jasper</artifactId>
    * 		<scope>provided</scope>
    * 		</dependency>

- 2: INTELLIJ
    * 		<dependency>
    * 		<groupId>org.apache.tomcat.embed</groupId>
    * 		<artifactId>tomcat-embed-jasper</artifactId>
    * 		</dependency>

- NOTE: <scope>provided</scope> is NOT needed for IntelliJ
- How does the Web work?
    - The browser sends a request
        - HttpRequest
    - The server handles the request
        - Your Spring Boot Web Application
    - The server returns the response
        - HttpResponse
- RequestParams
    - We can pass key=value in the request and use it in the controller for further processing
    - We can use @RequestParam to get the data into the controller
    - We can use ModelMap to pass the data to JSP files
- Logging in an application
    -  For development purposes use the logging level as debug, for production use logging level info
    - Knowing what to log is an essential skill to be a great programmer
    - Spring Boot makes logging easy
        - Spring-boot-starter-logging
        - Including spring-boot-starter-web will automatically get the logging starter as a transitive dependency
        - Default in spring-boot: Logback with SLF4j
- Spring MVC
    - Before MVC - All the logics, like view logic,flow logic, db logic all resided in JSPs, This is called Model 1 Architecture
        - Model 2 Arch - Separating concerns
            - Model: Data to generate the view
            - View: Show information to user
            - Controller: Controls the flow
            - Advantage: Simpler to maintain
            - Concern: where to implement common features to all controllers
        - Model 2 Arch with front controller
            - All requests go to a central controller and the common feature is implemented in this controller
            - After the common feature a executed it delegates the request to appropriate controller
        - Spring MVC Front Controller - Dispatcher Servlet
            - Receives HTTP Request
            - Process HTTP Request
                - Identifies the right controller method, based on the URL
                - Executes the controller method
                    - Returns model and view name
                - Identifies correct View
                    - Using the ViewResolver
                - Executes view
            - Returns HTTP Response
- Collecting data from the user
- Always use the post method so the data will be not sent as a part of the URL
- If we use GET the values will be sent a query params.
- Always try to use constructor injection for initialising a bean.
- Remember to use the Single responsibility principle wherever required. Follow Solid principle in general

TODO application  model

- Id
- Username
- Description
- targateDate
- Date - Using LocalDate is recommended over using a Date class


Request vs Model vs Session

- Request data are only valid and available for that request. - Request scope - Only for single request - Recommended for most use cases.
- Model data are by default only available to the scope of that request.
- Session data are retained across multiple requests.
    - Be careful about what you store in session (Takes additional memory as all details are stored on the server)
    - @SessionAttributes(“name”) - eg

Expression language is not sufficient for more complex and dynamic content

JSTL is more suitable.

Webjars is concept we can read about.

Spring boot starter parent manages all the versions of the dependencies, we can see it in effective pom.xml but for some dependency we need to add versions explicitly

To use Bootstrap CSS framework we need dependency of Jquery as well.

It is recommended to use bootstrap.min.css, bootstrap.min.js

Use jquery.min.js


Validations in HTML can be easily broken by hackers, so it always mandatory to have server side validation

Validations in Spring appt and Spring MVC is easy
- Spring Boot Starter validation - dependency to be added to pom.xml
- Command Bean (Form Backing Object)
    - 2-way binding(task.jsp & TaskController.java)
- Add Validations to Bean
    - Task.java
- Display validation Errors in the view
    - Task.jsp

Jsp fragments should be used to avoid duplication in Jsp files

Separate out header, footer and navigation files.

Spring Security takes care of the login of a page. By default it gives you a Login page with a username: user and Password is generated at the start of the application

We have configured the application for constant user and password. This is achieved by spring security configuration

    // Usualy LDAP or Database should be used to maintain user info
    // for the time being we can use in memory managemnet

    // Custom password encoder, to encrypt the password.
    // BCryptPasswordEncoder provides a strong encryption algorithm

Add h2 dependency after JPA dependency in pom.xml - otherwise an error will be thrown

When spring security is enabled.
    // All URLs are protected
    // A login form is shown for unauthorized requests
    // CSRF disable for accessing h2 console
    // Frames should be enabled, by default spring security blocks frames


Whenever h2 is added as dependency in pom.xml, spring will scan for any entity class and automatically creates a table.

In JPA entity mapping if we are using camel case for column names the column name will be separated by an underscore

targetDate -> TARGET_DATE

By default, data.sql files are processed before the Entity classes are processed.

# This will defer the execution of sql files, after entity clases are processed the sql file will be executed
spring.jpa.defer-datasource-initialization = true

H2 is a in memory database

# This will show all the sql that is being executed.
#spring.jpa.show-sql=true

Docker command to launch mysql

docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=tasks-user --env MYSQL_PASSWORD=dummytodos --env MYSQL_DATABASE=todos --name mysql --publish 3306:3306 mysql:8-oracle


A.1 mysqlsh — The MySQL Shell
MySQL Shell is an advanced command-line client and code editor for MySQL. In addition to SQL, MySQL Shell also offers scripting capabilities for JavaScript and Python. For information about using MySQL Shell, see MySQL Shell 8.0. When MySQL Shell is connected to the MySQL Server through the X Protocol, the X DevAPI can be used to work with both relational and document data, see Using MySQL as a Document Store. MySQL Shell includes the AdminAPI that enables you to work with InnoDB Cluster, InnoDB ClusterSet, and InnoDB ReplicaSet deployments; see Chapter 6, MySQL AdminAPI.
 
https://dev.mysql.com/doc/mysql-shell/8.0/en/mysqlsh.html



