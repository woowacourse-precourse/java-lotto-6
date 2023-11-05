package lotto.DTO;

import java.math.BigDecimal;
import java.util.List;

public class StatResultDTO {
    private List<Integer> winCount;
    private int totalProceeds;
    private BigDecimal rateOfReturn;
    
    // private enum price {
    //     FIFTH(5000),FORTH(50000),THIRD(1500000),SECOND(30000000),FIRST(2000000000);

    //     private int winnings;

    //     price(int winnings){
    //         this.winnings = winnings;
    //     }

    //     public int getPrice(){
    //         return winnings;
    //     }
    // }
    
    public void setWinCount(List<Integer> winCount){
        this.winCount = winCount;
    }

    public List<Integer> getWinCount(){
        return winCount;
    }

    public void setTotalProceeds(int totalProceeds){
        this.totalProceeds = totalProceeds;
    }

    public int getTotalProceeds(){
        return totalProceeds;
    }

    public void setRateOfReturn(){
        this.rateOfReturn = rateOfReturn;
    }

    public BigDecimal getRateOfReturn(){
        return rateOfReturn;
    }
}
