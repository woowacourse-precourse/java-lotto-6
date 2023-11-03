package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.WinningLottoTicket;
import lotto.service.LottoService;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private static final LottoService lottoService = new LottoService();

    public void start() {
        int amount = lottoService.displayPurchase();

        LottoTicket lottoTickets = lottoService.purchaseLottoTicket(amount);
        displayLottoTickets(amount, lottoTickets);

        List<Integer> winningNumbers = lottoService.displayWinningNumber();

        int bonusNumber = lottoService.displayBonusNumber(winningNumbers);

        WinningLottoTicket winningLottoTicket = lottoService.createWinningLottoTicket(winningNumbers, bonusNumber);
        Map<Rank, Integer> statistics = lottoService.getStatistics(lottoTickets, winningLottoTicket);

        displayResult(statistics, amount);
    }

    private static void displayLottoTickets(int amount, LottoTicket lottoTicket) {
        OutputView.printPurchasedLottoTickets(amount, lottoTicket);
    }

    private static void displayResult(Map<Rank, Integer> statistics, int amount) {
        OutputView.printStatistics(statistics, amount);
    }
}
