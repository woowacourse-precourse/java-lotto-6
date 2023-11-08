package lotto.controller;

import lotto.domain.LottoPrize;
import lotto.domain.LottoProfit;
import lotto.domain.LottoPurchase;
import lotto.service.LottoProfitService;

public class LottoProfitController {

    private final LottoProfitService lottoProfitService;

    public LottoProfitController() {
        lottoProfitService = new LottoProfitService();
    }

    public LottoProfit getLottoProfit(LottoPrize lottoPrize, LottoPurchase lottoPurchase) {
        return lottoProfitService.createLottoProfit(lottoPrize, lottoPurchase);
    }
}
