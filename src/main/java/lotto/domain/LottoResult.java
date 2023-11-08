package lotto.domain;

import java.util.Map;
import java.util.Set;
import lotto.domain.enumerte.Rank;

public class LottoResult {
    private final Map<Rank, Integer> ranks;

    public LottoResult(Map<Rank, Integer> ranks) {
        this.ranks = ranks;
    }

    public Map<Rank, Integer> getRanks() {
        return ranks;
    }

    public double calculateRate(PurchaseMoney purchaseMoney) {
        int price = purchaseMoney.getPurchaseMoney();

        double totalPrizeMoney = getTotalPrizeMoney();
        return ( totalPrizeMoney / price ) * 100;
    }

    private double getTotalPrizeMoney() {
        Set<Rank> rankSet = ranks.keySet();

        return rankSet.stream()
                .mapToDouble(this::getSum)
                .sum();
    }

    private double getSum(Rank rank) {
        Integer count = ranks.get(rank);

        return count * rank.getMoney();
    }

}
