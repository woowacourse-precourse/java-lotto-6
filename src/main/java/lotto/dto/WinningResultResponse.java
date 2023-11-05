package lotto.dto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Prize;

public class WinningResultResponse {
    private Map<Prize, Integer> winningResult;

    public WinningResultResponse() {
        winningResult = new HashMap<>();

        List<Prize> prizes = Arrays.stream(Prize.values()).toList();
        prizes.forEach(prize -> winningResult.put(prize, 0));
    }

    public void increaseMatchingCount(Prize prize) {
        winningResult.put(prize, winningResult.get(prize) + 1);
    }
}
