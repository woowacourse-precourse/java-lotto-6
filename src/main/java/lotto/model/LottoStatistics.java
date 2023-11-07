package lotto.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class LottoStatistics { //각 등수별 당첨된 횟수 기록, 당첨 금액을 계산 및 수익률 계산

    public enum PrizeInformation {
        FIFTH_PRIZE(5000, "3개 일치"),
        FOURTH_PRIZE(50000, "4개 일치"),
        THIRD_PRIZE(1500000, "5개 일치"),
        SECOND_PRIZE(30000000, "5개 일치, 보너스 볼 일치"),
        FIRST_PRIZE(2000000000, "6개 일치");


        private final int prizeAmount;
        private final String rankMessage;

        PrizeInformation(int prizeAmount, String rankMessage) {
            this.prizeAmount = prizeAmount;
            this.rankMessage = rankMessage;
        }

        public int getPrizeAmount() {
            return prizeAmount;
        }

        public String getRankMessage() {
            return rankMessage;
        }
    }

    public static final int DEFAULT_VALUE = 0;
    private final LinkedHashMap<PrizeInformation, Integer> lottoStatistics;
    public final PrizeInformation[] winningInformation = PrizeInformation.values();

    public LottoStatistics() {
        this.lottoStatistics = new LinkedHashMap<>();

        for (PrizeInformation rank : winningInformation) {
            lottoStatistics.put(rank, DEFAULT_VALUE);
        }
    }

    public void writeStatistics(ArrayList<PrizeInformation> lottoResult) {
        for (PrizeInformation rank : lottoResult) {
            lottoStatistics.computeIfPresent(rank, (key, value) -> value + 1);
        }
    }

    public LinkedHashMap<PrizeInformation, Integer> getStatistics() {
        return lottoStatistics;
    }


    public double calculateLottoProfit(int purchaseAmount) {
        final int percentageCoefficient = 100;
        int winningAmount = sumWinningAmount();

        double profit;
        profit = (double) winningAmount / purchaseAmount * percentageCoefficient;

        return profit;
    }

    private int sumWinningAmount() {
        int sum = DEFAULT_VALUE;
        Set<Entry<PrizeInformation, Integer>> ranks = lottoStatistics.entrySet();
        for (Entry<PrizeInformation, Integer> singleRank : ranks) {
            int prizeAmount = singleRank.getKey().getPrizeAmount();
            int winningCount = singleRank.getValue();
            sum += prizeAmount * winningCount;
        }
        return sum;
    }


}
