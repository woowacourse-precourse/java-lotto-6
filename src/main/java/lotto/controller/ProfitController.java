package lotto.controller;

import lotto.domain.LottoProfit;
import lotto.domain.LottoPurchase;
import lotto.domain.RankResult;
import lotto.view.console.OutputView;

public class ProfitController {
    private final LottoPurchase lottoPurchase;
    private final RankResult rankResult;

    private ProfitController(LottoPurchase lottoPurchase, RankResult rankResult) {
        this.lottoPurchase = lottoPurchase;
        this.rankResult = rankResult;
    }

    public static ProfitController of(LottoPurchase lottoPurchase, RankResult rankResult) {
        return new ProfitController(lottoPurchase, rankResult);
    }

    public void showProfit() {
        LottoProfit lottoProfit = LottoProfit.of(lottoPurchase, rankResult);
        double profitRate = lottoProfit.calculateProfitRate();

        OutputView.printProfitRate(profitRate);
    }
}
