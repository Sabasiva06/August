Feature: Getting Search Count from google

  Scenario Outline: Search count of a product from google
    Given user is on Google page
    When user enter text on search filed by given sheetname "<sheetName>" and rownumber <rownumber>
    And get the search count and add into excel

    Examples: 
      | sheetName | rownumber |
      | Sheet1    |         1 |
      #| Sheet1    |         1 |
      #| Sheet1    |         2 |
      #| Sheet1    |         3 |
      #| Sheet1    |         4 |
