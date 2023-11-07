package lotto.domain;

import java.util.Map;

public class ResultSheet {
    private static final int PERCENTAGE = 100;
    private final Map<Rank, Integer> sheet;

    public ResultSheet(Map<Rank, Integer> sheet) {
        this.sheet = sheet;
    }

    public int findCountByRank(Rank rank) {
        return sheet.get(rank);
    }

    public double getTotalProfit() {
        int purchaseCost = LottoOption.LOTTO_PRICE * getCount();
        double totalPrize = sheet.keySet()
                .stream()
                .mapToDouble(rank -> rank.getPrize() * sheet.get(rank))
                .sum();
        return (totalPrize / purchaseCost) * PERCENTAGE;
    }

    public int getCount() {
        return sheet.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
