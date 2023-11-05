package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_PRICE;

import java.util.Map;
import java.util.Map.Entry;
import lotto.utils.YieldFormatter;

public class YieldCalculator {

    public String calculate(Map<Rank, Integer> winningLottoTable, long lottoCnt) {
        double totalLottoPrice = calculateTotalLottoPrice(lottoCnt);
        double sum = calculateTotalRankPrice(winningLottoTable);
        return calculateYield(sum, totalLottoPrice);
    }

    private double calculateTotalLottoPrice(long lottoCnt) {
        return lottoCnt * LOTTO_PRICE;
    }

    private double calculateTotalRankPrice(Map<Rank, Integer> winningLottoTable) {
        return winningLottoTable.entrySet().stream().filter(this::winnable).mapToDouble(this::calculateRankPrice).sum();
    }

    private boolean winnable(Entry<Rank, Integer> winningLottoTable) {
        return winningLottoTable.getValue() != 0;
    }

    private double calculateRankPrice(Entry<Rank, Integer> winningLottoTable) {
        return winningLottoTable.getKey().getLotteryWinnings() * winningLottoTable.getValue();
    }

    private String calculateYield(double sum, double totalLottoPrice) {
        return YieldFormatter.format((sum / totalLottoPrice) * 100);
    }
}
