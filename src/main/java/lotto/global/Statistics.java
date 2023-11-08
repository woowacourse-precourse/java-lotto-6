package lotto.global;

import lotto.Lotto;
import lotto.Rank;

import java.util.HashMap;
import java.util.List;

public class Statistics {
    private HashMap<Rank, Integer>  rankStatistics;

    public Statistics() {
        this.rankStatistics = new HashMap<>();
    }

    public void setRankStatistics(HashMap<Rank, Integer> rankStatistics) {
        this.rankStatistics = rankStatistics;
    }

    public HashMap<Rank, Integer> calculateRanking(
            List<Integer> winningLotto, List<Lotto> issuedLottos
    ) {
        initRankStatistics();
        for (Lotto lotto : issuedLottos) {
            Rank rank = lotto.compareWithWinningNumbers(winningLotto);
            int value = rankStatistics.get(rank);
            rankStatistics.put(rank, ++value);
        }
        return rankStatistics;
    }

    private void initRankStatistics() {
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            rankStatistics.put(rank, 0);
        }
    }

    public void printRanking() {
        System.out.println("\n당첨 통계\n---");
        printEachRanking(Rank.FIFTH);
        printEachRanking(Rank.FOURTH);
        printEachRanking(Rank.THIRD);
        printEachRanking(Rank.SECOND);
        printEachRanking(Rank.FIRST);
    }

    private void printEachRanking(Rank rank) {
        String rankLabel = rank.getLabel();
        int rankCount = rankStatistics.get(rank);
        System.out.println(rankLabel + " - " + rankCount + "개");
    }

    public double calculateRateOfReturn(double lottoPurchaseMoney) {
        double rankingMoney = getRankingMoney();
        return rankingMoney / lottoPurchaseMoney * 100.0;
    }

    private int getRankingMoney() {
        int rankingMoney = 0;
        for (Rank rank : rankStatistics.keySet()) {
            rankingMoney += getEachRankMoney(rank);
        }
        return rankingMoney;
    }

    private double getEachRankMoney(Rank rank) {
        double rankMoney = rank.getPrice();
        double rankCount = (double) rankStatistics.get(rank);
        return rankMoney * rankCount;
    }

    public void printRateOfReturn(double rateOfReturn) {
        double rateRounds = Math.round(rateOfReturn * 10D) / 10D;
        System.out.println("총 수익률은 " + rateRounds + "%입니다.");
    }
}
