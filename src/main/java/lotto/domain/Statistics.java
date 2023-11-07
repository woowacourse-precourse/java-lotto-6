package lotto.domain;

import lotto.constant.Rank;

public class Statistics {
    private final Ranking ranking;
    private final Purchase purchasedLotto;

    public Statistics(final Ranking ranking, final Purchase purchasedLotto) {
        this.ranking = ranking;
        this.purchasedLotto = purchasedLotto;
    }

    public final Ranking getRanking() {
        return this.ranking;
    }

    private int sumRevenue() {
        return ranking.getRankStatus().get(Rank.FOURTH) * Rank.FOURTH.getPrize()
                + ranking.getRankStatus().get(Rank.THIRD) * Rank.THIRD.getPrize()
                + ranking.getRankStatus().get(Rank.SECOND) * Rank.SECOND.getPrize()
                + ranking.getRankStatus().get(Rank.SECOND_WITH_BONUS) * Rank.SECOND_WITH_BONUS.getPrize()
                + ranking.getRankStatus().get(Rank.FIRST) * Rank.FIRST.getPrize();
    }

    public final double getTotalRevenue() {
        final int totalRevenue = sumRevenue();
        final double revenue = (double) totalRevenue / (purchasedLotto.getAmount() * 10);

        return Math.round(revenue * 100.0) / 100.0;
    }
}
