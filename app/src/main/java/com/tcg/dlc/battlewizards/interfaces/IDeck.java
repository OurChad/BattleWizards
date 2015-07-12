package com.tcg.dlc.battlewizards.interfaces;

import com.tcg.dlc.battlewizards.entity.Card;

import java.util.HashMap;
import java.util.List;

public interface IDeck {

    public void shuffle();
    public void shuffle(List<Card> cards);
    public HashMap<Integer, List<Card>> deal(int numberOfPlayers);
    public List<Card> draw(int numberOfCards);
    public List<Card> draw(List<Card> previousCards, List<Card> newCards, int numberOfCards);
    public void discard(List<Card> cardsToDiscard, List<Card> previousCards, List<Card> newCards);
    public void discard(List<Card> previousCards, List<Card> newCards, int numberOfCards);
}
