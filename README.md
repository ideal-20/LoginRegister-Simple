# LoginRegister-simple

## A simple overview

A simple login and  register system built with HTML + CSS, Servlet, MySQL, Druid, JDBCTemplate

## Front-end page display

![image](https://github.com/BWH-Steven/LoginRegister-Simple/blob/master/web/img/loginRegister_bg.jpg)

##Technologies used

- `HTML + CSS` technology to write front-end login and registration page
- Use `Druid` (alibaba) database connection pooling technology to operate mysql, 'db1' database 'user' table, configuration file: druid.properties
- `JDBCTemplate` technology is used to encapsulate JDBC
- Generate random verification codes for login and registration using `Java/Servlet` technology
- Successful login or registration forwards to the "SuccessServlet" test page
- If the login or registration fails, it is forwarded to the 'FailServlet' test page

## The directory structure

src.cn.ideal

- dao : This layer is the data access layer, interacts with MySQL data, and exists as an interface
  - impl : Dao layer concrete implementation layer, this project encapsulates add and query two kinds of database statements
- domain  : Store entity ‘User’
- util : Tool classes: this project contains JDBC tool classes
- web
  - servlet : It mainly forwards access control and verifies various basic parameters
- test : Test Layer: This project uses unit testing to test login and registration functions``

## The process is introduced

Obtain the information submitted in the form in the servlet, and obtain our customized verification code. When the verification code is correctly entered, write the data into the database or query in the database to achieve the effect of registration or login, and forward it to the corresponding test page after successful or failed execution



## Summary

### Advantages

This project basically realizes the login and registration effect through the simple front-end page and Java technology, and realizes the data interaction with MySQL database，In order to prevent malicious operation, add the verification code part, and use Druid and Spring's JDBCTemplate technology to improve the efficiency of database connection

### Deficiency

The details are not perfect enough, form verification function should be added to prevent users from submitting illegal and unreasonable data, the jump after success or failure is not reasonable enough, only two test pages are given, and the setting of form data rules should be improved



## About

If you want to know more, please pay attention to my Wechat Public Account: Ideal-20

I am eager to communicate with you. Welcome to leave a message: ideal_bwh@163.com

![image](https://github.com/BWH-Steven/LoginRegister-Simple/blob/master/web/img/QRcode258.jpg)
