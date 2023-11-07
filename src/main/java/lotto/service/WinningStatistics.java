package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.ResultRepository;
import lotto.domain.constant.Rank;

public class WinningStatistics {
    private final int numberOfPurchase;
    private final int sumOfWinningCost;
    private List<Integer> countRank;

    public WinningStatistics(List<ResultRepository> repositories) {
        numberOfPurchase = repositories.size();
        sumOfWinningCost = getSumOfWinningCost(repositories);
        countRank = getCountRank(repositories);
    }

    public String getWinningDetail(Rank rank) {
        return rank.getCostForShow() + " - " + countRank.get(rank.getRankNumber()) + "개";
    }

    public double getWinningRate() {
        double percent = sumOfWinningCost / (double) numberOfPurchase;
        return Math.round(percent * 1000) / 10.0;
    }

    private int getSumOfWinningCost(List<ResultRepository> repositories) {
        return repositories.stream().mapToInt(result
                -> result.getRank().getCostForCalculate()).sum();
    }

    private List<Integer> getCountRank(List<ResultRepository> repositories) {
        List<Integer> arr = getEmptyCounter();
        for (int i = 0; i < repositories.size(); i++) {
            int idx = repositories.get(i).getRank().getRankNumber();
            arr.set(idx, arr.get(idx) + 1);
        }
        return arr;
    }

    private List<Integer> getEmptyCounter() {
        List<Integer> count = new ArrayList<>();
        for (int rank = 0; rank <= 5; rank++) {
            count.add(0);
        }
        return count;
    }
}
