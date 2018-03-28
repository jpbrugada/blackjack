/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Scanner;
/**
 *
 * @author admin
 */
public class Blackjack {

   
    public static void main(String[] args) {
        // TODO code application logic here
        String response = "";
        int n = 3;
        int m = 2;
        int money = 500;
        int bet;
        int cardValueDealer;
        int cardValueDealerTotal = 0;
        int cardValue;
        int cardValueTotal = 0;
        String replay;
        int answer = 1;
        
        while(answer == 1){
        Scanner y = new Scanner(System.in);
        System.out.print("How much do you wanna bet? Reminder that you have " + money + " credits. Enter the amount: ");
        bet = y.nextInt();
        int tempMoney = money - bet;
        System.out.println("Reminder that you have temporarily " + tempMoney + " credits as of now.");
        System.out.println();
    
        int[] deck = new int[52];
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        
        
        
        for (int i = 0; i < deck.length; i++){
            deck[i] += i;
        }
        
        for (int i = 0; i < deck.length; i++){
            int index = (int)(Math.random() * deck.length);
            int x = deck[i];
            deck[i] = deck[index];
            deck[index] = x;
        }
        
        //display 2 cards for you
        for(int i = 0; i < m; i++){
            String suit = suits[deck[i] / 13];
            String rank = ranks[deck[i] % 13];
            
            System.out.println("You got " + rank + " of " + suit);
            switch (rank){
                case "Ace":
                    cardValue = 1;
                    cardValueTotal = cardValueTotal + cardValue;
                    break;
                case "2":
                    cardValue = 2;
                    cardValueTotal = cardValueTotal + cardValue;
                    break;
                case "3":
                    cardValue = 3;
                    cardValueTotal = cardValueTotal + cardValue;
                    break;
                case "4":
                    cardValue = 4;
                    cardValueTotal = cardValueTotal + cardValue;
                    break;
                case "5":
                    cardValue = 5;
                    cardValueTotal = cardValueTotal + cardValue;
                    break;
                case "6":
                    cardValue = 6;
                    cardValueTotal = cardValueTotal + cardValue;
                    break;
                case "7":
                    cardValue = 7;
                    cardValueTotal = cardValueTotal + cardValue;
                    break;
                case "8":
                    cardValue = 8;
                    cardValueTotal = cardValueTotal + cardValue;
                    break;
                case "9":
                    cardValue = 9;
                    cardValueTotal = cardValueTotal + cardValue;
                    break;
                default:
                    cardValue = 10;
                    cardValueTotal = cardValueTotal + cardValue;
            }
            if(i == 1){
                System.out.print("You want to hit another card? yes/no: ");
                response = y.next();
                if(response.equals("yes")){
                    m++;
                }
            }
        }
        if(cardValueTotal > 21){
            System.out.println("You got a total of " + (cardValueTotal - 21) + " points!");
        }else System.out.println("You got a total of " + cardValueTotal + " points!");
        
        
        //display 2 cards for dealer (3 if he got less than 10 points)
        for(int i = 0; i < n; i++){
            String suit = suits[deck[i] / 13];
            String rank  = ranks[deck[i] % 13];
            
            System.out.println("The dealer got " + rank + " of " + suit);
            switch (rank) {
                case "Ace":
                    cardValueDealer = 1;
                    cardValueDealerTotal = cardValueDealerTotal + cardValueDealer;
                    if(cardValueDealerTotal < 11){
                        n++;
                        i++;
                    }
                    else i++;
                    break;
                case "2":
                    cardValueDealer = 2;
                    cardValueDealerTotal = cardValueDealerTotal + cardValueDealer;
                    if(cardValueDealerTotal < 11){
                        n++;
                        i++;
                    }
                    else i++;
                    break;
                case "3":
                    cardValueDealer = 3;
                    cardValueDealerTotal = cardValueDealerTotal + cardValueDealer;
                    if(cardValueDealerTotal < 11){
                        n++;
                        i++;
                    }
                    else i++;
                    break;
                case "4":
                    cardValueDealer = 4;
                    cardValueDealerTotal = cardValueDealerTotal + cardValueDealer;
                    if(cardValueDealerTotal < 11){
                        n++;
                        i++;
                    }
                    else i++;
                    break;
                case "5":
                    cardValueDealer = 5;
                    cardValueDealerTotal = cardValueDealerTotal + cardValueDealer;
                    if(cardValueDealerTotal < 11){
                        n++;
                        i++;
                    }
                    else i++;
                    break;
                case "6":
                    cardValueDealer = 6;
                    cardValueDealerTotal = cardValueDealerTotal + cardValueDealer;
                    if(cardValueDealerTotal < 11){
                        n++;
                        i++;
                    }
                    else i++;
                    break;
                case "7":
                    cardValueDealer = 7;
                    cardValueDealerTotal = cardValueDealerTotal + cardValueDealer;
                    if(cardValueDealerTotal < 11){
                        n++;
                        i++;
                    }
                    else i++;
                    break;
                case "8":
                    cardValueDealer = 8;
                    cardValueDealerTotal = cardValueDealerTotal + cardValueDealer;
                    if(cardValueDealerTotal < 11){
                        n++;
                        i++;
                    }
                    else i++;
                    break;
                case "9":
                    cardValueDealer = 9;
                    cardValueDealerTotal = cardValueDealerTotal + cardValueDealer;
                    if(cardValueDealerTotal < 11){
                        n++;
                        i++;
                    }
                    else i++;
                    break;
                default:
                    cardValueDealer = 10;
                    cardValueDealerTotal = cardValueDealerTotal + cardValueDealer;
                    if(cardValueDealerTotal < 11){
                        n++;
                        i++;
                    }
                    else i++;
                    break;
            }
        }
        System.out.println();
        System.out.println("The dealer got a total of " + cardValueDealerTotal + " points!");
        
        if(cardValueTotal > cardValueDealerTotal && cardValueTotal == 21){
            System.out.println();
            System.out.println("YOU'VE HIT BLACKJACK! WHAT THE FUCK NIGGA YOU CHEAT");
            money = tempMoney + (bet * 4);
            System.out.println("You have now earned " + money + " in total.");
        }
        else if(cardValueTotal > cardValueDealerTotal){
            System.out.println();
            System.out.println("You've won against the dealer!");
            money = tempMoney + (bet * 2);
            System.out.println("You have now earned " + money + " credits in total.");
        }
        else if(cardValueTotal == cardValueDealerTotal){
            System.out.println();
            System.out.println("You tied with each other.");
            money = tempMoney + bet;
            System.out.println("You have now earned " + money + " credits in total.");
        }
        else if(cardValueTotal < cardValueDealerTotal){
            System.out.println();
            System.out.println("Tough luck! You lost against the dealer.");
            money = tempMoney;
            System.out.println("You have now " + money + " credits remaining.");
        }
        if(money > 0){
                System.out.print("Do you want to play again? Type yes/no: ");
                replay = y.next();
                if(replay.equals("yes")){
                    answer = 1;
                }else answer = 0;
            }else System.out.println("You ran out of money. It's game over, lad. Better luck next time");
        }
    }
}

    

