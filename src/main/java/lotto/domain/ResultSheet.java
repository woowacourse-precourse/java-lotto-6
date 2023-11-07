package lotto.domain;

import java.util.Map;

public class ResultSheet {
    private Map<Rank, Integer> sheet;

    public ResultSheet(Map<Rank, Integer> sheet) {
        this.sheet = sheet;
    }

    public int findCountByRank(Rank rank) {
        return sheet.get(rank);
    }

    public float getTotalProfit() {
        int purchaseCost = LottoOption.LOTTO_PRICE * getCount();
        int totalPrize = (int) sheet.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return ((totalPrize * 1.0f) / purchaseCost) * 100;
    }

    public Map<Rank, Integer> getSheet() {
        return sheet;
    }

    public int getCount() {
        return sheet.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
