package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private LottoService lottoService = new LottoService();

    public void run() {
        buyTickets();
        showTickets();
        readWinningNumbers();
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
        lottoService.initWinningNumbers();
    }

    private void readMainNumbers() {
        try {
            lottoService.initMainNumbers(InputView.readMainNumbers());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            readMainNumbers();
        }
    }

    private void readBonusNumber() {
        try {
            lottoService.initBonusNumber(InputView.readBonusNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            readBonusNumber();
        }
    }

    private void showStatistics() {
        OutputView.printStatistics(lottoService.getPrizeResult());
    }

    private void close() {
        InputView.close();
    }
}
