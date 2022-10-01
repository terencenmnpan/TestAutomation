Feature: Register for Demo Request
  Scenario Outline: User is able to request a Demo
    Given User navigates to PHPTRAVELS Demo Page
    When User fills in Demo Request Form <firstName>, <lastName>, <businessName>, <email>
    Then Verify this
    Examples:
      | firstName | lastName | businessName | email               |
      | "ABC"     | "DEF"    | "Main Inc."  | "whatever@main.com" |

