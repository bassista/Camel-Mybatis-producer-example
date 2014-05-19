Camel-Mybatis-producer-example
==============================

An example of how to use Camel-Mybatis producer. This example is written using Java, Spring, Camel-Mybatis and Stored Procedures hosted on Mysql 
database.

This example demonstrates the use of Camel-Mybatis component. It shows how to call stored procedures from Camel-Mybatis producer. 
It could be extended to execute sql queries also, by just following Mybatis documentation.

Steps for running the example:
1. Log into mysql and create a new schema named `test`.
2. Run sql scripts on mysql to generate table and stored procedures (one with single paramater and another without parameter).
3. Populate (Insert) the newly created table.
4. Modify `database.properties` as per your mysql configuration.
5. Use appropriate email which is present in the newly created `person` table.
6. Run as maven test: mvn test
