package lotto.Controller;

import static lotto.Constants.DIVIDED;
import static lotto.MatchNums.*;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Calculate {
    private static final double POINT = 10.0;

    public int getMatchCount(List<Integer> generatedNums, List<Integer> inputNums){
        return (int)generatedNums.stream().filter(o -> inputNums.stream().anyMatch(Predicate.isEqual(o))).count();
    }

    public boolean canBeBonus(List<Integer> generatedNums, List<Integer> winningNums, int bonus){
        int cnt = getMatchCount(generatedNums, winningNums);
        if (cnt == FIVE.getNum()){
            return generatedNums.contains(bonus);
        }
        return false;
    }

    public String getProfitRate(double investment, double current){
        double result = investment/current * 100;
        return String.format("%,.1f", Math.round(result*POINT)/POINT);
    }

    public int getProfitCost(Map<Integer, Integer> matchMap){
        int profit = 0;
        for (Map.Entry<Integer, Integer> items: matchMap.entrySet()) {
            if (items.getKey() == THREE.getNum()) {
                profit += (THREE.getCost() * items.getValue());
            } else if (items.getKey() == FOUR.getNum()) {
                profit += (FOUR.getCost() * items.getValue());
            } else if (items.getKey() == FIVE.getNum()) {
                profit += (FIVE.getCost() * items.getValue());
            } else if (items.getKey()== FIVE_AND_BONUS.getNum()) {
                profit += (FIVE_AND_BONUS.getCost() * items.getValue());
            } else if (items.getKey() == SIX.getNum()){
                profit += (SIX.getCost() * items.getValue());
            }
        }
        return profit;
    }

    public int getLottoCount(int cost){
        return cost/DIVIDED.getNum();
    }
}
