# login-sandbox
login sandbox project using spring-security

[Reference](https://ver-1-0.net/2017/06/05/kotlin-spring-boot-authentication)

### Prepare database
````
SELECT  host, user FROM mysql.user;
CREATE USER 'app'@'localhost' IDENTIFIED BY '{password}';
SHOW GRANTS FOR 'app'@'localhost';

CREATE DATABASE logindb;
```