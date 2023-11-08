package lotto;

public class WinningResult {
    private int[] matchedCounts = new int[6];

    public void updateResult(int matchedNumbers, boolean hasBonusMatch) {
        if (matchedNumbers >= 3) {
            if (matchedNumbers == 5 && hasBonusMatch) {
                matchedCounts[5]++;
            } else {
                matchedCounts[matchedNumbers - 3]++;
            }
        }
    }

    public void printResult() {
        for (int i = 0; i < matchedCounts.length; i++) {
            int count = matchedCounts[i];
            if (count > 0) {
                int prizeMoney = calculatePrizeMoney(i + 3);
                System.out.printf("%d개 일치 (%s원) - %d개\n", i + 3, prizeMoney, count);
            }
        }
    }

    private int calculatePrizeMoney(int matchedCount) {
        switch (matchedCount) {
            case 3:
                return 5000;
            case 4:
                return 50000;
            case 5:
                return 1500000;
            case 6:
                return 2000000000;
            default:
                return 0;
        }
    }

    public double calculateTotalProfitRate() {
        int totalInvestment = matchedCounts[3] * 1000;
        int totalPrize = calculateTotalPrize();
        return ((double) totalPrize / totalInvestment) * 100;
    }

    private int calculateTotalPrize() {
        int totalPrize = 0;
        for (int i = 3; i <= 6; i++) {
            totalPrize += matchedCounts[i - 3] * calculatePrizeMoney(i);
        }
        return totalPrize;
    }
}