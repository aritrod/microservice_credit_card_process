# microservice_credit_card_process

Description of the project:
This is a springboot microservice application which provides for two rest apis.
  GET /sapient/creditCard/list -> Fetches all existing credit cards in the system
  POST /sapient/creditCard/add -> Adds a new valid credit card to the system
  
H2 in memory database has been used and a small script to create and insert initial data has been added, 
which will run at bootstrap and create and populate the table with some default entries.

How to run the application:
import this project as a maven project in any Eclipse/STS IDE, build it and run as java application.
The apis can be accessed under:
"http://localhost:8080/sapient/creditCard/list"  &  "http://localhost:8080/sapient/creditCard/add"
