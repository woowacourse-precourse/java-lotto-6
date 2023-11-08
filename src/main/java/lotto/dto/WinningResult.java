package lotto.dto;

import java.util.Arrays;
import java.util.LinkedHashMap;
import lotto.domain.Prize;

public record WinningResult(LinkedHashMap<Prize, Integer> prizes) {
    public static final int INITIAL_WINNING_RESULT = 0;

    public static WinningResult of(Prize... prizes) {
        WinningResult result = new WinningResult(new LinkedHashMap<>());
        Arrays.stream(prizes)
                .forEach(prize -> result.prizes.put(prize, INITIAL_WINNING_RESULT));
        return result;
    }
}
