package lotto.domain;

import java.util.Map;

public class WinningCondition {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningCondition(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Map<Lotto, Rank> findRankByLotto(LottoTickets lottoTickets) {
        return lottoTickets.findRankByLotto(winningLotto, bonusNumber);
    }

    public double calculateTotalReturn(int money, Map<Rank, Integer> winningResult) {
        return (calculateTotalReward(winningResult) / money) * 100;
    }

    private double calculateTotalReward(Map<Rank, Integer> winningResult) {
        return winningResult.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().calculateReward(entry.getValue()))
                .sum();
    }
}
