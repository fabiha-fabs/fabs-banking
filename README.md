# fabs-banking

# Required setups
1. After downloading the project go to the root directory of it.
2. Navigate to: src\main\resources
3. Open application.properties file and update following configurations based on your MySQL database connection user and password:

	spring.datasource.username=root
	spring.datasource.password=root
	
4. Create a database in MySQL database named: banking_db

# Run application
1. Use any IDE to import the project and run it based on the IDE or from the root directory of the project, run following commands:
	
	mvn clean install
	mvn spring-boot:run