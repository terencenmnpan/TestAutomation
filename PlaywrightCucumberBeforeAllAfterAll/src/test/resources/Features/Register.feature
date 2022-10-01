Feature: Register for Demo Request
  @HappyPath
  Scenario Outline: User is able to request a Demo
    Given User navigates to PHPTRAVELS Demo Page
    When User fills in Demo Request Form <firstName>, <lastName>, <businessName>, <email>
    When User calculates and fills result
    When User clicks submit
    Then Verify thank you text
    Examples:
      | firstName | lastName | businessName | email               |
      | "ABC"     | "DEF"    | "Main Inc."  | "whatever@main.com" |
  @Validation
  Scenario Outline: User is able to request a Demo but does not fill out result
    Given User navigates to PHPTRAVELS Demo Page
    When User fills in Demo Request Form <firstName>, <lastName>, <businessName>, <email>
    When User clicks submit
    Then Verify alert "Please input result number"
    Examples:
      | firstName | lastName | businessName | email               |
      | "ABC"     | "DEF"    | "Main Inc."  | "whatever@main.com" |
  @Validation
  Scenario Outline: User is able to request a Demo but fills out wrong result
    Given User navigates to PHPTRAVELS Demo Page
    When User fills in Demo Request Form <firstName>, <lastName>, <businessName>, <email>
    When User calculates and fills wrong result
    When User clicks submit
    Then Verify alert "Result number is wrong please type the correct one."
    Examples:
      | firstName | lastName | businessName | email               |
      | "ABC"     | "DEF"    | "Main Inc."  | "whatever@main.com" |

