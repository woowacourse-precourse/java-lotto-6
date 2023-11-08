package lotto.domain;

public class ProfitCalculator {

    private double totalPrize;

    public void calculatePrize(int[] prizeGradeCounts) {
        for (int grade = 0; grade < 6; grade++) {
            if (grade == 1) {
                totalPrize += prizeGradeCounts[grade] * 2000000000L;
            }
            if (grade == 2) {
                totalPrize += prizeGradeCounts[grade] * 30000000L;
            }
            if (grade == 3) {
                totalPrize += prizeGradeCounts[grade] * 1500000L;
            }
            if (grade == 4) {
                totalPrize += prizeGradeCounts[grade] * 50000L;
            }
            if (grade == 5) {
                totalPrize += prizeGradeCounts[grade] * 5000L;
            }
        }
    }

    public double getRevenueRate(int[] prizeGradeCounts, int money) {
        calculatePrize(prizeGradeCounts);
        return (totalPrize / money) * 100L;
    }







    // 총 수익률

}
