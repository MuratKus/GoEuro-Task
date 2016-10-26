Feature: Test

  @wip
  Scenario: One Way Trip With Train - Today

    Given I navigated to "http://goeuro.com"
    And I select "Berlin" as from and "Prague" as destination
    And I search
    And Select the "train" tab
    Then I should view ordered "train" results


  Scenario: One Way Trip With Flight - Today

    Given I navigated to "http://goeuro.com"
    And I select "Berlin" as from and "Prague" as destination
    And I search
    And Select the "flight" tab
    Then I should view ordered "flight" results


  Scenario: One Way Trip With Bus - Today

    Given I navigated to "http://goeuro.com"
    And I select "Berlin" as from and "Prague" as destination
    And I search
    And Select the "bus" tab
    Then I should view ordered "bus" results

