package lotto.util;

public class Calculator {
    public double getProfitRate(int totalProfit, int investment) {
        return (double) totalProfit / investment * 100;
    }
}
