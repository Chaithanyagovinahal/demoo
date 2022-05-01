Feature: Login to Application

Scenario:Positive test validating login
Given Initialize the browser with chrome
And Navigate to "htttp://qaclickacademy.com" site
And Click on Login link in home page
When Click enters "test99@gmail.com" and "123456" and logs in
Then Verify that user in successfully logged in
And close browsers