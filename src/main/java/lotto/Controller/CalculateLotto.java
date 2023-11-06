package lotto.Controller;

import static lotto.Model.MatchNums.*;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class CalculateLotto {
    public static final double POINT = 10.0;

    public int checkMatch(List<Integer> generatedNums, List<Integer> inputNums){
        return (int)generatedNums.stream().filter(o -> inputNums.stream().anyMatch(Predicate.isEqual(o))).count();
    }

    public boolean checkBonus(List<Integer> generatedNums, List<Integer> winningNums, int bonus){
        int cnt = checkMatch(generatedNums, winningNums);
        if (cnt == THREE.getNum()){
            return generatedNums.contains(bonus);
        }
        return false;
    }

    public double roi(double investment, double current){
        double result = investment/current * 100;
        return Math.round(result*POINT)/POINT;
    }

    public int getProfit(Map<Integer, Integer> matchMap){
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
}
