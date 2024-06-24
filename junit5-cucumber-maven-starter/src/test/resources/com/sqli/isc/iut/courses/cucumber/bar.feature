Feature: Cocktail bar
    As a customer, I want to enter the bar and order cocktails.

    Background:
        Given le Juste bar is a cocktail bar with only 10 seats

    Scenario: Refusal of entry because the bar is full
        Given Mr Pignon and Mr Leblanc go to the bar Le Juste
        And there are already 9 people in the bar
        When they try to enter
        Then they are refused entry
        When a person tries to enter
        Then she can enter
        And the bar is full

    Scenario: They can get in but then the bar is full
        Given Mr Pignon and Mr Leblanc go to the bar Le Juste
        And there are already 8 people in the bar
        When they enter the bar
        Then the person behind them can't get in
        And the bar is full
        When they each order a cocktail of the month for €10
        And Mr Leblanc pays for the whole thing
        Then at the end of their drinks, Mr Leblanc pays
        And Mr Pignon is happy because they only had one drink

    Scenario: They can go in and drink more cocktails
        Given Mr Pignon and Mr Leblanc go to the bar Le Juste
        And there are already 3 people in the bar
        When they enter the bar
        And they each order a cocktail of the month for €10
        Then no one pays for the other's drink
        When at the end of their drinks, they each check their bill
        And Mr Pignon pays
        And Mr Leblanc insists on paying for another cocktail of the month
        And so he orders 2 more cocktails of the month for his bill
        Then at the end of their drinks, Mr Leblanc checks the bill and pays
        And Mr Pignon is sad because he knows that over one cocktail he's going to have a very bad night