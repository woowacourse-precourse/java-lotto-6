package lotto.service;

import java.util.Map;
import lotto.lotto.win.WinResult;

public class Calculator {
    private final int pay;

    public Calculator(int pay) {
        this.pay = pay;
    }

    public String getRateWithRequirementFormat (Map<WinResult, Integer> result){
        long sum = getSum(result);
        double rate = getRateOfReturn(sum);
        return String.format("%,.1f",rate);
    }

    private long getSum(Map<WinResult, Integer> result){
        return result.entrySet().stream()
                .mapToLong(entry -> entry.getKey().reward * entry.getValue())
                .sum();
    }
    private double getRateOfReturn(long sum){
        return ((double) sum/pay - 1) * 100;
    }
}


