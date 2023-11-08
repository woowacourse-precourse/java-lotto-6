package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import lotto.constant.Constant;
import lotto.constant.Message;

public class WinningResult {
    private final EnumMap<Rank, Integer> results;

    public WinningResult() {
        results = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
    }

    public void addResult(Rank rank) {
        results.put(rank, results.get(rank) + 1);
    }

    public int getCount(Rank rank) {
        return results.get(rank);
    }

    public int calculateTotalPrizeMoney() {
        return Arrays.stream(Rank.values())
                .mapToInt(rank -> rank.getPrizeMoney() * results.get(rank))
                .sum();
    }

    public double calculateYield(int purchaseAmount) {
        if (purchaseAmount < Constant.LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException(Message.ERROR_PURCHASE_AMOUNT_UNDER_MINIMUM.getMessage());
        }
        if (purchaseAmount > Constant.MAXIMUM_PURCHASE_AMOUNT.getValue()) {
            throw new IllegalArgumentException(Message.ERROR_PURCHASE_AMOUNT_OVER_MAXIMUM.getMessage());
        }
        if (purchaseAmount % Constant.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(Message.ERROR_PURCHASE_AMOUNT_INVALID_UNIT.getMessage());
        }
        return 100. * (double) calculateTotalPrizeMoney() / purchaseAmount;
    }
}
