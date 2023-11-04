package lotto.service;

import java.util.Map;
import lotto.model.win.WinResult;

public class Calculator {

    public double calculateRateOfReturn(Map<WinResult, Integer> result, int pay){
        long sum = getSum(result);
        return ((double) sum/pay) * 100;
    }

    private long getSum(Map<WinResult, Integer> result){
        return result.entrySet().stream()
                .mapToLong(entry -> entry.getKey().reward * entry.getValue())
                .sum();
    }
}


