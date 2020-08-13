
package com.mycompany.nooblabblackjack;

/**
 *
 * @author MNoel
 */
public class Player extends Person{
        
    private boolean turn;
    private int points;
    private boolean stuck;
    private boolean winner;
    
    public Player(String name, boolean turn)
    {
        super(name);
        this.turn = turn;
        this.points = 0;
        this.stuck = false;
        this.winner = false;
    }
    
    public boolean isTurn()
    {
        return this.turn;
    }
    
    public void setTurn(boolean turn)
    {
        this.turn = turn;
    }
    
    public int getPoints()
    {
        return this.points;
    }
    
    public void setPoints(int point)
    { 
     this.points = this.points + point;
    }
    
    public boolean isStuck()
    {
       return this.stuck;
    }
    public void setStuck(boolean stuck)
    {
        this.stuck = stuck;
    }
    public boolean isWinner()
    {
        return this.winner;
    }
    public void setWinner(boolean winner)
    {
      this.winner = winner;   
    }
    
    public void stick(Player opponent)
    {
         this.stuck = true;
         this.turn = false; 
         if(opponent.isStuck() == false)
         {
             opponent.setTurn(true);
         }
    }
    public void twist(Dealer dealer, Player opponent)
    {
      Card newCard = dealer.dealCard();
      this.setCards(newCard);
      
      if (newCard.getNumber().equals("Ace"))
      {
        if (this.points <= 10)
        {
         newCard.setValue(11);
        }
        else
        {
         newCard.setValue(1);  
        }
      }
      
      if (this.stuck == false && opponent.isStuck()== false)
      {
         this.turn = false;
         opponent.setTurn(true); 
      }
      this.setPoints(newCard.getValue());
      
      if (this.points > 21)
      {
        this.stuck = true;
        this.printCards();
        this.printPoints();
        opponent.printCards();
        opponent.printPoints();
        System.out.println(this.getName()+" went bust");
        dealer.announceWinner(this, opponent);
      }
      
    }
   
    public void printCards()
    {
        String playersCards = "";
           for(int i= 0; i< this.getCards().size();i++)
           {
                   String suit = this.getCards().get(i).getSuit();
                   String number = this.getCards().get(i).getNumber();
                   if(i == this.getCards().size() - 1)
                   {
                     playersCards = playersCards +suit+" "+ number;
                   }else
                   {
                     playersCards = playersCards +suit+" "+ number+", "; 
                   }
           }
           System.out.println(this.getName()+"'s cards: " + playersCards);
           
    }
    
    public void printPoints()
    {
        System.out.println(this.getName()+"'s points: " + Integer.toString(this.points));
        System.out.println(" ");
    }
}
