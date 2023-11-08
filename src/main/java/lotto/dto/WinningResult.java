package lotto.dto;

import java.util.Map;
import java.util.function.IntBinaryOperator;
import lotto.enums.Prize;

public record WinningResult(Map<Prize, Integer> prizes) {
    private static final int ZERO = 0;

    public int countOf(final Prize prize) {
        return prizes.getOrDefault(prize, ZERO);
    }

    public int totalWinningAmount() {
        IntBinaryOperator multiply = (a, b) -> a * b;
        return prizes.keySet().stream()
                .filter(prize -> prize != Prize.NONE)
                .mapToInt(p -> multiply.applyAsInt(p.getWinningAmount(), prizes.get(p)))
                .sum();
    }
}
