package com.tcg.dlc.battlewizards.decks;

import com.tcg.dlc.battlewizards.entity.Card;
import com.tcg.dlc.battlewizards.entity.Deck;
import com.tcg.dlc.battlewizards.interfaces.IDeck;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DeadWizardDeck extends Deck implements IDeck {

    private DeadWizardDeck deadWizardDeck;

    protected DeadWizardDeck(){
    }

    public DeadWizardDeck getInstance(){
        if(this.deadWizardDeck == null){
            this.deadWizardDeck = new DeadWizardDeck();
        }

        return this.deadWizardDeck;
    }

    @Override
    public void shuffle() {
        shuffle(this.getInactiveCards());
    }

    @Override
    public void shuffle(List<Card> cards) {
        Collections.shuffle(cards);
    }

    @Override
    public HashMap<Integer, List<Card>> deal(int numberOfPlayers) {
        this.setInactiveCards(this.getAllCards());
        HashMap<Integer, List<Card>> hands = new HashMap<Integer, List<Card>>();
        for(int i = 0; i < numberOfPlayers; i++){
            List<Card> hand = draw(8);
            hands.put(i, hand);
        }

        return hands;
    }

    @Override
    public List<Card> draw(int numberOfCards) {
        return drawCards(this.inactiveCards, this.activeCards, numberOfCards);
    }

    @Override
    public List<Card> draw(List<Card> previousCards, List<Card> newCards, int numberOfCards) {
        return drawCards(previousCards, newCards, numberOfCards);
    }

    @Override
    public void discard(List<Card> cardsToDiscard, List<Card> previousCards, List<Card> newCards) {
        previousCards.removeAll(cardsToDiscard);
        newCards.addAll(cardsToDiscard);
    }

    @Override
    public void discard(List<Card> previousCards, List<Card> newCards, int numberOfCards) {
        List<Card> cardsToDiscard;

        if(numberOfCards > previousCards.size()){
            cardsToDiscard = previousCards.subList(0, previousCards.size());
        }else{
            cardsToDiscard = previousCards.subList(0, numberOfCards);
        }

        discard(cardsToDiscard, previousCards, newCards);
    }

    protected List<Card> drawCards(List<Card> previousCards, List<Card> newCards, int numberOfCards){
        List<Card> hand;
        int previousCardsSize = previousCards.size();

        if(previousCards == this.inactiveCards && numberOfCards > previousCardsSize) {
            hand = previousCards.subList(0, previousCardsSize);

            reshuffleDiscardedCards(); // Shuffle the discarded cards and add them as inactive cards

            List<Card> restOfHand = previousCards.subList(0, (numberOfCards - previousCardsSize));
            hand.addAll(restOfHand);
            previousCards.removeAll(restOfHand);
        } else if(numberOfCards > previousCardsSize){
            hand = previousCards.subList(0, previousCardsSize);
            previousCards.clear();
        } else {
            hand = previousCards.subList(0, numberOfCards);
            previousCards.removeAll(hand);
        }

        newCards.addAll(hand);

        return hand;
    }

    protected void reshuffleDiscardedCards(){
        shuffle(this.discardedCards);
        this.inactiveCards.clear();
        this.inactiveCards.addAll(this.discardedCards);
        this.discardedCards.clear();
    }
}
