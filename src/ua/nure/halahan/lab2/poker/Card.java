package ua.nure.halahan.lab2.poker;


import aima.core.agent.EnvironmentObject;

public class Card implements EnvironmentObject{

    /*
    * Card's suit
    * */
    private final static String SPADES =    "Spades";
    private final static String HEARTS =    "Hearts";
    private final static String DIAMONDS =  "Diamonds";
    private final static String CLUBS =     "Clubs";

    /*
    * Card's value: 6, 7, 8, 9, 10, J, Q, K, A
    * */
    private String cardValue;

    public String getCardValue() {
        return cardValue;
    }

    public void setCardValue(String cardValue) {
        this.cardValue = cardValue;
    }

    public Card() {
    }
}
