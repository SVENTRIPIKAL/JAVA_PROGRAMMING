package blackjackgame;

import java.util.List;

public interface Opponent
{
    List<String> getHand();
    
    void setHand(List<String> hand);
    
    void addToPile(List<String> hand);
    
    int getHandValue();
    
    void setHandValue(String card);
    
    void setHandValue(int value);
    
    void updateHandValue();
    
    double getBet();
    
    void setBet(double bet);
    
    double getPocketValue();
    
    void setPocketValue(double pocketValue);
}