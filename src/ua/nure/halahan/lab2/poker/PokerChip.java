package ua.nure.halahan.lab2.poker;


import aima.core.agent.EnvironmentObject;

public class PokerChip implements EnvironmentObject {

    /*
     * Denomination and currency of chips: 10$, 20$ .... 100$
     * */
    private Integer denomination;
    private String currency;

    public PokerChip() {
    }

    public PokerChip(Integer denomination, String currency) {
        this.denomination = denomination;
        this.currency = currency;
    }

    public Integer getDenomination() {
        return denomination;
    }

    public void setDenomination(Integer denomination) {
        this.denomination = denomination;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
