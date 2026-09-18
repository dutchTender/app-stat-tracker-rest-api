Feature: Player Account Management

  Scenario: Registering a new unique player
    Given the registration database is empty
    When a client requests registration for "Alice" with email "alice@example.com"
    Then the response status should be 201
    And the player "Alice" should exist in the system