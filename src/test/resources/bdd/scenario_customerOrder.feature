Feature: order

Scenario: A new order
Given a new order
When order get own pizzas <listOfOrder>
Then user can show <listOfOrder>

