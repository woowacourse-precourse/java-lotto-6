package lotto.controller;

import lotto.model.*;
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
        LottoTicket lottoTicket = buyLottoTicket();
        WinLotto winLotto = registerWinLotto();
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
        Lotto lotto = new Lotto(inputView.inputWinNumbers());
        LottoNumber bonusNumber = new LottoNumber(inputView.inputBonusNumber());
        return new WinLotto(lotto, bonusNumber);
    }

    private void calculateWinStatistics(LottoTicket lottoTicket, WinLotto winLotto) {
        List<Ranking> rankings = lottoTicket.checkRankings(winLotto);
        WinStatistics statistics = WinStatistics.from(rankings);
        outputView.printWinStatistics(statistics.calculateProfit(), statistics.getStatistics());
    }
}
