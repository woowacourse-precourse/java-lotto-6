package lotto.service;

import java.util.List;
import lotto.common.constants.LottoRank;
import lotto.controller.dto.output.WinningLottoResultDto;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.WinningTicket;
import lotto.model.purchase.LottoPurchase;
import lotto.model.purchase.LottoPurchaseAmount;

public class LottoWinningStatisticsService {

    public WinningLottoResultDto getWinningStatistics(LottoPurchase lottoPurchase, WinningTicket winningTicket) {
        LottoPurchaseAmount purchaseAmount = lottoPurchase.amount();
        List<Lotto> purchasedLottos = lottoPurchase.lottos();

        List<LottoRank> winningResult = calculateWinningResult(winningTicket, purchasedLottos);
        long totalPrize = calculatePrize(winningResult);
        float profitRate = calculateProfitRate(purchaseAmount, totalPrize);

        return new WinningLottoResultDto(winningResult, profitRate);
    }

    private List<LottoRank> calculateWinningResult(WinningTicket winningTicket, List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> lotto.calculateLottoRank(winningTicket))
                .toList();
    }

    private long calculatePrize(List<LottoRank> results) {
        long totalPrize = 0;
        for (LottoRank result : results) {
            totalPrize += result.getPrize();
        }
        return totalPrize;
    }

    private float calculateProfitRate(LottoPurchaseAmount lottoPurchaseAmount, long totalPrize) {
        int purchaseAmount = lottoPurchaseAmount.getValue();
        return (float) totalPrize / purchaseAmount * 100;
    }
}
