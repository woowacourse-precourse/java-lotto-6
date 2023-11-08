package lotto.service;

import java.util.Map;

public class ProfitCalculator {
    private static final Map<String, Integer> statisticsMatchesPrice=Map.of(
            "matchesThree",5000,
            "matchesFour",50000,
            "matchesFive",1500000,
            "matchesFiveAndBonus",30000000,
            "matchesSix",2000000000
    );

    public float calculateProfit(int budget,Map<String, Integer> statisticsMatchesCounts){
        return ((float)calculateMatchesPrice(statisticsMatchesCounts)/budget)*100;
    }

    private int calculateMatchesPrice(Map<String, Integer> statisticsMatchesCounts){
        int winningMoney=0;
        if(statisticsMatchesCounts.isEmpty()){
            throw new RuntimeException();
        }
        for (Map.Entry<String, Integer> entry : statisticsMatchesCounts.entrySet()) {
            winningMoney+=entry.getValue()*statisticsMatchesPrice.get(entry.getKey());
        }
        return winningMoney;
    }
}
