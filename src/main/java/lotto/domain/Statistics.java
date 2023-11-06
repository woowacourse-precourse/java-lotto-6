package lotto.domain;

import lotto.constant.Constant;
import lotto.constant.Rank;

public class Statistics {

    private final Ranking ranking;
    private final Purchase purchasedLotto;

    public Statistics(final Ranking ranking, final Purchase purchasedLotto) {
        this.ranking = ranking;
        this.purchasedLotto = purchasedLotto;
    }

    private int sumRevenue() {
        return ranking.getRankStatus().get(Rank.FOURTH) * Rank.FOURTH.getPrize()
                + ranking.getRankStatus().get(Rank.THIRD) * Rank.THIRD.getPrize()
                + ranking.getRankStatus().get(Rank.SECOND) * Rank.SECOND.getPrize()
                + ranking.getRankStatus().get(Rank.SECOND_WITH_BONUS) * Rank.SECOND_WITH_BONUS.getPrize()
                + ranking.getRankStatus().get(Rank.FIRST) * Rank.FIRST.getPrize();
    }

    private double totalRevenue() {
        final int totalRevenue = sumRevenue();
        final double revenue = (double) totalRevenue / (purchasedLotto.getAmount() * 10);

        return Math.round(revenue * 100.0) / 100.0;
    }

    public void printRevenue() {
        System.out.printf("총 수익률은 %.1f%%입니다.", totalRevenue());
    }

    private void getRank(final String phrase, final Rank rank) {
        System.out.printf("%s%d개\n", phrase, ranking.getRankStatus().get(rank));
    }

    public void printRank() {
        getRank(Constant.fourth, Rank.FOURTH);
        getRank(Constant.third, Rank.THIRD);
        getRank(Constant.second, Rank.SECOND);
        getRank(Constant.secondWithBonus, Rank.SECOND_WITH_BONUS);
        getRank(Constant.first, Rank.FIRST);
    }
}
