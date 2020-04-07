Feature: Cash Withdrawals

  Scenario Outline: Cash withdrawal
    Given '<customer>' has '<balance>' in his '<accountType>' account
    When he withdraws '<withdrawal>' in cash
    Then his remaining balance should be '<expectedBalance>'

    Examples:
      | customer | balance | accountType | withdrawal | expectedBalance |
      | Clive    | 1000    | Current     | 100        | 900             |
