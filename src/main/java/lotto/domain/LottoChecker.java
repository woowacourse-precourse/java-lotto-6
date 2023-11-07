package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoChecker {

    private static final String WINNING_RESULT_NULL_EXCEPTION = "당첨 결과가 존재하지 않습니다.";

    private final Lotto winningLotto;
    private final Bonus bonus;

    private Map<Rank, Integer> winningResult;

    public LottoChecker(Lotto winningLotto, Bonus bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    public Map<Rank, Integer> checkWinningResult(LottoTickets lottoTickets) {
        Map<Lotto, Rank> rankByLotto = findRankByLotto(lottoTickets);

        winningResult = Arrays.stream(Rank.values())
                .collect(Collectors.toMap(rank -> rank, rank -> 0));

        for (Rank rank : rankByLotto.values()) {
            winningResult.put(rank, winningResult.get(rank) + 1);
        }

        return winningResult;
    }

    private Map<Lotto, Rank> findRankByLotto(LottoTickets lottoTickets) {
        return lottoTickets.findRankByLotto(winningLotto, bonus);
    }

    public double calculateTotalReturn(Money money) {
        return (calculateTotalReward() / money.getAmount()) * 100;
    }

    private double calculateTotalReward() {
        if (winningResult == null) {
            throw new IllegalStateException(WINNING_RESULT_NULL_EXCEPTION);
        }
        return winningResult.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().calculateReward(entry.getValue()))
                .sum();
    }
}
