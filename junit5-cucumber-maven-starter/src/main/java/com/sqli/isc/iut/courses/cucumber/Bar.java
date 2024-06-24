package com.sqli.isc.iut.courses.cucumber;

public class Bar {
    private final int capacityMax;
    private int numberPeople;

    public Bar(int capacityMax) {
        this.capacityMax = capacityMax;
        this.numberPeople = 0;
    }

    public void setPeople(Integer nbPeople) {
        this.numberPeople = nbPeople;
    }

    public boolean entry(int nbPeople) {
        if (numberPeople + nbPeople <= capacityMax) {
            numberPeople += nbPeople;
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        return numberPeople == capacityMax;
    }
}
