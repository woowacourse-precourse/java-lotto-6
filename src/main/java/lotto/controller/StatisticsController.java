package lotto.controller;

import lotto.model.Rank;
import lotto.model.RankStatistics;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.EnumMap;

public class StatisticsController {
    private final OutputView outputView = new OutputView();

    public void printStatistics(RankStatistics rankStatistics) {
        outputView.printStatisticsStart();
        outputView.printStatisticsStartLine();
        EnumMap<Rank, Integer> statistic = rankStatistics.getRankStatistics();
        Arrays.stream(Rank.values())
                .filter(this::isRank)
                .forEach(rank -> printAllStatisticContent(rank, statistic.getOrDefault(rank, 0)));
    }

    private boolean isRank(Rank rank) {
        return rank != Rank.NO_RANK;
    }

    private void printAllStatisticContent(Rank rank, int hitCount) {
        if (rank == Rank.SECOND) {
            printStatisticsContentWithBonus(rank, hitCount);
            return;
        }
        printStatisticsContent(rank, hitCount);
    }

    private void printStatisticsContent(Rank rank, int hitCount) {
        outputView.printStatisticsContent(
                rank.getHitCount(),
                rank.getPrize(),
                hitCount);
    }

    private void printStatisticsContentWithBonus(Rank rank, int hitCount) {
        outputView.printStatisticsIncludeBonusNumber(
                rank.getHitCount(),
                rank.getPrize(),
                hitCount);
    }

    public void printProfitRate(RankStatistics rankStatistics, int userPayment) {
        double profitRate = rankStatistics.getProfitRate(userPayment);
        outputView.printProfitRate(profitRate);
    }
}