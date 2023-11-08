package lotto.controller;

import lotto.service.LottoService;
import lotto.service.RankingService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final RankingService rankingService;

    public LottoController(LottoService lottoService, RankingService rankingService) {
        this.lottoService = lottoService;
        this.rankingService = rankingService;
    }

    public void run() {
        buyTickets();
        showTickets();
        readWinningNumbers();
        playLotto();
        showStatistics();
        close();
    }

    private void buyTickets() {
        try {
            lottoService.buyTickets(InputView.readPayment());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            buyTickets();
        }
    }

    private void showTickets() {
        OutputView.printTickets(lottoService.tickets());
    }

    private void readWinningNumbers() {
        readMainNumbers();
        readBonusNumber();
        rankingService.initWinningNumbers();
    }

    private void readMainNumbers() {
        try {
            rankingService.initMainNumbers(InputView.readMainNumbers());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            readMainNumbers();
        }
    }

    private void readBonusNumber() {
        try {
            rankingService.initBonusNumber(InputView.readBonusNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            readBonusNumber();
        }
    }

    private void playLotto() {
        lottoService.play();
    }

    private void showStatistics() {
        OutputView.printStatistics(rankingService.getRankingResult());
    }

    private void close() {
        InputView.close();
    }
}
