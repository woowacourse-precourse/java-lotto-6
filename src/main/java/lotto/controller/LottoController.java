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
        WinLotto winLotto = Retry.retryOnException(() -> registerWinLotto());
        calculateWinStatistics(lottoTicket, winLotto);
    }

    private LottoTicket buyLottoTicket() {
        Integer purchaseAmount = inputView.inputPurchaseAmount();
        LottoStore lottoStore = new LottoStore();
        LottoTicket lottoTicket = new LottoTicket(lottoStore.sellLottos(purchaseAmount));
        outputView.printBuyLottos(lottoTicket.getLottosNumber(), lottoTicket.getLottos().size());
        return lottoTicket;
    }

    private WinLotto registerWinLotto() {
        Lotto lotto = Retry.retryOnException(() -> new Lotto(inputView.inputWinNumbers()));
        LottoNumber bonusNumber = Retry.retryOnException(() -> new LottoNumber(inputView.inputBonusNumber()));
        return new WinLotto(lotto, bonusNumber);
    }

    private void calculateWinStatistics(LottoTicket lottoTicket, WinLotto winLotto) {
        List<Ranking> rankings = lottoTicket.checkRankings(winLotto);
        WinStatistics statistics = WinStatistics.from(rankings);
        outputView.printWinStatistics(statistics.calculateProfit(), statistics.getStatistics());
    }
}
