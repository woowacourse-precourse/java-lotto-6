package lotto.service;

import lotto.domain.LottoPrize;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.Lottos;

public class LottoPrizeService {

    public LottoPrize createLottoPrize(Lottos lottos, LottoWinningNumbers lottoWinningNumbers) {
        LottoPrize lottoPrize = LottoPrize.create();
        lottoPrize.countPrizeRank(lottos, lottoWinningNumbers);
        return lottoPrize;
    }
}
