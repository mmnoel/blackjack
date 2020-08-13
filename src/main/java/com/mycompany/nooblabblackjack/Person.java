
package com.mycompany.nooblabblackjack;

import java.util.ArrayList;

/**
 *
 * @author MNoel
 */
public class Person {
    private String name;
    private ArrayList<Card> cards;
    
    public Person(String name)
    {
        this.name = name;
        this.cards = new ArrayList<Card>();
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public ArrayList<Card> getCards()
    {
        return this.cards;
    }
    
    public void setCards(Card card)
    {
        this.cards.add(card);
    }
     
}
