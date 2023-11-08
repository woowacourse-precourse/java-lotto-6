package lotto.domain;

import lotto.constants.LottoRank;

public class WinnerStatistics {

    private final RankCounts rankCounts;
    private final TotalPrizeAmount totalPrizeAmount;

    public WinnerStatistics() {
        rankCounts = new RankCounts();
        totalPrizeAmount = new TotalPrizeAmount();
    }

    public WinnerStatistics(RankCounts rankCounts, TotalPrizeAmount totalPrizeAmount) {
        this.rankCounts = rankCounts;
        this.totalPrizeAmount = totalPrizeAmount;
    }

    // todo 필드 불변성에 대해 생각해보기 -> new 생성하려면 getter로 값을 꺼내야함
    public WinnerStatistics collect(MatchingResults matchingResults) {
        matchingResults.getLottoRanks()
                .stream()
                .forEach(this::update);

        return new WinnerStatistics(rankCounts, totalPrizeAmount);
    }

    private void update(LottoRank lottoRank) {
        rankCounts.update(lottoRank);
        totalPrizeAmount.update(lottoRank.getPrizeMoney());
    }
}

