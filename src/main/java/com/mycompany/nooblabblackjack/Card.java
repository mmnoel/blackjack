
package com.mycompany.nooblabblackjack;

/**
 *
 * @author MNoel
 */
public class Card {
    private String suit;
    private String number;
    private int value;
    
    public Card(String suit, String number, int value)
    {
        this.suit = suit;
        this.number = number;
        this.value = value;
    }
    
    public String getSuit()
    {
        return this.suit;
    }
    
    public void setSuit(String suit)
    {
        this.suit = suit;
    }
    
    public String getNumber()
    {
        return this.number;
    }
    
    public void setNumber(String number)
    {
        this.number = number;
    }
    
    public int getValue()
    {
        return this.value;
    }
    
    public void setValue(int value)
    {
        this.value = value;
    }
}
