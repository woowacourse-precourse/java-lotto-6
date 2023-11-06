package lotto.controller;

import lotto.ApplicationConfig;
import lotto.model.AutoLottoGenerator;
import lotto.model.LottoBuyer;
import lotto.model.LottoSeller;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.service.LottoGameService;

public class LottoGameController {
    private final ApplicationConfig appConfig;
    private final LottoGameService lottoGameService;

    public LottoGameController(final ApplicationConfig appConfig) {
        this.appConfig = appConfig;
        this.lottoGameService = appConfig.lottoGameService();
    }

    public void run() {
        final LottoSeller seller = generateSeller();
        final LottoBuyer buyer = generateBuyer();
        final int countOfLotto = lottoGameService.calculateLottoCountOnBuy(buyer);

        final Lottos lottos = lottoGameService.generateLottosOnSell(seller, countOfLotto);
        lottoGameService.printLottoNumbersByCount(lottos);

        final WinningLotto winningLotto = lottoGameService.generateWinningLotto();
        lottoGameService.printWinningResult(winningLotto, lottos);
        lottoGameService.printTotalReturn(countOfLotto);
    }

    private LottoSeller generateSeller() {
        return new LottoSeller(appConfig.lottoGenerator());
    }

    private LottoBuyer generateBuyer() {
        return new LottoBuyer();
    }
}
