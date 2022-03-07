Feature: Login Scenarios

  Scenario Outline: Login successfully
    Given I have multiple users
    When I set the next credentials for user "<user>"
    Then The user should be logged

    Examples:
    | user                    |
    | standard_user           |
    | problem_user            |
    | performance_glitch_user |

  Scenario: Login with unlocked user
    Given I have multiple users
    When I set the next credentials for user "locked_out_user"
    Then There should be an error displayed