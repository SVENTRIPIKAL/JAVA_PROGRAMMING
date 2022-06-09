package projects.blackjackgame;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.text.NumberFormat;

public class Player implements Opponent
{
    private double bet = 0;                 // round bet
    private double pocketValue = 500;       // available betting money
    private int handValue = 0;              // value of face-up cards in hand
    private List<String> hand = new ArrayList<>();
    
    
    /**
     *  cut deck from the bottom
     */
    public void cutDeck()
    {
        try
        {
            System.out.printf("PLAYER IS CUTTING THE DECK...%n%n");
            Thread.sleep(1850);
        }
        catch (Exception ignore) {    }
        
        Random num = new Random();
        int cutRange = num.nextInt(16) + 60 ;   // cut deck (last 60-75 cards)
        
        for (int cards = 1; cards <= cutRange; cards++) // add removed cards to used pile
        {
            BlackJackGame.pile.add(
                    BlackJackGame.deck.remove(
                            BlackJackGame.deck.size()-1));
        }
    }
    
    
    public List<String> getHand() {
        return hand;
    }
    
    public void setHand(List<String> hand){
        this.hand = hand;
    }
    
    public void addToPile(List<String> hand){
        BlackJackGame.pile.addAll(hand);
        hand.clear();
    }
    
    public int getHandValue(){
        return handValue;
    }
    
    public void setHandValue(String card)
    {
        this.handValue += switch (card.toUpperCase())
        {
            case "KING", "QUEEN", "JACK" -> 10 ;
            case "ACE" -> {
                if (this.handValue <= 10) { yield 11 ;}
                else { yield 1 ;}
            }
            default -> Integer.parseInt(card);
        };
    }
    
    public void setHandValue(int value) {
        this.handValue = value;
    }
    
    public void updateHandValue(){
        this.handValue = 0;
        for (String card : this.hand){
            this.setHandValue(card);
        }
    }
    
    public double getBet() {
        return bet;
    }
    
    public void setBet(double bet) {
        this.bet = bet;
    }
    
    public double getPocketValue(){
        return pocketValue;
    }
    
    public void setPocketValue(double pocketValue){
        this.pocketValue = pocketValue;
    }
    
    
    @Override
    public String toString() {
        NumberFormat NF = NumberFormat.getCurrencyInstance();
        return "Player{" +
                "bet=" + NF.format(bet) +
                ", pocketValue=" + NF.format(pocketValue) +
                ", handValue=" + handValue +
                ", hand=" + hand +
                '}';
    }
}