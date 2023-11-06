package lotto.dto;

import java.util.Map;
import lotto.enums.Prize;

public record WinningResult(Map<Prize, Integer> prizes) {
    private static final int ZERO = 0;

    public int countOf(final Prize prize) {
        return prizes.getOrDefault(prize, ZERO);
    }
}
