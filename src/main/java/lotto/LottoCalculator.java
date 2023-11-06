package lotto;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoCalculator {
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
        return Math.round(result*100)/100.0;
    }
}
