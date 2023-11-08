package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playLotto() {
        int purchaseAmount = inputView.readPurchaseAmount();
        List<Lotto> lottoTickets = lottoService.purchaseLottoTickets(purchaseAmount);
        outputView.displayLottoTickets(lottoTickets);
        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber(winningNumbers);
        Map<LottoRank, Integer> results = lottoService.checkWinningResults(lottoTickets, winningNumbers, bonusNumber);
        outputView.displayResults(results);
        outputView.displayProfitRate(lottoService.calculateProfitRate(results, lottoTickets.size()));
    }
}
