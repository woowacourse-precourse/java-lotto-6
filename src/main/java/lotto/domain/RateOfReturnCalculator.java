package lotto.domain;

public class RateOfReturnCalculator {

    public static double calculate(int profit, int cost) {
        return (double)profit / cost * 100;
    }
}
