package lotto.domain;

public class Result {
    private int countOfMatch3;
    private int countOfMatch4;
    private int countOfMatch5;
    private int countOfMatch5WithBonus;
    private int countOfMatch6;

    public void update(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == 3) {
            countOfMatch3++;
        } else if (countOfMatch == 4) {
            countOfMatch4++;
        } else if (countOfMatch == 5) {
            if (matchBonus) {
                countOfMatch5WithBonus++;
            } else {
                countOfMatch5++;
            }
        } else if (countOfMatch == 6) {
            countOfMatch6++;
        }
    }

    public double calculateProfit(int purchaseAmount) {
        int totalWinningAmount = calculateTotalWinningAmount();
        return (double) totalWinningAmount / purchaseAmount * 100;
    }

    private int calculateTotalWinningAmount() {
        return countOfMatch3 * 5000 + countOfMatch4 * 50000 + countOfMatch5 * 1500000 + countOfMatch5WithBonus * 30000000 + countOfMatch6 * 2000000000;
    }

    // Getters for result counts
}
