Feature: Login into account


#without Example keyword
#Scenario: Check that user login into account with valid credential
#
#Given user is on login page
#When user enter "naveenwell@gmail.com" and "Wait@123"
#And user click on login button
#Then user view a home page

#with Example keyword
#Scenario Outline: Check that user login into account with valid credential
#
#Given user is on login page
#When user enter "<username>" and "<password>"
#And user click on login button
#Then user view a home page
#
#Examples:
#
#|username|password|
#|naveenwell@gmail.com|Wait@123|
#|tom@gmail.com|tom123|

Scenario: Check that user login into account with valid credential

Given user is on login page
When user enter username and password
|naveenwell@gmail.com|Wait@123|
And user click on login button
Then user view a home page
