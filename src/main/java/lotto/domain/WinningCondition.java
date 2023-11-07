package lotto.domain;

import java.util.Map;

public class WinningCondition {

    private final Lotto winningLotto;
    private final Bonus bonus;

    public WinningCondition(Lotto winningLotto, Bonus bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    public Map<Lotto, Rank> findRankByLotto(LottoTickets lottoTickets) {
        return lottoTickets.findRankByLotto(winningLotto, bonus);
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
