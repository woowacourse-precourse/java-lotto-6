package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {

    private Map<Integer, Integer> winningDetails = new HashMap<>();
    private double profitRate;


    public LottoMachine(Lotto lottoWinNumber, List<Lotto> lottos, Integer bonusNumber) {
        saveWinningDetails(lottoWinNumber, lottos, bonusNumber);
        calculationOfTotalReturn(lottos.size());
    }

    double calculationOfTotalReturn(int lottoSize) {

        double purchaseAmount = lottoSize * 1000D;
        double winningAmount = Arrays.stream(LotteryRanking.values())
                .filter(ranking -> winningDetails.get(ranking.getRankingKey()) != null)
                .mapToDouble(ranking -> winningDetails.get(ranking.getRankingKey()) * ranking.getPrice())
                .sum();

        double percentage = (winningAmount / purchaseAmount) * 100;
        profitRate = Math.round(percentage * 10) / 10.0;
        return profitRate;
    }


    private void saveWinningDetails(Lotto lottoWinNumber, List<Lotto> lottos, Integer bonusNumber) {
        for (Lotto lotto : lottos) {
            findWinningAndBonusNumbersInLottoArray(lotto, lottoWinNumber, bonusNumber);
        }
    }

    private void findWinningAndBonusNumbersInLottoArray(Lotto lotto, Lotto lottoWinNumber, Integer bonusNumber) {
        int lottoWinningCount = 0;
        int bonusCount = 0;

        for (Integer item : lotto.getNumbers()) {
            if (lottoWinNumber.getNumbers().contains(item)) {
                lottoWinningCount += 1;
            }
            if (item == bonusNumber) {
                bonusCount += 1;
            }
        }
        saveRanking(lottoWinningCount, bonusCount);
    }

    private void saveRanking(int lottoWinningCount, int bonusCount) {
        if (lottoWinningCount >= 3 && lottoWinningCount <= 6) {
            if (lottoWinningCount == 5 && bonusCount == 1) {
                winningDetails.put(51, winningDetails.getOrDefault(51, 0) + 1);
                return;
            }
            winningDetails.put(lottoWinningCount, winningDetails.getOrDefault(lottoWinningCount, 0) + 1);
        }
    }

    public Integer compareRankingWinningDetails(Integer rank) {
        if (winningDetails.get(rank) == null) {
            return 0;
        }
        return winningDetails.get(rank);
    }

    public boolean compareProfitRate(double profitRate) {
        if (this.profitRate == profitRate) {
            return true;
        }
        return false;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public Map<Integer, Integer> getWinningDetails() {
        return winningDetails;
    }
}
