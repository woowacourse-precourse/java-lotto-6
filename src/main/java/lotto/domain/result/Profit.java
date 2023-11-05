package lotto.domain.result;

import java.text.DecimalFormat;
import java.util.List;

public class Profit {

    public void announceProfitResult(List<Integer> prizeCounts, Integer quantity) {
        int totalPrize = calculateTotalPrize(prizeCounts);
        int totalSpent = quantity * 1000;

        double profitRate = calculateProfitRate(totalPrize, totalSpent);

        System.out.println("총 수익률은 " + formatProfitRate(profitRate) + "%입니다.");
    }

    public String formatProfitRate(double profitRate) {
        DecimalFormat formatter = new DecimalFormat("0.0");
        return formatter.format(profitRate);
    }

    public double calculateProfitRate(int totalPrize, int totalSpent) {
        if (totalSpent == 0) {
            return 0.0;
        }
        return ((double) totalPrize / totalSpent) * 100;
    }

    public int calculateTotalPrize(List<Integer> prizeCounts) {
        int totalPrize = 0;
        for (int i = 0; i < prizeCounts.size(); i++) {
            totalPrize += prizeCounts.get(i) * Prize.values()[i].getPrizeMoney();
        }
        return totalPrize;
    }
}
