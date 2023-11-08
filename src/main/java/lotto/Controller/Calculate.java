package lotto.Controller;

import static lotto.Constants.LOTTO_PRICE;
import static lotto.MatchNums.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import lotto.MatchNums;

public class Calculate {
    private static final double POINT = 10.0;

    public int getMatchCount(List<Integer> generatedNums, List<Integer> inputNums){
        return (int)generatedNums.stream()
                .filter(o -> inputNums.stream().anyMatch(Predicate.isEqual(o)))
                .count();
    }

    public boolean canBeBonus(List<Integer> generatedNums, List<Integer> winningNums, int bonus){
        if (getMatchCount(generatedNums, winningNums) == FIVE.getNum()){
            return generatedNums.contains(bonus);
        }
        return false;
    }

    public String getProfitRate(double investment, double current){
        double result = investment/current * 100;
        return String.format("%,.1f", Math.round(result*POINT)/POINT);
    }

    public int getProfitCost(Map<Integer, Integer> matchMap){
        int profit = Arrays.stream(MatchNums.values())
                .map(o -> o.calculateCost(matchMap.get(o.getNum())))
                .reduce(0, Integer::sum);
        return profit;
    }

    public int getLottoCount(int cost){
        return cost/ LOTTO_PRICE.getNum();
    }
}
