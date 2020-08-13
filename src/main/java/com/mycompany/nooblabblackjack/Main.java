
package com.mycompany.nooblabblackjack;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author K1903666 - Melissa Noel & K1915275 - Chris Skipsey
 */
public class Main {
    public static void main(String[] args)
     {  
       ArrayList<Card> diamond = new ArrayList<Card>();
       ArrayList<Card> heart = new ArrayList<Card>();
       ArrayList<Card> club = new ArrayList<Card>();
       ArrayList<Card> spade = new ArrayList<Card>();
       ArrayList<ArrayList<Card>> deck = new ArrayList<ArrayList<Card>>();
       ArrayList<Player> players = new ArrayList<Player>();
       Dealer dealer;
       String name;
       Player player1;
       Player player2;
       Player currentPlayer;
       Player opponent;
       String option; 
       
       diamond.add(new Card("diamond", "Ace", 11));
       diamond.add(new Card("diamond", "King", 10));
       diamond.add(new Card("diamond", "Queen", 10));
       diamond.add(new Card("diamond", "Jack", 10));
       diamond.add(new Card("diamond", "Ten", 10));
       diamond.add(new Card("diamond", "Nine", 9));
       diamond.add(new Card("diamond", "Eight", 8));
       diamond.add(new Card("diamond", "Seven", 7));
       diamond.add(new Card("diamond", "Six", 6));
       diamond.add(new Card("diamond", "Five", 5));
       diamond.add(new Card("diamond", "Four", 4));
       diamond.add(new Card("diamond", "Three", 3));
       diamond.add(new Card("diamond", "Two", 2));
      
   
       heart.add(new Card("heart", "Ace", 11));
       heart.add(new Card("heart", "King", 10));
       heart.add(new Card("heart", "Queen", 10));
       heart.add(new Card("heart", "Jack", 10));
       heart.add(new Card("heart", "Ten", 10));
       heart.add(new Card("heart", "Nine", 9));
       heart.add(new Card("heart", "Eight", 8));
       heart.add(new Card("heart", "Seven", 7));
       heart.add(new Card("heart", "Six", 6));
       heart.add(new Card("heart", "Five", 5));
       heart.add(new Card("heart", "Four", 4));
       heart.add(new Card("heart", "Three", 3));
       heart.add(new Card("heart", "Two", 2));
       
       club.add(new Card("club", "Ace", 11));
       club.add(new Card("club", "King", 10));
       club.add(new Card("club", "Queen", 10));
       club.add(new Card("club", "Jack", 10));
       club.add(new Card("club", "Ten", 10));
       club.add(new Card("club", "Nine", 9));
       club.add(new Card("club", "Eight", 8));
       club.add(new Card("club", "Seven", 7));
       club.add(new Card("club", "Six", 6));
       club.add(new Card("club", "Five", 5));
       club.add(new Card("club", "Four", 4));
       club.add(new Card("club", "Three", 3));
       club.add(new Card("club", "Two", 2));
       
       spade.add(new Card("spade", "Ace", 11));
       spade.add(new Card("spade", "King", 10));
       spade.add(new Card("spade", "Queen", 10));
       spade.add(new Card("spade", "Jack", 10));
       spade.add(new Card("spade", "Ten", 10));
       spade.add(new Card("spade", "Nine", 9));
       spade.add(new Card("spade", "Eight", 8));
       spade.add(new Card("spade", "Seven", 7));
       spade.add(new Card("spade", "Six", 6));
       spade.add(new Card("spade", "Five", 5));
       spade.add(new Card("spade", "Four", 4));
       spade.add(new Card("spade", "Three", 3));
       spade.add(new Card("spade", "Two", 2));
       
       deck.add(diamond);
       deck.add(heart);
       deck.add(club);
       deck.add(spade);
       
       dealer = new Dealer("Computer",deck);
       
       Scanner input = new Scanner(System.in);
       System.out.println("Welcome to your virtual game of Black Jack!");
       System.out.println(" ");
       for(int i = 0; i<2; i++)
       {
           System.out.println("Enter your name, Player "+Integer.toString(i+1)+": ");
           name = input.nextLine();
           if( i == 0)
           {
               players.add(new Player(name, true));

           }else
           {   
               players.add(new Player(name, false));
           }
       }
       
       player1 = players.get(0);
       player2 = players.get(1);
       
       dealer.startGame(player1, player2);
       System.out.println(" ");
       
       currentPlayer = player1;
       opponent = player2;
       while((player1.isTurn() == true || player2.isTurn()== true) && (player1.isStuck() == false || player2.isStuck() == false)&&(player1.isWinner() == false && player2.isWinner()== false) )
       {   
           player1.printCards();
           player1.printPoints();
           player2.printCards();
           player2.printPoints();
           
           if (player1.isTurn() == true)
           {
               currentPlayer = player1;
               opponent = player2;
           }else if(player2.isTurn() == true)
           {
               currentPlayer = player2;
               opponent = player1;
           }
           System.out.println("It's "+currentPlayer.getName()+"'s turn");
           
           do
           {
             System.out.println("Stick or Twist?");
             option = input.nextLine();
             System.out.println(" ");
             if(!option.equalsIgnoreCase("Stick") && !option.equalsIgnoreCase("Twist"))
             {
                 System.out.println("You can only choose Stick or Twist");
                 System.out.println();
             }
           }while(!option.equalsIgnoreCase("Stick") && !option.equalsIgnoreCase("Twist"));
           
           
           if(option.equalsIgnoreCase("Stick"))
           {   
               currentPlayer.stick(opponent);
           }else
           {
               currentPlayer.twist(dealer, opponent);
           }
           
       }
         if((player1.isStuck() == true && player2.isStuck() == true) && (player1.getPoints() <= 21 && player2.getPoints() <= 21)){
             player1.printCards();
             player1.printPoints();
             player2.printCards();
             player2.printPoints();
             dealer.announceWinner(player1, player2);
         }
       
       
     }     
}
