package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.entity.Lotto;
import lotto.model.service.LottoMatchService;
import lotto.model.service.LottoService;
import lotto.model.entity.Ranking;
import lotto.utils.Constants;
import lotto.view.ResultView;

public class GameController {

    private final LottoService lottoService = new LottoService();
    private final LottoMatchService lottoMatchService = new LottoMatchService();

    private int ticketCount;
    private List<Lotto> lottoList;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private List<Ranking> rankings;
    private Map<Ranking, Long> resultMap;

    public GameController() {
        run();
    }

    private void run() {
        purchaseTickets();
        showPurchasedTickets();
        awaitWinningNumberSelection();
        processGameOutcome();
        displayGameResults();
    }

    private void purchaseTickets() {
        ticketCount = lottoService.calculateTicketCount();
        lottoList = lottoService.createLottos(ticketCount);
        ResultView.printTicketCount(ticketCount);
    }

    private void showPurchasedTickets() {
        ResultView.printLottos(lottoList);
    }

    private void awaitWinningNumberSelection() {
        winningNumbers = InputController.inputWinningNumbers();
        bonusNumber = InputController.inputBonusNum(winningNumbers);
    }

    private void processGameOutcome() {
        rankings = lottoMatchService.determineLottoRankings(lottoList, winningNumbers, bonusNumber);
        resultMap = lottoMatchService.summarizeRankings(rankings);
    }

    private void displayGameResults() {
        ResultView.printSuccessResult();
        ResultView.printResults(resultMap);
        double revenueRate = lottoMatchService.calculateRevenueRate(
                Constants.LOTTO_TICKET_PRICE, ticketCount, rankings);
        ResultView.printRevenueRate(revenueRate);
    }
}
