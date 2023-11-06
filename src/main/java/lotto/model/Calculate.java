package lotto.model;

import java.util.List;

public class Calculate {

    public static double totalProfit(List<Integer> matchingCounts){
        double total = 0;
        for(int i=0; i<matchingCounts.size(); i++){
            total += Statistic.values()[i].getPrize() * matchingCounts.get(i);
        }
        return total;
    }

    public static String totalReturnRate(double profit, int purchaseAmount){
        double returnRate = profit/purchaseAmount*100;
        return String.format("%,.1f",returnRate);
    }

}
