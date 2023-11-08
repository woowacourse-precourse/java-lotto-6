package lotto;

import config.LottoConfig;

import java.util.List;

public class LottoRewardsCenter {
    private final LottoChecker lottoChecker;

    public LottoRewardsCenter(LottoChecker lottoChecker) {
        this.lottoChecker = lottoChecker;
    }

    public List<LottoPrize> getPrizeResults(List<Lotto> lottos) {
        return lottos.stream().map(lottoChecker::check).toList();
    }

    public Double calculateROI(List<LottoPrize> prizes) {
        int inputAmount = prizes.size() * LottoConfig.LOTTO_PRICE;
        long totalPrizeAmount = prizes.stream().mapToLong(LottoPrize::getPrizeAmount).sum();

        double ROI = (double) totalPrizeAmount * 100 / inputAmount;
        return Math.round(ROI * 10.0) / 10.0;
    }
}