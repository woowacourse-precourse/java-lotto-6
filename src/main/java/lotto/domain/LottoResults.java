package lotto.domain;

import java.util.List;

public class LottoResults {

    private final List<Rank> ranks;

    public LottoResults(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public long calculateTotalWinningMoney() {
        return ranks.stream()
                .mapToLong(Rank::getWinningMoney)
                .sum();
    }

}
