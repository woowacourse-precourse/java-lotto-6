package lotto.controller;

import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.WinningLottoTicket;
import lotto.service.LottoService;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public void start() {
        int purchaseAmount = lottoService.getPurchaseAmount();

        LottoTickets lottoTickets = lottoService.purchaseLottoTicket(purchaseAmount);
        displayLottoTickets(purchaseAmount, lottoTickets);

        List<Integer> winningNumbers = lottoService.getWinningNumbers();

        int bonusNumber = lottoService.getBonusNumber(winningNumbers);

        WinningLottoTicket winningLottoTicket = lottoService.createWinningLottoTicket(winningNumbers, bonusNumber);
        Map<Rank, Integer> statistics = lottoService.calculateStatistics(lottoTickets, winningLottoTicket);

        displayResult(statistics, purchaseAmount);
    }

    private static void displayLottoTickets(int purchaseAmount, LottoTickets lottoTicket) {
        OutputView.printPurchasedLottoTickets(purchaseAmount, lottoTicket);
    }

    private static void displayResult(Map<Rank, Integer> statistics, int purchaseAmount) {
        OutputView.printStatistics(statistics, purchaseAmount);
    }
}
