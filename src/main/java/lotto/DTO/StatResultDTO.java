package lotto.DTO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatResultDTO {
    //private List<Integer> winCount;
    Map<Integer,Integer> winCount = new HashMap<>();
    private int totalProceeds;
    private BigDecimal rateOfReturn;

    public StatResultDTO(){
        for(int i =0;i<5;i++){
            winCount.put(i,0);
        }
    }
    

    
    public void setWinCount(int index ,int winCount){
        this.winCount.put(index, winCount);
    }

    public int getWinCount(int index){
        return winCount.get(index);
    }

    public void setTotalProceeds(int totalProceeds){
        this.totalProceeds = totalProceeds;
    }

    public int getTotalProceeds(){
        return totalProceeds;
    }

    public void setRateOfReturn(int totalProceeds,int purchaseAmount){
        BigDecimal totalProceedsDecimal = new BigDecimal(totalProceeds);
        BigDecimal purchaseAmountDecimal = new BigDecimal(purchaseAmount);
        BigDecimal rate = totalProceedsDecimal.divide(purchaseAmountDecimal);
        rate = rate.multiply(new BigDecimal(100));
        rate = rate.setScale(1,RoundingMode.HALF_UP);
        this.rateOfReturn = rate;
    }

    public BigDecimal getRateOfReturn(){
        return rateOfReturn;
    }
}
