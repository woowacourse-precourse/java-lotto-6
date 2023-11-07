package lotto.service;

import java.util.Map;
import java.util.stream.Collectors;
import lotto.config.Constants;
import lotto.domain.Rank;

public class Calculator {

    public static double calculateRateOfReturn(Map<Rank, Integer> result) {
        long sum = getSum(result);
        int pay = getPayment(result);
        return ((double) sum / pay) * 100;
    }
    private static long getSum(Map<Rank, Integer> result) {
        return result.entrySet().stream()
                .mapToLong(entry -> (entry.getKey().reward) * (entry.getValue()))
                .sum();
    }

    private static int getPayment(Map<Rank, Integer> result){
        int amount = result.values().stream().mapToInt(Integer::intValue).sum();
        return amount * Constants.LOTTO_PRICE;
    }
}


