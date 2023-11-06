package lotto.model;

import java.util.List;

public class CalculateTotal {

    public static double profit(List<Integer> matchingCounts){
        double total = 0;
        for(int i=0; i<matchingCounts.size(); i++){
            total += Statistic.values()[i].getPrize() * matchingCounts.get(i);
        }
        return total;
    }

    public static double returnRate(double profit, int purchaseAmount){
        return profit/purchaseAmount*100;
    }

}
