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

    public Money getRewardMoney() {
        return rewardMoney;
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

    private Money calculateRewardMoney() {
        List<Money> winningMoney = new ArrayList<>();
        for (Rank rank : ranks.keySet()) {
            winningMoney.add(sumUnitRankReward(rank));
        }
        return calculateEarning(winningMoney);
    }

    private Money sumUnitRankReward(Rank rank) {
        return rank.getReward().multiply(ranks.get(rank));
    }

    private Money calculateEarning(List<Money> winningMoney) {
        return winningMoney.stream()
                .reduce(Money::plus)
                .orElse(new Money(0));
    }
}
