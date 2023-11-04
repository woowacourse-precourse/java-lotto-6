package lotto.service;

import java.util.Map;
import lotto.domain.Rank;

public class Calculator {

    public static double calculateRateOfReturn(Map<Rank, Integer> result, int pay) {
        long sum = getSum(result);
        return ((double) sum / pay) * 100;
    }

    private static long getSum(Map<Rank, Integer> result) {
        return result.entrySet().stream()
                .mapToLong(entry -> (entry.getKey().reward) * (entry.getValue()))
                .sum();
    }
}


