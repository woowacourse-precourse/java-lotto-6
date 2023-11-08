package lotto.service;

import lotto.domain.LottoPrize;
import lotto.domain.LottoProfit;
import lotto.domain.LottoPurchase;

public class LottoProfitService {

    public LottoProfit createLottoProfit(LottoPrize lottoPrize, LottoPurchase lottoPurchase) {
        LottoProfit lottoProfit = LottoProfit.create();
        lottoProfit.updateLottoProfit(lottoPrize, lottoPurchase);
        return lottoProfit;
    }
}
