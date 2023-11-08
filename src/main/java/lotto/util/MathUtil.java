package lotto.util;

import lotto.config.Rank;

import java.util.List;
import java.util.Set;

public class MathUtil {
    private MathUtil() {
    }

    public static int getIntersectionSize(Set<Integer> aSet, Set<Integer> bSet) {
        bSet.retainAll(aSet);
        return bSet.size();
    }

    public static String formatPercentage(int money, double profit) {
        double roundedProfit = profit / money * 100.0;
        return String.format("%,.1f%%", roundedProfit);
    }

    public static double getProfit(List<Integer> winningDetails) {
        double profit = 0;
        Rank[] rank = Rank.values();
        for (int i = 0; i < rank.length; i++) {
            profit += rank[i].getReward() * winningDetails.get(i);
        }
        return profit;
    }
}
