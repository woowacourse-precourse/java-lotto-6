package lotto.domain;

import java.util.Map;

public record ResultSheet(Map<Rank, Integer> sheet) {
    private static final int PERCENTAGE = 100;

    public void addCountByRank(Rank rank) {
        sheet.put(rank, sheet.get(rank) + 1);
    }

    public int findCountByRank(Rank rank) {
        return sheet.get(rank);
    }

    public double getTotalProfit() {
        int purchaseCost = LottoOption.LOTTO_PRICE * getTotalCount();
        double totalPrize = sheet.keySet()
                .stream()
                .mapToDouble(rank -> rank.getPrize() * sheet.get(rank))
                .sum();
        return (totalPrize / purchaseCost) * PERCENTAGE;
    }

    public int getTotalCount() {
        return sheet.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
