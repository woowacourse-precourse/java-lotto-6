package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WinningResult {

    private final Map<Integer, Long> winningResult;

    public WinningResult(List<Integer> drawResult) {
        winningResult = drawResult.stream()
                .filter(number -> number >= Rule.MINIMUM_NUMBER_TO_WIN.value())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public Map<Integer, Long> getWinningResult() {
        return winningResult;
    }

    /**
     * 당첨 통계
     * ---
     * 3개 일치 (5,000원) - 1개
     * 4개 일치 (50,000원) - 0개
     * 5개 일치 (1,500,000원) - 0개
     * 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
     * 6개 일치 (2,000,000,000원) - 0개
     * 총 수익률은 62.5%입니다.
     */
}
