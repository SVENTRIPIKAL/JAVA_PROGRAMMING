package projects.games.blackjack;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.text.NumberFormat;

public class Dealer implements Opponent
{
    private double bet = 0;                 // round bet
    private double pocketValue = 5000;      // available betting money
    private int handValue = 0;              // value of face-up cards in hand
    private int faceDownHandValue = 0;      // value of face-down cards in hand
    private List<String> hand = new ArrayList<>();
    private List<String> faceDownHand = new ArrayList<>();
    
    
    /**
     *  creates and shuffles 6 decks of cards
     */
    public void buildAndShuffleDeck()
    {
        try
        {
            System.out.printf("DEALER IS SHUFFLING THE DECK...%n%n");
            Thread.sleep(1850);
        }
        catch (Exception ignore) {    }
        
        for (int deck = 1; deck <= 6; deck++)
        {
            for (int num = 2; num <= 10; num++)  // create sets of 4 number cards
            {
                for (int set = 1; set <= 4; set++)
                {
                    BlackJackGame.deck.add(String.valueOf(num));   // add to deck
                }
            }
            
            for (int face = 1; face <= 4; face++)   // create sets of 4 face cards
            {
                String card = switch(face) {
                    case 1 -> "ACE" ;
                    case 2 -> "KING" ;
                    case 3 -> "QUEEN" ;
                    case 4 -> "JACK" ;
                    default -> null;
                };
                
                for (int set = 1; set <= 4; set++)
                {
                    BlackJackGame.deck.add(card);       // add to deck
                }
            }
            
            Collections.shuffle(BlackJackGame.deck);    // shuffle deck x2
            Collections.shuffle(BlackJackGame.deck);
        }
    }
    
    public void reShuffle(Player player){
        try {
            System.out.printf("%nDEALER IS RESHUFFLING THE DECK...%n%n");
            Thread.sleep(1850);
            BlackJackGame.deck.addAll(BlackJackGame.pile);
            BlackJackGame.pile.clear();
            Collections.shuffle(BlackJackGame.deck);
            Collections.shuffle(BlackJackGame.deck);
            player.cutDeck();
            System.out.printf("CONTINUING DEAL...%n%n%n");
            Thread.sleep(2000);
        }
        catch (Exception ignore) { }
    }
    
    /**
     *  deal 2 face-up cards to player, and 1 to self
     */
    public void dealCard(Opponent player) throws Exception
    {
        try
        {
            player.getHand().add(BlackJackGame.deck.remove(0));
            String card = player.getHand().get(player.getHand().size()-1);
            System.out.printf("%s'S DEAL:\t[%s]%n%n",
                    player.getClass().getSimpleName().toUpperCase(), card);
            Thread.sleep(650);
            player.setHandValue(card);
        }
        catch (Exception deckEmpty) {
            reShuffle(BlackJackGame.player);
            player.getHand().add(BlackJackGame.deck.remove(0));
            String card = player.getHand().get(player.getHand().size()-1);
            System.out.printf("%s'S DEAL:\t[%s]%n%n",
                    player.getClass().getSimpleName().toUpperCase(), card);
            Thread.sleep(650);
            player.setHandValue(card);
        }
    }
    
    /**
     *
     * @param dealer deal 1 face-down card to self
     */
    public void dealCardFaceDown(Dealer dealer) throws Exception
    {
        try
        {
            dealer.getFaceDownHand().add(BlackJackGame.deck.remove(0));
            String card = dealer.getFaceDownHand().get(
                    dealer.getFaceDownHand().size()-1);
            System.out.printf("%s'S DEAL:\t[FACE-DOWN]%n%n",
                    dealer.getClass().getSimpleName().toUpperCase());
            Thread.sleep(650);
            dealer.setFacedDownHandValue(card);
        }
        catch (Exception deckEmpty)
        {
            reShuffle(BlackJackGame.player);
            dealer.getFaceDownHand().add(BlackJackGame.deck.remove(0));
            String card = dealer.getFaceDownHand().get(
                    dealer.getFaceDownHand().size()-1);
            System.out.printf("%s'S DEAL:\t[FACE-DOWN]%n%n",
                    dealer.getClass().getSimpleName().toUpperCase());
            Thread.sleep(650);
            dealer.setFacedDownHandValue(card);
        }
    }
    
    
    public List<String> getHand() {
        return hand;
    }
    
    public List<String> getFaceDownHand() {
        return faceDownHand;
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
    
    public int getFaceDownHandValue(){
        return faceDownHandValue;
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
    
    public void setFacedDownHandValue(String card)
    {
        this.faceDownHandValue += switch (card.toUpperCase())
        {
            case "KING", "QUEEN", "JACK" -> 10 ;
            case "ACE" -> {
                if (this.faceDownHandValue <= 10) { yield 11 ;}
                else { yield 1 ;}
            }
            default -> Integer.parseInt(card);
        };
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
        return "Dealer{" +
                "bet=" + NF.format(bet) +
                ", pocketValue=" + NF.format(pocketValue) +
                ", handValue=" + handValue +
                ", faceDownHandValue=" + faceDownHandValue +
                ", hand=" + hand +
                ", faceDownHand=" + faceDownHand +
                '}';
    }
}