
package com.mycompany.nooblabblackjack;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author MNoel
 */
public class Dealer extends Person{
        
    public ArrayList<ArrayList<Card>> cards;
            
    public Dealer(String name, ArrayList<ArrayList<Card>> cards)
    {
        super(name);
        this.cards = cards;
    }
    
    public void startGame(Player player1, Player player2)
    {
        Card startingCard1 = this.dealCard();
        Card startingCard2 = this.dealCard();
        if (startingCard1.getNumber().equals("Ace"))
        { 
            startingCard1.setValue(11);
        }   
        if(startingCard2.getNumber().equals("Ace"))
        { 
            startingCard2.setValue(11);
        }
        player1.setCards(startingCard1);
        player1.setPoints(startingCard1.getValue());
        player2.setCards(startingCard2);
        player2.setPoints(startingCard2.getValue());
    }
    public Card dealCard()
    {
        Random rand = new Random();
        
        if (!this.cards.isEmpty())
        {
             int randInt1 = rand.nextInt(this.cards.size());
             int randInt2 = rand.nextInt(this.cards.get(randInt1).size());
  
             Card dealtCard = this.cards.get(randInt1).get(randInt2);
             this.cards.get(randInt1).remove(randInt2); 
             if (this.cards.get(randInt1).isEmpty() )
             {
                this.cards.remove(randInt1);
             }
             return dealtCard;
           
        }else
        { 
            return null;
        }
    }
    
    public void announceWinner(Player player1, Player player2)
    {
        if(player1.getPoints() > player2.getPoints() && player1.getPoints()<= 21 || player2.getPoints()> 21)
        {
            player1.setWinner(true);
            System.out.println(player1.getName() + ", congratulations you won!");
            System.out.println(" ");
        }else if(player2.getPoints() > player1.getPoints() && player2.getPoints()<= 21 || player1.getPoints()> 21)
        {
            player2.setWinner(true);
            System.out.println(player2.getName() + ", congratulations you won!");
            System.out.println(" ");
        }else if(player1.getPoints() == player2.getPoints() && player1.getPoints()<= 21 )
        {
            player1.setWinner(true);
            player2.setWinner(true);
            System.out.println("It's a draw! Play again!");
            System.out.println(" ");
        }else
        {
            System.out.println("You're both bust");
            System.out.println(" ");
        }
    }
}
