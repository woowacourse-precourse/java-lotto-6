package lotto.game;

public class Calculator {
    public static String calculateProfitRate(double profit, int money) {
        return String.valueOf((float)Math.round((float)profit/money*1000)/10);
    }
}
