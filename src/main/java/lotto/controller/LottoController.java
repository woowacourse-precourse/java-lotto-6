package lotto.controller;

import lotto.model.*;
import lotto.utils.Retry;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        LottoTicket lottoTicket = Retry.retryOnException(() -> buyLottoTicket());

        Lotto lotto = Retry.retryOnException(() -> inputWinLottoNumbers());
        WinLotto winLotto = Retry.retryOnException(() -> inputBonusNumberForWinLotto(lotto));

        calculateAndPrintWinStatistics(lottoTicket, winLotto);
    }

    private LottoTicket buyLottoTicket() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        LottoStore lottoStore = new LottoStore();
        LottoTicket lottoTicket = new LottoTicket(lottoStore.sellLottos(purchaseAmount));
        outputView.printBuyLottos(lottoTicket.getLottosNumber(), lottoTicket.getLottos().size());
        return lottoTicket;
    }

    private Lotto inputWinLottoNumbers() {
        return Lotto.from(inputView.inputWinNumbers());
    }

    private WinLotto inputBonusNumberForWinLotto(Lotto winLotto) {
        LottoNumber lottoNumber = new LottoNumber(inputView.inputBonusNumber());
        return new WinLotto(winLotto, lottoNumber);
    }

    private void calculateAndPrintWinStatistics(LottoTicket lottoTicket, WinLotto winLotto) {
        List<Ranking> rankings = lottoTicket.checkRankings(winLotto);
        WinStatistics statistics = WinStatistics.from(rankings);
        outputView.printWinStatistics(statistics.calculateProfit(), statistics.getStatistics());
    }
}
