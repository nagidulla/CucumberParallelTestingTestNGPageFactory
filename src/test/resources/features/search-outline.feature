Feature: Searching on Google using scenario outline

  Scenario Outline: Outline Scenario
    Given launch browser '<browserName>'
    When user navigates to '<url>'
    Then user enters search from term '<search>'
    And Clicks on search button

    Examples: 
      | browserName | url                | search |
      | chrome      | https://google.com | HEllo  |
      | edge        | https://google.com | Bye    |
