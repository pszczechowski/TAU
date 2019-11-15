Feature: order

Scenario: A new order
Given a new order
When order get own pizzas <listOfOrder>
Then user can show <listOfOrder>

Scenario: Get order by regex
Given init order list
When user wanna order with <listOrder> hawajska
Then user get all tasks with <listOrder> hawajska



