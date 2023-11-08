package lotto.service;

import java.util.List;
import lotto.domain.LottoBundle;
import lotto.domain.LottoSeller;
import lotto.domain.WinnerReader;
import lotto.domain.WinningLottoTable;
import lotto.domain.YieldCalculator;
import lotto.dto.BuyLottoDto;

public class LottoService {
    private final LottoSeller lottoSeller;
    private final WinnerReader winnerReader;
    private final YieldCalculator yieldCalculator;

    public LottoService(LottoSeller lottoSeller, WinnerReader winnerReader, YieldCalculator yieldCalculator) {
        this.lottoSeller = lottoSeller;
        this.winnerReader = winnerReader;
        this.yieldCalculator = yieldCalculator;
    }

    public BuyLottoDto buy(long fee) {
        LottoBundle lottoBundle = lottoSeller.sell(fee);
        int lottoCnt = lottoBundle.size();
        return BuyLottoDto.valueOf(lottoBundle, lottoCnt);
    }

    public WinningLottoTable check(List<List<Integer>> lotteries) {
        return winnerReader.checkLotteries(new LottoBundle(lotteries));
    }

    public String calculate(WinningLottoTable winningLottoTable, long lottoCnt) {
        return yieldCalculator.calculate(winningLottoTable, lottoCnt);
    }
}
