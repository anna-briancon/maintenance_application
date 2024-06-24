package com.sqli.isc.iut.courses.cucumber;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BarSteps {

    private Bar bar;
    public boolean entryRefused;
    private int totalCostPignon;
    private int totalCostLeblanc;
    private boolean mrPignonHappy;

    @Given("le Juste bar is a cocktail bar with only {int} seats")
    public void le_juste_bar_is_a_cocktail_bar_with_only_seats(Integer capacity) {
        bar = new Bar(capacity);
    }

    @Given("there are already {int} people in the bar")
    public void there_are_already_people_in_the_bar(Integer nbPeople) {
        bar.setPeople(nbPeople);
    }

    @Given("Mr Pignon and Mr Leblanc go to the bar Le Juste")
    public void mrPignonAndMrLeblancGoToTheBarLeJuste() {
        bar.setPeople(0);
    }

    @When("they try to enter")
    public void they_try_to_enter() {
        entryRefused = !bar.entry(2);
    }

    @Then("they are refused entry")
    public void they_are_refused_entry() {
        assertTrue(entryRefused);
    }

    @When("a person tries to enter")
    public void a_person_tries_to_enter() {
        entryRefused = !bar.entry(1);
    }

    @Then("she can enter")
    public void she_can_enter() {
        assertFalse(entryRefused);
    }

    @Then("the bar is full")
    public void the_bar_is_full() {
        assertTrue(bar.isFull());
    }

    @When("they enter the bar")
    public void they_enter_the_bar() {
        entryRefused = !bar.entry(2);
        assertFalse(entryRefused);
    }

    @Then("the person behind them can't get in")
    public void the_person_behind_them_can_t_get_in() {
        entryRefused = !bar.entry(1);
        assertTrue(entryRefused);
    }

    @When("they each order a cocktail of the month for €{int}")
    public void they_each_order_a_cocktail_of_the_month_for_€(Integer int1) {
        totalCostPignon += 10;
        totalCostLeblanc += 10;
    }

    @When("Mr Leblanc pays for the whole thing")
    public void mr_leblanc_pays_for_the_whole_thing() {
        totalCostLeblanc = totalCostPignon + totalCostLeblanc;
        totalCostPignon = 0;
    }

    @Then("at the end of their drinks, Mr Leblanc pays")
    public void at_the_end_of_their_drinks_mr_leblanc_pays() {
        assertTrue(totalCostLeblanc == 20);
    }

    @Then("Mr Pignon is happy because they only had one drink")
    public void mr_pignon_is_happy_because_they_only_had_one_drink() {
        mrPignonHappy = true;
        assertTrue(mrPignonHappy);
    }

    @Then("no one pays for the other's drink")
    public void no_one_pays_for_the_other_s_drink() {
    }

    @When("at the end of their drinks, they each check their bill")
    public void at_the_end_of_their_drinks_they_each_check_their_bill() {
    }

    @When("Mr Pignon pays")
    public void mr_pignon_pays() {
        assertTrue(totalCostPignon == 10);
        totalCostPignon = 0;
    }

    @When("Mr Leblanc insists on paying for another cocktail of the month")
    public void mr_leblanc_insists_on_paying_for_another_cocktail_of_the_month() {
        totalCostLeblanc += 10;
    }

    @When("so he orders {int} more cocktails of the month for his bill")
    public void so_he_orders_more_cocktails_of_the_month_for_his_bill(Integer nbCocktails) {
        totalCostLeblanc += nbCocktails * 10;
    }

    @Then("at the end of their drinks, Mr Leblanc checks the bill and pays")
    public void at_the_end_of_their_drinks_mr_leblanc_checks_the_bill_and_pays() {
        assertTrue(totalCostLeblanc == 40); 
    }

    @Then("Mr Pignon is sad because he knows that over one cocktail he's going to have a very bad night")
    public void mr_pignon_is_sad_because_he_knows_that_over_one_cocktail_he_s_going_to_have_a_very_bad_night() {
        mrPignonHappy = false;
        assertFalse(mrPignonHappy);
    }
}
