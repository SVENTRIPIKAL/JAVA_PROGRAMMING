package blackjackgame;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BlackJackGame
{
    private static final int BLACKJACK = 21;
    private static final int MIN_HAND_SIZE = 1;
    private static final int DEALER_HIT_LIMIT = 16;
    private static final int DEALER_STAND_LIMIT = 17;
    
    public enum Section {
        SHUFFLE_N_CUT, BET, DEAL, PLAYERS_NATURAL, DEALERS_NATURAL, THE_PLAY,
        STAND, HIT, FOLD, DEALERS_PLAY, EVALUATE, BUST, NEXT_ROUND
    }
    
    public static final Player player = new Player();           // player
    public static final Dealer dealer = new Dealer();           // opponent
    public static final List<String> deck = new ArrayList<>();  // game deck
    public static final List<String> pile = new ArrayList<>();  // used card pile
    
    public static Section begin = Section.SHUFFLE_N_CUT;
    public static BufferedReader BR =
            new BufferedReader(new InputStreamReader(System.in));
    public static NumberFormat NF = NumberFormat.getCurrencyInstance();
    
    public static void main(String[] args) throws Exception
    {
        while(true)
        {
            switch(begin)
            {
                case EVALUATE -> {
                    if ((dealer.getHandValue() > BLACKJACK &&
                         player.getHandValue() <= BLACKJACK) ||
                        (dealer.getHandValue() < player.getHandValue()))
                    {
                        double playerProfit = player.getBet();
                        double playerRefund = player.getPocketValue() + player.getBet();
                        double dealerAdjustment = (dealer.getPocketValue() +
                                dealer.getBet()) - playerProfit;
                        player.setPocketValue(playerRefund + playerProfit);
                        dealer.setPocketValue(dealerAdjustment);
                        System.out.printf("%nYOU WON THE ROUND!\tYOU COLLECTED: %s%n%n",
                                NF.format(playerProfit+player.getBet()));
                        viewTable(dealer, player);
                        Thread.sleep(3250);
                        player.addToPile(player.getHand());
                        dealer.addToPile(dealer.getHand());
                        dealer.addToPile(dealer.getFaceDownHand());
                        System.out.printf("%nALL HANDS DISCARDED TO USED PILE...%n%n");
                        Thread.sleep(3250);
                        begin = Section.NEXT_ROUND;
                    }
                    else if (dealer.getHandValue() <= BLACKJACK &&
                             dealer.getHandValue() > player.getHandValue())
                    {
                        System.out.printf("%nDEALER WON THE ROUND!%n%n");
                        viewTable(dealer, player);
                        Thread.sleep(3250);
                        double dealerProfit = player.getBet();
                        double dealerRefund = dealer.getPocketValue() + dealer.getBet();
                        dealer.setPocketValue(dealerRefund + dealerProfit);
                        System.out.printf("%nYOU FORFEITED: %s%n%n",
                                NF.format(dealerProfit));
                        Thread.sleep(3250);
                        player.addToPile(player.getHand());
                        dealer.addToPile(dealer.getHand());
                        dealer.addToPile(dealer.getFaceDownHand());
                        System.out.printf("%nALL HANDS DISCARDED TO USED PILE...%n%n");
                        Thread.sleep(3250);
                        begin = Section.NEXT_ROUND;
                    }
                    else {
                        System.out.printf("%nSTAND-OFF (A TIE)!!!%n%n");
                        viewTable(dealer, player);
                        Thread.sleep(3250);
                        player.setPocketValue(player.getPocketValue() + player.getBet());
                        dealer.setPocketValue(dealer.getPocketValue() + dealer.getBet());
                        System.out.printf("%nALL BETS HAVE BEEN RETURNED...%n%n");
                        Thread.sleep(3250);
                        player.addToPile(player.getHand());
                        dealer.addToPile(dealer.getHand());
                        dealer.addToPile(dealer.getFaceDownHand());
                        System.out.printf("%nALL HANDS DISCARDED TO USED PILE...%n%n");
                        Thread.sleep(3250);
                        begin = Section.NEXT_ROUND;
                    }
                }
                
                case SHUFFLE_N_CUT -> {
                    dealer.buildAndShuffleDeck();
                    player.cutDeck();
                    System.out.printf("""
                        %nDECK: %s[=]\tUSED PILE: %s[X]%n
                        STARTING ROUND...%n
                        """, deck.size(), pile.size());
                    Thread.sleep(2000);
                    begin = Section.BET;
                }
                
                case BET -> {
                    player.setHandValue(0);
                    dealer.setHandValue(0);
                    System.out.printf("""
                        %nWALLET: %s
                        ENTER YOUR BET [%s - %s]:\t""",
                            NF.format(player.getPocketValue()),
                            NF.format(2), NF.format(500));
                    try {
                        double bet = Double.parseDouble(BR.readLine().strip());
                        if (bet < 2 || bet > 500) {
                            System.out.printf("""
                            %n%nSORRY, ONLY %s - %s BETS ALLOWED...%n
                            """, NF.format(2), NF.format(500));
                            Thread.sleep(1800);
                            break;
                        }
                        if (bet > player.getPocketValue()) {
                            System.out.printf("""
                            %n%nNOT ENOUGH FUNDS TO WAGER THAT AMOUNT...%n
                            """);
                            Thread.sleep(1800);
                            break;
                        }
                        double newPocketValue = player.getPocketValue() - bet;
                        player.setBet(bet); player.setPocketValue(newPocketValue);
                        Random num = new Random();
                        bet = num.nextInt(499)+2;
                        newPocketValue = dealer.getPocketValue() - bet;
                        dealer.setBet(bet); dealer.setPocketValue(newPocketValue);
                        System.out.println();
                        begin = Section.DEAL;
                    }
                    catch (Exception inputError) {
                        System.out.println();
                        System.out.printf("""
                            %nINVALID INPUT -- TRY AGAIN...%n
                            """);
                        Thread.sleep(1800);
                        break;
                    }
                }
    
                case DEAL -> {
                    System.out.printf("%n%n%nDEALING...%n%n");
                    Thread.sleep(1250);
                    for (int i = 0; i < 4; i++)
                    {
                        Opponent name = i % 2 == 0 ? player : dealer ;
                        if (i != 3) { dealer.dealCard(name); }
                        else        { dealer.dealCardFaceDown(dealer); }
                    }
    
                    if ((player.getHand().contains("ACE"))  &&
                        (player.getHand().contains("KING")  ||
                         player.getHand().contains("QUEEN") ||
                         player.getHand().contains("JACK")  ||
                         player.getHand().contains("10")))
                    {
                        begin = Section.PLAYERS_NATURAL;
                        break;
                    }
                    
                    if ((dealer.getHand().contains("ACE"))  ||
                        (dealer.getHand().contains("KING")  ||
                         dealer.getHand().contains("QUEEN") ||
                         dealer.getHand().contains("JACK")  ||
                         dealer.getHand().contains("10")))
                    {
                        begin = Section.DEALERS_NATURAL;
                        break;
                    }
                    
                    begin = Section.THE_PLAY;
                }
                
                case PLAYERS_NATURAL -> {
                    player.setHandValue(BLACKJACK);
                    System.out.printf("%n%n%nYOU HAVE A NATURAL!%n%n");
                    viewTable(dealer, player);
                    Thread.sleep(3250);
                    System.out.printf("%nDEALER REVEALS THEIR FACE-DOWN CARD...%n%n");
                    Thread.sleep(3250);
                    dealer.getHand().addAll(dealer.getFaceDownHand());
                    dealer.getFaceDownHand().clear();
                    dealer.updateHandValue();
                    
                    if ((dealer.getHand().contains("ACE"))  &&
                        (dealer.getHand().contains("KING")  ||
                         dealer.getHand().contains("QUEEN") ||
                         dealer.getHand().contains("JACK")  ||
                         dealer.getHand().contains("10")))
                    {
                        dealer.setHandValue(BLACKJACK);
                        System.out.printf("%nSTAND-OFF (A TIE)!!!%n%n");
                        viewTable(dealer, player);
                        Thread.sleep(3250);
                        player.setPocketValue(player.getPocketValue() + player.getBet());
                        dealer.setPocketValue(dealer.getPocketValue() + dealer.getBet());
                        System.out.printf("%nALL BETS HAVE BEEN RETURNED...%n%n");
                        Thread.sleep(3250);
                        player.addToPile(player.getHand());
                        dealer.addToPile(dealer.getHand());
                        dealer.addToPile(dealer.getFaceDownHand());
                        System.out.printf("%nALL HANDS DISCARDED TO USED PILE...%n%n");
                        Thread.sleep(3250);
                        begin = Section.NEXT_ROUND;
                    }
                    
                    else {
                        double playerProfit = player.getBet() * 1.50;
                        double playerRefund = player.getPocketValue() + player.getBet();
                        double dealerAdjustment = (dealer.getPocketValue() +
                                dealer.getBet()) - playerProfit;
                        player.setPocketValue(playerRefund + playerProfit);
                        dealer.setPocketValue(dealerAdjustment);
                        System.out.printf("%nYOU WON THE ROUND!\tYOU COLLECTED: %s%n%n",
                                NF.format(playerProfit+player.getBet()));
                        viewTable(dealer, player);
                        Thread.sleep(3250);
                        player.addToPile(player.getHand());
                        dealer.addToPile(dealer.getHand());
                        dealer.addToPile(dealer.getFaceDownHand());
                        System.out.printf("%nALL HANDS DISCARDED TO USED PILE...%n%n");
                        Thread.sleep(3250);
                        begin = Section.NEXT_ROUND;
                    }
                }
                
                case DEALERS_NATURAL -> {
                    System.out.printf("""
                        %n%n%nDEALER HAS A POSSIBLE NATURAL...%n
                        """);
                    viewTable(dealer, player);
                    Thread.sleep(3250);
                    System.out.printf("%nDEALER REVEALS THEIR FACE-DOWN CARD...%n%n");
                    Thread.sleep(3250);
                    dealer.getHand().addAll(dealer.getFaceDownHand());
                    dealer.getFaceDownHand().clear();
                    dealer.updateHandValue();
    
                    if ((dealer.getHand().contains("ACE"))  &&
                        (dealer.getHand().contains("KING")  ||
                         dealer.getHand().contains("QUEEN") ||
                         dealer.getHand().contains("JACK")  ||
                         dealer.getHand().contains("10")))
                    {
                        dealer.setHandValue(BLACKJACK);
                        System.out.printf("%nDEALER WON THE ROUND BY NATURAL!%n%n");
                        viewTable(dealer, player);
                        Thread.sleep(3250);
                        double dealerProfit = player.getBet();
                        double dealerRefund = dealer.getPocketValue() + dealer.getBet();
                        dealer.setPocketValue(dealerRefund + dealerProfit);
                        System.out.printf("%nYOU FORFEITED: %s%n%n",
                                NF.format(dealerProfit));
                        Thread.sleep(3250);
                        player.addToPile(player.getHand());
                        dealer.addToPile(dealer.getHand());
                        dealer.addToPile(dealer.getFaceDownHand());
                        System.out.printf("%nALL HANDS DISCARDED TO USED PILE...%n%n");
                        Thread.sleep(3250);
                        begin = Section.NEXT_ROUND;
                        break;
                    }
                    
                    begin = Section.THE_PLAY;
                }
                
                case THE_PLAY -> {
                    viewTable(dealer, player);
                    System.out.printf("""
                            ENTER YOUR MOVE:
                        [STAND]   [HIT]   [FOLD]
                        """);
                    String move = BR.readLine().toUpperCase().strip();
                    System.out.println();
                    if (!move.equals("STAND") && !move.equals("HIT") &&
                        !move.equals("FOLD"))
                    {
                        System.out.printf("""
                            %nINVALID INPUT -- TRY AGAIN...%n
                            """);
                        Thread.sleep(1800);
                        break;
                    }
                    switch (move)
                    {
                        case "STAND" -> { begin = Section.STAND; }
                        case "HIT" ->   { begin = Section.HIT; }
                        case "FOLD" ->  { begin = Section.FOLD; }
                    }
                }
                
                case STAND -> {
                    System.out.printf("""
                        %n%n%nPLAYER STANDS...%n
                        """);
                    Thread.sleep(3250);
                    begin = Section.DEALERS_PLAY;
                }
                
                case HIT -> {
                    dealer.dealCard(player);
                    if (player.getHandValue() > BLACKJACK) {
                        begin = Section.BUST;
                        break;
                    }
                    begin = Section.THE_PLAY;
                }
                
                case FOLD -> {
                    System.out.printf("%n%nGAMEOVER...%n");
                    return;
                }
                
                case BUST -> {
                    System.out.printf("%nYOU BUSTED!%n%n");
                    viewTable(dealer, player);
                    Thread.sleep(3250);
                    System.out.printf("%nDEALER WON THE ROUND!%n%n");
                    Thread.sleep(3250);
                    double dealerProfit = player.getBet();
                    double dealerRefund = dealer.getPocketValue() + dealer.getBet();
                    dealer.setPocketValue(dealerRefund + dealerProfit);
                    System.out.printf("%nYOU FORFEITED: %s%n%n",
                            NF.format(dealerProfit));
                    Thread.sleep(3250);
                    player.addToPile(player.getHand());
                    dealer.addToPile(dealer.getHand());
                    dealer.addToPile(dealer.getFaceDownHand());
                    System.out.printf("%nALL HANDS DISCARDED TO USED PILE...%n%n");
                    Thread.sleep(3250);
                    begin = Section.NEXT_ROUND;
                }
                
                case DEALERS_PLAY -> {
                    System.out.printf("""
                        %nDEALER BEGINS THEIR TURN...%n
                        """);
                    Thread.sleep(3250);
                    if (dealer.getHand().size() == MIN_HAND_SIZE) {
                        System.out.printf("%nDEALER REVEALS THEIR FACE-DOWN CARD...%n%n");
                        Thread.sleep(3250);
                        dealer.getHand().addAll(dealer.getFaceDownHand());
                        dealer.getFaceDownHand().clear();
                        dealer.updateHandValue();
                        viewTable(dealer, player);
                        Thread.sleep(3250);
                    }
                    if (dealer.getHandValue() <= DEALER_HIT_LIMIT) {
                        System.out.printf("%nDEALING...%n%n");
                        Thread.sleep(1250);
                        while (dealer.getHandValue() <= DEALER_HIT_LIMIT){
                            dealer.dealCard(dealer);
                        }
                    }
                    if (dealer.getHandValue() >= DEALER_STAND_LIMIT) {
                        System.out.printf("%nDEALER STANDS...%n%n");
                        Thread.sleep(3250);
                        begin = Section.EVALUATE;
                    }
                }
    
                /**
                 *  FIX THIS LATER!
                 */
                case NEXT_ROUND -> {
                    if (player.getPocketValue() >= 2 && dealer.getPocketValue() >= 2){
                        System.out.printf("""
                        %nDECK: %s[=]\tUSED PILE: %s[X]%n
                        STARTING NEXT ROUND...%n
                        """, deck.size(), pile.size());
                        Thread.sleep(2000);
                        begin = Section.BET;
                        break;
                    }
                    begin = Section.FOLD;
                }
            }
        }
    }
    
    
    /**
     *  Outputs player-view of face-up cards on table
     */
    public static void viewTable(Dealer dealer, Player player)
    {
        System.out.printf("""
                                %s
                                DEALER: %s
                                %s%n
            %s
            PLAYER: %s
            %s%n
            """, dealer.getHand(), dealer.getHandValue(),
                NF.format(dealer.getPocketValue()),
                player.getHand(), player.getHandValue(),
                NF.format(player.getPocketValue())
        );
    }
}