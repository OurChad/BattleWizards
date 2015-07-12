package com.tcg.dlc.battlewizards.entity;

import java.util.List;

public class Deck {

    protected List<Card> allCards;
    protected List<Card> inactiveCards;
    protected List<Card> activeCards;
    protected List<Card> discardedCards;

    public List<Card> getAllCards() {
        return allCards;
    }

    public void setAllCards(List<Card> allCards) {
        this.allCards = allCards;
    }

    public List<Card> getInactiveCards() {
        return inactiveCards;
    }

    public void setInactiveCards(List<Card> inactiveCards) {
        this.inactiveCards = inactiveCards;
    }

    public List<Card> getActiveCards() {
        return activeCards;
    }

    public void setActiveCards(List<Card> activeCards) {
        this.activeCards = activeCards;
    }

    public List<Card> getDiscardedCards() {
        return discardedCards;
    }

    public void setDiscardedCards(List<Card> discardedCards) {
        this.discardedCards = discardedCards;
    }

}
