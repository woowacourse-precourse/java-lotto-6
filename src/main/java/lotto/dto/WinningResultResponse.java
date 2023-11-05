package lotto.dto;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.domain.Prize;

public class WinningResultResponse {
    private Map<Prize, Integer> winningResult;

    public WinningResultResponse() {
        winningResult = new LinkedHashMap<>();

        List<Prize> prizes = Stream.of(Prize.values()).sorted(Comparator.reverseOrder()).toList();
        prizes.forEach(prize -> winningResult.put(prize, 0));
    }

    public void increaseMatchingCount(Prize prize) {
        winningResult.put(prize, winningResult.get(prize) + 1);
    }

    public Map<Prize, Integer> getWinningResult() {
        return Collections.unmodifiableMap(winningResult);
    }

    public int getTotalWinningPrice() {
        int totalPrice = 0;
        for (Map.Entry<Prize, Integer> entry : winningResult.entrySet()) {
            totalPrice += (entry.getKey().getWinningAmount() * entry.getValue());
        }
        return totalPrice;
    }
}
