Feature: Searching on Google

Scenario: Direct Search on Google Edge

Given launch browser 'edge'
When user navigates to 'https://google.com'
Then user enters search from term 'HEllo'
And Clicks on search button


Scenario: Direct Search on Google Chrome
Given launch browser 'chrome'
When user navigates to 'https://google.com'
Then user enters search from term 'Bye'
And Clicks on search button