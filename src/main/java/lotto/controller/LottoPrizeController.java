package lotto.controller;

import lotto.domain.LottoPrize;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.Lottos;
import lotto.service.LottoPrizeService;

public class LottoPrizeController {

    private final LottoPrizeService lottoPrizeService;

    public LottoPrizeController() {
        lottoPrizeService = new LottoPrizeService();
    }

    public LottoPrize getLottoPrize(Lottos lottos, LottoWinningNumbers lottoWinningNumbers) {
        return lottoPrizeService.createLottoPrize(lottos, lottoWinningNumbers);
    }
}
