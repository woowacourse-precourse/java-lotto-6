package lotto.service;

import java.util.Map;
import lotto.model.win.Rank;

public class Calculator {

    public double calculateRateOfReturn(Map<Rank, Integer> result, int pay){
        long sum = getSum(result);
        return ((double) sum/pay) * 100;
    }

    private long getSum(Map<Rank, Integer> result){
        return result.entrySet().stream()
                .mapToLong(entry -> entry.getKey().reward * entry.getValue())
                .sum();
    }
}


