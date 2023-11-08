package lotto.dto;

import lotto.domain.Money;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WinningResult {

    private final Map<Rank, Integer> ranks;
    private final Money rewardMoney;

    public WinningResult(Map<Rank, Integer> ranks) {
        this.ranks = ranks;
        this.rewardMoney = calculateRewardMoney();
    }

    private Money calculateRewardMoney() {
        List<Money> winningMoney = new ArrayList<>();
        for (Rank rank : ranks.keySet()) {
            for (Integer i = 0; i < ranks.get(rank); i++) {
                winningMoney.add(rank.getReward());
            }
        }
        return calculateEarning(winningMoney);
    }

    private static Money calculateEarning(List<Money> winningMoney) {
        Money earning = new Money(0);
        for (Money money : winningMoney) {
            earning = earning.plus(money);
        }
        return earning;
    }

    public Map<Rank, Integer> getRanks() {
        return ranks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningResult winningResult = (WinningResult) o;
        return Objects.equals(ranks, winningResult.ranks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ranks);
    }
}
