package lotto.controller;

import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.WinningLottoTicket;
import lotto.service.BonusNumberService;
import lotto.service.LottoService;
import lotto.service.WinningLottoService;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final LottoService lottoService = new LottoService();
    private final WinningLottoService winningLottoService = new WinningLottoService();
    private final BonusNumberService bonusNumberService = new BonusNumberService();

    public void start() {
        int purchaseAmount = lottoService.getPurchaseAmount();

        LottoTickets lottoTickets = lottoService.purchaseLottoTicket(purchaseAmount);
        displayLottoTickets(purchaseAmount, lottoTickets);

        List<Integer> winningNumbers = winningLottoService.getWinningNumbers();

        int bonusNumber = bonusNumberService.getBonusNumber(winningNumbers);

        WinningLottoTicket winningLottoTicket = winningLottoService.createWinningLottoTicket(winningNumbers, bonusNumber);
        Map<Rank, Integer> statistics = lottoService.calculateStatistics(lottoTickets, winningLottoTicket);

        displayResult(statistics, purchaseAmount);
    }

    private void displayLottoTickets(int purchaseAmount, LottoTickets lottoTickets) {
        OutputView.printPurchasedLottoTickets(purchaseAmount, lottoTickets);
    }

    private void displayResult(Map<Rank, Integer> statistics, int purchaseAmount) {
        OutputView.printStatistics(statistics, purchaseAmount);
    }
}
