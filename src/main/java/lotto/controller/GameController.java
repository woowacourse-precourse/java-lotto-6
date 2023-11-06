package lotto.controller;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoMatchService;
import lotto.model.LottoService;
import lotto.model.Ranking;
import lotto.utils.Constants;
import lotto.view.ResultView;

public class GameController {
    private final LottoService lottoService = new LottoService();
    private final LottoMatchService lottoMatchService = new LottoMatchService();
    private final int ticketCount;
    private final List<Lotto> lottoList;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public GameController() {
        this.ticketCount = lottoService.calculateTicketCount();
        this.lottoList = lottoService.createLottos(ticketCount);
        this.winningNumbers = InputController.inputWinningNumbers();
        this.bonusNumber = InputController.inputBonusNum();
    }

    public void run() {
        try {
            start();
            displayWinners();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private void start() {
        ResultView.printTicketCount(ticketCount);
        ResultView.printLottos(lottoList);
    }

    private void displayWinners() {
        List<Ranking> rankings = lottoMatchService.calculateWinners(lottoList, winningNumbers, bonusNumber);
        Map<Ranking, Long> resultMap = lottoMatchService.summarizeResults(rankings);
        displayResults(resultMap);
    }

    private void displayResults(Map<Ranking, Long> resultMap) {
        ResultView.printSuccessResult();
        ResultView.printResults(resultMap);
        double revenueRate = lottoMatchService.calculateRevenueRate(Constants.LOTTO_TICKET_PRICE, ticketCount, resultMap);
        ResultView.printRevenueRate(revenueRate);
    }
}
