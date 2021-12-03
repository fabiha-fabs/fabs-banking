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
	
# End points
There are 2 endpoints this project offers:
	1. 
		Request Method: GET
		End point: http://localhost:8181/
	
	2.
		Request Method: POST
		End point: http://localhost:8181/transaction/
		Request body: 
					{
						"requestId": "A32W4ER2341",
						"requester": "XYZ App",
						"transactionType": "VFJBTlNGRVI=",
						"sourceAccountNumber":"MzIzNDEyMDA5MjM0ODc=",
						"destinationAccountNumber": "MDAxMjQxMDA5MjExNDM5",
						"amount": "MTUwMC41MA==",
						"note": "Test data"
					}
					
# NOTE: 
As we are using this project as a microservice, we have dependency on Base64 decoder service and Eureka discovery server microservices. These 2 projects should be running before we run this one.