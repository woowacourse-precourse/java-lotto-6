package lotto;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class CalculateLotto {
    public int checkMatch(List<Integer> generatedNums, List<Integer> inputNums){
        return (int)generatedNums.stream().filter(o -> inputNums.stream().anyMatch(Predicate.isEqual(o))).count();
    }

    public boolean checkBonus(List<Integer> generatedNums, List<Integer> winningNums, int bonus){
        int cnt = checkMatch(generatedNums, winningNums);
        if (cnt == 5){
            return generatedNums.contains(bonus);
        }
        return false;
    }

    public double roi(double investment, double current){
        double result = investment/current * 100;
        return Math.round(result*10)/10.0;
    }

    public int getProfit(Map<Integer, Integer> matchMap){
        int profit = 0;
        for (Map.Entry<Integer, Integer> items: matchMap.entrySet()) {
            if (items.getKey() == 3) {
                profit += (5000 * items.getValue());
            } else if (items.getKey() == 4) {
                profit += (50_000 * items.getValue());
            } else if (items.getKey() == 5) {
                profit += (1_500_000 * items.getValue());
            } else if (items.getKey()== 55) {
                profit += (30_000_000 * items.getValue());
            } else if (items.getKey() == 6){
                profit += (2_000_000_000 * items.getValue());
            }
        }
        return profit;
    }
}
