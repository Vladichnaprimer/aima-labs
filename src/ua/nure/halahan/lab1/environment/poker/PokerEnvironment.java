package ua.nure.halahan.lab1.environment.poker;

import aima.core.agent.*;
import aima.core.agent.impl.AbstractEnvironment;
import aima.core.agent.impl.DynamicAction;
import java.util.List;


public abstract class PokerEnvironment extends AbstractEnvironment {

    private List<EnvironmentObject> cards;
    private List<EnvironmentObject> pokerChips;
    private EnvironmentObject table;
    private List<Agent> otherPlayers;
    private Agent croupier;

    private final static  Action ACTION_SAY_PASS = new DynamicAction("pass");
    private final static  Action ACTION_SAY_FOLD = new DynamicAction("fold");
    private final static  Action ACTION_SAY_CHECK = new DynamicAction("check");
    private final static  Action ACTION_SPREAD_CARDS = new DynamicAction("spread cards");


    public List<EnvironmentObject> getCards() {
        return cards;
    }

    public void setCards(List<EnvironmentObject> cards) {
        this.cards.add((EnvironmentObject) cards);
    }

    public List<EnvironmentObject> getPokerChips() {
        return pokerChips;
    }

    public void setPokerChips(List<EnvironmentObject> pokerChips) {
        this.pokerChips.add((EnvironmentObject) pokerChips);
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
