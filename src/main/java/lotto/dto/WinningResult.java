package lotto.dto;

import java.util.Map;
import lotto.domain.LottoAmount;
import lotto.enums.Prize;

public record WinningResult(Map<Prize, Integer> prizes) {
    private static final int ZERO = 0;

    public int countOf(final Prize prize) {
        return prizes.getOrDefault(prize, ZERO);
    }

    public double calculateYield(final LottoAmount amount) {
        return (double) this.totalWinningMoney() / amount.amount() * 100;
    }

    private int totalWinningMoney() {
        return prizes.keySet().stream()
                .filter(prize -> prize != Prize.NONE)
                .mapToInt(prize -> prize.getWinningMoney() * prizes.get(prize))
                .sum();
    }
}
