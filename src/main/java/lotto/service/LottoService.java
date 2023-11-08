package lotto.service;

import lotto.constant.LottoPrice;
import lotto.domain.WinningPrize;
import lotto.model.WinningInfo;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoService {
    private WinningInfo winningInfo;

    public LottoService(WinningInfo winningInfo) {
        this.winningInfo = winningInfo;
    }
    public LottoService(){

    }

    public void WinningResults(Map<Long, Long> winningResults) {
        LinkedHashMap<Long, Long> winnings = winningInfo.getWinnings();

        for (Map.Entry<Long, Long> resultEntry : winningResults.entrySet()) {
            long prizeMatchingCount = resultEntry.getKey();
            Long winningCount = resultEntry.getValue();

            if (winnings.containsKey(prizeMatchingCount)) {

                winnings.put(prizeMatchingCount, winnings.get(prizeMatchingCount) + winningCount);
            }
        }

        winningInfo.setWinnings(winnings);
    }

    public double calculateProfitRate(int buyCount, Map<Long, Long> winningResults) {
        long totalPrize = 0L;

        for (Map.Entry<Long, Long> resultEntry : winningResults.entrySet()) {
            long prizeMatchingCount = resultEntry.getKey();
            Long winningCount = resultEntry.getValue();

            String prizeAmount = WinningPrize.getPrizeMap().get((int) prizeMatchingCount);
            if (prizeAmount != null) {
                long prizeValue = Long.parseLong(prizeAmount.replace(",", ""));
                totalPrize += prizeValue * winningCount;
            }
        }

        LottoPrice lottoPrice = LottoPrice.ONE_TICKET_PRICE;
        long totalCost = buyCount * lottoPrice.getPrice();
        double profitRate = ((totalPrize - totalCost) / (double) totalCost) * 100.0;


        return profitRate;
    }

}