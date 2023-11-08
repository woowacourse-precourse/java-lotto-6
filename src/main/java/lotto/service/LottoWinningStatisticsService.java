package lotto.service;

import java.util.List;
import lotto.common.constants.LottoRank;
import lotto.controller.dto.output.WinningLottoResultDto;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.WinningLotto;
import lotto.model.purchase.LottoPurchase;
import lotto.model.purchase.LottoPurchaseAmount;

public class LottoWinningStatisticsService {

    public WinningLottoResultDto getWinningStatistics(LottoPurchase lottoPurchase, WinningLotto winningLotto) {
        LottoPurchaseAmount purchaseAmount = lottoPurchase.amount();
        List<Lotto> purchasedLottos = lottoPurchase.lottos();

        List<LottoRank> winningResult = calculateWinningResult(winningLotto, purchasedLottos);
        long totalPrize = calculatePrize(winningResult);
        float profitRate = calculateProfitRate(purchaseAmount, totalPrize);

        return new WinningLottoResultDto(winningResult, profitRate);
    }

    private List<LottoRank> calculateWinningResult(WinningLotto winningLotto, List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> lotto.calculateLottoRank(winningLotto))
                .toList();
    }

    private long calculatePrize(List<LottoRank> result) {
        return result.stream()
                .map(LottoRank::getPrize)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private float calculateProfitRate(LottoPurchaseAmount lottoPurchaseAmount, long totalPrize) {
        int purchaseAmount = lottoPurchaseAmount.getValue();
        return (float) totalPrize / purchaseAmount * 100;
    }
}
