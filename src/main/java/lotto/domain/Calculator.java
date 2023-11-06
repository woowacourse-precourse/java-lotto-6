package lotto.domain;

public class Calculator {
    public static int calculateTotalPrize() {
        int totalPrize = 0;
        for (Rank rank : Rank.values()) {
            totalPrize += rank.getPrize() * rank.getCountOfWin();
        }
        return totalPrize;
    }

    public static double calculateEarningRate(int totalPrize, Money money) {
        return ((double) totalPrize / money.getMoney()) * 100;
    }

}
