package ua.nure.halahan.lab2.poker;

import aima.core.agent.*;
import aima.core.agent.impl.AbstractEnvironment;
import aima.core.agent.impl.DynamicAction;

import java.util.ArrayList;
import java.util.List;


public abstract class PokerEnvironment extends AbstractEnvironment {

    /**
     * Environment objects
     * */
    private List<Card> cards;
    private List<PokerChip> pokerChips;
    private EnvironmentObject table;
    private List<Agent> otherPlayers;
    private Agent croupier;

    /**
     * Player agent actions
     * */
    private final static  Action ACTION_SAY_PASS = new DynamicAction("pass");
    private final static  Action ACTION_SAY_FOLD = new DynamicAction("fold");
    private final static  Action ACTION_SAY_CHECK = new DynamicAction("check");
    private final static  Action ACTION_PICKUP_WIN = new DynamicAction("pick up the win");
    private final static  Action ACTION_SPREAD_CARDS = new DynamicAction("spread cards");
    private boolean hasWon = false;

    /**
     * Croupier agent actions
     * */
    private final static  Action ACTION_DEAL_CARDS = new DynamicAction("deal cards");
    private final static  Action ACTION_PICKUP_CARDS = new DynamicAction("pick up the cards");

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards.add((Card) cards);
    }

    public List<PokerChip> getPokerChips() {
        return pokerChips;
    }

    public void setPokerChips(List<PokerChip> pokerChips) {
        this.pokerChips.add((PokerChip) pokerChips);
    }

    public EnvironmentObject getTable() {
        return table;
    }

    public void setTable(EnvironmentObject table) {
        this.table = table;
    }

    public List<Agent> getOtherPlayers() {
        return otherPlayers;
    }

    public void setOtherPlayers(List<Agent> otherPlayers) {
        this.otherPlayers.add((Agent) otherPlayers);
    }

    public Agent getCroupier() {
        return croupier;
    }

    public void setCroupier(Agent croupier) {
        this.croupier = croupier;
    }

    @Override
    public abstract EnvironmentState executeAction(Agent arg0, Action arg1);

    @Override
    public abstract EnvironmentState getCurrentState();

    @Override
    public abstract Percept getPerceptSeenBy(Agent arg0);

    public void addAgent(Agent a) {
        super.addAgent(a);
    }
}
