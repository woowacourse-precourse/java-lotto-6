package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PrizeResult {
    private static final int SECOND_PRIZE_MATCH = 5;
    private final WinningNumbers winningNumbers;
    private final List<Lotto> lottoTickets;

    public PrizeResult(WinningNumbers winningNumbers, List<Lotto> lottoTickets) {
        this.winningNumbers = winningNumbers;
        this.lottoTickets = lottoTickets;
    }

    public Map<Prize, Integer> getWinningResult() {
        Map<Prize, Integer> result = initResult();
        lottoTickets.forEach(lotto -> {
            Prize prize = checkPrize(winningNumbers, lotto);
            result.put(prize, result.get(prize) + 1);
        });
        return Collections.unmodifiableMap(result);
    }

    private Map<Prize, Integer> initResult() {
        Map<Prize, Integer> result = new LinkedHashMap<>();
        Arrays.stream(Prize.values())
                .forEach(prize -> result.put(prize, 0));
        return result;
    }

    private Prize checkPrize(WinningNumbers winningNumbers, Lotto lotto) {
        int match = matchCount(winningNumbers, lotto);
        if (match == SECOND_PRIZE_MATCH && lotto.isContain(winningNumbers.getBonusNumber())) {
            return Prize.SECOND;
        }
        return Prize.getByMatch(match);
    }

    private int matchCount(WinningNumbers winningNumbers, Lotto lotto) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(winningNumbers::isContain)
                .count();
    }
}
