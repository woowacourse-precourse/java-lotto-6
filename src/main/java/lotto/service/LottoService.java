package lotto.service;

import lotto.Lotto;
import lotto.domain.Bonus;
import lotto.domain.LottoBundle;
import lotto.domain.LottoSeller;
import lotto.domain.WinnerReader;
import lotto.domain.WinningLottoTable;
import lotto.domain.YieldCalculator;
import lotto.dto.BuyLottoDto;
import lotto.dto.LottoInfoDto;

public class LottoService {
    private final LottoSeller lottoSeller;
    private final YieldCalculator yieldCalculator;

    public LottoService(LottoSeller lottoSeller, YieldCalculator yieldCalculator) {
        this.lottoSeller = lottoSeller;
        this.yieldCalculator = yieldCalculator;
    }

    public BuyLottoDto buy(long fee) {
        LottoBundle lottoBundle = lottoSeller.sell(fee);
        long lottoCnt = lottoBundle.size();
        return BuyLottoDto.valueOf(lottoBundle, lottoCnt);
    }

    public WinningLottoTable solveLottoResult(LottoInfoDto lottoInfoDto) {
        WinnerReader winnerReader = createWinnerReader(lottoInfoDto);
        return winnerReader.checkLotteries(new LottoBundle(lottoInfoDto.getLotteries()));
    }

    private WinnerReader createWinnerReader(LottoInfoDto lottoInfoDto) {
        Lotto winnerLotto = new Lotto(lottoInfoDto.getWinnerLotto());
        Bonus bonus = new Bonus(winnerLotto, lottoInfoDto.getBonusNumber());
        return new WinnerReader(winnerLotto, bonus);
    }

    public String calculate(WinningLottoTable winningLottoTable, long lottoCnt) {
        return yieldCalculator.calculate(winningLottoTable, lottoCnt);
    }
}
