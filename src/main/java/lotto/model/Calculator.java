package lotto.model;

public class Calculator {
    public static long calculateTotalPrize() {
        long totalPrize = 0;
        for (Rank rank : Rank.values()) {
            totalPrize += rank.getPrize() * rank.getCountOfWin();
        }
        return totalPrize;
    }
}
